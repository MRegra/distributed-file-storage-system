package org.smr.userinterface;

import org.smr.utilities.FileUtilities;

import java.io.*;
import java.net.Socket;

/**
 * @author MRegra on 19/12/2022
 */
public class Terminal {

    private final Socket socket;
    private final InputStream input;
    private final ObjectOutputStream output;

    public Terminal(Socket socket, InputStream input, OutputStream output) throws IOException {
        this.socket = socket;
        this.input = input;
        this.output = new ObjectOutputStream(output);
    }

    public void processInput() {
        String operation = "";
        while(!operation.equals("exit")){
            getTerminalInputInterface();
            BufferedReader reader = getUserInput();
            try {
                operation = reader.readLine();
                TerminalOptions.processOperation(operation, output);
            } catch (IOException e) {
                System.out.println("Something went wrong. \nException: " + e);
            }
        }
        closeConnections();
    }

    private BufferedReader getUserInput() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    private void getTerminalInputInterface(){
        System.out.print(FileUtilities.ANSI_CYAN + "smr-storage-system $ " + FileUtilities.ANSI_RESET);
        System.out.flush();
    }

    private void closeConnections() {
        try {
            this.socket.close();
            this.input.close();
            this.output.close();

        } catch (IOException e) {
            System.out.println("IOException Message: " + e.getMessage());
            System.out.println("Error: Closing Connection");
        }
    }
}
