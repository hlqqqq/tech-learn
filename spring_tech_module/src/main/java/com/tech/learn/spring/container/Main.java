package com.tech.learn.spring.container;

import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by heliqing on 2017/6/6.
 */
public class Main {
    private static ConcurrentHashMap<String,Container> container=new ConcurrentHashMap<String, Container>();

    public static void main(String[] args){
        System.out.println("开始初始化框架");
        try{
            ServiceLoader<Container> serviceLoader=ServiceLoader.load(Container.class);
            for(Container c:serviceLoader){
                container.put(c.getName(),c);
            }
            for (Container c:container.values()){
                c.start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Runtime.getRuntime().addShutdownHook(new Thread(){

        });
        synchronized (Main.class){
            while(true){
                try{
                    Main.class.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
