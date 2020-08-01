package com.company.task4;

import java.util.Comparator;

public class CarDopZnachComparator implements Comparator<CarsOthers> {
    @Override
    public int compare(CarsOthers car1, CarsOthers car2) {
        return car1.dopZnach-car2.dopZnach;
    }
}
