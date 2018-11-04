package com.epam.building;

import java.util.ArrayList;

public interface Illumination {

    static int illum(Room room){

        int sum = 0;
        sum += room.getNumberOfWindows()*700;
        ArrayList<Light> lights = room.getLights();
        for(Light l : lights){
            sum += l.getIllum();
        }
        return sum;
    }
}
