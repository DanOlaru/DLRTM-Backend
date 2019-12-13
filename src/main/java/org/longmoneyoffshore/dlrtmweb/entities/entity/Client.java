package org.longmoneyoffshore.dlrtmweb.entities.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Client")
@Table(name = "clients")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client implements Serializable {

    @Id //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue
    private int clientID;

    private String clientName;

    private String clientBusinessPhone;

    private String emailAddress;

    private String clientAddress;
    //@Nullable
    //private Address clientDeliveryAddress; //the actual delivery address used —————— one from the list above

    //#6 payment info
    //@OneToMany (mappedBy = "paymentCards")
    //private List<PaymentCard> cards;
    //@Nullable
    private String paymentCard; // points to one of the above

    //#7 Other (/internal) client info Value Range 0-5

    private String clientStatus;

    private String clientSpecialMentions;


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
}