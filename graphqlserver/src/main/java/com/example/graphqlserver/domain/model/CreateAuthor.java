package com.example.graphqlserver.domain.model;

import java.util.UUID;

public record CreateAuthor (
		String firstName,
		String lastName) {

    public static Author create( CreateAuthor createAuthor ) {
    	UUID uuid = UUID.randomUUID();
        return new Author( uuid.toString(), createAuthor.firstName, createAuthor.lastName );
    }

}