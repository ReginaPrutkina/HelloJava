package com.company.project;

import java.util.List;

public class DepositService implements DepositServiceActions{
    //здесь д б объект связи в ресурсом хранения данных - БД или файл
    NeedNotificate notification;
    public DepositService(NeedNotificate notification){
        this.notification = notification;
    }
    @Override
    public List<Deposit> getAllDeposits() {
        return null;
    }

    @Override
    public Deposit getDeposit(int Id) {
        return null;
    }

    @Override
    public boolean saveDeposit(Deposit deposit) {
        return false;
    }

   }
