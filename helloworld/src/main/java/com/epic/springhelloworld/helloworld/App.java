package com.epic.springhelloworld.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.epic.springhelloworld.helloworld.configuration.HelloWorldConfig;
import com.epic.springhelloworld.helloworld.domain.Driver;

public class App {
	/*
	 * public static void main(String args[]) { AbstractApplicationContext
	 * context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
	 * HelloWorldImpl bean = (HelloWorldImpl) context.getBean("helloWorldBean");
	 * bean.sayHello("Spring 4"); context.close(); }
	 */

	/*
	 * public static void main(String args[]) { AbstractApplicationContext
	 * context = new AnnotationConfigApplicationContext(App.class);
	 * 
	 * // Byname Autowiring Application application = (Application)
	 * context.getBean("application"); System.out.println(
	 * "Application Details : " + application);
	 * 
	 * }
	 */

	public static void main(String args[]) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);

		Driver driver = (Driver) context.getBean("driver");
		System.out.println("Driver Details : " + driver);
	}
}
