package com.minnela.bookstore.service.impl;

import com.minnela.bookstore.dto.request.OrderRequest;
import com.minnela.bookstore.entity.Book;
import com.minnela.bookstore.exception.BookNotFoundException;
import com.minnela.bookstore.repository.BookRepository;
import com.minnela.bookstore.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Set<Book> updateBookStock(OrderRequest orderRequest) {
        Set<Book> set = new HashSet<Book>();
        Map<String, Integer> idsAndAmounts = orderRequest.getBookIdsAndAmounts();
        if(idsAndAmounts.size() > 0){
            idsAndAmounts.forEach((id, amount) -> {
                Book book = updateBookStock(id, amount);
                set.add(book);
            });
        }
        return set;
    }

    @Override
    public Book updateBookStock(String bookId, int amount) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
        if(book.getStock() - amount > 0){
            book.setStock(book.getStock() - amount);
            bookRepository.save(book);
        }
        return book;
    }

    @Override
    public Book addBookStock(String bookId, int amount) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
        book.setStock(book.getStock() + amount);
        bookRepository.save(book);
        return book;
    }
}
