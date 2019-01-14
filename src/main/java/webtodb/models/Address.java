package webtodb.models;

import java.util.Objects;

public class Address {

    //fields
    private String fullAddress;


    private String personName;

    private String bldgNumber;
    private String streetName;
    private String cityName;
    private String provinceName; // same as state for US
    private String zipCode;
    private String country;

    private String otherInfo;


    public Address(String fullAddress) {
        this.fullAddress = fullAddress;
        //TODO: from here we populate the individual fields!!!!!!!!!!
    }

    public Address(String personName, String bldgNumber, String streetName, String cityName, String provinceName, String zipCode, String country, String otherInfo) {
        this.personName = personName;
        this.bldgNumber = bldgNumber;
        this.streetName = streetName;
        this.cityName = cityName;
        this.provinceName = provinceName;
        this.zipCode = zipCode;
        this.country = country;
        this.otherInfo = otherInfo;
    }


    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getBldgNumber() {
        return bldgNumber;
    }

    public void setBldgNumber(String bldgNumber) {
        this.bldgNumber = bldgNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }


    @Override
    public String toString() {
        return "Address{" +
                "fullAddress='" + fullAddress + '\'' +
                ", personName='" + personName + '\'' +
                ", bldgNumber='" + bldgNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", otherInfo='" + otherInfo + '\'' +
                '}';
    }



    //utility methods — experimental
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(fullAddress, address.fullAddress) &&
                Objects.equals(personName, address.personName) &&
                Objects.equals(bldgNumber, address.bldgNumber) &&
                Objects.equals(streetName, address.streetName) &&
                Objects.equals(cityName, address.cityName) &&
                Objects.equals(provinceName, address.provinceName) &&
                Objects.equals(zipCode, address.zipCode) &&
                Objects.equals(country, address.country) &&
                Objects.equals(otherInfo, address.otherInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullAddress, personName, bldgNumber, streetName, cityName, provinceName, zipCode, country, otherInfo);
    }
}
