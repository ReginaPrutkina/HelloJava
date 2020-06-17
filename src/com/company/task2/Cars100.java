package com.company.task2;

public class Cars100 extends Cars{
     public Cars100(int[][] intArr,int type,String typeName,double cost1lGSM,double rashod100km){
        int arrLen=0;
       this.rashod100km=rashod100km;  //=12.5;
       this.cost1lGSM=cost1lGSM;    //= 46.10;
       this.type=type;   //=100;
       this.typeName=typeName;   //="легковой авто";
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
