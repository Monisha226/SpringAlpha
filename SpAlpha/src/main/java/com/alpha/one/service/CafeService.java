package com.alpha.one.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.one.bean.OrderBean;
import com.alpha.one.repository.DAO;

@Service
public class CafeService {

	@Autowired
	private DAO dao;
	
	

	public List<OrderBean> getorderlist() {


		List<OrderBean> list= dao.getorderlist();
		
		return list;
	}

	
	public String placeorder(OrderBean order) {
		
		String msg= dao.placeorder(order);
		
		return msg;
	}

	
	public String cancelorder(int id) {

		String msg= dao.cancelorder(id);
		
		return msg;
	}

	
	public OrderBean editorder(int id) {

		OrderBean eorder= dao.editorder(id);
		
		return eorder;
	}
}
