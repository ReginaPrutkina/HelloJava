package com.company.task2;

public class Massiv {
    ElementArr firstEl;
     public Massiv(int[] intArr){
        ElementArr currentEl=new ElementArr(intArr[0]);
        firstEl=currentEl;
        for (int i=1;i<intArr.length;i++) {
            ElementArr newEl=new ElementArr(intArr[i],currentEl);
            currentEl.next=newEl;
            currentEl=newEl;
        }

    }
    public void printArr(){
        ElementArr currentEl=firstEl;
        while (currentEl!=null)
        {
            System.out.println(currentEl.val);
            currentEl=currentEl.next;
        }
        System.out.println("");
    }
    public void addElement(int val, int idx){
        ElementArr currentEl=firstEl;
        int i=0;
        while (currentEl.next!=null && i<idx)
        {
            i++;
            currentEl=currentEl.next;
        }
        ElementArr newEl;
        if (i==idx)
            {
                newEl = new ElementArr(val, currentEl.prev, currentEl);
                if (currentEl.prev != null) currentEl.prev.next = newEl;
                else firstEl = newEl;
                currentEl.prev = newEl;
            } else
            //Добавление в конец массива
        {
            newEl = new ElementArr(val, currentEl, currentEl.next);
            currentEl.next = newEl;
        }
    }
    public void delElement(int idx) {
        ElementArr currentEl = firstEl;
        int i = 0;
        while (currentEl.next != null && i < idx) {
            i++;
            currentEl = currentEl.next;
        }
        if (i==idx)
        //Проверяем отдельно первый и последний элементы списка
        {if (currentEl.prev!=null) currentEl.prev.next=currentEl.next;
        else firstEl=firstEl.next;
         if (currentEl.next!=null) currentEl.next.prev=currentEl.prev;
        }
    }
    public void changeEl(int val, int idx){
        int i = 0;
        ElementArr currentEl=firstEl;
        while (currentEl!= null && i < idx) {
            i++;
            currentEl = currentEl.next;
        }
        if (currentEl!=null) currentEl.val=val;
    }

    public void fillMassive(int val){
        ElementArr currentEl=firstEl;
        while (currentEl!= null) {
            currentEl.val=val;
            currentEl = currentEl.next;
            }
        }
    public int minElement(){
        ElementArr currentEl=firstEl;
        int minEl=currentEl.val;
        while (currentEl!= null) {
            if (minEl>currentEl.val) minEl=currentEl.val;
            currentEl = currentEl.next;
        }
        return minEl;
    }
    public int maxElement(){
        ElementArr currentEl=firstEl;
        int maxEl=currentEl.val;
        while (currentEl!= null) {
            if (maxEl<currentEl.val) maxEl=currentEl.val;
            currentEl = currentEl.next;
        }
        return maxEl;
    }
    public int lengthMassive() {
        ElementArr currentEl = firstEl;
        int count = 0;
        while (currentEl != null) {
            count++;
            currentEl = currentEl.next;
        }
        return count;
    }

    public Massiv sortArrUp() {
        int[] intArr=new int [this.lengthMassive()];
        ElementArr currentElement=firstEl;
        int i=0;
        while (currentElement!=null)
        {intArr[i]=currentElement.val;
            i++;
            currentElement=currentElement.next;
        }
        Massiv newMassive=new Massiv(intArr);

        int lenArr=newMassive.lengthMassive();
        boolean sortedFlag = false;

        while (!sortedFlag) {
            sortedFlag=true;
            currentElement=newMassive.firstEl;
            int el;
            for (i = 0; i <lenArr-1 ; i++) {
                if (currentElement.val>currentElement.next.val) {
                    sortedFlag = false;
                    el=currentElement.val;
                    currentElement.val=currentElement.next.val;
                    currentElement.next.val=el;
                }
                currentElement=currentElement.next;
            }
        }

        return newMassive;
    }
}
