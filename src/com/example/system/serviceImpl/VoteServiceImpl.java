package com.example.system.serviceImpl;


import java.util.List;

import com.example.system.dao.BaseDao;
import com.example.system.daoImpl.VoteDaoImpl;
import com.example.system.model.Vote;
import com.example.system.service.VoteService;

public class VoteServiceImpl implements VoteService{
	
	private VoteDaoImpl vdao;
	public VoteDaoImpl getVdao() {
		return vdao;
	}
	public void setVdao(VoteDaoImpl vdao) {
		this.vdao = vdao;
	}
	
	@Override
	public boolean saveVote(Vote vote) {
		boolean flag=getVdao().saveObject(vote);
		return flag;
	}

	@Override
	public List queryVoteByUno(int uno) {
		return getVdao().queryObjectById("from Vote v where u_no=?",uno);
	}
	@Override
	public List queryVoteAll() {
		return getVdao().hqlQuery("from Vote ");
	}
	@Override
	public List queryVoteByUname(String name) {
		return getVdao().queryObjectById("from Vote v where u_name=?",name);
	}
	
	
	

}
