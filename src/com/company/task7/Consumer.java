package com.company.task7;

public class Consumer implements Runnable {
    Shop shop;

    Consumer(Shop shop) {
        this.shop = shop;
    }

    public void run() {
        while (shop.saledCount < 19) {
            try {
                shop.saleProduct();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());

            }
        }
    }
}
