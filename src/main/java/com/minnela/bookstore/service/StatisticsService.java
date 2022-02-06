package com.minnela.bookstore.service;

import com.minnela.bookstore.entity.Customer;
import com.minnela.bookstore.entity.Order;
import com.minnela.bookstore.entity.Statistics;

import java.util.Optional;

public interface StatisticsService {
    void updateCustomerOrderStatistics(Customer customer, Order order);
    Optional<Statistics> findStatisticByCustomer(String customerId);
}
