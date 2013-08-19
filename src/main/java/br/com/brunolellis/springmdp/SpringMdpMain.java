package br.com.brunolellis.springmdp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMdpMain {

	public static void main(String[] args) throws Throwable {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("mdp-context.xml");
		classPathXmlApplicationContext.start();
		
	}

}
