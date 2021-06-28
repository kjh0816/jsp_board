package com.kjh.exam.app;

import com.kjh.exam.container.Container;
import com.kjh.mysqliutil.MysqlUtil;

// App.java가 공유객체(Controller, Service, Repository) 객체를 최초 한번 생성하고, DB정보를 세팅한다.
public class App {
	public static boolean isDevMode() {
		// 이 부분을 false로 바꾸면 production 모드 이다.
		return true;
	}
	
	public static void init() {
		// DB 세팅
		MysqlUtil.setDBInfo("localhost", "jhmysql", "1234", "jsp_board");
		MysqlUtil.setDevMode(isDevMode());
		
		// 공용 객체 세팅
		Container.init();
	}
}
