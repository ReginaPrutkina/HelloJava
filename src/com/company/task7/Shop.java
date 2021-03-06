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
    int soldCount = 0;
    public Shop(){
        poducts = new ArrayList<>();
        lock = new ReentrantLock();
        cond = lock.newCondition();
    }
    public void produceProduct()  {
        try {
        this.lock.lock();
        while (this.poducts.size() >= 5){
                this.cond.await();
            this.cond.signalAll();

        }
            String newProduct = "Product "+producedCount;
            this.poducts.add(newProduct);
            System.out.println(newProduct+ " поставлен");
            System.out.println("на полке "+this.poducts.size()+ " товаров");
            producedCount++;
           // this.lock.unlock();
          // this.cond.signal();
            }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }finally {
            this.lock.unlock();
        }

    };
    public void saleProduct(){
        try {
            this.lock.lock();
            while (this.poducts.size() == 0){
                this.cond.await();
                this.cond.signalAll();

            }
            String soldProduct = this.poducts.get(0);
            this.poducts.remove(0);
            System.out.println(soldProduct+ " продан");
            soldCount++;
            System.out.println("Продано всего "+soldCount);
            System.out.println("на полке "+this.poducts.size()+ " товаров");


        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            this.lock.unlock();
        }


    }
}
