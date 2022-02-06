package com.minnela.bookstore.service;

import com.minnela.bookstore.dto.request.OrderRequest;
import com.minnela.bookstore.entity.Book;

import java.util.Set;

public interface BookService {
    void addBook(Book book);
    Set<Book> updateBookStock(OrderRequest orderRequest);
    Book updateBookStock(String bookId, int amount);
    Book addBookStock(String bookId, int amount);
}
