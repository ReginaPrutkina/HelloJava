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
      //  int[][] testArr={{11,2,3,4},{10,500,1,7},{10,45,1,7}};
        //cars.sortArray(testArr,2);
        //cars.shlopArr(cars.Arr200,2);
        cars.printSortArrays();
    }
}
