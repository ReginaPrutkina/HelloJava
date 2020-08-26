package com.company.task8;

public class OneSecInfo implements Runnable{
    LifeTime lifeTime;
    OneSecInfo(LifeTime lifeTime){
        this.lifeTime = lifeTime;
    }

    @Override
    public void run() {
        while (lifeTime.getLifeTime() < 30000)
            try {
                System.out.println("OneSecondInfo: "+lifeTime.getLifeTime());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

}
