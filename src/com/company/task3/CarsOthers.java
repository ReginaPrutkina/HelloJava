package com.company.task3;

public class CarsOthers extends Cars {
    int colFields=4;
    String dopZnach;

    public CarsOthers(int[][] intArr, int type, String typeName, double cost1lGSM, double rashod100km, String dopZnach) {
        this.dopZnach = dopZnach;     //"объем перевезенного груза (см. куб.)";
        int arrLen=0;
        this.rashod100km=rashod100km;  //=12.5;
        this.cost1lGSM=cost1lGSM;    //= 46.10;
        this.type=type;   //=100;
        this.typeName=typeName;   //="легковой авто";
        for (int i = 0; i < intArr.length; i++)
            if (intArr[i][0]==type) arrLen++;
        carsArr=new int[arrLen][colFields];
        int i1=0;
        for (int i = 0; i <intArr.length ; i++)
            if (intArr[i][0]==type)
            {
                for (int j = 0; j <colFields ; j++) {
                    carsArr[i1][j]=intArr[i][j];
                }
                i1++;}

    }

}

