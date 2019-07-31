package com.fjt.repository;

import org.springframework.data.repository.CrudRepository;

import com.fjt.pojo.OrderItem;
import com.fjt.pojo.Orders;
import com.fjt.repository.custom.OrderItemCustom;
import com.fjt.repository.custom.OrdersCustom;

public interface OrderItemRepo extends CrudRepository<OrderItem, Long>,OrderItemCustom{

}
