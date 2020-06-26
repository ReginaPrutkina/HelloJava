package com.company.task3;

import java.time.LocalDateTime;

public class Logger implements Logging{
    String userName="USER";
    String computerName;
    Logger(String userName){
        this.userName=userName;
        computerName=System.getenv("COMPUTERNAME");
    }
    @Override
    public void logMethod(String description) {
        System.out.println(LocalDateTime.now());
        System.out.printf("computerName: %s user:%s\n",computerName,userName);
        // берем из стека элемент массива [2] для вывода имени метода,
        // т.к. в [1] - текущий метод - logMethod
        StackTraceElement sTE = Thread.currentThread().getStackTrace()[2];
        System.out.println(sTE.getClassName() + " / " + sTE.getMethodName());
        System.out.println(description);
    }
}
