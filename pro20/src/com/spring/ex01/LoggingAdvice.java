package com.spring.ex01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		// TODO Auto-generated method stub

		System.out.println("[메서드 호출 전 : LogginAdvice]");
		System.out.println(arg0.getMethod() + "메서드 호출 전");
		
		Object object = arg0.proceed();
		
		System.out.println("[메서드 호출 후 : loggingAdvice]");
		System.out.println(arg0.getMethod() + "메서드 호출 후");
		
		return object;
		
	} // invoke 종료

} // class 끝
