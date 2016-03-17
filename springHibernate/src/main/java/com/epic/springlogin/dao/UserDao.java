package com.epic.springlogin.dao;

import com.epic.springlogin.model.User;

public interface UserDao {
	
	User findById(int id);
	User findBySSO(String sso);
}
