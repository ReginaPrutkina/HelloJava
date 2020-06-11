package com.company.task1;

public class Massiv {
    /**
     * массив int
     * @param intArr исходный массив
     * @param idx индекс места вставки, если > длины массива, то добавление
     * @param el - элемент вставки
     * @return
     */
    public int[] addElement(int[] intArr,int idx,int el){
      int[] newIntArr= new int[intArr.length+1];
      if (idx>intArr.length){
          for (int i = 0; i < intArr.length; i++) {
              newIntArr[i]=intArr[i];
          }
          newIntArr[intArr.length]=el;
      }
      else{
          for (int i = 0; i < intArr.length; i++) {
              if (i<idx) newIntArr[i]=intArr[i];
              if (i>idx) newIntArr[i+1]=intArr[i];
          }
          newIntArr[idx]=el;
      }
      return newIntArr;
    }
    public int[] delElement(int[] intArr,int idx){
        int[] newIntArr= new int[intArr.length-1];
           for (int i = 0; i < intArr.length; i++) {
                if (i<idx) newIntArr[i]=intArr[i];
                if (i>idx) newIntArr[i-1]=intArr[i];
            }
        return newIntArr;
    }
    public int[] changeArr(int[] intArr,int idx,int el){
        int[] newIntArr= new int[intArr.length];
        newIntArr[idx]=el;
        return newIntArr;
    }
    public void outputArr(int[] intArr) {
        for (int el : intArr) System.out.println(el);
    }
    public int[] sortArrUp(int[] intArr) {
        int[] newIntArr=new int[intArr.length];
        for (int i = 0; i < intArr.length; i++) {
            newIntArr[i]=intArr[i];
        }
        boolean sortedFlag = false;
        int el;
        while (!sortedFlag) {
            sortedFlag=true;
            for (int i = 0; i <intArr.length-1 ; i++) {
                if (newIntArr[i]>newIntArr[i+1]) {
                    sortedFlag = false;
                    el=newIntArr[i];
                    newIntArr[i]=newIntArr[i+1];
                    newIntArr[i+1]=el;
                }
            }
        }

         return newIntArr;
    }
    public int lenArr(int[] intArr){
        return intArr.length;
    }
    public int[] sortArrDown(int[] intArr) {
        int[] newIntArr=new int[intArr.length];
        for (int i = 0; i < intArr.length; i++) {
            newIntArr[i]=intArr[i];
        }
        boolean sortedFlag = false;
        int el;
        while (!sortedFlag) {
            sortedFlag=true;
            for (int i = 0; i <intArr.length-1 ; i++) {
                if (newIntArr[i]<newIntArr[i+1]) {
                    sortedFlag = false;
                    el=newIntArr[i];
                    newIntArr[i]=newIntArr[i+1];
                    newIntArr[i+1]=el;
                }
            }
        }

        return newIntArr;
    }
    public int[] fillArr(int[] intArr,int el){
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] =el;
        }
        return intArr;
    }
    public int minArr(int[] intArr){
        int min=intArr[0];
        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] <min) min=intArr[i];
        }
        return min;
    }
    public int maxArr(int[] intArr){
        int max=intArr[0];
        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] >max) max=intArr[i];
        }
        return max;
    }

}
