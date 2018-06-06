package com.example.testGRaphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.testGRaphql.entity.Author;
import com.example.testGRaphql.entity.Book;
import com.example.testGRaphql.repository.AuthorRepository;
import com.example.testGRaphql.repository.BookRepository;

import java.util.Optional;

/**
 * Created by adrien on 2018-06-06.
 */
public class Mutation implements GraphQLMutationResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        bookRepository.save(book);

        return book;
    }

    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Optional<Book> bookOpt =  bookRepository.findById(id);
        if(bookOpt.isPresent()){
            Book book = bookOpt.get();
            book.setPageCount(pageCount);
            bookRepository.save(book);

            return book;
        }

        return null;
    }
}
