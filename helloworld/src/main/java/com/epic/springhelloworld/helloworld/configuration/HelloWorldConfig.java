package com.epic.springhelloworld.helloworld.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.epic.springhelloworld.helloworld")
public class HelloWorldConfig {
	/*@Bean(name = "helloWorldBean")
	@Description("This is a sample HelloWorld Bean")
	public HelloWorld helloWorld() {
		return new HelloWorldImpl();
	}*/
}
