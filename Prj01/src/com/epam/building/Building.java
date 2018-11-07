package com.epam.building;

import com.epam.building.Exceptions.IlluminanceTooLittleException;
import com.epam.building.Exceptions.IlluminanceTooMuchException;
import com.epam.building.Exceptions.SpaceUsageTooMuchException;

import java.util.ArrayList;

public class Building implements Illumination, Space{
    private String nameOfBuilding;
    private ArrayList<Room> rooms;

    public Building(String name) {
        this.nameOfBuilding = name;
    }

    public String getName() {
        return nameOfBuilding;
    }

    public void setName(String name) {
        this.nameOfBuilding = name;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(String nameOfRoom, double square, int numberOfWind){
        Room room = new Room(nameOfRoom, square, numberOfWind);
        this.rooms.add(room);
    }

    //check on building requirements
    public boolean isValid() throws SpaceUsageTooMuchException, IlluminanceTooMuchException, IlluminanceTooLittleException {
        boolean res = true;
        for(Room r : rooms) {
            if ((Space.space(r)) > (r.getSquare() * 0.7)) {
                res = false;
                throw new SpaceUsageTooMuchException(Space.space(r));
            }
            if ((Illumination.illum(r)) > 4000) {
                res = false;
                throw new IlluminanceTooMuchException(Illumination.illum(r));
            } else if((Illumination.illum(r)) < 300 ){
                res = false;
                throw  new IlluminanceTooLittleException(Illumination.illum(r));
            }
        }
        return res;
    }


    public void describe() throws SpaceUsageTooMuchException, IlluminanceTooMuchException, IlluminanceTooLittleException {
        boolean isVal = isValid();
        if(isVal){
            System.out.println(nameOfBuilding);
        }
        for(Room r : rooms){
            System.out.println("  " + r.getNameOfRoom());
            System.out.print("Освещенность = " + Illumination.illum(r) +
                    " (" + r.getNumberOfWindows() + " окна по 700 лк, лампочки ");
            for(Light l : r.getLights()) {
                System.out.print(l.getIllum() + "лк");
            }
            System.out.println(")");
            System.out.print("Площадь = " + Space.space(r) + " м^2 (занято ");
        }

    }


}

