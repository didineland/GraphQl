package com.example.testGRaphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.testGRaphql.entity.Author;
import com.example.testGRaphql.entity.Book;
import com.example.testGRaphql.repository.AuthorRepository;

import java.util.Optional;

public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        Optional<Author> author = authorRepository.findById(book.getAuthor().getId());
        return author.get();
    }
}