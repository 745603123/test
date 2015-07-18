package com.example.system.servlet;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.system.model.BaseModel;
import com.example.system.model.Item;
import com.example.system.model.User;
import com.example.system.model.Vote;
import com.example.system.service.ItemService;
import com.example.system.service.UserService;
import com.example.system.service.VoteService;
import com.example.system.util.ErrorCode;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.xinge.XingeApp;

public class PublishVoteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DataInputStream inputStream = new DataInputStream(req.getInputStream());
		String voteInfo = inputStream.readUTF();
		Vote v = getListVote(voteInfo);
		List<Item> listitem = v.getItemlist();

		
		
		ServletContext servletContext = this.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		VoteService vservice = (VoteService) context.getBean("vservice");
		ItemService iservice = (ItemService) context.getBean("iservice");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
	    Date date = new Date(); 
	//    System.out.println(dateFormat.format(date)); 
		v.setPubtime(dateFormat.format(date));
		boolean voteresult = vservice.saveVote(v);
		boolean itemresule = iservice.saveItemList(listitem);		
		if (!(voteresult == false || itemresule == false)) {			
			XingeApp.pushAllAndroid(2100132542, "6a29eb4ef16158660f1c4ba789430b30", v.getV_title(), v.getV_content());
			DataOutputStream output = new DataOutputStream(resp.getOutputStream());
			output.writeUTF(ErrorCode.PUBLISHVOTE_SUCCESS);
			output.close();
		} else {
			DataOutputStream output = new DataOutputStream(resp.getOutputStream());
			output.writeUTF(ErrorCode.PUBLISHVOTE_FAIL);
			output.close();
		}

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

	}

	/*
	 * Function : 解析JSON数据，还原成Person对象列表 Param : jsonString 从服务器获得的Json数据 Retuen
	 * : Person对象列表 Author :
	 */
	public static Vote getListVote(String jsonString) {
		Vote v = new Vote();
		Gson gson = new Gson();
		v = gson.fromJson(jsonString, new TypeToken<Vote>() {
		}.getType());
		return v;
	}

}
