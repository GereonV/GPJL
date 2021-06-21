package example.network;

import gpjl.network.Client;

public class MyClient extends Client {

    public static void main(String[] args) throws InterruptedException {
        Client client = new MyClient("localhost");  //create a Client-Object - replace localhost with IP
        if(!client.connect(3636))   //try to connect to a ServerSocket
            return;
        client.sendString("Test from Client");  //send Data
        Thread.sleep(1000);
        client.sendEnd();   //close the Connection
    }

    public MyClient(String hostname) {
        super(hostname);    //push through to Client-Class
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
        System.out.println("Server closed Connection"); //log that the Server closed the Connection
    }
    
}
