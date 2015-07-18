package com.example.system.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class VoteTest {

	public static void main(String[] args) {
		Vote v = new Vote(2,"33", "3", 3, 0,null, null);
		/*System.out.println(v);
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t=s.beginTransaction();
		s.save(v);
		t.commit();
		s.close();
		sf.close();
		textadd();*/
	//	testsave(v);
	//	UserTest.testquery();
	}
/*	public static void textadd() {
		Dao dao = Dao.getInstance();
		Vote back = (Vote) dao.queryVoteById(2);
		HibernateSessionFactory.closeSession();
		System.out.println(back);
	}
	
	private static void testsave(Vote vote) {
		Dao dao =Dao.getInstance();
		boolean f = dao.saveVote(vote);
		HibernateSessionFactory.closeSession();
		System.out.println(f);
	}*/
}
