package com.fjt.service;

import com.fjt.pojo.Users;

public interface UserService {

	Users findUser(String userName, String passwd);

	void save(Users user);
}
