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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.system.model.BaseModel;
import com.example.system.model.Item;
import com.example.system.model.User;
import com.example.system.util.ErrorCode;


public class AddVoteServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{	 
		/*    String iid=req.getParameter("I_id");        	        
	        Item item=new Item();
	        item.setI_id(Integer.valueOf(iid));
	        Dao dao = Dao.getInstance();
			boolean back = dao.updateItem(item);
			HibernateSessionFactory.closeSession();      
	        if(back == false){	        	
				DataOutputStream output = new DataOutputStream(resp.getOutputStream() );			
				output.writeUTF(ErrorCode.VOTING_FAIL);
				output.close();	        	
	        }else{
				DataOutputStream output = new DataOutputStream(resp.getOutputStream() );			
				output.writeUTF(ErrorCode.VOTING_SUCCESS);
				output.close();	        	
	        }*/
	        
			
		}
		
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}


}
