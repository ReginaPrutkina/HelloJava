package com.company.task7;

import javax.imageio.IIOException;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Shop {
    ArrayList<String> poducts;
    Lock lock;
    Condition cond;
    int producedCount = 0;
    int saledCount = 0;
    public Shop(){
        poducts = new ArrayList<>();
        lock = new ReentrantLock();
        cond = lock.newCondition();
    }
    public void produceProduct()  {
        try {
        this.lock.lock();
        while (this.poducts.size() >= 5)
                this.cond.await();
            String newProduct = "Product "+producedCount;
            this.poducts.add(newProduct);
            System.out.println(newProduct+ " поставлен");
            producedCount++;
            this.lock.unlock();
           //this.cond.signal();
            }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

    };
    public void saleProduct(){
        try {
            this.lock.lock();
            while (this.poducts.size() == 0)
                this.cond.await();
            String saledProduct = this.poducts.get(0);
            this.poducts.remove(0);
            System.out.println(saledProduct+ "продан");
            saledCount++;
            System.out.println("Продано всего "+saledCount);
            this.lock.unlock();
           // this.cond.signal();
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

    }
}
