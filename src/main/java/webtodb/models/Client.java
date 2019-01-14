package webtodb.models;

//import android.util.Log;
import java.util.Arrays;
import java.util.List;

import static webtodb.globalvalues.GlobalValues.US_ANONYMIZER_PREFIX;


//change
public class Client {

    /* Client info consists of: name, location, phone number, product, quantity, total price, price per unit,
     * ClientPriceAdjust is positive if client owes and negative if client is owed,
     * ClientUrgency is on a scale of 1 to 5
     * ClientValue is on a scale of 1 to 5 — expresses how important client is
     * ClientSeen - expresses whether the client was served or not
     * this is the data with which the core code operates, pulled off of the database
     */

    //version 2 attributes ================================================================================================

    //private Client thisClientRef;

    private String clientUniqueID;

    //Client Name
    private String clientFirstName;
    private String clientMiddleName;
    private String clientLastName;

    //Phone contact info
    private PhoneNumber clientPrimaryPhone, clientAlternatePhone, clientMobilePhone, clientPrimaryContactPhone; //first phone to contact

    //email address
    private String clientPrimaryEmailAddress,clientAlternateEmailAddress;


    //Client adresses

    private Address clientBillingAddress, clientShippingAddress, clientAlternateAddress;
    private Address clientDeliveryAddress; //the actual delivery address —————— one from the list above


    //payment info

    private PaymentInfo cardInfo, alternateCardInfo;
    private PaymentInfo selectedPaymentMethod; // one of the above


    //Other (/internal) info
    private float clientUrgency;
    private float clientValue;
    private String clientStatus;

    //other hidden internal / reference / utility variables
    private String clientReferenceCode = "0";
    private String revision = "0";

    //version 2 attributes ================================================================================================




    /****************************************Constructors******************/
    // 1° constructor -  basic
    public Client()
    {}

    //full constructor


    public Client(String clientUniqueID, String clientFirstName, String clientMiddleName, String clientLastName,
                  PhoneNumber clientPrimaryPhone, PhoneNumber clientAlternatePhone, PhoneNumber clientMobilePhone,
                  String clientPrimaryEmailAddress, String clientAlternateEmailAddress, Address clientBillingAddress,
                  Address clientShippingAddress, Address clientAlternateAddress, Address clientDeliveryAddress, PaymentInfo cardInfo,
                  PaymentInfo alternateCardInfo, PaymentInfo selectedPaymentMethod, float clientUrgency, float clientValue,
                  String clientStatus, String clientReferenceCode, String revision) {

        this.clientUniqueID = clientUniqueID;
        this.clientFirstName = clientFirstName;
        this.clientMiddleName = clientMiddleName;
        this.clientLastName = clientLastName;
        this.clientPrimaryPhone = clientPrimaryPhone;
        this.clientAlternatePhone = clientAlternatePhone;
        this.clientMobilePhone = clientMobilePhone;
        this.clientPrimaryEmailAddress = clientPrimaryEmailAddress;
        this.clientAlternateEmailAddress = clientAlternateEmailAddress;
        this.clientBillingAddress = clientBillingAddress;
        this.clientShippingAddress = clientShippingAddress;
        this.clientAlternateAddress = clientAlternateAddress;
        this.clientDeliveryAddress = clientDeliveryAddress;
        this.cardInfo = cardInfo;
        this.alternateCardInfo = alternateCardInfo;
        this.selectedPaymentMethod = selectedPaymentMethod;
        this.clientUrgency = clientUrgency;
        this.clientValue = clientValue;
        this.clientStatus = clientStatus;
        this.clientReferenceCode = clientReferenceCode;
        this.revision = revision;

        //by Dan
        this.clientPrimaryContactPhone = clientMobilePhone;
    }

    // 6° constructor from the same type of object — Dan
    public Client (Client fromClient)
    {
        this.clientUniqueID = fromClient.getClientUniqueID();
        this.clientFirstName = fromClient.getClientFirstName();
        this.clientMiddleName = fromClient.getClientMiddleName();
        this.clientLastName = fromClient.getClientLastName();
        this.clientPrimaryPhone = fromClient.getClientPrimaryPhone();
        this.clientAlternatePhone = fromClient.getClientAlternatePhone();
        this.clientMobilePhone = fromClient.getClientMobilePhone()
        this.getClientPrimaryPhone = fromClient.getClientP
        this.clientPrimaryEmailAddress = clientPrimaryEmailAddress;
        this.clientAlternateEmailAddress = clientAlternateEmailAddress;
        this.clientBillingAddress = clientBillingAddress;
        this.clientShippingAddress = clientShippingAddress;
        this.clientAlternateAddress = clientAlternateAddress;
        this.clientDeliveryAddress = clientDeliveryAddress;
        this.cardInfo = cardInfo;
        this.alternateCardInfo = alternateCardInfo;
        this.selectedPaymentMethod = selectedPaymentMethod;
        this.clientUrgency = clientUrgency;
        this.clientValue = clientValue;
        this.clientStatus = clientStatus;
        this.clientReferenceCode = clientReferenceCode;
        this.revision = revision;

    }

    /****************Getters and setters - methods use to access the private attributes of a class **/

    public String getClientUniqueID() {
        return clientUniqueID;
    }

    public void setClientUniqueID(String clientUniqueID) {
        this.clientUniqueID = clientUniqueID;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientMiddleName() {
        return clientMiddleName;
    }

    public void setClientMiddleName(String clientMiddleName) {
        this.clientMiddleName = clientMiddleName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public PhoneNumber getClientPrimaryPhone() {
        return clientPrimaryPhone;
    }

    public void setClientPrimaryPhone(PhoneNumber clientPrimaryPhone) {
        this.clientPrimaryPhone = clientPrimaryPhone;
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

    public PaymentInfo getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(PaymentInfo cardInfo) {
        this.cardInfo = cardInfo;
    }

    public PaymentInfo getAlternateCardInfo() {
        return alternateCardInfo;
    }

    public void setAlternateCardInfo(PaymentInfo alternateCardInfo) {
        this.alternateCardInfo = alternateCardInfo;
    }

    public PaymentInfo getSelectedPaymentMethod() {
        return selectedPaymentMethod;
    }

    public void setSelectedPaymentMethod(PaymentInfo selectedPaymentMethod) {
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

    /****************Getters and setters - methods use to access the private attributes of a class **/


    //return a reference to this Client object
    public Client getClient () {return this;}

    //other methods

    //convert client to List<List<Object>>
   /* public List<List<Object>> returnClientAsObjectList() {
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

        if (!this.clientName.equals(other.getClientName())) differencesIndex+=1; else differencesIndex+=0;

        if (!this.clientPhoneNo.equals(other.getClientPhoneNo())) differencesIndex+=1; else differencesIndex+=0;

        if (!this.clientLocation.equals(other.getClientLocation())) differencesIndex+=1; else differencesIndex+=0;

        if (this.clientUrgency != other.getClientUrgency()) differencesIndex+=1; else differencesIndex+=0;

        if (this.clientValue != other.getClientValue()) differencesIndex+=1; else differencesIndex+=0;

        if (!this.clientStatus.equals(other.getClientStatus())) differencesIndex+=1; else differencesIndex+=0;

        return differencesIndex;
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