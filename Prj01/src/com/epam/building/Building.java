package com.epam.building;

import com.epam.building.Exceptions.IlluminanceTooLittleException;
import com.epam.building.Exceptions.IlluminanceTooMuchException;
import com.epam.building.Exceptions.SpaceUsageTooMuchException;
import com.epam.furniture.Furniture;

import java.util.ArrayList;

public class Building implements Illumination, Space{
    private String nameOfBuilding;
    private ArrayList<Room> rooms = new ArrayList<>();

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

    public void addRoom(String name, int sqr, int numberOfWin) {
        Room room = new Room(name, sqr, numberOfWin);
        this.rooms.add(room);
    }

    public Room getRoom (String name){
        Room room = null;
        for(Room r : rooms){
            if(r.getNameOfRoom().equals(name)){
                room = r;
                break;
            }
        }
        return room;
    }

    //check on building requirements
    public boolean isValid() throws SpaceUsageTooMuchException, IlluminanceTooMuchException, IlluminanceTooLittleException {
        boolean res = true;
        for(Room r : rooms) {
            if ((Space.maxSpace(r)) > (r.getSquare() * 0.7)) {
                res = false;
                throw new SpaceUsageTooMuchException(Space.maxSpace(r));
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
            System.out.print("    Освещенность = " + Illumination.illum(r) +
                    " (" + r.getNumberOfWindows() + " окна по 700 лк");
            if(!r.getLights().isEmpty()){
                System.out.print(", лампочки ");
            for(Light l : r.getLights()) {
               if((r.getLights().indexOf(l)) == (r.getLights().size() - 1)){
                   System.out.print(l.getIllum() + " лк");
               } else{
                   System.out.print(l.getIllum() + " лк, ");
               }
            }
            }
            System.out.println(")");
            System.out.print("    Площадь = " + r.getSquare() + " м^2 ");
            if(r.getArrayfurn().isEmpty())  {
                System.out.println("(свободно 100%)");
            }else {
                System.out.println("(занято " +
                        Space.minSpase(r) + "-" + Space.maxSpace(r) + " м^2, гарантированно свободно " +
                        (r.getSquare() - Space.maxSpace(r)) + " м^2 или " +
                        (((r.getSquare() - Space.maxSpace(r)) / r.getSquare()) * 100) + "% площади)");
            }
            if(!r.getArrayfurn().isEmpty()){
                System.out.println("    Мебель:");
                for(Furniture f : r.getArrayfurn()){
                    System.out.print("      "+ f.getNameOfFurn() + " (площадь ");
                   if(f.getMinSquare() != 0){
                       System.out.println("от " + f.getMinSquare() + " м^2 до " + f.getMaxSquare() + " м^2)");
                   } else{
                       System.out.println(f.getMaxSquare() + " м^2)");
                   }
                }
            }else{
                System.out.print("    Мебели нет");
            }
        }

    }


}

