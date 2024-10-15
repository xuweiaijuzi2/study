package com.xuwei.spring;

		import org.springframework.context.ApplicationContext;
		import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {
	public static void main(String[] args) {
		/* 通过spring容器创建创建Hello对象,
		 * 并调用Hello中的sayHi方法  */
		//1.加载spring的核心配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.从spring容器中获取bean对象(而不是自己new)
		Hello hello = (Hello) ac.getBean("hello");

		//3.调用hello对象的方法
		hello.sayHi();
	}
}
