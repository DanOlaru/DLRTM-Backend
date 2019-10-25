package org.longmoneyoffshore.dlrtmweb.entities.models.entity;

import org.springframework.lang.Nullable;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    /****************Getters and setters - methods use to access the private attributes of a class **/



    /************ !!!!!!!!!!!!!!!!!!!!!!!!!!!! other/utility methods !!!!!!!!!!!!!!!!!!!!!!!!!!!! *******/

    //convert client to List<List<Object>>

  /*  public List<List<Object>> returnClientAsObjectList() {
        List<List<Object>> values = Arrays.asList(
                Arrays.asList(
                        this.clientName, this.clientPhoneNo, this.clientLocation, this.clientProductID,
                        this.clientQuantity, this.clientPrice, this.clientPriceAdjust, this.clientUrgency,
                        this.clientValue, this.clientStatus));
        return values;
    }*/

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    @Nullable
    public String getClientName() {
        return clientName;
    }

    public void setClientName(@Nullable String clientName) {
        this.clientName = clientName;
    }

    @Nullable
    public String getClientBusinessPhone() {
        return clientBusinessPhone;
    }

    public void setClientBusinessPhone(@Nullable String clientBusinessPhone) {
        this.clientBusinessPhone = clientBusinessPhone;
    }

    @Nullable
    public String getClientPrimaryEmailAddress() {
        return clientPrimaryEmailAddress;
    }

    public void setClientPrimaryEmailAddress(@Nullable String clientPrimaryEmailAddress) {
        this.clientPrimaryEmailAddress = clientPrimaryEmailAddress;
    }

    @Nullable
    public String getClientBillingAddress() {
        return clientBillingAddress;
    }

    public void setClientBillingAddress(@Nullable String clientBillingAddress) {
        this.clientBillingAddress = clientBillingAddress;
    }

    @Nullable
    public List<String> getCards() {
        return cards;
    }

    public void setCards(@Nullable List<String> cards) {
        this.cards = cards;
    }

    public float getClientUrgency() {
        return clientUrgency;
    }

    public void setClientUrgency(float clientUrgency) {
        this.clientUrgency = clientUrgency;
    }

    public float getClientValue() {
        return clientValue;
    }

    public void setClientValue(float clientValue) {
        this.clientValue = clientValue;
    }

    public String getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(String clientStatus) {
        this.clientStatus = clientStatus;
    }

    public String getClientSpecialMentions() {
        return clientSpecialMentions;
    }

    public void setClientSpecialMentions(String clientSpecialMentions) {
        this.clientSpecialMentions = clientSpecialMentions;
    }

    public String getClientReferenceCode() {
        return clientReferenceCode;
    }

    public void setClientReferenceCode(String clientReferenceCode) {
        this.clientReferenceCode = clientReferenceCode;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
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