package com.company.task8;

public class FiveSecondInfo implements Runnable{
    LifeTime lifeTime;
    FiveSecondInfo(LifeTime lifeTime){
        this.lifeTime = lifeTime;
    }

    @Override
    public void run() {
        while (lifeTime.getLifeTime() < 30000)
            try {
                System.out.println("FiveSecondInfo: "+lifeTime.getLifeTime());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

}
