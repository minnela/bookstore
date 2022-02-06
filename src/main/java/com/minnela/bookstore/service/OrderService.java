package com.minnela.bookstore.service;

import com.minnela.bookstore.dto.request.OrderRequest;
import com.minnela.bookstore.dto.response.OrderDetailResponse;
import com.minnela.bookstore.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    OrderDetailResponse create(OrderRequest orderRequest);
    Optional<Order> getOrderById(String id);
    List<Order> listOrdersByTimeInterval(String startDate, String endDate);
    Page<OrderDetailResponse> findAllByCustomerId(String id, Pageable pageable);
}
