package com.tech.learn.proxy;



import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


/**
 * Created by heliqing on 2017/6/12.
 * 将委托类作为动态代理生成的字节码类的父类，然后调用父类方法。在调用时植入逻辑
 */
public class StudyCgLibProxy  implements MethodInterceptor {

    private Enhancer enhancer=new Enhancer();

    public Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);   //enhancer为生成的子类字节码；
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cgLib动态代理before");
        Object result=methodProxy.invokeSuper(o,objects);
        System.out.println("cgLib动态代理after");
        return result;
    }

    public static void main(String[] args){

        StudyCgLibProxy studyCgLibProxy=new StudyCgLibProxy();
        Subject proxy=(Subject)studyCgLibProxy.getProxy(RealSubject.class);
        System.out.println(proxy.getClass().getName());  //com.tech.learn.proxy.RealSubject$$EnhancerByCGLIB$$23f65a17
        proxy.copy();;
        proxy.study();
        proxy.write();
    }
}
