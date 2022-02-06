package com.minnela.bookstore.exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(){super("Book not found");}
    public BookNotFoundException(String id){super("Book not found with given id: " + id);}
}
