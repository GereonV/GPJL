package gevi.network.api;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The {@code Server} class represents a Server, that a {@code Socket} can connect to.
 * 
 * @author  Gereon
 * @see     gevi.network.api.Endpoint
 * @since   0.1
 * @version 1.0
 */
public abstract class Server extends Endpoint {

    @Override
    protected Socket connectSocket(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        serverSocket.close();
        return socket;
    }

}
