package com.company.task4;

import java.util.Objects;

abstract class Cars {
    int probeg;
    int type=0;
    String typeName="";
    String gosNumber; //для уникальности гос номер имеет вид: тип_номер

    @Override
    public String toString() {
        return "тип: " + type +
                " " + typeName +
                 " гос.номер: " + gosNumber+
                " пробег: " + probeg;
    }
    // объекты и хэши равны для машин одного типа с одинаковым гос номером
    @Override
    public int hashCode() {
        String str=" typeName: '" + typeName +
                " gosNumber: " + gosNumber;
        return str.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        return true;
        if ((obj == null) || (getClass() != obj.getClass()))
            return false;
        Cars car=(Cars) obj;
        if ((!Objects.equals(this.gosNumber, car.gosNumber))||(this.type!=car.type))
            return false;
        return true;
    }

}




