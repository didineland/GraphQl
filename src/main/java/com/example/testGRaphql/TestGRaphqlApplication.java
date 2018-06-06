package com.example.testGRaphql;

import com.example.testGRaphql.entity.Author;
import com.example.testGRaphql.entity.Book;
import com.example.testGRaphql.repository.AuthorRepository;
import com.example.testGRaphql.repository.BookRepository;
import com.example.testGRaphql.resolver.BookResolver;
import com.example.testGRaphql.resolver.Mutation;
import com.example.testGRaphql.resolver.Query;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestGRaphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestGRaphqlApplication.class, args);
	}

	@Bean
	public BookResolver authorResolver(AuthorRepository authorRepository) {
		return new BookResolver(authorRepository);
	}

	@Bean
	public Query query(AuthorRepository authorRepository, BookRepository bookRepository) {
		return new Query(authorRepository, bookRepository);
	}

	@Bean
	public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
		return new Mutation(authorRepository, bookRepository);
	}

    @Bean
    public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository) {
        return (args) -> {
            Author author = new Author("Herbert", "Schildt");
            authorRepository.save(author);
            bookRepository.save(new Book("Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, author));

            author = new Author("Didine", "Didine");
            authorRepository.save(author);
            bookRepository.save(new Book("Didine LOL", "fefe", 2, author));



      };
    }
}
