package com.Thinkitive;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MyDBConnection {

	Employee e;
	Configuration cfg;
	SessionFactory factory;
	Session session;
	Transaction tx;
	
	public MyDBConnection() {

		e = new Employee();
		cfg = new Configuration();

		factory = cfg.configure().buildSessionFactory();

		session = factory.openSession(); // CONNECTION OPEN

		tx = session.beginTransaction();
	}
	public void createEmployee(int empId, String empName, int salary) {
		e.setEmpid(empId);
		e.setEname(empName);
		e.setSalary(salary);
	}
	public void insertEmployee(int empId, String empName, int salary) {
		
		createEmployee(empId, empName, salary);
		session = factory.openSession();
		tx = session.beginTransaction();
		session.save(e);
		
		tx.commit();

		session.close();
		//factory.close();

	}
	public void updateEmployee() {
		
		session = factory.openSession();
		tx = session.beginTransaction();
		session.update(e);
		
		tx.commit();
		
		session.close();
		//factory.close();
	}
	public void deleteEmployee() {
		
		session = factory.openSession();
		tx = session.beginTransaction();
		session.delete(e);
		
		tx.commit();
		
		session.close();
		//factory.close();
	}
	public void selectEmployee() {
		session = factory.openSession();
		tx = session.beginTransaction();
		
		Query q = session.createQuery("From Employee where salary > 50000");
		List l = q.list();
		System.out.println(l);
		
		tx.commit();
		session.close();
		//factory.close();
	}
	public void display() {
		session = factory.openSession();
		tx = session.beginTransaction();
		
		Query q = session.createQuery("From Employee");
		List l = q.list();
		System.out.println(l);
		
		tx.commit();
		session.close();
		//factory.close();
	}
}