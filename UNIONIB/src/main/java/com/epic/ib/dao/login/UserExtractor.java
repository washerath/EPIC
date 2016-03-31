package com.epic.ib.dao.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.epic.ib.mapping.Ibmobuser;

/**
 * @author : Bilal AK
 * @Date Time : Mar 22, 2016:12:05:26 PM
 * @Class :UserExtractor.java
 **/
@Component
@Scope("prototype")
public class UserExtractor implements ResultSetExtractor<Ibmobuser> {

	@Autowired
	Ibmobuser user;
	
	public Ibmobuser extractData(ResultSet resultSet)
			throws SQLException, DataAccessException {
//		System.out.println("in the row mapper");
//		Ibmobuser user = new Ibmobuser();
		user.setUserid(resultSet.getInt(1));
		System.out.println("$$$$ id is:"+user.getUserid());
		user.setUsername(resultSet.getString(2));
		user.setPassword(resultSet.getString(3));
		user.setEmail(resultSet.getString(4));
		user.setStatus(resultSet.getString(5));
		user.setFirstlogin(resultSet.getBigDecimal(6));
		user.setLastlogindate(resultSet.getTimestamp(7, Calendar.getInstance(new Locale("en","US"))));
		user.setExpirydate(resultSet.getObject(8));
		user.setChannel(resultSet.getString(9));
		user.setAttempts(resultSet.getBigDecimal(10));
		user.setCif(resultSet.getString(11));
		user.setImage(resultSet.getBytes(12));
		user.setRemark(resultSet.getString(13));
		user.setGender(resultSet.getString(14));
		user.setLastupdateduser(resultSet.getString(15));
		user.setLastupdatedtime(resultSet.getDate(16));
		user.setCreatedtime(resultSet.getDate(17));
		user.setTitle(resultSet.getString(18));
		user.setFirstname(resultSet.getString(19));
		user.setMiddlename(resultSet.getString(20));
		user.setLastname(resultSet.getString(21));
		user.setNic(resultSet.getString(22));
		user.setPermAddress(resultSet.getString(23));
		user.setPassword(resultSet.getString(24));
		user.setContactHome(resultSet.getString(25));
		user.setContactMobile(resultSet.getString(26));
		user.setContactOffice(resultSet.getString(27));
		return user;
	}

}
