package com.alpha.one.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.alpha.one.bean.OrderBean;
import com.alpha.one.rowmapper.OrderRowMapper;

@Repository
public class OrderDao implements DAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<OrderBean> getorderlist() {

		
		String sql= "select * from Orders";
		List<OrderBean> orderlist= jdbcTemplate.query(sql, new OrderRowMapper());
		return orderlist;
	}

	
	@Override
	public String placeorder(OrderBean order) {
		String sql= "insert into orders(maincourse,quantity,total,odate) values(?,?,?,?) ";
		int i= jdbcTemplate.update( sql, order.getMaincourse(), order.getQuantity(), 
				order.getTotal(), order.getOdate());
		if(i<1)
			return "ok";
		else 
			return "error";
	}

	@Override
	public String cancelorder(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderBean editorder(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
