package com.example.demo.repositories;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration
@EnableJdbcRepositories("com.example.demo.repositories")
public class RepositoryConfig {
}
