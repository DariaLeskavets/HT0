package com.epam.furniture;

public abstract class Furniture {

    private String nameOfFurn;
    private int minSquare;
    private int maxSquare;

    public Furniture(String nameOfFurn, int maxSquare){
        this.nameOfFurn = nameOfFurn;
        this.maxSquare = maxSquare;
    }

    public Furniture(String nameOfFurn, int minSquare, int maxSquare){
        this.nameOfFurn = nameOfFurn;
        this.minSquare = minSquare;
        this.maxSquare = maxSquare;
    }

    public int getMinSquare() {
        return minSquare;
    }

    public void setMinSquare(int minSquare) {
        this.minSquare = minSquare;
    }

    public int getMaxSquare() {
        return maxSquare;
    }

    public void setMaxSquare(int maxSquare) {
        this.maxSquare = maxSquare;
    }

    public String getNameOfFurn() {
        return nameOfFurn;
    }

    public void setNameOfFurn(String nameOfFurn) {
        this.nameOfFurn = nameOfFurn;
    }
}
