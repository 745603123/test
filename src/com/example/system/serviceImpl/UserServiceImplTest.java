package com.example.system.serviceImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.example.system.dao.BaseDao;
import com.example.system.daoImpl.UserDaoImpl;
import com.example.system.model.Item;
import com.example.system.model.User;
import com.example.system.model.Vote;
import com.example.system.service.ItemService;
import com.example.system.service.UserService;
import com.example.system.service.VoteService;

public class UserServiceImplTest {
	static VoteService vservice;
	static UserService uservice;
	static ItemService iservice;

	public static void main(String[] args) {
		/*
		 * ApplicationContext context = new FileSystemXmlApplicationContext(
		 * "WebContent/WEB-INF/applicationContext.xml");
		 */

		// queryvotetest();
		// queryusertest();
		queryitemtest();

		// savetest();
		// querytest();
	}

	public static void savetest() {
		ApplicationContext context = new FileSystemXmlApplicationContext("WebContent/WEB-INF/applicationContext.xml");
		uservice = (UserService) context.getBean("service");
		User u = new User();
		u.setU_no(100);
		u.setU_name("712ddde4444");
		u.setU_pwd("tesssst");
		boolean f = uservice.saveUser(u);
		if (f != false)
			System.out.println("保存成功！");
		else
			System.out.println("保存失败！");
	}

	@SuppressWarnings("unchecked")
	public static void querytest() {
		ApplicationContext context = new FileSystemXmlApplicationContext("WebContent/WEB-INF/applicationContext.xml");
		uservice = (UserService) context.getBean("service");
		List<User> list = (List<User>) uservice.queryUserById(new User(7, "638", null, null, null));
		System.out.println(list.get(0).getU_tel());

	}

	public static void queryusertest() {
		ApplicationContext context = new FileSystemXmlApplicationContext("WebContent/WEB-INF/applicationContext.xml");
		uservice = (UserService) context.getBean("service");
		List<User> list = (List<User>) uservice.queryUserAll();
		System.out.println(list);

	}

	public static void queryitemtest() {
		ApplicationContext context = new FileSystemXmlApplicationContext("WebContent/WEB-INF/applicationContext.xml");
		iservice = (ItemService) context.getBean("iservice");
		List<Item> list = (List<Item>) iservice.queryItemAll();
		System.out.println(list);

	}

	public static void queryvotetest() {
		ApplicationContext context = new FileSystemXmlApplicationContext("WebContent/WEB-INF/applicationContext.xml");
		vservice = (VoteService) context.getBean("vservice");
		List<Vote> list = (List<Vote>) vservice.queryVoteAll();
		System.out.println(list);

	}

	public static void savevotetest() {
		ApplicationContext context = new FileSystemXmlApplicationContext("WebContent/WEB-INF/applicationContext.xml");
		uservice = (UserService) context.getBean("service");
		User u = new User();
		u.setU_no(100);
		u.setU_name("712ddde");
		u.setU_pwd("tesssst");
		boolean f = uservice.saveUser(u);
		if (f != false)
			System.out.println("保存成功！");
		else
			System.out.println("保存失败！");
	}

}
