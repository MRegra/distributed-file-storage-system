package org.smr;

import org.smr.exceptions.CouldNotReadLineException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author MRegra on 19/12/2022
 */
public class ClientHandler {

    private final Socket socket;
    private final DataInputStream dis;
    private final DataOutputStream dos;

    public ClientHandler(Socket socket, DataInputStream dis, DataOutputStream dos) {
        this.socket = socket;
        this.dis = dis;
        this.dos = dos;
    }

    public void processInput(){

    }

    private String getUserInput() throws CouldNotReadLineException {
        try {
            return dis.readUTF();
        } catch (IOException e) {
            throw new CouldNotReadLineException();
        }
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
