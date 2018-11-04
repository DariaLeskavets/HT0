package com.epam.building;

import com.epam.furniture.Furniture;

import java.util.ArrayList;

public class Room {
    private String nameOfRoom;
    private double square;
    private int numberOfWindows;
    private ArrayList<Light> lights;
    private ArrayList<Furniture> furn;

    public Room(String nameOfRoom, double square, int numberOfWindows) {
        this.nameOfRoom = nameOfRoom;
        this.square = square;
        this.numberOfWindows = numberOfWindows;
    }

    public ArrayList<Furniture> getFurn() {
        return furn;
    }

    public void setFurn(ArrayList<Furniture> furn) {
        this.furn = furn;
    }

    public String getNameOfRoom() {
        return nameOfRoom;
    }

    public void setNameOfRoom(String nameOfRoom) {
        this.nameOfRoom = nameOfRoom;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getNumberOfWindows() {
        return numberOfWindows;
    }

    public void setNumberOfWindows(int numberOfWindows) {
        this.numberOfWindows = numberOfWindows;
    }

    public ArrayList<Light> getLights() {
        return lights;
    }

    public void setLights(ArrayList<Light> lights) {
        this.lights = lights;
    }

    //add lights and items of furniture
    public void add (Object object){
        if(object.getClass() == lights.getClass()){
            lights.add((Light) object);
        } else if(object.getClass() == furn.getClass()){
            furn.add((Furniture) object);
        }
    }

}
