package com.dgx.chapter1.waitandnotify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Create by dgx 2022-08-14 21:45
 */
public class ProducerAndConsumerModel {



    public static void main(String[] args) {
        EvenStorage evenStorage = new EvenStorage(10);

        Producer producer = new Producer(evenStorage);
        Consumer consumer = new Consumer(evenStorage);

        new Thread(producer).start();
        new Thread(consumer).start();

    }
}
class Producer implements  Runnable{
    private EvenStorage evenStorage;

    public Producer(EvenStorage evenStorage) {
        this.evenStorage = evenStorage;
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            evenStorage.put();

        }
    }
}

class Consumer implements  Runnable{
    private EvenStorage evenStorage;

    public Consumer(EvenStorage evenStorage) {
        this.evenStorage = evenStorage;
    }

    @Override
    public void run() {

        for (int i=0;i<100;i++){
           evenStorage.take();
        }
    }
}

class EvenStorage {

    Integer maxSize;
    List<Date> storage;

    public EvenStorage(Integer maxSize) {
        this.maxSize = maxSize;
        this.storage = new ArrayList<>();
    }

    public synchronized  void put(){
        while (storage.size()==maxSize){
            try {
                wait();
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());

        System.out.println("仓库现在有 \t"+storage.size());
        notifyAll();
    }

    public  synchronized  void take()  {

        while (storage.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Date date = storage.get(0);
        storage.remove(0);
        System.out.println("拿到了 "+date +", 现在还有 "+storage.size());
        notifyAll();

    }
}