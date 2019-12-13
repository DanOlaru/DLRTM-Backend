package org.longmoneyoffshore.dlrtmweb.entities.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity (name = "Client")
@Table(name = "clients_hibernate")
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

    private float clientUrgency;
    private float clientValue;
    private String clientStatus;

    private String clientSpecialMentions;

    /************ !!!!!!!!!!!!!!!!!!!!!!!!!!!! other/utility methods !!!!!!!!!!!!!!!!!!!!!!!!!!!! *******/

    /*public String clientDifferences(Client other) {
        String differencesIndex="";

        //#1 Client id
        if (!(this.clientID ==other.getClientID())) differencesIndex+=1; else differencesIndex+=0;

        //#2 Client Name
        if (!this.clientName.equals(other.getClientName())) differencesIndex+=1; else differencesIndex+=0;

        //#3 Phone contact info
        if (!this.clientBusinessPhone.equals(other.getClientBusinessPhone())) differencesIndex+=1; else differencesIndex+=0;

        //#4 email address
        if (!this.emailAddress.equals(other.getEmailAddress())) differencesIndex+=1; else differencesIndex+=0;

        //#5 Client adresses
        if (!this.clientAddress.equals(other.getClientAddress())) differencesIndex+=1; else differencesIndex+=0;


        //#6 payment info
        //if (!this.cards.equals(other.getCards())) differencesIndex+=1; else differencesIndex+=0;
        //if (!this.selectedPaymentMethod.equals(other.getSelectedPaymentMethod())) differencesIndex+=1; else differencesIndex+=0;


        //#7 Other (/internal) info
        if (this.clientUrgency != other.getClientUrgency()) differencesIndex+=1; else differencesIndex+=0;
        if (this.clientValue != other.getClientValue()) differencesIndex+=1; else differencesIndex+=0;
        if (!this.clientStatus.equals(other.getClientStatus())) differencesIndex+=1; else differencesIndex+=0;

        return differencesIndex;
    }*/

    @Override
    public String toString() {
        return "Client{" +
                "clientID='" + clientID + '\'' +
                ", clientName=" + clientName +
                ", clientBusinessPhone=" + clientBusinessPhone +
                ", clientPrimaryEmailAddress='" + emailAddress + '\'' +
                //", cards=" + cards +
                ", clientUrgency=" + clientUrgency +
                ", clientValue=" + clientValue +
                ", clientStatus='" + clientStatus + '\'' +
                ", clientSpecialMentions='" + clientSpecialMentions + '\'' +
                '}';
    }

    public String smallToString() {
        return "Client{" +
                "clientID='" + clientID + '\'' +
                ", clientName=" + clientName +
                ", clientPrimaryEmailAddress='" + emailAddress + '\'' +
                ", clientUrgency=" + clientUrgency +
                ", clientValue=" + clientValue +
                ", clientStatus='" + clientStatus + '\'' +
                ", clientSpecialMentions='" + clientSpecialMentions + '\'' +
                '}';
    }
}