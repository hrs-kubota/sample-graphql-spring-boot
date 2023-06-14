package com.example.graphqlserver.domain.model;

import java.util.UUID;

public record CreateBook (String name, int pageCount, CreateAuthor author) {

    public static Book create( CreateBook createBook, String authorId ) {
    	UUID uuid = UUID.randomUUID();
        return new Book(uuid.toString(), createBook.name, createBook.pageCount, authorId);
    }

}