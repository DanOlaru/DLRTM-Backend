package org.longmoneyoffshore.dlrtmweb.entities.models.entity;

import lombok.Data;
import org.springframework.lang.Nullable;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class SimpleClient {
    @NotNull
    private String clientID;
    @Nullable
    private String clientName;
    @Nullable
    private String clientBusinessPhone;
    @Nullable
    private String clientPrimaryEmailAddress;
    @Nullable
    private String clientBillingAddress;
    @Nullable
    private List<String> cards;

    private float clientUrgency;
    private float clientValue;
    private String clientStatus;

    private String clientSpecialMentions;

    //#8 internal reference / utility variables
    private String clientReferenceCode = "0";
    private String revision = "0";

    //=============CONSTRUCTORS======================================================================================================

    public SimpleClient() {}

    //primitives Constructor
    public SimpleClient(String clientID, String clientName, String clientPhone, String clientPrimaryEmailAddress,
                  String clientAddress, String cardInfo, String clientSpecialMentions) {

        this.clientID = clientID;
        this.clientName = clientName;
        this.clientBusinessPhone = clientPhone; //this.clientMobilePhone;
        this.clientPrimaryEmailAddress = clientPrimaryEmailAddress;
        this.clientBillingAddress = clientAddress;

        this.cards.add(cardInfo);

        this.clientUrgency = 5;
        this.clientValue = 5;
        this.clientStatus = null;
        this.clientSpecialMentions = clientSpecialMentions;

        //by default the 'primary' fields point to these attributes, respectively
        //this.clientDeliveryAddress = clientShippingAddress;
        //this.selectedPaymentMethod = this.cards.get(0);
    }

    public SimpleClient(Client client) {
        this.clientID = client.getClientID();
        this.clientName = client.getClientName().getSimpleName();
        this.clientBusinessPhone = client.getClientBusinessPhone().getClientPhoneNo(); //this.clientMobilePhone;
        this.clientPrimaryEmailAddress = client.getClientPrimaryEmailAddress();
        this.clientBillingAddress = client.getClientBillingAddress().simpleAddress();

        this.cards = client.getCards().stream().map(c -> c.simpleCardInfo()).collect(Collectors.toList());

        this.clientUrgency = client.getClientUrgency();
        this.clientValue = client.getClientValue();
        this.clientStatus = client.getClientStatus();
        this.clientSpecialMentions = client.getClientSpecialMentions();
    }



    public String smallToString() {
        return "Client{" +
                "clientID='" + clientID + '\'' +
                ", clientName=" + clientName +
                ", clientPrimaryEmailAddress='" + clientPrimaryEmailAddress + '\'' +
                //", cards=" + cards.get(0).simpleCardInfo() +
                ", clientUrgency=" + clientUrgency +
                ", clientValue=" + clientValue +
                ", clientStatus='" + clientStatus + '\'' +
                ", clientSpecialMentions='" + clientSpecialMentions + '\'' +
                '}';
    }
}