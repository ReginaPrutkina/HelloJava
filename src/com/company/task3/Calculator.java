package com.company.task3;


public class Calculator  {
    protected Logging logger;
    Calculator(Logging logger){
        this.logger=setLogger(logger);
    }
    public Logging setLogger(Logging logger){
         return logger;
    }
    int calcSum(int a, int b)  {
        logger.logMethod("Суммирование");
        return a+b;
    }
    double calcSum(double a, double b){
        logger.logMethod("Суммирование");
        return a+b;
    }
    double calcSum(int a,double b){
        logger.logMethod("Суммирование");
        return (double)a+b;
    }
    int calcDif(int a, int b){
        logger.logMethod("Вычитание");
        return a-b;
    }
    double calcDif(double a, double b){
        logger.logMethod("Вычитание");
        return a-b;
    }
    double calcDif(int a,double b){
        logger.logMethod("Вычитание");
        return (double)a-b;
    }
    int calcProd(int a, int b){
        logger.logMethod("Умножение");
        return a*b;
    }
    double calcProd(double a, double b){
        logger.logMethod("Умножение");
        return a*b;
    }
    double calcProd(int a,double b){
        logger.logMethod("Умножение");
        return (double)a*b;
    }
    double calcDiv(int a, int b){
        logger.logMethod("Деление");
        return (double)a/(double) b;
    }
    double calcDiv(double a, double b){
        logger.logMethod("Деление");return a/b;
    }
    double calcDiv(int a,double b){
        logger.logMethod("Деление");return (double)a/b;
    }

}
