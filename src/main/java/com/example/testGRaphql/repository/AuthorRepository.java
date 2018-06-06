package com.example.testGRaphql.repository;

import com.example.testGRaphql.entity.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by adrien on 2018-06-06.
 */
public interface AuthorRepository extends CrudRepository<Author, Long> { }
