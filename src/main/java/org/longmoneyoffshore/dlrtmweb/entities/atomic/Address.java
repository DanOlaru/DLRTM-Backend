/*
package org.longmoneyoffshore.dlrtmweb.entities.atomic;

import lombok.*;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Builder
@Getter
@Setter
@AllArgsConstructor
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
    private double latitude, longitude;


    public Address() {
        this.fullAddress = "";
    }

    public Address(String fullAddress) {
        this.fullAddress = fullAddress;
        //TODO: parse and populate the individual fields!!!!!!!!!!
        //regex?

    }


    public String getStandardAddress() {
        return personName + "\n" +
                " " + bldgNumber + " " + streetName + "\n" +
                cityName + ", " + provinceName + ", " + zipCode + "\n" +
                country + "\n" ;
    }

    @Override
    public String toString() {
        return
                ", personName='" + personName + '\'' +
                ", bldgNumber='" + bldgNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", otherInfo='" + otherInfo + '\'' +

                //by Dan
                ", latitude ='" + latitude  + '\'' +
                ", longitude ='" + longitude + '\'' +
                '}';
    }

    public String simpleAddress() {
        return
                        ", bldgNumber='" + bldgNumber + '\'' +
                        ", streetName='" + streetName + '\'' +
                        ", cityName='" + cityName + '\'' +
                        ", provinceName='" + provinceName + '\'' +
                        ", zipCode='" + zipCode + '\'' +
                        ", country='" + country + '\'' +
                        ", otherInfo='" + otherInfo + '\''
                       ;
    }


    //utility methods
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
*/
