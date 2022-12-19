package org.smr;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author MRegra on 19/12/2022
 */
public class ClientMain {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 5000);
            DataInputStream input = new DataInputStream(System.in);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            new ClientHandler(socket, input, out);
        } catch (IOException u) {
            System.out.println("Problems reading from DataInputStream: " + u);
        }
    }
}