package org.smr;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author MRegra on 19/12/2022
 */
public class ServerHandler extends Thread {

    private final Socket socket;
    private final ObjectInputStream input;
    private final ObjectOutputStream output;

    public ServerHandler(Socket socket, ObjectInputStream input, ObjectOutputStream output) {
        this.socket = socket;
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Operation received = (Operation) input.readObject();
                System.out.println("-->New request received...");
                System.out.println(received.getOperationType());

            } catch (IOException e) {
                break;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            closeConnections();
        } catch (IOException e) {
            System.out.println("IOException Message: " + e.getMessage());
        }
    }

    private void processRequest(String request) {

    }

    public void closeConnections() throws IOException {
        this.socket.close();
        try {
            // closing resources
            this.input.close();
            this.output.close();

        } catch (IOException e) {
            System.out.println("IOException Message: " + e.getMessage());
            System.out.println("Error: Closing Connection");
        }
    }
}
