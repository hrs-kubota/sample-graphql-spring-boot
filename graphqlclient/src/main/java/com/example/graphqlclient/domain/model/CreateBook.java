package com.example.graphqlclient.domain.model;

public record CreateBook (
		String name,
		int pageCount,
		CreateAuthor author) {

}