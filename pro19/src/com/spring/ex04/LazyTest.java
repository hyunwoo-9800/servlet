package com.spring.ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class LazyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new FileSystemXmlApplicationContext("lazy.xml");
		System.out.println("SecondBean 얻기");
		context.getBean("secondBean");

	} // main

} // class 끝
