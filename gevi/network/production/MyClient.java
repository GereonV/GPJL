package gevi.network.production;

import gevi.network.api.Client;

public class MyClient extends Client {

    public static void main(String[] args) throws InterruptedException {
        Client client = new MyClient("localhost");
        client.sendString("Test from Client");
        client.sendEnd();
    }

    public MyClient(String hostname) {
        super(hostname);
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
        System.out.println("Server closed Connection");
    }
    
}
