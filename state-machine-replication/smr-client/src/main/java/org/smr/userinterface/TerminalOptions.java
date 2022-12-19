package org.smr.userinterface;

import org.smr.Client;
import org.smr.Operation;
import org.smr.utilities.FileUtilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Objects;

/**
 * @author MRegra on 19/12/2022
 */
public class TerminalOptions {

    public static void processOperation(String operation, ObjectOutputStream out, BufferedReader reader){
        if(operation.equals("add")) {
            try {
                getInsertFileDisplay();
                String filePath = reader.readLine();
                byte[] fileData = FileUtilities.getFileData(Objects.requireNonNull(FileUtilities.getFileInputStream(filePath)));
                sendOperation(new Operation(operation, new Client(), fileData, filePath), out);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private static void getInsertFileDisplay(){
        System.out.print(FileUtilities.ANSI_RED + "File Path: " + FileUtilities.ANSI_RESET);
        System.out.flush();
    }

    private static void sendOperation(Operation operation, ObjectOutputStream out){
        try {
            out.writeObject(operation);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

