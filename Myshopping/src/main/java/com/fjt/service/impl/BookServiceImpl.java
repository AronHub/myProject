package com.fjt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fjt.pojo.Book;
import com.fjt.repository.BookRepo;
import com.fjt.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}

}
