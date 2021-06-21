package gevi.network.api;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class Server extends Endpoint {

    @Override
    protected Socket connectSocket(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        serverSocket.close();
        return socket;
    }

}
