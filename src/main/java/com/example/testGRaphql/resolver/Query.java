package com.example.testGRaphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.testGRaphql.entity.Author;
import com.example.testGRaphql.entity.Book;
import com.example.testGRaphql.repository.AuthorRepository;
import com.example.testGRaphql.repository.BookRepository;

/**
 * Created by adrien on 2018-06-06.
 */
public class Query implements GraphQLQueryResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }
    public long countAuthors() {
        return authorRepository.count();
    }
}