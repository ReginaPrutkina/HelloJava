package com.company.task3;

public class Cars implements UtilsCars {

    double rashod100km=0;
    double cost1lGSM= 0;
    int type=0;
    String typeName="";
    int [][]carsArr;

    /**
     * Считает расход для заданного массива
     * @return сумму расходов от всех эл массива carsArr
     */
    public double rashodType(){
        double summaRashOnKm=rashod100km*cost1lGSM;
        double summaRash=0.0;
        for (int i = 0; i < carsArr.length; i++) summaRash+=(double) carsArr[i][2]*summaRashOnKm;
        return ((double) Math.round( summaRash)/100);
    }


}

