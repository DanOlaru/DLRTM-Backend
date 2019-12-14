package org.longmoneyoffshore.dlrtmweb.view;

import lombok.*;
import org.longmoneyoffshore.dlrtmweb.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("TransactionCommandObject")
@Data
@Builder
@Getter
@Setter
public class TransactionCommandObject {
    private int clientId;
    private String productIds;
    private String transactionStatus;
    private String transactionSpecialMentions;

    public TransactionCommandObject() {}

    public TransactionCommandObject (int clientId) {
        this.clientId = clientId;
    }

    public TransactionCommandObject (int clientId, String productIds, String transactionStatus, String transactionSpecialMentions) {
        this.clientId = clientId;
        this.productIds = productIds;
        this.transactionStatus = transactionStatus;
        this.transactionSpecialMentions = transactionSpecialMentions;
    }


    @Override
    public String toString() {
        return "TransactionCommandObject{" +
                "clientId=" + clientId +
                ", productIds='" + productIds + '\'' +
                ", transactionStatus='" + transactionStatus + '\'' +
                ", transactionSpecialMentions='" + transactionSpecialMentions + '\'' +
                '}';
    }
}
