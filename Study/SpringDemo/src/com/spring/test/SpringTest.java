package com.spring.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.action.UserAction;
import com.spring.model.HelloWorld;
import com.spring.model.User;

public class SpringTest {

	private BeanFactory beanFactory;

	@Before
	public void init() {
		beanFactory = new ClassPathXmlApplicationContext("spring_bean.xml");
	}

	@Test
	public void test001() {
		HelloWorld h1 = beanFactory.getBean("helloWold",
				HelloWorld.class);
		
		HelloWorld h2 = beanFactory.getBean("helloWold",
				HelloWorld.class);
		
		System.err.println(h1==h2);

	}
	
	@Test
	public void test002() throws Exception {
		UserAction ua = beanFactory.getBean("userAction",UserAction.class);
		User user = new User("fasd",1);
		ua.setUser(user);
		ua.add();
	}
}
