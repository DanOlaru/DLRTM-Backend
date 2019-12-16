package org.longmoneyoffshore.dlrtmweb.entities.entity;

import lombok.*;
import org.longmoneyoffshore.dlrtmweb.entities.atomic.PaymentCard;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "Client")
@Table(name = "clients")
@Builder
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "clientName")
    private String clientName;

    @Column(name = "clientBusinessPhone")
    private String clientBusinessPhone;

    @Column(name = "emailAddress")
    private String emailAddress;

    @ToString.Exclude
    @Column(name = "clientAddress")
    private String clientAddress;

    @OneToMany (mappedBy = "client", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<PaymentCard> cards = new ArrayList<>();

    @Column(name = "clientStatus")
    private String clientStatus;

    @Column(name = "clientSpecialMentions")
    private String clientSpecialMentions;

    public Client () { }

    @Override
    public String toString() {
        return "Client{" +
                "clientID='" + id + '\'' +
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
                "clientID='" + id + '\'' +
                ", clientName=" + clientName +
                ", clientPrimaryEmailAddress='" + emailAddress + '\'' +
                ", clientStatus='" + clientStatus + '\'' +
                ", clientSpecialMentions='" + clientSpecialMentions + '\'' +
                '}';
    }
    public String smallToStringWithCards() {
        return "Client{" +
                "clientID='" + id + '\'' +
                ", clientName=" + clientName +
                ", clientPrimaryEmailAddress='" + emailAddress + '\'' +
                ", clientStatus='" + clientStatus + '\'' +
                ", cards='" + cards.stream().map(PaymentCard::getFullCardInfo).collect(Collectors.joining(" || ")) + '\'' +
                ", clientSpecialMentions='" + clientSpecialMentions + '\'' +
                '}';
    }

    public void addCard (PaymentCard paymentCard) {
        cards.add(paymentCard);
        paymentCard.setClient(this);
    }

    public void removeCard (PaymentCard paymentCard) {
        cards.remove(paymentCard);
        paymentCard.setClient(null);
    }


}