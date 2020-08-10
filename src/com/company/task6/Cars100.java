package com.company.task6;

public class Cars100 extends Cars {
        public Cars100( String gosNumber, int type, int run){
        this.run=run;
        this.type=type;   //=100;
        this.gosNumber=gosNumber;
        this.paramsDT = new ParamsDtCars(type);

    }
    @Override
    public String toString() {
        return "тип: " + type +
                " " + paramsDT.typeName +
                " гос.номер: " + gosNumber+
                " пробег: " + run;
    }
}
