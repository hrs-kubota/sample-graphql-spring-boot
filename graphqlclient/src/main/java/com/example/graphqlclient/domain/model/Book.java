package com.example.graphqlclient.domain.model;

public record Book(
        String id,
        String name,
        int pageCount,
        Author author
) {
}