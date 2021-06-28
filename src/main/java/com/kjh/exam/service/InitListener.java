package com.kjh.exam.service;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.kjh.exam.app.App;

// ServletContextListener를 구현(implements)한 클래스는 WAS(Web Server Application)에 해당하는
// apache Tomcat이 실행됐을 때, 종료 됐을 때의 각 한 번씩만 실행될 메소드 등을 정의해줄 수 있다.
// 현재 InitListener 클래스에서 App.java가 실행되도록 구현돼있다.


@WebListener
public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    	App.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
