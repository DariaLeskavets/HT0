package com.epam.building;

import com.epam.furniture.Furniture;

import java.util.ArrayList;

public interface Space {

    static double space(Room room){
        double sqr = room.getSquare();
        double sum = 0;
        ArrayList<Furniture> furn = room.getFurn();
        for(Furniture f : furn){
            sum += f.getMaxSquare();
        }
        return sum;
    }
}
