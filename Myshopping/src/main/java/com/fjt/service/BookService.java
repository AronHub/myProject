package com.fjt.service;

import java.util.List;

import com.fjt.pojo.Book;

public interface BookService {

	List<Book> findAll();

	Book findById(Long id);
}
