package com.tech.learn.tran;

/**
 * Created by heliqing on 2017/6/15.
 * 该程序证明了THreadLoacl的里面的获取和设置都是针对当前线程的，线程之间互不影响
 */
public class SequenceNumber {
    private static ThreadLocal<Integer> number=new ThreadLocal<Integer>(){
        public Integer initialValue(){   //通过匿名内部类覆写父类的初始值方法
            return 0;
        }
    };

    public int getNextNum(){
        number.set(number.get()+2);
        return number.get();
    }

    public static void main(String[] args){
        SequenceNumber sn=new SequenceNumber();
        Thread t1=new TestThread(sn);
        Thread t2=new TestThread(sn);
        Thread t3=new TestThread(sn);
        t1.start();
        t2.start();
        t3.start();
    }

}

class TestThread extends Thread{
    private SequenceNumber sn;
    public TestThread(SequenceNumber sn){
        this.sn=sn;
    }
    public void run(){
        for(int i=0;i<3;i++){
            System.out.println(Thread.currentThread().getName()+"-"+sn.getNextNum());   //在每个线程都相当于加了一次。如果线程安全，则各个线程值独立
        }
    }
}
