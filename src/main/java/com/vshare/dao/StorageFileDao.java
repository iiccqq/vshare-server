package com.vshare.dao;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vshare.model.StorageFile;

@Repository
public class StorageFileDao {

	@Resource
	JdbcTemplate jdbcTemplate;

	public List<StorageFile> getFilesByIds(Set<Integer> fileIds) {
		StringBuilder condition = new StringBuilder();
		for(Integer id : fileIds){
			if(condition.length() == 0)
				condition.append("(");
			else
				condition.append(",");
			condition.append(id);			
		}
		condition.append(")");
		String sql = "select * from com_file where id in " + condition;
		List<StorageFile> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<StorageFile>(StorageFile.class));
		return list;
	}

}
