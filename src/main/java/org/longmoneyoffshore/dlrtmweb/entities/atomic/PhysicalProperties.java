/*
package org.longmoneyoffshore.dlrtmweb.entities.atomic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
//import javax.persistence.Entity;

//@Entity
@Embeddable
//@Access(AccessType.PROPERTY)
@Getter
@Setter
@Builder
@AllArgsConstructor
public class PhysicalProperties {

    @Column(name="LENGTH")
    private double length;

    @Column(name="WIDTH")
    private double width;

    @Column(name="DEPTH")
    private double depth;

    @Column(name="HEIGHT")
    private double height;

    @Column(name="WEIGHT")
    private double weight;

    @Column(name="SIZEMEASUREMENUNIT")
    @Size(max = 40)
    private String sizeMeasurementUnit;

    @Column(name="WEIGHTMEASUREMENTUNIT")
    @Size(max = 40)
    private String weightMeasurementUnit;


    public PhysicalProperties() { }

    @Override
    public String toString() {
        return "PhysicalProperties{" +
                "length=" + length + "\n" +
                ", width=" + width + "\n" +
                ", depth=" + depth + "\n" +
                ", height=" + height + "\n" +
                ", weight=" + weight + "\n" +
                ", sizeMeasurementUnit='" + sizeMeasurementUnit.trim() + '\'' + "\n" +
                ", weightMeasurementUnit='" + weightMeasurementUnit.trim() + '\'';
    }
}
*/
