package com.tech.learn.proxy;

/**
 * Created by heliqing on 2017/6/12.
 */
public class RealSubject implements Subject {

    @Override
    public void study() {
        System.out.println("学习代理模式");
    }

    @Override
    public void write() {
        System.out.println("亲自写了代理模式");
    }

    @Override
    public void copy() {
        System.out.println("抄的代理模式");
    }
}
