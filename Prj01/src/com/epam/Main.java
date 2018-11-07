package com.epam;

import com.epam.building.Building;
import com.epam.building.Exceptions.IlluminanceTooLittleException;
import com.epam.building.Exceptions.IlluminanceTooMuchException;
import com.epam.building.Exceptions.SpaceUsageTooMuchException;
import com.epam.building.Light;
import com.epam.building.Room;
import com.epam.furniture.Armchair;
import com.epam.furniture.Table;

public class Main {

    public static void main(String[] args) throws IlluminanceTooLittleException, SpaceUsageTooMuchException, IlluminanceTooMuchException {
        Building building = new Building("Здание 1");
        building.addRoom("Комната 1", 100, 3);
        building.addRoom("Комната 2", 5, 2);
        building.getRoom("Комната 1").addLights(new Light(150));
        building.getRoom("Комната 1").addLights(new Light(250));
        building.getRoom("Комната 1").addFurn(new Table("Стол письменный", 3));
        building.getRoom("Комната 1").addFurn(new Armchair("Кресло мягкое и пушистое", 1, 2));
        building.describe();

    }
}
