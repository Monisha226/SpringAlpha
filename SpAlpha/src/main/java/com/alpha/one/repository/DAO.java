package com.alpha.one.repository;

import java.util.List;

import com.alpha.one.bean.OrderBean;


public interface DAO {

	
 public	List<OrderBean> getorderlist();
 
 public	String placeorder(OrderBean order);
 
 public	String cancelorder(int id);
 
 public	OrderBean editorder(int id);
 
 
 
}
