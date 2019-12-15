package org.longmoneyoffshore.dlrtmweb.entities.atomic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Client;

import javax.persistence.*;

//@Embeddable
@Entity(name = "PaymentCard")
@Table(name = "payment_cards")
@Getter
@Setter
@Data
public class PaymentCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cardID")
    private int cardID;

    private String fullCardInfo;
    private String cardNumber;
    private String nameOnCard;
    private String cardExpirationDate;
    private String CVC;

    //@JsonIgnore
    //@ManyToOne(fetch = FetchType.LAZY)
    //@ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "clientid")
    //private Client client;

    public PaymentCard() {
        cardNumber = "";
        nameOnCard = "";
        cardExpirationDate = "";
        CVC = "";
    }

    public PaymentCard(String cardNumber, String nameOnCard, String cardExpirationDate, String CVC) {
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.cardExpirationDate = cardExpirationDate;
        this.CVC = CVC;
    }

    //TODO: card details contains, in this order: card number, expiration date, CVC
    public PaymentCard(String cardDetails) {

        String[] cardDetailsSplit = cardDetails.split(",");
        this.fullCardInfo = cardDetails;

        this.cardNumber = cardDetailsSplit[0];
        this.cardExpirationDate = cardDetailsSplit[1];
        this.CVC = cardDetailsSplit[2];
    }

    public PaymentCard(String cardDetails, String nameOnCard) {
        this.fullCardInfo = cardDetails;
        this.nameOnCard = nameOnCard;

        String[] cardDetailsSplit = cardDetails.split(",");
        this.cardNumber = cardDetailsSplit[0];
        this.cardExpirationDate = cardDetailsSplit[1];
        this.CVC = cardDetailsSplit[2];
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentCard)) return false;
        return cardID != 0 && cardID == (((PaymentCard) o).getCardID());
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
