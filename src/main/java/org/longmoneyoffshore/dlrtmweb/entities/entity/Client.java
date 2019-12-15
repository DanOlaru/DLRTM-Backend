package org.longmoneyoffshore.dlrtmweb.entities.entity;

import lombok.*;
import org.longmoneyoffshore.dlrtmweb.entities.atomic.PaymentCard;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "Client")
@Table(name = "clients")
@Builder
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "clientID")
    private int clientID;

    @Column(name = "clientName")
    private String clientName;

    @Column(name = "clientBusinessPhone")
    private String clientBusinessPhone;

    @Column(name = "emailAddress")
    private String emailAddress;

    @Column(name = "clientAddress")
    private String clientAddress;
    //@Nullable
    //private Address clientDeliveryAddress; //the actual delivery address used —————— one from the list above

    //#6 payment info
    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "clientID")
    //@OneToMany (mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaymentCard> cards = new ArrayList<>();

    //#7 Other (/internal) client info Value Range 0-5

    @Column(name = "clientStatus")
    private String clientStatus;

    @Column(name = "clientSpecialMentions")
    private String clientSpecialMentions;

    public Client () { }

    @Override
    public boolean equals(Object o) {

        if ((o == null) || !(o instanceof Client)) return false;

        return (this.clientID == ((Client) o).getClientID());
    }

    @Override
    public int hashCode() {
        int sumOfDigits = 0, xCopy = this.clientID;
        while (xCopy > 0) {
            sumOfDigits += xCopy / 10;
            xCopy /= 10;
        }

        return sumOfDigits;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientID='" + clientID + '\'' +
                ", clientName=" + clientName +
                ", clientBusinessPhone=" + clientBusinessPhone +
                ", clientPrimaryEmailAddress='" + emailAddress + '\'' +
                //", cards=" + cards +
                ", clientStatus='" + clientStatus + '\'' +
                ", clientSpecialMentions='" + clientSpecialMentions + '\'' +
                '}';
    }

    public String smallToString() {
        return "Client{" +
                "clientID='" + clientID + '\'' +
                ", clientName=" + clientName +
                ", clientPrimaryEmailAddress='" + emailAddress + '\'' +
                ", clientStatus='" + clientStatus + '\'' +
                ", clientSpecialMentions='" + clientSpecialMentions + '\'' +
                '}';
    }
    public String smallToStringWithCards() {
        return "Client{" +
                "clientID='" + clientID + '\'' +
                ", clientName=" + clientName +
                ", clientPrimaryEmailAddress='" + emailAddress + '\'' +
                ", clientStatus='" + clientStatus + '\'' +
                ", cards='" + cards.stream().map(PaymentCard::getFullCardInfo).collect(Collectors.joining(" || ")) + '\'' +
                ", clientSpecialMentions='" + clientSpecialMentions + '\'' +
                '}';
    }

    /*public void addCard (PaymentCard paymentCard) {
        this.cards.add(paymentCard);
        paymentCard.setClient(this);
    }

    public void removeCard (PaymentCard paymentCard) {
        cards.remove(paymentCard);
        paymentCard.setClient(null);
    }*/


}