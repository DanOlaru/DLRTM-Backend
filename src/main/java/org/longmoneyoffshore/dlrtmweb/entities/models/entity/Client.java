package org.longmoneyoffshore.dlrtmweb.entities.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.longmoneyoffshore.dlrtmweb.entities.models.atomic.Address;
import org.longmoneyoffshore.dlrtmweb.entities.models.atomic.PaymentCard;
import org.longmoneyoffshore.dlrtmweb.entities.models.atomic.PersonName;
import org.longmoneyoffshore.dlrtmweb.entities.models.atomic.PhoneNumber;
import org.springframework.data.annotation.Id;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javax.persistence.GenerationType.*;

//@Entity
@JsonIgnoreProperties({ "clientName", "clientHomePhone", "clientBusinessPhone","clientAlternatePhone", "clientMobilePhone",
"clientPrimaryContactPhone", "clientBillingAddress", "clientShippingAddress", "clientAlternateAddress", "clientDeliveryAddress"})
public class Client {
    //#1 Client id
    //@Id
    private String clientID;

    //#2 Client Name
    private PersonName clientName;

    //#3 Phone contact info
    private PhoneNumber clientHomePhone, clientBusinessPhone, clientAlternatePhone, clientMobilePhone;
    private PhoneNumber clientPrimaryContactPhone; //first phone to contact

    //#4 email address
    private String clientPrimaryEmailAddress,clientAlternateEmailAddress;

    //#5 Client addresses
    @Nullable
    private Address clientBillingAddress, clientShippingAddress, clientAlternateAddress;
    @Nullable
    private Address clientDeliveryAddress; //the actual delivery address used —————— one from the list above

    //#6 payment info
    @Nullable
    private List<PaymentCard> cards;
    @Nullable
    private PaymentCard selectedPaymentMethod; // points to one of the above

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
    public Client()
    {}

    //full constructor
    public Client(String clientID, PersonName clientName, PhoneNumber clientHomePhone, PhoneNumber clientBusinessPhone,
                  PhoneNumber clientAlternatePhone, PhoneNumber clientMobilePhone, PhoneNumber clientPrimaryContactPhone,
                  String clientPrimaryEmailAddress, String clientAlternateEmailAddress, Address clientBillingAddress,
                  Address clientShippingAddress, Address clientAlternateAddress, Address clientDeliveryAddress, List<PaymentCard> cards,
                  PaymentCard selectedPaymentMethod, float clientUrgency, float clientValue,
                  String clientStatus, String clientSpecialMentions) {

        this.clientID = clientID;
        this.clientName = clientName;
        this.clientHomePhone = clientHomePhone;
        this.clientBusinessPhone = clientBusinessPhone;
        this.clientAlternatePhone = clientAlternatePhone;
        this.clientMobilePhone = clientMobilePhone;
        this.clientPrimaryContactPhone = clientPrimaryContactPhone;
        this.clientPrimaryEmailAddress = clientPrimaryEmailAddress;
        this.clientAlternateEmailAddress = clientAlternateEmailAddress;
        this.clientBillingAddress = clientBillingAddress;
        this.clientShippingAddress = clientShippingAddress;
        this.clientAlternateAddress = clientAlternateAddress;
        this.clientDeliveryAddress = clientDeliveryAddress;
        this.cards = cards;
        this.selectedPaymentMethod = selectedPaymentMethod;
        this.clientUrgency = clientUrgency;
        this.clientValue = clientValue;
        this.clientStatus = clientStatus;
        this.clientSpecialMentions = clientSpecialMentions;
    }

    //smaller-signature Constructor
    public Client(String clientID, PersonName clientName, PhoneNumber clientHomePhone, PhoneNumber clientBusinessPhone,
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
        this.clientPrimaryContactPhone = clientMobilePhone;
        this.clientDeliveryAddress = clientShippingAddress;
        this.selectedPaymentMethod = this.cards.get(0);
    }

    //brief-signature Constructor
    public Client(String clientID, PersonName clientName, PhoneNumber clientPhone, String clientPrimaryEmailAddress,
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
        this.clientPrimaryContactPhone = clientMobilePhone;
        this.clientDeliveryAddress = clientShippingAddress;
        this.selectedPaymentMethod = this.cards.get(0);
    }

    //primitives Constructor
    public Client(String clientID, String clientName, String clientPhone, String clientPrimaryEmailAddress,
                  String clientAddress, String cardInfo, String clientSpecialMentions) {

        this.clientID = clientID;
        this.clientName = new PersonName(clientName);

        this.clientMobilePhone = new PhoneNumber(clientName, clientPhone);
        this.clientHomePhone = this.clientMobilePhone;
        this.clientBusinessPhone = this.clientMobilePhone;
        this.clientAlternatePhone = this.clientMobilePhone;
        this.clientPrimaryEmailAddress = clientPrimaryEmailAddress;
        this.clientAlternateEmailAddress = clientPrimaryEmailAddress;
        this.clientBillingAddress = new Address(clientAddress);
        this.clientShippingAddress = this.clientBillingAddress;
        this.clientAlternateAddress = this.clientBillingAddress;

        this.cards = new ArrayList<>(Arrays.asList(new PaymentCard(cardInfo, clientName)));

        this.clientUrgency = 5;
        this.clientValue = 5;
        this.clientStatus = null;
        this.clientSpecialMentions = clientSpecialMentions;

        //by default the 'primary' fields point to these attributes, respectively
        this.clientPrimaryContactPhone = clientMobilePhone;
        this.clientDeliveryAddress = clientShippingAddress;
        this.selectedPaymentMethod = this.cards.get(0);
    }

    // 6° constructor from the same type of object
    public Client (Client myClient)
    {
        this.clientID = myClient.getClientID();
        this.clientName = myClient.getClientName();

        this.clientHomePhone = myClient.getClientHomePhone();
        this.clientBusinessPhone = myClient.getClientBusinessPhone();
        this.clientAlternatePhone = myClient.getClientAlternatePhone();
        this.clientMobilePhone = myClient.getClientMobilePhone();
        this.clientPrimaryContactPhone = myClient.getClientPrimaryContactPhone();
        this.clientPrimaryEmailAddress = myClient.getClientPrimaryEmailAddress();
        this.clientAlternateEmailAddress = myClient.getClientAlternateEmailAddress();
        this.clientBillingAddress = myClient.getClientBillingAddress();
        this.clientShippingAddress = myClient.getClientShippingAddress();
        this.clientAlternateAddress = myClient.getClientAlternateAddress();
        this.clientDeliveryAddress = myClient.getClientDeliveryAddress();
        this.cards = myClient.getCards();
        this.selectedPaymentMethod = myClient.getSelectedPaymentMethod();
        this.clientSpecialMentions = myClient.getClientSpecialMentions();

        //utility attributes
        this.clientUrgency = myClient.getClientUrgency();
        this.clientValue = myClient.getClientValue();
        this.clientStatus = myClient.getClientStatus();
        this.clientReferenceCode = myClient.getClientReferenceCode();
        this.revision = myClient.getRevision();
    }

    //=============CONSTRUCTORS======================================================================================================

    /****************Getters and setters - methods use to access the private attributes of a class **/

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "clientID", unique = true, nullable = false)
    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }


    public PersonName getClientName() {
        return clientName;
    }

    public void setClientName(PersonName clientName) {
        this.clientName = clientName;
    }

    public PhoneNumber getClientBusinessPhone() {
        return clientBusinessPhone;
    }

    public void setClientBusinessPhone(PhoneNumber clientBusinessPhone) {
        this.clientBusinessPhone = clientBusinessPhone;
    }

    public PhoneNumber getClientPrimaryContactPhone() {
        return clientPrimaryContactPhone;
    }

    public void setClientPrimaryContactPhone(PhoneNumber clientPrimaryContactPhone) {
        this.clientPrimaryContactPhone = clientPrimaryContactPhone;
    }


    public PhoneNumber getClientHomePhone() {
        return clientHomePhone;
    }

    public void setClientHomePhone(PhoneNumber clientHomePhone) {
        this.clientHomePhone = clientHomePhone;
    }

    public PhoneNumber getClientAlternatePhone() {
        return clientAlternatePhone;
    }

    public void setClientAlternatePhone(PhoneNumber clientAlternatePhone) {
        this.clientAlternatePhone = clientAlternatePhone;
    }

    public PhoneNumber getClientMobilePhone() {
        return clientMobilePhone;
    }

    public void setClientMobilePhone(PhoneNumber clientMobilePhone) {
        this.clientMobilePhone = clientMobilePhone;
    }

    public String getClientPrimaryEmailAddress() {
        return clientPrimaryEmailAddress;
    }

    public void setClientPrimaryEmailAddress(String clientPrimaryEmailAddress) {
        this.clientPrimaryEmailAddress = clientPrimaryEmailAddress;
    }

    public String getClientAlternateEmailAddress() {
        return clientAlternateEmailAddress;
    }

    public void setClientAlternateEmailAddress(String clientAlternateEmailAddress) {
        this.clientAlternateEmailAddress = clientAlternateEmailAddress;
    }

    public Address getClientBillingAddress() {
        return clientBillingAddress;
    }

    public void setClientBillingAddress(Address clientBillingAddress) {
        this.clientBillingAddress = clientBillingAddress;
    }

    public Address getClientShippingAddress() {
        return clientShippingAddress;
    }

    public void setClientShippingAddress(Address clientShippingAddress) {
        this.clientShippingAddress = clientShippingAddress;
    }

    public Address getClientAlternateAddress() {
        return clientAlternateAddress;
    }

    public void setClientAlternateAddress(Address clientAlternateAddress) {
        this.clientAlternateAddress = clientAlternateAddress;
    }

    public Address getClientDeliveryAddress() {
        return clientDeliveryAddress;
    }

    public void setClientDeliveryAddress(Address clientDeliveryAddress) {
        this.clientDeliveryAddress = clientDeliveryAddress;
    }

    @Nullable
    public List<PaymentCard> getCards() {
        return cards;
    }

    public void setCards(@Nullable List<PaymentCard> cards) {
        this.cards = cards;
    }

    public PaymentCard getSelectedPaymentMethod() {
        return selectedPaymentMethod;
    }

    public void setSelectedPaymentMethod(PaymentCard selectedPaymentMethod) {
        this.selectedPaymentMethod = selectedPaymentMethod;
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


    //****************Getters and setters - methods use to access the private attributes of a class

    //return a reference to this Client object
    public Client getClient () {return this;}

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
        if (!this.clientID.equals(other.getClientID())) differencesIndex+=1; else differencesIndex+=0;

        //#2 Client Name
        if (!this.clientName.equals(other.getClientName())) differencesIndex+=1; else differencesIndex+=0;

        //#3 Phone contact info
        if (!this.clientHomePhone.equals(other.getClientHomePhone())) differencesIndex+=1; else differencesIndex+=0;
        if (!this.clientBusinessPhone.equals(other.getClientBusinessPhone())) differencesIndex+=1; else differencesIndex+=0;
        if (!this.clientAlternatePhone.equals(other.getClientAlternatePhone())) differencesIndex+=1; else differencesIndex+=0;
        if (!this.clientMobilePhone.equals(other.getClientMobilePhone())) differencesIndex+=1; else differencesIndex+=0;
        if (!this.clientPrimaryContactPhone.equals(other.getClientPrimaryContactPhone())) differencesIndex+=1; else differencesIndex+=0;

        //#4 email address
        if (!this.clientPrimaryEmailAddress.equals(other.getClientPrimaryEmailAddress())) differencesIndex+=1; else differencesIndex+=0;
        if (!this.clientAlternateEmailAddress.equals(other.getClientAlternateEmailAddress())) differencesIndex+=1; else differencesIndex+=0;

        //#5 Client adresses
        if (!this.clientBillingAddress.equals(other.getClientBillingAddress())) differencesIndex+=1; else differencesIndex+=0;
        if (!this.clientShippingAddress.equals(other.getClientShippingAddress())) differencesIndex+=1; else differencesIndex+=0;
        if (!this.clientAlternateAddress.equals(other.getClientAlternateAddress())) differencesIndex+=1; else differencesIndex+=0;
        if (!this.clientDeliveryAddress.equals(other.getClientDeliveryAddress())) differencesIndex+=1; else differencesIndex+=0;


        //#6 payment info
        if (!this.cards.equals(other.getCards())) differencesIndex+=1; else differencesIndex+=0;
        if (!this.selectedPaymentMethod.equals(other.getSelectedPaymentMethod())) differencesIndex+=1; else differencesIndex+=0;


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
                ", clientPrimaryContactPhone=" + clientPrimaryContactPhone +
                ", clientPrimaryEmailAddress='" + clientPrimaryEmailAddress + '\'' +
                ", clientAlternateEmailAddress='" + clientAlternateEmailAddress + '\'' +
                ", clientBillingAddress=" + clientBillingAddress +
                ", clientShippingAddress=" + clientShippingAddress +
                ", clientAlternateAddress=" + clientAlternateAddress +
                ", clientDeliveryAddress=" + clientDeliveryAddress +
                ", cards=" + cards +
                ", selectedPaymentMethod=" + selectedPaymentMethod +
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
                //", cards=" + cards.get(0).simpleCardInfo() +
                ", clientUrgency=" + clientUrgency +
                ", clientValue=" + clientValue +
                ", clientStatus='" + clientStatus + '\'' +
                ", clientSpecialMentions='" + clientSpecialMentions + '\'' +
                '}';
    }

    //for debugging purposes
   /* public void showClient () {
        Log.d("THIS_CLIENT NAME", clientName);
        Log.d("THIS_CLIENT PHONE", clientPhoneNo);
        Log.d("THIS_CLIENT LOCATION", clientLocation);
        Log.d("THIS_CLIENT PROD ID", clientProductID);
        Log.d("THIS_CLIENT QUANT", String.valueOf(clientQuantity));
        Log.d("THIS_CLIENT PRICE", String.valueOf(clientPrice));
        Log.d("THIS_CLIENT PR ADJ", String.valueOf(clientPriceAdjust));
        Log.d("THIS_CLIENT URGENCY", String.valueOf(clientUrgency));
        Log.d("THIS_CLIENT VALUE", String.valueOf(clientValue));
        Log.d("THIS_CLIENT STATUS", clientStatus);
        Log.d("THIS_CLIENT REF CODE", clientReferenceCode);
        Log.d("THIS_CLIENT REVISION", revision);
    }*/

}