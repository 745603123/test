package com.example.system.servlet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.system.model.User;
import com.example.system.model.UserTest;
import com.example.system.model.Vote;
import com.example.system.service.UserService;
import com.example.system.util.ErrorCode;
import com.example.system.util.JsonTools;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class LoginServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		DataInputStream inputStream = new DataInputStream(req.getInputStream());
		String userInfo = inputStream.readUTF();
		User u = getListPerson(userInfo);						
		ServletContext servletContext = this.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servletContext);
		UserService uservice = (UserService) context.getBean("service");
		List<User> userlist = (List<User>) uservice.queryUserById(u);	
		if (!userlist.get(0).equals(null)) {
			String str = JsonTools.createJsonString(userlist.get(0));
			DataOutputStream out = new DataOutputStream(resp.getOutputStream());
			out.writeUTF(str);
			out.flush();
			out.close();
		} else {
			DataOutputStream output = new DataOutputStream(
					resp.getOutputStream());
			output.writeUTF(ErrorCode.LOGIN_FAIL);
			output.close();
		}

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);

	}

	/*
	 * Function : 解析JSON数据，还原成Person对象列表 Param : jsonString 从服务器获得的Json数据
	 * Retuen　 : Person对象列表 Author : 
	 */
	public static User getListPerson(String jsonString) {
		User user = new User();
		Gson gson = new Gson();
		user = gson.fromJson(jsonString, new TypeToken<User>() {
		}.getType());
		return user;
	}

}
