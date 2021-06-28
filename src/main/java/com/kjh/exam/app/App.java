package com.kjh.exam.app;

import com.kjh.exam.container.Container;
import com.kjh.mysqliutil.MysqlUtil;

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
