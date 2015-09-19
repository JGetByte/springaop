/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linksinnovation.springaop;

import com.linksinnovation.springaop.service.SimpleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Jirawong Wongdokpuang <jirawong@linksinnovation.com>
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SimpleService bean = ctx.getBean(SimpleService.class);
        bean.setMessage("hahahh");
        System.out.println("------");
        bean.getMessage();
    }
}
