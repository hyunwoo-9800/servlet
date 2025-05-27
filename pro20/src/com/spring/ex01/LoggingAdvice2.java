package com.spring.ex01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

// xml 로깅 처리 확인 테스트
public class LoggingAdvice2 implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		// TODO Auto-generated method stub

		System.out.println("test1");
		
		Object object = arg0.proceed();
		
		System.out.println("test2");
		return object;
		
	} // invoke 종료

} // class 끝
