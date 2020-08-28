package com.company.task8;

import java.util.Date;

public class MainTimer {

    public static void main(String[] args)  {
        Date start = new Date();
        LifeTime lifeTime = new LifeTime(start.getTime());

        Thread fiveSecThread = new Thread(new FiveSecondInfo(lifeTime));
        Thread oneSecThread = new Thread(new OneSecInfo(lifeTime));
        oneSecThread.start();
        fiveSecThread.start();
        while (((new Date()).getTime() - start.getTime()) < 30000) {
            try {
               Thread.sleep(1000);

        } catch (Exception e) {
                e.printStackTrace();
            }
        }
        oneSecThread.interrupt();
        fiveSecThread.interrupt();
    }

}

