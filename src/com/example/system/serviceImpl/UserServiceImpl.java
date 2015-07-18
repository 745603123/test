package com.example.system.serviceImpl;


import java.util.List;

import com.example.system.dao.BaseDao;
import com.example.system.daoImpl.ItemDaoImpl;
import com.example.system.daoImpl.UserDaoImpl;
import com.example.system.daoImpl.VoteDaoImpl;
import com.example.system.model.User;
import com.example.system.service.UserService;
import com.example.system.util.CyptoUtils;


public class UserServiceImpl implements UserService{
	
	private UserDaoImpl udao;
	public UserDaoImpl getDao() {
		return udao;
	}
	public void setDao(UserDaoImpl udao) {
		this.udao = udao;
	}
	public boolean saveUser(User user){
		return getDao().saveObject(user);
	}

	@Override
	public List queryUserById(User user) {
		return getDao().queryObjectById("from User u where u_no=? and u_pwd=?",user.getU_no(), CyptoUtils.decode("voteApppush",user.getU_pwd()));
	}
	@Override
	public List queryUserAll() {
		return getDao().hqlQuery("from User ");
	}

}
