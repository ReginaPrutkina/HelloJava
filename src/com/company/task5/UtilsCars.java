package com.company.task5;

import java.util.Collection;

public class UtilsCars {

  public void printCarsList(Collection<Cars> carsCollection)

    {
        for (Object car:carsCollection
             ) {
            System.out.println(car);

        }
    }

     // Считает расход топлива для заданного типа
    public double fuelExpenseForType(Collection<Cars> carsCollection, int type) {
        double sumOfExpense=0;
        for (Cars car : carsCollection)
            if (car.type==type) {
                sumOfExpense += (double) car.run * sumOfExpense;
            }
        return ((double) Math.round(sumOfExpense) / 100);
        }

    }
