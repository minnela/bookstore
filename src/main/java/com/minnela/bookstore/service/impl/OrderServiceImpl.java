package com.minnela.bookstore.service.impl;

import com.minnela.bookstore.dto.request.OrderRequest;
import com.minnela.bookstore.dto.response.OrderDetailResponse;
import com.minnela.bookstore.entity.Book;
import com.minnela.bookstore.entity.Customer;
import com.minnela.bookstore.entity.Order;
import com.minnela.bookstore.repository.OrderRepository;
import com.minnela.bookstore.service.BookService;
import com.minnela.bookstore.service.CustomerService;
import com.minnela.bookstore.service.OrderService;
import com.minnela.bookstore.service.StatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private CustomerService customerService;
    private BookService bookService;
    private StatisticsService statisticsService;

    @Override
    public OrderDetailResponse create(OrderRequest orderRequest) {
        Set<Book> books = bookService.updateBookStock(orderRequest);
        Customer customer = customerService.findCustomerById(orderRequest.getCustomerId());
        Order newOrder = Order.builder().status("open")
                .startedDate( new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()))
                .amount(orderRequest.getAmount())
                .customer(customer)
                .book(books).build();
        orderRepository.save(newOrder);
        statisticsService.updateCustomerOrderStatistics(customer, newOrder);
        return OrderDetailResponse.mapper(newOrder);
    }

    @Override
    public Optional<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> listOrdersByTimeInterval(String startDate, String endDate) {
        return orderRepository.findAllByStartedDateBetweenAndEndDate(startDate, endDate);
    }

    @Override
    public Page<OrderDetailResponse> findAllByCustomerId(String id, Pageable pageable) {
        return orderRepository.findAllByCustomer_Id(id, pageable)
                .map(OrderDetailResponse::mapper);
    }
}
