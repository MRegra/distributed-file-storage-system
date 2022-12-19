package org.smr;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author MRegra on 19/12/2022
 */
public class ServerHandler extends Thread {

    private final Socket socket;
    private final DataInputStream dis;
    private final DataOutputStream dos;

    public ServerHandler(Socket socket, DataInputStream dis, DataOutputStream dos) {
        this.socket = socket;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String received = dis.readUTF();
                System.out.println("-->New request received...");
                System.out.println(received);

            } catch (IOException e) {
                break;
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

    private void closeConnections() throws IOException {
        this.socket.close();
        try {
            // closing resources
            this.dis.close();
            this.dos.close();

        } catch (IOException e) {
            System.out.println("IOException Message: " + e.getMessage());
            System.out.println("Error: Closing Connection");
        }
    }
}
