package com.epic.springlogin.service;

import com.epic.springlogin.model.User;

public interface UserService {
	User findById(int id);
	User findBySso(String sso);
}
