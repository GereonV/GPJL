package gevi.network.api;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.SocketException;

public abstract class Endpoint {
    
    public final static byte DISCONNECT = -1;
    public final static byte STRING = 0;
    public final static byte OBJECT = 1;

    private Socket socket;
    private ObjectOutputStream out;

    protected abstract Socket connectSocket(int port) throws IOException;
    protected abstract void readString(String string);
    protected abstract void readObject(Object object);
    protected abstract void onDisconnect();

    public boolean connect(int port) {
        disconnect();
        try {
            socket = connectSocket(port);
            out = new ObjectOutputStream(socket.getOutputStream());
            startReadThread();
            return true;
        } catch(IOException e) {
            System.out.println("Building Connection failed");
            return false;
        }
    }

    public void disconnect() {
        if(socket == null || socket.isClosed())
            return;
        try {
            socket.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void sendEnd() {
        send(DISCONNECT, null);
        disconnect();
    }
    
    public void sendString(String string) {
        send(STRING, string);
    }

    public <T extends Serializable> void sendObject(T obj) {
        send(OBJECT, obj);
    }

    private <T extends Serializable> void send(byte type, T obj) {
        if(socket == null || socket.isClosed())
            return;
        try {
            out.writeByte(type);
            switch(type) {
                case STRING -> out.writeUTF((String) obj);
                case OBJECT -> out.writeObject(obj);
            }
            out.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void startReadThread() {
        new Thread(() -> {
            try {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                while(true) {
                    byte type = in.readByte();
                    switch (type) {
                        case STRING -> readString(in.readUTF());
                        case OBJECT -> readObject(in.readObject());
                        default -> throw new DisconnectedException();
                    }
                }
            } catch(DisconnectedException e) {
                disconnect();
                onDisconnect();
            } catch(SocketException e) {
            } catch(IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
