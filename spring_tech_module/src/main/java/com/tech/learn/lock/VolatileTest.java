package com.tech.learn.lock;

/**
 * Created by heliqing on 2018/3/8.
 */
public class VolatileTest implements Runnable {
    private long x = 4444444L;


    @Override
    public void run() {
        while (true) {
            if (x == 44444444444444444L) {
                x = 333333333333333L;
            } else {
                x = 44444444444444444L;
            }
            System.out.println(x);
        }
    }


    public static void main(String args[]){
        VolatileTest t1 = new VolatileTest();
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start(); new Thread(t1).start(); new Thread(t1).start(); new Thread(t1).start(); new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();


    }
}
