package com.fjt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fjt.pojo.Users;
import com.fjt.repository.UserRepo;
import com.fjt.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public Users findUser(String userName, String passwd) {
		// TODO Auto-generated method stub
		Users user = userRepo.findUser(userName, passwd);

		return user;
	}

	@Override
	public void save(Users user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}

}
