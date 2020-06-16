package com.company.task2;

public class Cars300 extends Cars {
    public Cars300(){
        int arrLen=0;
        rashod100km=11.5;
        cost1lGSM= 47.50;
        type=300;
        typeName="пассажирский транспорт";
        dopZnach="число перевезенных пассажиров";
        int colFields=4;
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
