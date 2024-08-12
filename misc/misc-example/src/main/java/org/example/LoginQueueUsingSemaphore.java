package org.example;

import java.util.concurrent.Semaphore;

public class LoginQueueUsingSemaphore{
    private final Semaphore semaphore;

    public LoginQueueUsingSemaphore(int permits){
        semaphore = new Semaphore(permits);
    }

    public boolean tryLogin(){
        try {
            Thread.sleep(1000);
            System.out.println("Trying to login, available slots: "+this.availableSlots());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return semaphore.tryAcquire();
    }

    public void logout(){
        System.out.println("logout called");
        semaphore.release();
    }

    public int availableSlots(){
        return semaphore.availablePermits();
    }
}
