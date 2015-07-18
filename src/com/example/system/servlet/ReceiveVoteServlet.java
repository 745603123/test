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
import com.example.system.model.User;
import com.example.system.model.Vote;
import com.example.system.service.UserService;
import com.example.system.service.VoteService;
import com.example.system.util.ErrorCode;
import com.example.system.util.JsonTools;

public class ReceiveVoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String name = req.getParameter("name");		
		ServletContext servletContext = this.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servletContext);
		VoteService vservice = (VoteService) context.getBean("vservice");
		List<Vote> voteresult = (List<Vote>) vservice.queryVoteAll();	
		if (voteresult != null && !voteresult.isEmpty()) {
			String str = JsonTools.createJsonString(voteresult);
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
		doPost(req, resp);
	}

}
