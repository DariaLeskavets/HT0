package com.epam.building.Exceptions;

public class IlluminanceTooMuchException extends Exception {

    private double illum;

    public IlluminanceTooMuchException(double illum) {
        this.illum = illum;
        System.out.println(illum + " is much lighting requirements.");
    }

    public double getIllum() {
        return illum;
    }

    public void setIllum(double illum) {
        this.illum = illum;
    }
}
