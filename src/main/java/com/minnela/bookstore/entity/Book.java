package com.minnela.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "book")
public class Book {
    @Id
    private String id;
    private String bookName;
    private String writerName;
    private String category;
    private double price;
    private int stock;
    private int publishedYear;
}
