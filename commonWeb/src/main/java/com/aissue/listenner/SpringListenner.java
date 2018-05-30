package com.aissue.listenner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 测试ServletContextListener 实现spring容器启动后台程序
 */
public class SpringListenner implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("--------------MySpringListenner is running ------------");
        /*
        //一个使用的例子
        QueueHandler queueHandler = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext()).getBean(QueueHandler.class);
        QueueThreadObserver queueThreadObserver = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext()).getBean(QueueThreadObserver.class);
        System.out.println("--------监听器启动--------");
        ZookeeperDataConsumer consumer = new ZookeeperDataConsumer(queueHandler);
        consumer.addObserver(queueThreadObserver);
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
        */
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("--------------MySpringListenner is down ------------");
    }
}
