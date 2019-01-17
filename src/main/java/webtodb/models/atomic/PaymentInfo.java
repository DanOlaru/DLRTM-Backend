package webtodb.models.atomic;

public class PaymentInfo {

    private String cardNumber;
    private String nameOnCard;
    private String cardExpirationDate;
    private String cardVerificationNumber; //CVV

    public PaymentInfo(String cardNumber, String nameOnCard, String cardExpirationDate, String cardVerificationNumber) {
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.cardExpirationDate = cardExpirationDate;
        this.cardVerificationNumber = cardVerificationNumber;
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

    public String getCardVerificationNumber() {
        return cardVerificationNumber;
    }

    public void setCardVerificationNumber(String cardVerificationNumber) {
        this.cardVerificationNumber = cardVerificationNumber;
    }


    @Override
    public String toString() {
        return "PaymentInfo{" +
                "cardNumber='" + cardNumber + '\'' +
                ", nameOnCard='" + nameOnCard + '\'' +
                ", cardExpirationDate='" + cardExpirationDate + '\'' +
                ", cardVerificationNumber='" + cardVerificationNumber + '\'' +
                '}';
    }

}
