package com.company.task2;

public class Cars100 extends Cars{
     public Cars100(){
        int arrLen=0;
       rashod100km=12.5;
       cost1lGSM= 46.10;
       type=100;
       typeName="легковой авто";
       for (int i = 0; i < intArr.length; i++)
             if (intArr[i][0]==type) arrLen++;
       carsArr=new int[arrLen][3];
       int i1=0;
         for (int i = 0; i <intArr.length ; i++)
             if (intArr[i][0]==type)
             {
             for (int j = 0; j <3 ; j++) {
                 carsArr[i1][j]=intArr[i][j];
             }
             i1++;}

    }
}
