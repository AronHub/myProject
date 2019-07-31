package com.fjt.repository;

import org.springframework.data.repository.CrudRepository;

import com.fjt.pojo.Orders;
import com.fjt.pojo.Users;
import com.fjt.repository.custom.OrdersCustom;

public interface OrdersRepo extends CrudRepository<Orders, Long>,OrdersCustom{
       

	
}
