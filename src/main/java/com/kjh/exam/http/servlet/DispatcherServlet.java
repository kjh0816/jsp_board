package com.kjh.exam.http.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjh.exam.container.Container;
import com.kjh.exam.http.Rq;
import com.kjh.exam.http.controller.Controller;
import com.kjh.mysqliutil.MysqlUtil;

@WebServlet("/usr/*")
public class DispatcherServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		Rq rq = new Rq(req, resp);

		if (rq.isInvalid()) {
			rq.print("올바른 요청이 아닙니다.");
		}

		Controller controller = null;

		if (runInterceptors(rq) == false) {
			return;
		}

		switch (rq.getControllerTypeName()) {
		case "usr":
			switch (rq.getControllerName()) {
			case "article":
				controller = Container.usrArticleController;
				break;
			case "member":
				controller = Container.usrMemberController;
				break;
			}

			break;
		}

		if (controller != null) {
			controller.performAction(rq);

			MysqlUtil.closeConnection();
		}
	}

	private boolean runInterceptors(Rq rq) {

		if (Container.beforeActionInterceptor.runBeforeAction(rq) == false) {
			return false;
		}

		if (Container.needLoginInterceptor.runBeforeAction(rq) == false) {
			return false;
		}

		if (Container.needLogoutInterceptor.runBeforeAction(rq) == false) {
			return false;
		}

		return true;
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
