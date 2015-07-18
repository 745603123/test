package com.example.system.daoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.example.system.dao.BaseDao;
import com.example.system.model.User;

public class VoteDaoImpl extends HibernateDaoSupport implements BaseDao {

	@Override
	public boolean deleteObject(Object obj) throws HibernateException {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteObject(Class class1, Serializable serializable)
			throws HibernateException {
				return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateObject(Object obj) throws HibernateException {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean saveObject(Object obj) throws HibernateException {
		boolean isSave = true;
			try {
				getHibernateTemplate().save(obj);
			
			} catch (RuntimeException re) {
				isSave=false;
				throw re;
			}
			return isSave;

	}

	@Override
	public boolean getObject(Class class1, Serializable serializable)
			throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List hqlQuery(String hsql) throws HibernateException {
		// TODO Auto-generated method stub
		List list=getHibernateTemplate().find(hsql);
		return list;
	}

	@Override
	public List hqlQuery(String hsql, Object obk) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List queryObjectById(String hsql, int no, String pw) throws HibernateException {
		return null;
	}

	@Override
	public List queryObjectById(String hsql, int no) throws HibernateException {
		// TODO Auto-generated method stub
		List list=getHibernateTemplate().find(hsql, no);
		return list;
	}

	public List queryObjectById(String hsql, String name) throws HibernateException {
		// TODO Auto-generated method stub
		List list=getHibernateTemplate().find(hsql, name);
		return list;
	}
/*	@Override
	public Object queryObjectById(String hsql)
			throws HibernateException {
		Object object=getHibernateTemplate().find(hsql, values);
		return null;
	}*/


}
