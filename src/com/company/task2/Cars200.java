package com.company.task2;

public class Cars200 extends Cars{
    public Cars200(){
        int arrLen=0;
        rashod100km=12.0;
        cost1lGSM= 48.90;
        type=200;
        typeName="грузовой авто";
        dopZnach="объем перевезенного груза (см. куб.)";
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
