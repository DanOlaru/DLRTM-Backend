package webtodb.models;

import java.util.StringTokenizer;

public class PersonName {

    //Enum<String> PersonalTitles {"Mr.","Mrs.","Ms.", "Miss."} //TODO what's wrong with these??
    //Enum<String> PersonalPostfixes {"Sr.", "Jr."};


    private String title = null; //TODO: to be converted to the Enum defined in the Global Values class
    private String postFix = null; //TODO: to be converted to the Enum defined in the Global Values class

    private String clientFirstName;
    private String clientMiddleName;
    private String clientLastName;

    private String nickname, alias;

    //#1 constructor that separates individual names from single String name, no title or postfix
    public PersonName(String fullName) {

        StringTokenizer tokenizer = new StringTokenizer(fullName);

        this.clientFirstName = tokenizer.nextToken();
        this.clientMiddleName = tokenizer.nextToken();
        this.clientLastName = tokenizer.nextToken();
    }

    //#2 from already separated names, no title or postfix
    public PersonName(String clientFirstName, String clientMiddleName, String clientLastName) {
        this.clientFirstName = clientFirstName;
        this.clientMiddleName = clientMiddleName;
        this.clientLastName = clientLastName;
    }

    //#3 from complete separated names, w/ title and postfix
    public PersonName(String title, String clientFirstName, String clientMiddleName, String clientLastName, String postFix) {
        this.title = title;
        this.postFix = postFix;
        this.clientFirstName = clientFirstName;
        this.clientMiddleName = clientMiddleName;
        this.clientLastName = clientLastName;
    }

    //#4 full constructor
    public PersonName(String title, String postFix, String clientFirstName, String clientMiddleName, String clientLastName,
                      String nickname, String alias) {
        this.title = title;
        this.postFix = postFix;
        this.clientFirstName = clientFirstName;
        this.clientMiddleName = clientMiddleName;
        this.clientLastName = clientLastName;
        this.nickname = nickname;
        this.alias = alias;
    }

    //Getters and Setters

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientMiddleName() {
        return clientMiddleName;
    }

    public void setClientMiddleName(String clientMiddleName) {
        this.clientMiddleName = clientMiddleName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostFix() {
        return postFix;
    }

    public void setPostFix(String postFix) {
        this.postFix = postFix;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }


    //TODO: utility methods to convert human-readable to machine readable name formats

    @Override
    public String toString() {
        return "PersonName{" +
                "title='" + title + '\'' +
                ", postFix='" + postFix + '\'' +
                ", clientFirstName='" + clientFirstName + '\'' +
                ", clientMiddleName='" + clientMiddleName + '\'' +
                ", clientLastName='" + clientLastName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}
