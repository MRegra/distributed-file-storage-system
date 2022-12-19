package org.smr.utilities;

import java.io.*;
import java.util.Arrays;

/**
 * @author MRegra on 19/12/2022
 */
public class FileUtilities {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static InputStream getFileInputStream(String filePath) {
        File file = new File(filePath);
        try {
            InputStream in2 = new FileInputStream(file);
            return in2;
        } catch (FileNotFoundException e) {
            System.err.println("Error: No such file.");
            return null;
        }
    }

    public static byte[] getFileData(InputStream inputStream){
        byte[] byteArray = new byte[1073741824]; //1G
        int bytesCount = 0;

        //Read file data
        while (true) {
            try {
                if (!((bytesCount = inputStream.read(byteArray)) != -1)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return trim(byteArray);
    }

    public static byte[] trim(byte[] bytes) {
        int i = bytes.length - 1;
        while (i >= 0 && bytes[i] == 0){
            --i;
        }
        return Arrays.copyOf(bytes, i + 1);
    }

    public static void storeMessageIntoFile(String message, String filePath){
        try {
            File myObj = new File(filePath);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter myWriter = new FileWriter(filePath, true);
            myWriter.write(message+"\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * @param file (String)
     * @return boolean
     */
    public static boolean verifyIfFileExists(String file) {
        File testFile = new File(file);
        return testFile.exists();
    }
}
