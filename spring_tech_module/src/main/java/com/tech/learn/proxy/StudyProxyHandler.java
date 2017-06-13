package com.tech.learn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by heliqing on 2017/6/12.
 * jdk代理模式，不同于cglib
 * jdk代理模式需要委托类必须有接口实现，否则不能代理，这也是jdk动态代理的特点，
 * cglib可以代理class继承的类型，所以不能代理final方法。
 */
public class StudyProxyHandler implements InvocationHandler{
    private Object target;   //委托类实例

    public StudyProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行正式方法前先跟大家打个招呼吧");
        method.invoke(this.target, args);
        System.out.println("正式方法执行完毕");
        return null;
    }

    public static void main(String[] args){
        RealSubject realSubject=new RealSubject();
        StudyProxyHandler studyProxyHandler=new StudyProxyHandler(realSubject);
        Class clazz=realSubject.getClass();
        //这立proxy的参数2必须为为委托类class的Class实例，因为委托类才有接口继承，在获取接口时不会为空，否则会报转发代理失败
        Subject subject=(Subject)Proxy.newProxyInstance(Subject.class.getClassLoader(),clazz.getInterfaces(),studyProxyHandler);
        subject.study();
        subject.write();
        subject.copy();
    }
}
