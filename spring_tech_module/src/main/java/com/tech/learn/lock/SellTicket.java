package com.tech.learn.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by heliqing on 2018/2/23.
 */
public class SellTicket implements Runnable {
    private int ticket = 10;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true) {
            try {
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖出一张票，还剩" + ticket-- + "张票");
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
