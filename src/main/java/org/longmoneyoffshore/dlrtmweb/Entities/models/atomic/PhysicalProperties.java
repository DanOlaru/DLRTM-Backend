package org.longmoneyoffshore.dlrtmweb.Entities.models.atomic;

public class PhysicalProperties {

    private double length;
    private double width;
    private double depth;
    private double height;
    private double weight;
    private String sizeMeasurementUnit;
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
