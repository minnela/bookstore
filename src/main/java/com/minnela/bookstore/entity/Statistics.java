package com.minnela.bookstore.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "statistics")
public class Statistics{
    @Id
    private String id;
    private int orderAmount;
    private int bookAmount;
    private double totalPurchasedAmount;
    @DBRef
    private Customer customer;
}
