package com.company.project;

import java.util.Date;

public class PercentAtTheEnd implements TypeOfPercent{
    static int percentType=0;  //%%  в конце периода
    @Override
    public double sumOnEndOfPeriod(Date startDate, Date endDate, double sumOfDeposit, double rateOfInterest) {
        int daysInPeriod=(int)((endDate.getTime()-startDate.getTime())/(24*60*60*1000));
        sumOfDeposit+=sumOfDeposit*rateOfInterest/100/365*daysInPeriod;  //считаем год  - 365 дней
        return sumOfDeposit;
    }

    @Override
    public String toString(){
        return "at the end of period";
    }
}
