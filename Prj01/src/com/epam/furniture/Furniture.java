package com.epam.furniture;

public abstract class Furniture {

    private String nameOfFurn;
    private double minSquare;
    private double maxSquare;

    public Furniture(String nameOfFurn, double maxSquare){
        this.nameOfFurn = nameOfFurn;
        this.maxSquare = maxSquare;
    }

    public Furniture(String nameOfFurn, double minSquare, double maxSquare){
        this.nameOfFurn = nameOfFurn;
        this.minSquare = minSquare;
        this.maxSquare = maxSquare;
    }

    public double getMinSquare() {
        return minSquare;
    }

    public void setMinSquare(double minSquare) {
        this.minSquare = minSquare;
    }

    public double getMaxSquare() {
        return maxSquare;
    }

    public void setMaxSquare(double maxSquare) {
        this.maxSquare = maxSquare;
    }

    public String getNameOfFurn() {
        return nameOfFurn;
    }

    public void setNameOfFurn(String nameOfFurn) {
        this.nameOfFurn = nameOfFurn;
    }
}
