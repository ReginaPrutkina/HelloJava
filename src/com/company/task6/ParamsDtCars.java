package com.company.task6;

public class ParamsDtCars {
    public String addParamName=null;
    public String typeName=null;
    public double rashod100km;
    double cost1lGSM;
    public ParamsDtCars(int type){
        switch (type){
            case 100->{
                this.typeName = " легковой автомобиль ";
                this.rashod100km=12.5;
                this.cost1lGSM=46.10;
            }
            case 200->{
                this.typeName = "  грузовой автомобиль ";
                this.addParamName = "Объем перевезенных грузов (см.куб.) ";
                this.rashod100km = 12.0;
                this.cost1lGSM = 48.90;
            }
            case 300->{
                this.typeName = " пассажирский транспорт ";
                this.addParamName = "Число перевезенных пассажиров";
                this.rashod100km = 11.5;
                this.cost1lGSM = 47.50;
            }
            case 400->{
                this.typeName = " тяжелая техника, краны ";
                this.addParamName = "вес поднятых грузов тонн";
                this.rashod100km = 12.5;
                this.cost1lGSM = 48.90;
            }
        }
    }
}
