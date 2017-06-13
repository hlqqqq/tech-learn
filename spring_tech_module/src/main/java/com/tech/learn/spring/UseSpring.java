package com.tech.learn.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by heliqing on 2017/6/6.
 */
public class UseSpring {
    public static void main(String agrs[]){
        //当使用classPathXmlApplication时，会从classPath的目录中寻找配置文件
        Logger logger= LoggerFactory.getLogger(UseSpring.class);
        logger.info("学习spring啦");
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring-context.xml");
        FirstSpringComponent firstSpringComponent=(FirstSpringComponent)context.getBean("firstSpringComponent");
        System.out.println(firstSpringComponent.Dosomting("ddd"));
    }
}
