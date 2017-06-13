package com.tech.learn.spring.container;

/**
 * Created by heliqing on 2017/6/6.
 * 定义容器的启动与关闭和容器的名称
 */
public interface Container {
    void start();

    void stop();

    String getName();
}
