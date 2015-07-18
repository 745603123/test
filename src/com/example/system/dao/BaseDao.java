package com.example.system.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;

public interface BaseDao {

	public boolean deleteObject(Object obj) throws HibernateException;

	public boolean deleteObject(Class class1, Serializable serializable)
			throws HibernateException;

	public boolean updateObject(Object obj) throws HibernateException;

	public boolean saveObject(Object obj) throws HibernateException;

	public boolean getObject(Class class1, Serializable serializable)
			throws HibernateException;

	public List hqlQuery(String hsql) throws HibernateException;

	public List hqlQuery(String hsql, Object obk) throws HibernateException;
	
	public Object queryObjectById(String hsql,int no,String pw) throws HibernateException;

	public List queryObjectById(String hsql, int no) throws HibernateException;
	
	/*
	 * public Session getSession(); public void setSession(Session session);
	 */

}
