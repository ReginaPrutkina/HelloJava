package com.company.task2;

public class Calculator {
    int calcSum(int a, int b){
        return a+b;
    }

    double calcSum(double a, double b){
        return a+b;
    }
    double calcSum(int a,double b){
        return (double)a+b;
    }
    int calcDif(int a, int b){
        return a-b;
    }
    double calcDif(double a, double b){
        return a-b;
    }
    double calcDif(int a,double b){
        return (double)a-b;
    }
    int calcProd(int a, int b){
        return a*b;
    }
    double calcProd(double a, double b){
        return a*b;
    }
    double calcProd(int a,double b){
        return (double)a*b;
    }
    double calcDiv(int a, int b){
        return (double)a/(double) b;
    }
    double calcDiv(double a, double b){
        return a/b;
    }
    double calcDiv(int a,double b){
        return (double)a/b;
    }
    double calcSqr(int a){
        double x1= a;
        double x2;
        while (true){
            x2=0.5 * (x1 + (double) a /x1);
            if (x1-x2<0.01) break;
            else x1=x2;
        }
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
        return (double)Math.round(x2*100)/100;
    }
    double calcPow2(double a){
        return a*a;
    }
    int calcPow2(int a){
        return a*a;
    }


}
