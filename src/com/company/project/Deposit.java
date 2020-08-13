package com.company.project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Deposit {
    private int Id;
    private String name;
    private String owner;
    private Double sum;
    private double rateOfInterest;
    private int currency;   //810,840,978
    private Date startDate;
    private Date endDate;
    private String comment;
    void Deposit (HashMap<String,String> fieldsMap) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yyyy");
        try {
            this.Id = Integer.parseInt(fieldsMap.get("Id"));
            this.name = fieldsMap.get("name");
            this.owner = fieldsMap.get("owner");
            this.sum = Double.parseDouble(fieldsMap.get("sum"));
            this.rateOfInterest = Double.parseDouble(fieldsMap.get("rateOfInterest"));
            this.currency = Integer.parseInt(fieldsMap.get("currency"));
            this.startDate = formatter.parse(fieldsMap.get("startDate"));
            this.endDate = formatter.parse(fieldsMap.get("endDate"));
            this.comment = fieldsMap.get("comment");
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    };
    TypeOfPercent typeOfPercent;
    Logging logger;
}
