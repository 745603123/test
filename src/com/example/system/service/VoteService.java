package com.example.system.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.example.system.model.User;
import com.example.system.model.Vote;

public interface VoteService {

	public boolean saveVote(Vote vote);
	public List queryVoteByUno(int uno);
	public List queryVoteByUname(String name);
	public List queryVoteAll();

}
