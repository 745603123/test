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
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.system.model.BaseModel;
import com.example.system.model.User;
import com.example.system.service.UserService;
import com.example.system.util.ErrorCode;


public class RegisterServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{	 
		    String name=req.getParameter("UserName");
	        String password=req.getParameter("Password");	 
	        String email=req.getParameter("Email");	
	        String tel=req.getParameter("Tel");        
	        User u=new User();
	        u.setU_name(name);
	        u.setU_pwd(password);
	        u.setU_email(email);
	        u.setU_tel(tel);
			
			ServletContext servletContext = this.getServletContext();
			WebApplicationContext context = WebApplicationContextUtils
					.getRequiredWebApplicationContext(servletContext);
			UserService uservice = (UserService) context.getBean("service");
			boolean result = uservice.saveUser(u);	
			
	        if(result == false){        	
				DataOutputStream output = new DataOutputStream(resp.getOutputStream() );			
				output.writeUTF(ErrorCode.REGISTER_FAIL);
				output.close();	        	
	        }else{

				DataOutputStream output = new DataOutputStream(resp.getOutputStream() );			
				output.writeUTF(ErrorCode.REGISTER_SUCCESS);
				output.close();	        	
	        }	        
			
		}
		
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}


}
