package com.company.task3;

import java.time.LocalDateTime;
import java.util.Date;

public class Calculator implements Logging {
    String userName="USER";
    String computerName;
    Calculator(String userName){
        this.userName=userName;
        computerName=System.getenv("COMPUTERNAME");
    }

    @Override
    public void logMethod(String text) {
        System.out.println(LocalDateTime.now());
        System.out.printf("computerName: %s user:%s\n",computerName,userName);
        // берем из стека элемент массива [2] для вывода имени метода,
        // т.к. в [1] - текущий метод - logMethod
        StackTraceElement sTE = Thread.currentThread().getStackTrace()[2];
        System.out.println(sTE.getClassName() + " / " + sTE.getMethodName());
        System.out.println(text);
    }

    int calcSum(int a, int b)  {
        this.logMethod("Суммирование");
        return a+b;
    }
    double calcSum(double a, double b){
        this.logMethod("Суммирование");
        return a+b;
    }
    double calcSum(int a,double b){
        this.logMethod("Суммирование");
        return (double)a+b;
    }
    int calcDif(int a, int b){
        this.logMethod("Вычитание");
        return a-b;
    }
    double calcDif(double a, double b){
        this.logMethod("Вычитание");
        return a-b;
    }
    double calcDif(int a,double b){
        this.logMethod("Вычитание");
        return (double)a-b;
    }
    int calcProd(int a, int b){
        this.logMethod("Умножение");
        return a*b;
    }
    double calcProd(double a, double b){
        this.logMethod("Умножение");
        return a*b;
    }
    double calcProd(int a,double b){
        this.logMethod("Умножение");
        return (double)a*b;
    }
    double calcDiv(int a, int b){
        this.logMethod("Деление");
        return (double)a/(double) b;
    }
    double calcDiv(double a, double b){
        this.logMethod("Деление");return a/b;
    }
    double calcDiv(int a,double b){
        this.logMethod("Деление");return (double)a/b;
    }

}
