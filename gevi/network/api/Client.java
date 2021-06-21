package gevi.network.api;

import java.io.IOException;
import java.net.Socket;

public abstract class Client extends Endpoint {
    
    private final String hostname;

    public Client(String hostname) {
        this.hostname = hostname;
    }

    @Override
    protected Socket connectSocket(int port) throws IOException {
        return new Socket(hostname, port);
    }

}
