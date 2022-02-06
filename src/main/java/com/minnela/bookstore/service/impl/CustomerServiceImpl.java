package com.minnela.bookstore.service.impl;

import com.minnela.bookstore.dto.request.CustomerRequest;
import com.minnela.bookstore.dto.response.CustomerDetailResponse;
import com.minnela.bookstore.dto.response.OrderDetailResponse;
import com.minnela.bookstore.entity.Customer;
import com.minnela.bookstore.exception.CustomerNotFoundException;
import com.minnela.bookstore.repository.CustomerRepository;
import com.minnela.bookstore.repository.OrderRepository;
import com.minnela.bookstore.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;

    @Override
    public CustomerDetailResponse createCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder().email(customerRequest.getEmail())
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .build();
        customerRepository.save(customer);
        return CustomerDetailResponse.mapper(customer);
    }

    @Override
    public Page<OrderDetailResponse> listAllOrders(String customerId, Pageable pageable) {
        return orderRepository.findAllByCustomer_Id(customerId, pageable)
                .map(OrderDetailResponse::mapper);
    }

    @Override
    public Customer findCustomerById(String id) {
        return customerRepository.findById(id).orElseThrow(() ->
                new CustomerNotFoundException(id));
    }
}
