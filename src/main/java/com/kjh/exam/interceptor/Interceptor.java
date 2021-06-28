package com.kjh.exam.interceptor;

import com.kjh.exam.http.Rq;

public abstract class Interceptor {
	abstract public boolean runBeforeAction(Rq rq);
}
