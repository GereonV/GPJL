package gevi.network.production;

import gevi.network.api.Server;

public class MyServer extends Server {

    public static void main(String[] args) throws InterruptedException {
        Server server = new MyServer();
        server.connect(3636);
        Thread.sleep(2000);
        server.sendString("Test from Server");
    }

    @Override
    protected void readString(String string) {
        System.out.println(string);
    }

    @Override
    protected void readObject(Object object) {
        System.out.println("Received an Object");
    }

    @Override
    protected void onDisconnect() {
        System.out.println("Client closed Connection");
    }

}
