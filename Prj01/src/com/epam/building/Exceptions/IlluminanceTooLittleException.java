package com.epam.building.Exceptions;

public class IlluminanceTooLittleException extends Exception {

    private double illum;

    public IlluminanceTooLittleException(double illum) {
        this.illum = illum;
        System.out.println(illum + " is little lighting requirements.");
    }

    public double getIllum() {
        return illum;
    }

    public void setIllum(double illum) {
        this.illum = illum;
    }
}
