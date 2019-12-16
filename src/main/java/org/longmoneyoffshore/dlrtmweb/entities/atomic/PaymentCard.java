package org.longmoneyoffshore.dlrtmweb.entities.atomic;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Client;

import javax.persistence.*;
import javax.transaction.Transactional;

import static javax.persistence.GenerationType.IDENTITY;

//@Embeddable
@Entity
@Table(name = "payment_cards")
@Data
@Transactional
public class PaymentCard {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String fullCardInfo;
    private String cardNumber;
    private String nameOnCard;
    private String cardExpirationDate;
    private String CVC;

    //@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

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
        return id != 0 && id == (((PaymentCard) o).getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
