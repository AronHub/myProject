package com.fjt.service;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.fjt.pojo.Book;

//这个表示我的购物车
@Component
public class MyCart {
	HashMap<String, Book> hm = new HashMap<>();

	//添加书
	public void addBook(String id, Book book) {
		hm.put(id, book);
	}

	//删除书
	public void deltBook(String id) {
		hm.remove(id);
	}

	//更新书（对于购物车更新...）
	public void updateBook(String id, String nums) {

	}

	//清空购物车
	public void clearBook() {
		hm.clear();
	}

}
