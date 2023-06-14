package com.example.graphqlclient.presentation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.graphqlclient.application.service.BookService;
import com.example.graphqlclient.domain.model.Book;
import com.example.graphqlclient.domain.model.CreateAuthor;
import com.example.graphqlclient.domain.model.CreateBook;

@RestController
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping
	@RequestMapping("/book/{bookId}")
	public Book book( @PathVariable("bookId") String bookId ) {
		return bookService.findBook(bookId).block();
	}

	@GetMapping
	@RequestMapping("/new")
	public Book newBook() {
		CreateBook createBook = new CreateBook("New Book", 100, new CreateAuthor("Agatha", "Christie"));
		return bookService.createBook( createBook ).block();
	}

}
