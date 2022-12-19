package org.smr.utilities;

import java.io.*;

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

    /**
     * @param filePath (String)
     * @return InputStream
     */
    public static InputStream getFileInputStream(String filePath) {
        File file = new File(filePath);
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.err.println("Error: No such file.");
            return null;
        }
    }

    /**
     * @param filePath (String)
     * @return InputStream
     */
    public static OutputStream getFileOutputStream(String filePath) {
        File file = new File(filePath);
        try {
            return new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            System.err.println("Error: No such file.");
            return null;
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
