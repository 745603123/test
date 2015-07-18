package com.example.system.model;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class UserTest {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t=s.beginTransaction();	
		String hql="from User u where u_name='s1'";    
		User u=(User)s.createQuery(hql).uniqueResult();
		System.out.println(u);
		t.commit();
		s.close();
		sf.close();
		
	//	testquery();
	//	testsave(new User(0,"test2", null, null, null));
	}

/*	private static void testsave(User user) {
		Dao dao =Dao.getInstance();
		boolean f = dao.saveUser(user);
		HibernateSessionFactory.closeSession();
		System.out.println(f);
	}

	public static void testquery() {
		Dao dao = Dao.getInstance();
		User back = (User) dao.queryUserByUno(1);
		HibernateSessionFactory.closeSession();
		System.out.println(back);
		
	}*/

}
