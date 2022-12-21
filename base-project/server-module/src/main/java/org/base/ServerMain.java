package org.base;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

/**
 * @author MRegra on 19/12/2022
 */
public class ServerMain {

    public static void main(String[] args) {
        try {
            // Starts the server
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server started...");
            Socket socket;
            while(true) {
                socket = server.accept();

                // Should be moved to logs.
                System.out.println("Connection received from IP: " + socket.getInetAddress().getHostAddress() +
                        " and hostname: " + socket.getInetAddress().getHostName());

                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

                Thread t = new ServerHandler(socket, input, out);

                // start the thread
                t.start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}