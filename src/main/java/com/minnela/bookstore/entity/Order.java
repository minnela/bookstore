package com.minnela.bookstore.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Builder
@Document(collection = "order")
public class Order{
    @Id
    private String id;
    private String status;
    private int amount;
    private String startedDate;
    private String updatedDate;
    private String endDate;
    private double totalPrice;
    @DBRef
    private Set<Book> book;
    @DBRef
    private Customer customer;
}
