package com.example.system.servlet;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import com.example.system.service.VoteService;
import com.example.system.util.ErrorCode;
import com.example.system.util.JsonTools;

public class OptionServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String v_title = req.getParameter("V_title");	
		String v_id = req.getParameter("V_id");	
		ServletContext servletContext = this.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servletContext);
		ItemService iservice = (ItemService) context.getBean("iservice");
		List<Item> itemresult = (List<Item>) iservice.queryItemAllByVtitle(v_title);		
		if (itemresult!=null&&!itemresult.isEmpty()) {
			String str = JsonTools.createJsonString(itemresult);
			DataOutputStream out = new DataOutputStream(resp.getOutputStream());
			out.writeUTF(str);
			out.flush();
			out.close();
		} else {
			DataOutputStream output = new DataOutputStream(
					resp.getOutputStream());
			output.writeUTF(ErrorCode.PUBLISHVOTE_FAIL);
			output.close();
		}

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("fdfdf");
				doPost(req, resp);
	}

}
