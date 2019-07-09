package com.fjt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fjt.pojo.Book;
import com.fjt.repository.custom.BookCustom;

public interface BookRepo extends CrudRepository<Book, Long>, BookCustom {

	@Override
	@Query("from Book ")
	List<Book> findAll();

	@Query("from Book where id=:id")
	Book findById(@Param("id") Long id);
}
