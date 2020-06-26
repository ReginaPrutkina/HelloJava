package com.company.task3;

public class CalculatorEng extends Calculator{
    CalculatorEng(Logging logger){
        super(logger);
    }
    double calcSqr(int a){
        double x1= a;
        double x2;
        while (true){
            x2=0.5 * (x1 + (double) a /x1);
            if (x1-x2<0.01) break;
            else x1=x2;
        }
        logger.logMethod("Квадратный корень");
        return (double)Math.round(x2*100)/100;
    }
    double calcSqr(double a) {
        double x1=a;
        double x2;
        while (true){
            x2=0.5 * (x1 + a /x1);
            if (x1-x2<0.01) break;
            else x1=x2;
        }
        logger.logMethod("Квадратный корень");
        return (double)Math.round(x2*100)/100;
    }
    double calcPow2(double a){
        logger.logMethod("Квадрат числа");
        return a*a;
    }
    int calcPow2(int a){
        logger.logMethod("Квадрат числа");
        return a*a;
    }
}
