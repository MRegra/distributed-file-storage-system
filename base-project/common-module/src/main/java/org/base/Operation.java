package org.base;

import java.io.Serializable;

/**
 * @author MRegra on 19/12/2022
 */
public class Operation implements Serializable {

    private String operationType;
    private Client client;
    private byte[] fileContents;
    private String fileName;

    public Operation(String operationType, Client client, byte[] fileContents, String fileName) {
        this.operationType = operationType;
        this.client = client;
        this.fileName = fileName;
        this.fileContents = fileContents;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public byte[] getFileContents() {
        return fileContents;
    }

    public void setFileContents(byte[] fileContents) {
        this.fileContents = fileContents;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString(){
        return "{\n Operation:\n" +
                "  [\n   OperationType: " + getOperationType() + "\n" +
                "  ]\n}";
    }
}
