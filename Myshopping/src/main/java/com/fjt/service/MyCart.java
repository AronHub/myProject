package com.fjt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.springframework.stereotype.Component;

import com.fjt.pojo.Book;

//这个表示我的购物车
//?????为什么不把购物车设计成数据库表？？
@Component
public class MyCart {

	HashMap<String, Book> hm = new HashMap<>();

	//添加书
	public void addBook(String id, Book book) {
		if (hm.containsKey(id)) {
			Book bk = hm.get(id);
			int amount = bk.getAmount();
			bk.setAmount(amount + 1);

		} else {
			hm.put(id, book);
		}

	}

	//删除书
	public void deltBook(String id) {
		hm.remove(id);
	}

	//更新书（对于购物车更新...）
	public void updateBook(String id, String nums) {
        Book book=hm.get(id);
        book.setAmount(Integer.parseInt(nums));
		
	}

	//清空购物车
	public void clearBook() {
		System.out.println(hm.toString());
		hm.clear();
	}

	//显示该购物车中的所有商品信息
	public ArrayList showAllMyCart() {
		ArrayList<Book> bookList = new ArrayList<>();
		Iterator<String> iterator = hm.keySet().iterator();
		while (iterator.hasNext()) {
			//取出key
			String id = iterator.next();
			Book book = hm.get(id);
			bookList.add(book);

		}
		return bookList;
	}

	/**
	 * 
	     * @Title: 返回该购物车的总价
	     * @Description: TODO(这里用一句话描述这个方法的作用)
	     * @param @return 参数
	     * @return float 返回类型
	     * @throws
	 */
	public double getTotalPrice() {
		Iterator<String> key = hm.keySet().iterator();
		float sum = 0.0f;
		while (key.hasNext()) {
			String id = key.next();
			Book book = hm.get(id);
			sum += book.getAmount() * book.getPrice();
		}
		return sum;
	}
}
