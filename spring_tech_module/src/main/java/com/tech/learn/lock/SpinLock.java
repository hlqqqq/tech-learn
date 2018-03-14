package com.tech.learn.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by heliqing on 2018/2/23.
 * 自悬锁简单实现
 */
public class SpinLock {
    private static AtomicReference<Thread> sign = new AtomicReference<Thread>();
    public void lock(){
        Thread current = Thread.currentThread();
        while(!sign.compareAndSet(null,current)){} //如果不为预期的那样为空，则一直循环直到为空，则设置为当前线程引用
    }
    public void unlock(){
        Thread current = Thread.currentThread();
        while(!sign.compareAndSet(current,null)){} //如果不为预期的那样为当前线程，则一直循环直到为当前贤臣，则设置为null
    }
}
