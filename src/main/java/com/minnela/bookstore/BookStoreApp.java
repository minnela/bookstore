package com.minnela.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BookStoreApp {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApp.class, args);
    }

}
