package com.annotation.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AnnotationTest {

	public static void main(String[] args) {
		Xiaoming person = new Xiaoming(20, "huancai");
		Person p = DynamicProxy.newInstance(person);
		System.err.println(p.getName());
		System.err.println(p.getAge());
	}

}

interface Person {
	public void setName(String name);

	@LogInfo("设置年龄")
	public void setAge(int age);

	public String getName();

	@LogInfo("获得年龄")
	public int getAge();
}

class Xiaoming implements Person {
	private int age;
	private String name;

	public Xiaoming(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
}

class DynamicProxy implements InvocationHandler {

	private Object object;

	public static <T> T newInstance(Object o) {
		DynamicProxy proxy = new DynamicProxy();
		proxy.object = o;
		Object result = Proxy.newProxyInstance(o.getClass().getClassLoader(), o
				.getClass().getInterfaces(), proxy);
		return (T) result;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if (method.isAnnotationPresent(LogInfo.class)) {
			LogInfo info = method.getAnnotation(LogInfo.class);
			System.err.println(info.value());
		}
		return method.invoke(this.object, args);
	}

}