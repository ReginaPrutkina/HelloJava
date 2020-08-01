package com.company.task4;

import java.util.Collection;

public class UtilsCars {

  //  public void printCarsList(Collection<Object> carsCollection) //почему не могу сделать Collection<Cars> carsCollection?
    public void printCarsList(Collection<Cars> carsCollection) //почему не могу сделать Collection<Cars> carsCollection?

    {
        for (Object car:carsCollection
             ) {
            System.out.println(car);

        }
    }

     // Считает расход топлива для заданного массива
    public double rashodType(Collection<Cars> carsCollection,double rashod100km,double cost1lGSM) {
        double summaRashOnKm = rashod100km * cost1lGSM;
        double summaRash = 0.0;
        for (Cars car : carsCollection)
            summaRash += (double) car.probeg * summaRashOnKm;
            return ((double) Math.round(summaRash) / 100);
        }

    }
