package com.company.task4;

import java.util.Comparator;

public class CarProbegComparator implements Comparator<Cars> {
    @Override
    public int compare(Cars car1, Cars car2) {
         return car1.probeg - car2.probeg;
    }
}
