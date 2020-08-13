package com.company.project;

import java.util.Date;

public class PercentDaily implements TypeOfPercent {
    static int percentType=1;  //%%  ежедневно

    @Override
    public double sumOnEndOfPeriod(Date startDate, Date endDate, double sumOfDeposit,double rateOfInterest) {
        int daysInPeriod=(int)((endDate.getTime()-startDate.getTime())/(24*60*60*1000));
        for(int day=1; day<daysInPeriod; day++)
            sumOfDeposit+=sumOfDeposit*rateOfInterest/100/365;  //считаем год  - 365 дней
        return sumOfDeposit;
    }

    @Override
    public String toString(){
        return "daily";
    }

}
