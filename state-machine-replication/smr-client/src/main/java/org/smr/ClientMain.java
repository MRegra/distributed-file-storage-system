package org.smr;

import org.smr.userinterface.Terminal;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author MRegra on 19/12/2022
 */
public class ClientMain {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 5000);
            InputStream input = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            Terminal terminalProcess = new Terminal(socket, input, out);
            terminalProcess.processInput();
        } catch (IOException u) {
            System.out.println("Problems reading from DataInputStream: " + u);
        }
    }
}