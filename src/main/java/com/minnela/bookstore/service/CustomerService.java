package com.minnela.bookstore.service;

import com.minnela.bookstore.dto.request.CustomerRequest;
import com.minnela.bookstore.dto.response.CustomerDetailResponse;
import com.minnela.bookstore.dto.response.OrderDetailResponse;
import com.minnela.bookstore.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    CustomerDetailResponse createCustomer(CustomerRequest customer);
    Page<OrderDetailResponse> listAllOrders(String customerId, Pageable pageable);
    Customer findCustomerById(String id);
}
