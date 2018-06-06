package com.example.testGRaphql.repository;

import com.example.testGRaphql.entity.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by adrien on 2018-06-06.
 */
public interface BookRepository extends CrudRepository<Book, Long> { }
