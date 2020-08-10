package com.company.task6;

import java.util.Comparator;

public class CarAddParamComparator implements Comparator<Cars> {

    @Override
    public int compare(Cars car1, Cars car2) {
        return ((CarsOthers)car1).addParam-((CarsOthers)car2).addParam;
    }
}
