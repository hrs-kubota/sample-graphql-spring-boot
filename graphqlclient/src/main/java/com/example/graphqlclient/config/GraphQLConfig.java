package com.example.graphqlclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;

@Configuration
public class GraphQLConfig {

	@Bean
	public HttpGraphQlClient httpGraphQlClient() {
        return HttpGraphQlClient.builder().url("http://localhost:8181/graphql").build();
	}
}
