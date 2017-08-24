package com.vshare.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vshare.model.Item;

@Repository
public class ItemDao {

	@Resource 
	JdbcTemplate jdbcTemplate;
	
	public List<Item> getItemsList() {
		String sql = "select * from com_item";
		List<Item> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Item>(Item.class));
		return list;
	}

	public Item getItemById(String itemid) {
		String sql = "select * from com_item where id = ?";
		List<Item> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Item>(Item.class),itemid);
		if(list.size() > 0)
			return list.get(0);
		else
			return null;
	}

}
