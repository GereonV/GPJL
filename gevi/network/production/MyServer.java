package gevi.network.production;

import gevi.network.api.Server;

public class MyServer extends Server {

    public static void main(String[] args) throws InterruptedException {
        Server server = new MyServer(); //create a Server-Object
        server.connect(3636);   //open ServerSocket for a new Connection
        server.sendString("Test from Server");  //send Data after connection has been established
    }

    @Override
    protected void readString(String string) {
        System.out.println(string); //print incoming Strings
    }

    @Override
    protected void readObject(Object object) {
        System.out.println("Received an Object");   //log that an Object has been sent
    }

    @Override
    protected void onDisconnect() {
        System.out.println("Client closed Connection\n");   //log that the Client closed the Connection
        connect(3636);  //reopen for a new Connection
    }

}
