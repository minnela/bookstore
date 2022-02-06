package com.minnela.bookstore.repository;

import com.minnela.bookstore.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    Page<Order> findAllByCustomer_Id(String id, Pageable pageable);
    List<Order> findAllByStartedDateBetweenAndEndDate(String startDate, String endData);

}
