package com.company.task2;

public class ElementArr {
    public ElementArr prev=null;
    public ElementArr next=null;
    public int val;
    ElementArr(int val,ElementArr prev,ElementArr next){
        this(val,prev);
        this.next=next;
    }
    ElementArr(int val,ElementArr prev){
        this(val);
        this.prev=prev;
    }
    ElementArr (int val){
       this.val=val;
    }

}
