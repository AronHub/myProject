package com.fjt.util;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
//�Զ����Repostiy�ӿڡ�
@NoRepositoryBean
public interface EntinRepostiy<T, ID extends Serializable> extends Repository<T, ID>{

	<S extends T> S save(S entity);
	
	T findOne(ID id);
	
	void delete(ID id);
	
	void delete(T entity);
	
	void deleteAll();
}
