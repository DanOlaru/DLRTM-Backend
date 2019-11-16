package org.longmoneyoffshore.dlrtmweb.entities.atomic;

//@Embeddable
public class PaymentCard {

    private String fullCardInfo;
    private String cardNumber;
    private String nameOnCard;
    private String cardExpirationDate;
    private String CVC;

    public PaymentCard() {}

   /* public PaymentCard() {
        cardNumber = "";
        nameOnCard = "";
        cardExpirationDate = "";
        CVC = "";
    };*/

    public PaymentCard(String cardNumber, String nameOnCard, String cardExpirationDate, String CVC) {
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.cardExpirationDate = cardExpirationDate;
        this.CVC = CVC;
    }

    //TODO: card details contains, in this order: card number, expiration date, CVC
    public PaymentCard(String cardDetails) {
        //TODO: parse cardDetails to cardNumber, cardExpirationDate, cardVerificationNumber
        this.fullCardInfo = cardDetails;
        cardNumber = "";
        nameOnCard = "";
        cardExpirationDate = "";
        CVC = "";
    }

    public String getFullCardInfo() {
        return fullCardInfo;
    }

    public void setFullCardInfo(String fullCardInfo) {
        this.fullCardInfo = fullCardInfo;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getCardExpirationDate() {
        return cardExpirationDate;
    }

    public void setCardExpirationDate(String cardExpirationDate) {
        this.cardExpirationDate = cardExpirationDate;
    }

    public String getCVC() {
        return CVC;
    }

    public void setCVC(String CVC) {
        this.CVC = CVC;
    }


    @Override
    public String toString() {
        return "PaymentInfo{" +
                "cardNumber='" + cardNumber + '\'' +
                ", nameOnCard='" + nameOnCard + '\'' +
                ", cardExpirationDate='" + cardExpirationDate + '\'' +
                ", cardVerificationNumber='" + CVC + '\'' +
                '}';
    }

    public String simpleCardInfo() {
        return
                "cardNumber='" + cardNumber + '\'' +
                ", nameOnCard='" + nameOnCard + '\'' +
                ", cardExpirationDate='" + cardExpirationDate + '\'' +
                ", cardVerificationNumber='" + CVC + '\'' +
                '}';
    }

}
