package com.company.task7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShopService {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Thread threadProducer = new Thread(new Producer(shop));

        Thread threadConsumer = new Thread(new Consumer(shop));
        threadProducer.start();
        threadConsumer.start();
    }
}
