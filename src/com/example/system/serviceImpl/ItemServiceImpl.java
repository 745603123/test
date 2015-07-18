package com.example.system.serviceImpl;


import java.util.ArrayList;
import java.util.List;
import com.example.system.daoImpl.ItemDaoImpl;
import com.example.system.model.Item;
import com.example.system.model.Vote;
import com.example.system.service.ItemService;

public class ItemServiceImpl implements ItemService{
	
	private ItemDaoImpl idao;
	public ItemDaoImpl getIdao() {
		return idao;
	}
	public void setIdao(ItemDaoImpl idao) {
		this.idao = idao;
	}
	@Override
	public boolean saveItem(Item item) {
		return getIdao().saveObject(item);
	}
	@Override
	public List queryItemAllByVid(int v_id) {
		return getIdao().queryObjectById("from Item i where v_id=?",v_id);
	}
	@Override
	public List queryItemAllByVtitle(String v_title) {
		return getIdao().queryObjectById("from Item i where v_title=?",v_title);
	}
	@Override
	public List queryItemAll() {
		return getIdao().hqlQuery("from Item ");
	}
	@Override
	public boolean saveItemList(List<Item> itemlist) {
		boolean flag=true;
		for(Item item:itemlist)
			if(getIdao().saveObject(item)==false)
				flag=false;
		return flag;
	}



}
