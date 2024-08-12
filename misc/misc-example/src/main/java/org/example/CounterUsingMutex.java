package org.example;

import java.util.concurrent.Semaphore;

public class CounterUsingMutex {

    private Semaphore mutex;
    private int count;

    public CounterUsingMutex(){
        mutex = new Semaphore(1);
        count = 0;
    }

    public void increase() throws InterruptedException{
        mutex.acquire();
        this.count = this.count + 1;
        System.out.println("Count: "+this.count);
        Thread.sleep(1000);
        mutex.release();
    }

    public int getCount(){
        return this.count;
    }

    public boolean hasQueuedThreads(){
        return mutex.hasQueuedThreads();
    }


}
