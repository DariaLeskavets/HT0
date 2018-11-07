package com.epam.building;

import com.epam.furniture.Furniture;

import java.util.ArrayList;

public class Room {
    private String nameOfRoom;
    private int square;
    private int numberOfWindows;
    private ArrayList<Light> lights = new ArrayList<Light>();
    private ArrayList<Furniture> arrayfurn = new ArrayList<Furniture>();

    public Room(String nameOfRoom, int square, int numberOfWindows) {
        this.nameOfRoom = nameOfRoom;
        this.square = square;
        this.numberOfWindows = numberOfWindows;
    }

    public ArrayList<Furniture> getArrayfurn() {
        return arrayfurn;
    }

    public void setArrayfurn(ArrayList<Furniture> furn) {
        this.arrayfurn = furn;
    }

    public String getNameOfRoom() {
        return nameOfRoom;
    }

    public void setNameOfRoom(String nameOfRoom) {
        this.nameOfRoom = nameOfRoom;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
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
    public void addLights (Light light){
            lights.add(light);
    }

    public void addFurn (Furniture furn){
       arrayfurn.add(furn);
    }

}
