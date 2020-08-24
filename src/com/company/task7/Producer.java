package com.company.task7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Producer implements Runnable{
            Shop shop;
        public int count = 0;
                Producer(Shop shop){
            this.shop=shop;
                    }
        public void run(){
        while (shop.producedCount<20) {
            try {
                shop.produceProduct();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());

            }

        }
    }
}
