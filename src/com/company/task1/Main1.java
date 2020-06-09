package com.company.task1;

public class Main1 {
    public static void main(String[] args){
        System.out.println("привет");
        Cars cars = new Cars();
        System.out.println("Arr200:" + cars.Arr200.length);
        for (int i = 0; i < cars.Arr200.length; i++) {
            for (int j = 0; j < 3; j++) System.out.print(Integer.toString(cars.Arr200[i][j]) + ' ');
            System.out.println();
        }
        cars.rashodAllTypesCar();
    }
}
