package com.example.system.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.example.system.model.Item;
import com.example.system.model.User;
import com.example.system.model.Vote;

public interface ItemService {

	public boolean saveItem(Item item);
	public List queryItemAllByVid(int v_id);
	public List queryItemAllByVtitle(String v_title);
	public List queryItemAll();
	public boolean saveItemList(List<Item> itemlist);
}
