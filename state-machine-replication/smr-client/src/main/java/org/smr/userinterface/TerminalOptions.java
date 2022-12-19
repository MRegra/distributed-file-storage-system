package org.smr.userinterface;

import org.smr.Client;
import org.smr.Operation;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author MRegra on 19/12/2022
 */
public class TerminalOptions {

    public static void processOperation(String operation, ObjectOutputStream out){
        if(operation.equals("add")) {
            sendOperation(new Operation(operation, new Client()), out);
        }
    }

    private static void sendOperation(Operation operation, ObjectOutputStream out){
        try {
            System.out.println(operation.toString());
            out.writeObject(operation);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

