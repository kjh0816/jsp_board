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

// 사용자의 요청에 정상적인 응답 절차를 수행하도록 DispatcherServlet과 Controller, Service, Repository를 연결해준다.
// 결국, 객체를 매번 생성하지 않도록 하기 위함이며, 한번 생성한 객체들을 저장하는 역할.
// 예를 들어, 사용자가 usr/article/list를 요청할 때마다 articleController 객체가 생성되면서 호출되어야 하는데, 
// Container에 미리 객체를 한번 생성한 후, Controller 호출 시, 이미 생성된 객체를 계속 호출하는 방식이 가능해진다.

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
