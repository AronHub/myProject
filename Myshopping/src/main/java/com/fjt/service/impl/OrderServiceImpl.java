package com.fjt.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fjt.pojo.Book;
import com.fjt.pojo.OrderItem;
import com.fjt.pojo.Orders;
import com.fjt.pojo.Users;
import com.fjt.repository.OrderItemRepo;
import com.fjt.repository.OrdersRepo;
import com.fjt.service.MyCart;
import com.fjt.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrdersRepo ordersRepo;

	@Autowired
	private OrderItemRepo orderItemRepo;

	@Override
	public void saveOrder(MyCart myCart, Users user) {
		// TODO Auto-generated method stub
		Orders order = new Orders();
		order.setOrderDate(new Date());
		order.setTotalPrice(myCart.getTotalPrice());
		order.setUserId(user.getId());
		ordersRepo.save(order);
		System.out.println("id=" + order.getId());

		List<Book> bookList = myCart.showAllMyCart();
		for (Book bk : bookList) {
			OrderItem orderItem = new OrderItem();
			orderItem.setBokId(bk.getId());
			orderItem.setBookNum(bk.getAmount());
			//可以从上面的order对象中获取到id
			orderItem.setOrdersId(order.getId());
			orderItemRepo.save(orderItem);

		}

	}

}
