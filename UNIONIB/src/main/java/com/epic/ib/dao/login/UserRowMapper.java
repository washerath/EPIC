package com.epic.ib.dao.login;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.epic.ib.mapping.Ibmobuser;

/**
*@author : Asitha Perera
*@Date Time : Mar 22, 2016:12:25:51 PM
*@Class :UserRowMapper.java
**/
@Component
@Scope("prototype")
public class UserRowMapper implements RowMapper<Ibmobuser> {

	@Autowired
	UserExtractor userExtractor;
	
	public Ibmobuser mapRow(ResultSet resultSet, int line) throws SQLException {
//		UserExtractor userExtractor = new UserExtractor();
		System.out.println("in the extractor..");
		return userExtractor.extractData(resultSet);
	}
}
