package webtodb.models;

import static webtodb.globalvalues.GlobalValues.US_ANONYMIZER_PREFIX;

public class PhoneNumber {

    private String clientPhoneNo; // It's a string because the sequence of numbers does not have any logic behind it
    private String clientAreaCode;
    private String anonymizerPrefix = US_ANONYMIZER_PREFIX; //can be set to a different value —————————— hidden

    //utility variables
    private int isPrimary = 0;


    public PhoneNumber(String clientPhoneNo, String clientAreaCode, String anonymizerPrefix) {
        this.clientPhoneNo = clientPhoneNo;
        this.clientAreaCode = clientAreaCode;
        this.anonymizerPrefix = anonymizerPrefix;
    }


    public String getClientPhoneNo() {
        return clientPhoneNo;
    }

    public void setClientPhoneNo(String clientPhoneNo) {
        this.clientPhoneNo = clientPhoneNo;
    }

    public String getClientAreaCode() {
        return clientAreaCode;
    }

    public void setClientAreaCode(String clientAreaCode) {
        this.clientAreaCode = clientAreaCode;
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
