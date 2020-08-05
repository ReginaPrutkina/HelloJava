package com.company.task5;

import java.util.Comparator;

public class CarRunComparator implements Comparator<Cars> {
    @Override
    public int compare(Cars car1, Cars car2) {
         return car1.run - car2.run;
    }
}
