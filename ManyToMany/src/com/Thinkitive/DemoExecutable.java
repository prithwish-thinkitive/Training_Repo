package com.Thinkitive;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DemoExecutable {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Address a1 = new Address(555, "AAA");
		Address a2 = new Address(444, "BBB");
		Address a3 = new Address(333, "CCC");

		List<Address> l = new ArrayList<>();
		
		l.add(a1);
		l.add(a2);
		l.add(a3);
		
		
		Employee e = new Employee(10, "Alpha", 98900, l);
		
		session.save(e);
		t.commit();
		session.close();
		factory.close();
	}
}