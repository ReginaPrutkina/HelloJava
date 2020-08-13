package com.company.project;

public class CurrencyService implements GetCurrencyRateCB {
    private String url = "";
    CurrencyService(String url){
        this.url = url;
    }
    @Override
    public double getCurrencyRateCB(int currencyCode){
        double rate=0;
        //получение курса ЦБ из интернет ресурса (какого?) для заданной валюты
        return rate;
    }
    // курсы покупки-продажи??
}
