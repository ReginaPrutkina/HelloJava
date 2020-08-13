package com.company.project;

import java.util.List;

public interface DepositServiceActions {
    List<Deposit> getAllDeposits();
    Deposit getDeposit(int Id);
    boolean saveDeposit(Deposit deposit);
}
