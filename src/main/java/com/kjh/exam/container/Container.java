package com.kjh.exam.container;

import com.kjh.exam.http.controller.UsrArticleController;
import com.kjh.exam.http.controller.UsrMemberController;
import com.kjh.exam.interceptor.BeforeActionInterceptor;
import com.kjh.exam.interceptor.NeedLoginInterceptor;
import com.kjh.exam.interceptor.NeedLogoutInterceptor;
import com.kjh.exam.repository.ArticleRepository;
import com.kjh.exam.repository.MemberRepository;
import com.kjh.exam.service.ArticleService;
import com.kjh.exam.service.MemberService;

public class Container {
	public static BeforeActionInterceptor beforeActionInterceptor;
	public static NeedLoginInterceptor needLoginInterceptor;
	public static NeedLogoutInterceptor needLogoutInterceptor;
	
	public static ArticleRepository articleRepository;
	public static ArticleService articleService;
	public static UsrArticleController usrArticleController;

	public static MemberRepository memberRepository;
	public static MemberService memberService;
	public static UsrMemberController usrMemberController;
	
	public static void init() {
		articleRepository = new ArticleRepository();
		memberRepository = new MemberRepository();
		
		articleService = new ArticleService();
		memberService = new MemberService();
		
		beforeActionInterceptor = new BeforeActionInterceptor();
		needLoginInterceptor = new NeedLoginInterceptor();
		needLogoutInterceptor = new NeedLogoutInterceptor();
		
		usrArticleController = new UsrArticleController();
		usrMemberController = new UsrMemberController();
	}
}
