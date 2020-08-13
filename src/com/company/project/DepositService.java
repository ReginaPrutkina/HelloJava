package com.company.project;

import java.util.HashMap;
import java.util.List;

public class DepositService implements DepositServiceActions{
    //здесь д б объект связи в ресурсом хранения данных - БД или файл
    public DepositService(){

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
