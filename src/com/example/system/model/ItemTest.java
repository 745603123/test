package com.example.system.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ItemTest {

	public static void main(String[] args) {
		/*// System.out.println("aa");
		Item i = new Item();
		i.setI_content("QQQ23");	
		System.out.println(i);
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t=s.beginTransaction();
		s.save(i);
		t.commit();
		s.close();
		sf.close();*/
	//	textadd();
	//	testsave(new Item(6,"ppp", 0, 0, 0));
		Item j=new Item(10,"", 0, 0, 0,"");
	//	for(int i=0;i<3;i++)
	//	testupdate(j);
	//	testsave1(new Item(6,"ppp", 0, 0, 0));
	}

/*	private static void testupdate(Item i) {
		Dao dao = Dao.getInstance();
		boolean back = dao.updateItem(i);
		HibernateSessionFactory.closeSession();
		System.out.println(back);
		
	}

	public static void textadd() {
		Dao dao = Dao.getInstance();
		Item back = (Item) dao.queryItemByIid(2);
		HibernateSessionFactory.closeSession();
		System.out.println(back);
	}
	
	private static void testsave(Item i) {
		Dao dao =Dao.getInstance();
		boolean f = dao.saveItem(i);
		HibernateSessionFactory.closeSession();
		System.out.println(f);
	}*/
	
	@SuppressWarnings("null")
	public static void testsave1(Item i) {
		
		List<Item> listitem = new ArrayList<Item>();
	//	Item i1=new Item(9, "i1", 0, 0, 0);
		/*Item i2=new Item(2, "i2", 0, 0, 0);
		
		listitem.add(i1);*/
		listitem.add(i);
		System.out.println(listitem.get(0));
	}
}
