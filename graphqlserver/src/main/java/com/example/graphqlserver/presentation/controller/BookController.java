package com.example.graphqlserver.presentation.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.example.graphqlserver.domain.model.Author;
import com.example.graphqlserver.domain.model.Book;
import com.example.graphqlserver.domain.model.CreateAuthor;
import com.example.graphqlserver.domain.model.CreateBook;

@Controller
public class BookController {

	@QueryMapping
    public Book bookById(@Argument("id") String id) {
        return Book.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }

    @MutationMapping
    public Book newBook(@Argument("input") CreateBook createBook) {
    	Author newAuthor = CreateAuthor.create( createBook.author() );
    	Book newBook = CreateBook.create(createBook, newAuthor.id());
    	Book.add(newBook);
    	Author.add(newAuthor);
    	return newBook;
    }

}