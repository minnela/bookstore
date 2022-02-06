package com.minnela.bookstore.controller;

import com.minnela.bookstore.dto.request.OrderRequest;
import com.minnela.bookstore.dto.response.OrderDetailResponse;
import com.minnela.bookstore.entity.Order;
import com.minnela.bookstore.service.OrderService;
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

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/bookstore/order")
@AllArgsConstructor
@Tag(name = "bookstore/order", description = "Endpoints for managing orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDetailResponse> createOrder(@Valid @RequestBody OrderRequest orderRequest) {
        return new ResponseEntity(orderService.create(orderRequest), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> getOrderById(@PathVariable("id") String orderId) {
        return new ResponseEntity(orderService.getOrderById(orderId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Optional<Order>> listOrdersByTimeInterval(@RequestParam String startDate, String endDate) {
        return new ResponseEntity(orderService.listOrdersByTimeInterval(startDate, endDate), HttpStatus.OK);
    }
}
