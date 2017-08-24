package com.vshare.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vshare.model.ItemDetail;

@Repository
public class ItemDetailDao {

	@Resource
	JdbcTemplate jdbcTemplate;
	
	public ItemDetail getItemByItemid(String itemid) {
		String sql = "select * from com_item_detail  where itemid = ?";
		List<ItemDetail> detailList =jdbcTemplate.query(sql, new BeanPropertyRowMapper<ItemDetail>(ItemDetail.class),itemid);
		if(detailList.size() > 0)
			return detailList.get(0);
		else
			return null;
	}

}
