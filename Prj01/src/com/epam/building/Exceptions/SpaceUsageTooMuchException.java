package com.epam.building.Exceptions;

public class SpaceUsageTooMuchException extends Exception{

    double space;

    public double getSpace() {
        return space;
    }

    public void setSpace(double space) {
        this.space = space;
    }

    public SpaceUsageTooMuchException(double space) {
        this.space = space;
        System.out.println(space + " is more than 70% of all building space.");
    }
}
