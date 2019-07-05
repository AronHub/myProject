package com.fjt.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fjt.pojo.Users;
import com.fjt.repository.custom.UserCustom;

public interface UserRepo extends CrudRepository<Users, Long>,UserCustom{
	/**
	 * 
	 * @param userName
	 * @param passwd
	 * @return
	 */
	@Query("from Users where name=:name and passwd=:passwd ")
	Users findUser(@Param("name")String userName, 
			@Param("passwd")String passwd);
	
}
