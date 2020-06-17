package com.company.task2;

public class Cars400 extends Cars{
    String dopZnach;
    public Cars400(int[][] intArr,int type,String typeName,double cost1lGSM,double rashod100km){
        int arrLen=0;
        this.rashod100km=rashod100km;
        this.cost1lGSM=cost1lGSM;
        this.type=type;
        this.typeName=typeName;
        dopZnach="вес поднятых грузов тонн";
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
