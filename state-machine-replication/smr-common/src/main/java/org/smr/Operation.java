package org.smr;

import java.io.Serializable;

/**
 * @author MRegra on 19/12/2022
 */
public class Operation implements Serializable {

    private String operationType;
    private Client client;

    public Operation(String operationType, Client client) {
        this.operationType = operationType;
        this.client = client;
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

    @Override
    public String toString(){
        return "{\n Operation:\n" +
                "  [\n   OperationType: " + getOperationType() + "\n" +
                "  ]\n}";
    }
}
