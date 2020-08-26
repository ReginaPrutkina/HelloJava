package com.company.task8;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LifeTime {
    private Long start;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    LifeTime(Long start){
        this.start = start;
    }
    public Long getLifeTime(){
        return (new Date()).getTime()-start;
    }
}
