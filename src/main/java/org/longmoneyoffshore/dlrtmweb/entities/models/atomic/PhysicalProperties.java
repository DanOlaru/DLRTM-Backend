package org.longmoneyoffshore.dlrtmweb.entities.models.atomic;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
//import javax.persistence.Entity;

//@Entity
@Embeddable
//@Access(AccessType.PROPERTY)
public class PhysicalProperties {

    //@Column(name="LENGTH")
    private double length;

    //@Column(name="WIDTH")
    private double width;

    //@Column(name="DEPTH")
    private double depth;

    //@Column(name="HEIGHT")
    private double height;

    //@Column(name="WEIGHT")
    private double weight;

    //@Column(name="SIZEMEASUREMENUNIT")
    @Size(max = 40)
    private String sizeMeasurementUnit;

    //@Column(name="WEIGHTMEASUREMENTUNIT")
    @Size(max = 40)
    private String weightMeasurementUnit;


    public PhysicalProperties() { }

    public PhysicalProperties(double length, double width, double depth, double height, double weight, String sizeMeasurementUnit,
                              String weightMeasurementUnit) {
        this.length = length;
        this.width = width;
        this.depth = depth;
        this.height = height;
        this.weight = weight;
        this.sizeMeasurementUnit = sizeMeasurementUnit;
        this.weightMeasurementUnit = weightMeasurementUnit;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSizeMeasurementUnit() {
        return sizeMeasurementUnit;
    }

    public void setSizeMeasurementUnit(String sizeMeasurementUnit) {
        this.sizeMeasurementUnit = sizeMeasurementUnit;
    }

    public String getWeightMeasurementUnit() {
        return weightMeasurementUnit;
    }

    public void setWeightMeasurementUnit(String weightMeasurementUnit) {
        this.weightMeasurementUnit = weightMeasurementUnit;
    }

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
