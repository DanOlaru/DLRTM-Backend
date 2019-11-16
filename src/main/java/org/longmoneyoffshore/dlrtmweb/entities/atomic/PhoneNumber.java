package org.longmoneyoffshore.dlrtmweb.entities.atomic;

import static org.longmoneyoffshore.dlrtmweb.globalvalues.GlobalValues.US_ANONYMIZER_PREFIX;

public class PhoneNumber { //implements Serializable {

    private String ownerName;
    private String clientPhoneNo;
    private String clientAreaCode;
    private String anonymizerPrefix = US_ANONYMIZER_PREFIX; //can be set to a different value —————————— hidden

    //utility variables
    private int isPrimary = 0;


    public PhoneNumber() {
        this.ownerName = "";
        this.clientPhoneNo = "";
        this.clientAreaCode = "";
    }

    //full constructor
    public PhoneNumber(String owner, String phoneNo, String clientAreaCode, String anonymizerPrefix) {
        this.ownerName = owner;
        this.clientPhoneNo = phoneNo;
        this.clientAreaCode = clientAreaCode;
        this.anonymizerPrefix = anonymizerPrefix;
    }

    public PhoneNumber(String owner, String phoneNo) {
        this.ownerName = owner;
        this.clientPhoneNo = phoneNo;
        this.clientAreaCode = "";
        this.anonymizerPrefix = "";
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getClientPhoneNo() {
        return clientPhoneNo;
    }

    public void setClientPhoneNo(String phoneNo) {
        this.clientPhoneNo = phoneNo;
    }

    public String getClientAreaCode() {
        return clientAreaCode;
    }

    public void setClientAreaCode(String areaCode) {
        this.clientAreaCode = areaCode;
    }

    public String getAnonymizerPrefix() {
        return anonymizerPrefix;
    }

    public void setAnonymizerPrefix(String anonymizerPrefix) {
        this.anonymizerPrefix = anonymizerPrefix;
    }



    //utility variables
    public int getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(int isPrimary) {
        this.isPrimary = isPrimary;
    }



    @Override
    public String toString() {
        return "PhoneNumber{" +
                "clientPhoneNo='" + clientPhoneNo + '\'' +
                ", clientAreaCode='" + clientAreaCode + '\'' +
                ", anonymizerPrefix='" + anonymizerPrefix + '\'' +
                '}';
    }


    //utility methods

    //formats the number imputted to standard US spacing/format
    public void formatPhoneNo() {
        StringBuilder formattingResultNo = new StringBuilder();
        int resultLen = 0;

        for (int k=0; k<clientPhoneNo.length();k++) {
            if (clientPhoneNo.charAt(k) != ' ')
            {
                if ((resultLen==3) || (resultLen==7)) {
                    if (clientPhoneNo.charAt(k) != ' ') formattingResultNo.append(" ");
                    resultLen++;
                }
                formattingResultNo.append(clientPhoneNo.charAt(k));
                resultLen++;
            }
        }

        this.clientPhoneNo = formattingResultNo.toString();
    }

}
