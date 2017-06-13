package com.tech.learn.spring.container;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by heliqing on 2017/6/6.
 */
public class SpringContainer implements Container {

    private static ClassPathXmlApplicationContext ctx;

    public void start() {
        ctx=new ClassPathXmlApplicationContext("spring-context.xml");
        ctx.start();
    }

    public void stop() {
        try {
            ctx.stop();
            ctx.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getName() {
        return "spring";
    }
}
