package org.longmoneyoffshore.dlrtmweb.entities.entity;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.entities.atomic.Address;
import org.longmoneyoffshore.dlrtmweb.entities.atomic.PaymentCard;
import org.longmoneyoffshore.dlrtmweb.entities.atomic.PersonName;
import org.longmoneyoffshore.dlrtmweb.entities.atomic.PhoneNumber;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
//@Entity
//@Table(name = "clients_hibernate")
public class Client implements Serializable {

    @Id
    //@NotNull
    private int clientID;

    @Nullable
    private PersonName clientName;

    @Nullable
    private PhoneNumber clientHomePhone, clientBusinessPhone, clientAlternatePhone, clientMobilePhone;

    @Nullable
    private String clientPrimaryEmailAddress,clientAlternateEmailAddress;

    @Nullable
    private Address clientBillingAddress, clientShippingAddress, clientAlternateAddress;
    //@Nullable
    //private Address clientDeliveryAddress; //the actual delivery address used —————— one from the list above

    //#6 payment info
    @Nullable
    //@OneToMany (mappedBy = "paymentCards")
    private List<PaymentCard> cards;
    //@Nullable
    //private PaymentCard selectedPaymentMethod; // points to one of the above

    //#7 Other (/internal) client info Value Range 0-5
    private float clientUrgency;
    private float clientValue;
    private String clientStatus;

    private String clientSpecialMentions;

    //#8 internal reference / utility variables
    private String clientReferenceCode = "0";
    private String revision = "0";

    //=============CONSTRUCTORS======================================================================================================
    // 1° constructor -  basic
    public Client() {}

    public Client(int clientID) {
        this.clientID = clientID;
    }

    //full constructor
    public Client(int clientID, PersonName clientName, PhoneNumber clientHomePhone, PhoneNumber clientBusinessPhone,
                  PhoneNumber clientAlternatePhone, PhoneNumber clientMobilePhone,
                  String clientPrimaryEmailAddress, String clientAlternateEmailAddress, Address clientBillingAddress,
                  Address clientShippingAddress, Address clientAlternateAddress, List<PaymentCard> cards,
                  float clientUrgency, float clientValue,
                  String clientStatus, String clientSpecialMentions) {

        this.clientID = clientID;
        this.clientName = clientName;
        this.clientHomePhone = clientHomePhone;
        this.clientBusinessPhone = clientBusinessPhone;
        this.clientAlternatePhone = clientAlternatePhone;
        this.clientMobilePhone = clientMobilePhone;
        this.clientPrimaryEmailAddress = clientPrimaryEmailAddress;
        this.clientAlternateEmailAddress = clientAlternateEmailAddress;
        this.clientBillingAddress = clientBillingAddress;
        this.clientShippingAddress = clientShippingAddress;
        this.clientAlternateAddress = clientAlternateAddress;
        //this.clientDeliveryAddress = clientDeliveryAddress;
        this.cards = cards;
        //this.selectedPaymentMethod = selectedPaymentMethod;
        this.clientUrgency = clientUrgency;
        this.clientValue = clientValue;
        this.clientStatus = clientStatus;
        this.clientSpecialMentions = clientSpecialMentions;
    }

    /*//smaller-signature Constructor
    public Client(int clientID, PersonName clientName, PhoneNumber clientHomePhone, PhoneNumber clientBusinessPhone,
                  PhoneNumber clientAlternatePhone, PhoneNumber clientMobilePhone, String clientPrimaryEmailAddress,
                  String clientAlternateEmailAddress, Address clientBillingAddress, Address clientShippingAddress,
                  Address clientAlternateAddress, List<PaymentCard> cards, float clientUrgency,
                  float clientValue, String clientStatus, String clientSpecialMentions) {

        this.clientID = clientID;
        this.clientName = clientName;
        this.clientHomePhone = clientHomePhone;
        this.clientBusinessPhone = clientBusinessPhone;
        this.clientAlternatePhone = clientAlternatePhone;
        this.clientMobilePhone = clientMobilePhone;
        this.clientPrimaryEmailAddress = clientPrimaryEmailAddress;
        this.clientAlternateEmailAddress = clientAlternateEmailAddress;
        this.clientBillingAddress = clientBillingAddress;
        this.clientShippingAddress = clientShippingAddress;
        this.clientAlternateAddress = clientAlternateAddress;
        this.cards = cards;
        this.clientUrgency = clientUrgency;
        this.clientValue = clientValue;
        this.clientStatus = clientStatus;
        this.clientSpecialMentions = clientSpecialMentions;

        //by default the 'primary' fields point to these attributes, respectively
        //this.clientPrimaryContactPhone = clientMobilePhone;
        //this.clientDeliveryAddress = clientShippingAddress;
        //this.selectedPaymentMethod = this.cards.get(0);
    }*/

    //brief-signature Constructor
    public Client(int clientID, PersonName clientName, PhoneNumber clientPhone, String clientPrimaryEmailAddress,
                  Address clientAddress, List<PaymentCard> cards, String clientSpecialMentions) {

        this.clientID = clientID;
        this.clientName = clientName;

        this.clientMobilePhone = clientPhone;
        this.clientHomePhone = clientPhone;
        this.clientBusinessPhone = clientPhone;
        this.clientAlternatePhone = clientPhone;
        this.clientPrimaryEmailAddress = clientPrimaryEmailAddress;
        this.clientAlternateEmailAddress = clientPrimaryEmailAddress;
        this.clientBillingAddress = clientAddress;
        this.clientShippingAddress = clientAddress;
        this.clientAlternateAddress = clientAddress;
        this.cards = cards;
        this.clientUrgency = 5;
        this.clientValue = 5;
        this.clientStatus = null;
        this.clientSpecialMentions = clientSpecialMentions;

        //by default the 'primary' fields point to these attributes, respectively
        //this.clientDeliveryAddress = clientShippingAddress;
        //this.selectedPaymentMethod = this.cards.get(0);
    }

    //primitives Constructor
    public Client(int clientID, String clientName, String clientPhone, String clientPrimaryEmailAddress,
                  String clientAddress, String cardInfo, String clientSpecialMentions) {

        this.clientID = clientID;
        this.clientName = new PersonName(clientName);

        this.clientMobilePhone = new PhoneNumber(clientName, clientPhone);
        this.clientHomePhone = new PhoneNumber(clientName, clientPhone); //this.clientMobilePhone;
        this.clientBusinessPhone = new PhoneNumber(clientName, clientPhone); //this.clientMobilePhone;
        this.clientAlternatePhone = new PhoneNumber(clientName, clientPhone); //this.clientMobilePhone;
        this.clientPrimaryEmailAddress = clientPrimaryEmailAddress;
        this.clientAlternateEmailAddress = clientPrimaryEmailAddress;
        this.clientBillingAddress = new Address(clientAddress);
        this.clientShippingAddress = new Address(clientAddress); //this.clientBillingAddress;
        this.clientAlternateAddress = new Address(clientAddress); //this.clientBillingAddress;

        this.cards.add(new PaymentCard(cardInfo));

        this.clientUrgency = 5;
        this.clientValue = 5;
        this.clientStatus = null;
        this.clientSpecialMentions = clientSpecialMentions;

        //by default the 'primary' fields point to these attributes, respectively
        //this.clientDeliveryAddress = clientShippingAddress;
        //this.selectedPaymentMethod = this.cards.get(0);
    }

    // 6° constructor from the same type of object
    /*public Client (Client myClient)
    {
        this.clientID = myClient.getClientID();
        this.clientName = myClient.getClientName();

        this.clientHomePhone = myClient.getClientHomePhone();
        this.clientBusinessPhone = myClient.getClientBusinessPhone();
        this.clientAlternatePhone = myClient.getClientAlternatePhone();
        this.clientMobilePhone = myClient.getClientMobilePhone();
        this.clientPrimaryEmailAddress = myClient.getClientPrimaryEmailAddress();
        this.clientAlternateEmailAddress = myClient.getClientAlternateEmailAddress();
        this.clientBillingAddress = myClient.getClientBillingAddress();
        this.clientShippingAddress = myClient.getClientShippingAddress();
        this.clientAlternateAddress = myClient.getClientAlternateAddress();
        //this.clientDeliveryAddress = myClient.getClientDeliveryAddress();
        this.cards = myClient.getCards();
        //this.selectedPaymentMethod = myClient.getSelectedPaymentMethod();
        this.clientSpecialMentions = myClient.getClientSpecialMentions();

        //utility attributes
        this.clientUrgency = myClient.getClientUrgency();
        this.clientValue = myClient.getClientValue();
        this.clientStatus = myClient.getClientStatus();
        this.clientReferenceCode = myClient.getClientReferenceCode();
        this.revision = myClient.getRevision();
    }*/



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

    public boolean equalsRevision(Client toCompare) {
        return this.getRevision().equals(toCompare.getRevision());
    }

    public String clientDifferences(Client other) {
        String differencesIndex="";

        //#1 Client id
        if (!(this.clientID ==other.getClientID())) differencesIndex+=1; else differencesIndex+=0;

        //#2 Client Name
        if (!this.clientName.equals(other.getClientName())) differencesIndex+=1; else differencesIndex+=0;

        //#3 Phone contact info
        if (!this.clientHomePhone.equals(other.getClientHomePhone())) differencesIndex+=1; else differencesIndex+=0;
        if (!this.clientBusinessPhone.equals(other.getClientBusinessPhone())) differencesIndex+=1; else differencesIndex+=0;
        if (!this.clientAlternatePhone.equals(other.getClientAlternatePhone())) differencesIndex+=1; else differencesIndex+=0;
        if (!this.clientMobilePhone.equals(other.getClientMobilePhone())) differencesIndex+=1; else differencesIndex+=0;

        //#4 email address
        if (!this.clientPrimaryEmailAddress.equals(other.getClientPrimaryEmailAddress())) differencesIndex+=1; else differencesIndex+=0;
        if (!this.clientAlternateEmailAddress.equals(other.getClientAlternateEmailAddress())) differencesIndex+=1; else differencesIndex+=0;

        //#5 Client adresses
        if (!this.clientBillingAddress.equals(other.getClientBillingAddress())) differencesIndex+=1; else differencesIndex+=0;
        if (!this.clientShippingAddress.equals(other.getClientShippingAddress())) differencesIndex+=1; else differencesIndex+=0;
        if (!this.clientAlternateAddress.equals(other.getClientAlternateAddress())) differencesIndex+=1; else differencesIndex+=0;
        //if (!this.clientDeliveryAddress.equals(other.getClientDeliveryAddress())) differencesIndex+=1; else differencesIndex+=0;


        //#6 payment info
        if (!this.cards.equals(other.getCards())) differencesIndex+=1; else differencesIndex+=0;
        //if (!this.selectedPaymentMethod.equals(other.getSelectedPaymentMethod())) differencesIndex+=1; else differencesIndex+=0;


        //#7 Other (/internal) info
        if (this.clientUrgency != other.getClientUrgency()) differencesIndex+=1; else differencesIndex+=0;
        if (this.clientValue != other.getClientValue()) differencesIndex+=1; else differencesIndex+=0;
        if (!this.clientStatus.equals(other.getClientStatus())) differencesIndex+=1; else differencesIndex+=0;

        return differencesIndex;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientID='" + clientID + '\'' +
                ", clientName=" + clientName +
                ", clientHomePhone=" + clientHomePhone +
                ", clientBusinessPhone=" + clientBusinessPhone +
                ", clientAlternatePhone=" + clientAlternatePhone +
                ", clientMobilePhone=" + clientMobilePhone +
                ", clientPrimaryEmailAddress='" + clientPrimaryEmailAddress + '\'' +
                ", clientAlternateEmailAddress='" + clientAlternateEmailAddress + '\'' +
                ", clientBillingAddress=" + clientBillingAddress +
                ", clientShippingAddress=" + clientShippingAddress +
                ", clientAlternateAddress=" + clientAlternateAddress +
                ", cards=" + cards +
                ", clientUrgency=" + clientUrgency +
                ", clientValue=" + clientValue +
                ", clientStatus='" + clientStatus + '\'' +
                ", clientSpecialMentions='" + clientSpecialMentions + '\'' +
                '}';
    }

    public String smallToString() {
        return "Client{" +
                "clientID='" + clientID + '\'' +
                ", clientName=" + clientName.getSimpleName() +
                ", clientHomePhone=" + clientHomePhone.getClientPhoneNo() +
                ", clientPrimaryEmailAddress='" + clientPrimaryEmailAddress + '\'' +
                ", clientBillingAddress=" + clientBillingAddress.getFullAddress() +
                ", clientUrgency=" + clientUrgency +
                ", clientValue=" + clientValue +
                ", clientStatus='" + clientStatus + '\'' +
                ", clientSpecialMentions='" + clientSpecialMentions + '\'' +
                '}';
    }
}