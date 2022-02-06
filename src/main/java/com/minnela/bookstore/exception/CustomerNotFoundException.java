package com.minnela.bookstore.exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(){super("Customer not found");}
    public CustomerNotFoundException(String id){super("Customer not found with given id: " + id);}
}
