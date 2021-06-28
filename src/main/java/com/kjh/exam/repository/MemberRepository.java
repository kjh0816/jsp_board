package com.kjh.exam.repository;

import com.kjh.exam.dto.Member;
import com.kjh.mysqliutil.MysqlUtil;
import com.kjh.mysqliutil.SecSql;

public class MemberRepository {

	public Member getMemberByLoginId(String loginId) {
		SecSql sql = new SecSql();
		sql.append("SELECT M.*");
		sql.append("FROM member AS M");
		sql.append("WHERE M.loginId = ?", loginId);
		
		return MysqlUtil.selectRow(sql, Member.class);
	}

}
