package com.fjt.repository.custom;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fjt.pojo.Users;

public interface UserCustom {
	public Page<Users> HiberPage(Map<String,Object> map,Pageable pageable,String jpql);
	
}
