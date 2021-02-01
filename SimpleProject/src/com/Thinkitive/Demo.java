package com.Thinkitive;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	public static void main(String args[]) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("anyname.xml");
		
		Employee emp = context.getBean(Employee.class);
		
		emp.hello();
		System.out.println(emp);
	}
}
