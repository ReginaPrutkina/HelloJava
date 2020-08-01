package com.company.task4;

public class CarsOthers extends Cars {
    int dopZnach;
    String dopZnachName;
    public CarsOthers(String gosNumber, int type, String typeName, int prober, String dopZnachName,int dopZnach) {
        this.dopZnach = dopZnach;
        this.dopZnachName=dopZnachName;
        this.gosNumber=gosNumber;
        this.probeg=prober;
        this.type=type;
        this.typeName=typeName;
    }

    @Override
    public String toString() {
        return  super.toString()+ " "+
                dopZnachName+ ": " + dopZnach;
    }

}

