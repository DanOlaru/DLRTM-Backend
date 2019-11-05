package org.longmoneyoffshore.dlrtmweb.view;

import lombok.Data;

@Data
public class TransactionCommandObject {
    private String clientId;
    private String productIds;

    private String transactionStatus;
    private String transactionSpecialMentions;

    public TransactionCommandObject () {}

    public TransactionCommandObject (String clientId) {
        this.clientId = clientId;
    }

}
