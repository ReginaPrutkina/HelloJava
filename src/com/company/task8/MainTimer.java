package com.company.task8;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainTimer {

    public static void main(String[] args)  {
        Long countSec = 0L;
        boolean flag1000 = false;
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Date start = new Date();
        LifeTime lifeTime = new LifeTime(start.getTime());

        Thread fiveSecThread = new Thread(new FiveSecondInfo(lifeTime));
        Thread oneSecThread = new Thread(new OneSecInfo(lifeTime));
        oneSecThread.start();
        fiveSecThread.start();
        while (((new Date()).getTime() - start.getTime()) < 30000) {
            try {
                lock.lock();
                Thread.sleep(1000);

        } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        oneSecThread.interrupt();
        fiveSecThread.interrupt();
    }

}

