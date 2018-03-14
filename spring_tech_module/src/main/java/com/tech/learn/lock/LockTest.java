package com.tech.learn.lock;

/**
 * Created by heliqing on 2018/2/23.
 */
public class LockTest {
    public static void main(String[] args){
        SellTicket sellTicket = new SellTicket();
        SellTicket2 sellTicket2 = new SellTicket2();
        Thread a = new Thread(sellTicket,"窗口1");
        Thread b = new Thread(sellTicket,"窗口2");
        Thread c = new Thread(sellTicket2,"来福士窗口3");
        Thread d = new Thread(sellTicket2,"来福士窗口4");
        Thread c1 = new Thread(sellTicket2,"来福士窗口4");
        Thread d2 = new Thread(sellTicket2,"来福士窗口5");
        Thread c3 = new Thread(sellTicket2,"来福士窗口6");
        Thread d4 = new Thread(sellTicket2,"来福士窗口7");
        Thread c5 = new Thread(sellTicket2,"来福士窗口8");
        Thread d6 = new Thread(sellTicket2,"来福士窗口9");
//        a.start();
//        b.start();
        c.start();
        d.start();
        c1.start();
        d2.start();
        c3.start();
        d4.start();
        c5.start();
        d6.start();
    }
}
