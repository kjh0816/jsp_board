package com.kjh.exam.interceptor;

import com.kjh.exam.dto.Member;
import com.kjh.exam.http.Rq;
import com.kjh.exam.util.Ut;

public class BeforeActionInterceptor extends Interceptor {

	@Override
	public boolean runBeforeAction(Rq rq) {
		String loginedMemberJson = rq.getSessionAttr("loginedMemberJson", "");

		if (loginedMemberJson.length() > 0) {
			rq.setLogined(true);
			rq.setLoginedMember(Ut.toObjFromJson(loginedMemberJson, Member.class));
			rq.setLoginedMemberId(rq.getLoginedMember().getId());
		}
		
		rq.setAttr("rq", rq);

		return true;
	}

}
