package com.goalapa.cacamuca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class Application {

    @Autowired
    static ApplicationContext appContext;
    public static void main(String[] args) {

        System.out.println("args = " + args);
//        String[] beanNames = appContext.getBeanDefinitionNames();
//        for (String bean:
//        beanNames) {
//            System.out.println("bean = " + bean);
//        }


        SpringApplication.run(Application.class, args);
    }

}
