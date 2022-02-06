package com.minnela.bookstore.repository;

import com.minnela.bookstore.entity.Statistics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatisticsRepository extends MongoRepository<Statistics, String> {
    Optional<Statistics> findAllByCustomer_Id(String customerId);
}
