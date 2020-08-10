package com.company.task6;

public class CarsOthers extends Cars {
    int addParam;

    public CarsOthers(String gosNumber, int type, int run, int addParam) {
        this.addParam = addParam;
        this.gosNumber = gosNumber;
        this.run = run;
        this.type = type;
        this.paramsDT = new ParamsDtCars(type);
    }

    @Override
    public String toString() {
        return  "тип: " + type +
                " " + paramsDT.typeName +
                " гос.номер: " + gosNumber+
                " пробег: " + run + " "+
                paramsDT.addParamName+ ": " + addParam;
    }

}

