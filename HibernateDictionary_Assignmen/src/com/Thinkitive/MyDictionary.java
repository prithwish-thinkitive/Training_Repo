package com.Thinkitive;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class MyDictionary {
	
	public String getWords( String word) {
		Dictionary d1 = new Dictionary();
		
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Dictionary.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		Criteria c = session.createCriteria(Dictionary.class);
		c.add(Restrictions.eqOrIsNull("word", word));
		List list = c.list();
		//session.save(d1);
		//List l1 = session.createQuery("From Dictionary").list();
		
		
		t.commit();
		session.close();
		factory.close();
		return list.toString();
	}

}