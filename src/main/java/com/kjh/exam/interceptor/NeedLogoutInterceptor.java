package com.kjh.exam.interceptor;

import com.kjh.exam.http.Rq;

public class NeedLogoutInterceptor extends Interceptor {

	@Override
	public boolean runBeforeAction(Rq rq) {
		return true;
	}

}
