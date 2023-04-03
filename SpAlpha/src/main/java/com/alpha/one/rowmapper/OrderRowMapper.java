package com.alpha.one.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.alpha.one.bean.OrderBean;

public class OrderRowMapper implements RowMapper<OrderBean> {

	@Override
	public OrderBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		OrderBean order= new OrderBean();
		order.setOid(rs.getInt("oid"));
		order.setMaincourse(rs.getString("maincourse"));
		order.setQuantity(rs.getString("quantity"));
		order.setOdate(rs.getDate("date"));

		
		return order;
	}

	
}
