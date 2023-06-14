package com.example.graphqlclient.application.service;

import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;

import com.example.graphqlclient.domain.model.Book;
import com.example.graphqlclient.domain.model.CreateBook;

import reactor.core.publisher.Mono;

@Service
public class BookService {

    private final HttpGraphQlClient graphQlClient;

    public BookService(HttpGraphQlClient graphQlClient) {
		this.graphQlClient = graphQlClient;
	}

	public Mono<Book> findBook( String bookId ) {

        Mono<Book> book = graphQlClient.documentName("bookById")
        		.variable("bookId", bookId)
                .retrieve("bookById")
                .toEntity(Book.class);

        return book;
    }

    public Mono<Book> createBook( CreateBook createBook ) {

        Mono<Book> book = graphQlClient.documentName("newBook")
        		.variable("input", createBook)
                .retrieve("newBook")
                .toEntity(Book.class);

        return book;
    }
}