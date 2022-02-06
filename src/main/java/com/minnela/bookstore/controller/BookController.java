package com.minnela.bookstore.controller;

import com.minnela.bookstore.entity.Book;
import com.minnela.bookstore.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookstore")
@AllArgsConstructor
@Tag(name = "bookstore", description = "Endpoints for managing books")
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity createBook(@RequestBody Book book){
        try {
            bookService.addBook(book);
            return new ResponseEntity(book, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Update book stock")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book stock is updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "409", description = "Data conflict",
                    content = @Content)})
    @GetMapping("/{id}")
    public ResponseEntity updateBookStock(@PathVariable("id") String bookId, @RequestParam int amount){
        try {
            Book book = bookService.updateBookStock(bookId, amount);
            return new ResponseEntity(book, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/add")
    public ResponseEntity addBookStock(@RequestParam("id") String bookId, @RequestParam("amount") int amount){
        try {
            Book book = bookService.addBookStock(bookId, amount);
            return new ResponseEntity(book, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
