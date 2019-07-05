package com.fjt.repository.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.fjt.pojo.Users;
import com.fjt.repository.UserRepo;
import com.fjt.repository.custom.UserCustom;

public class UserRepoImpl implements UserCustom{
	@PersistenceContext
	private EntityManager entitymanager;
	
	@Override
	public Page<Users> HiberPage(Map<String, Object> map, Pageable pageable, String jpql) {
	    Query query = entitymanager.createQuery(jpql);
		/* //setFirstResult��ʾ�ӵڼ�����ʼ��
		query.setFirstResult(pageable.getOffset());
		//setMaxResults��ʾȡ������¼��
		query.setMaxResults(pageable.getPageSize());
		*/
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			//System.out.println("key="+key+"value="+value);
			query.setParameter(key, value);
		}
		@SuppressWarnings("unchecked")
		List<Users> content = query.getResultList();
		
		Page<Users> pge = new PageImpl<Users>(content, pageable, 1);
		return pge;
	}

	

}
