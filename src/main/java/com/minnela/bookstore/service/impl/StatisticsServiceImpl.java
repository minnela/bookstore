package com.minnela.bookstore.service.impl;

import com.minnela.bookstore.entity.Customer;
import com.minnela.bookstore.entity.Order;
import com.minnela.bookstore.entity.Statistics;
import com.minnela.bookstore.repository.StatisticsRepository;
import com.minnela.bookstore.service.StatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class StatisticsServiceImpl implements StatisticsService {
    private StatisticsRepository statisticsRepository;

    @Override
    public void updateCustomerOrderStatistics(Customer customer, Order order) {
        Optional<Statistics> statistics = statisticsRepository.findAllByCustomer_Id(customer.getId());
        if (statistics.isPresent()) {
            Statistics newStat = Statistics.builder().id(statistics.get().getId())
                    .customer(customer)
                    .orderAmount(statistics.get().getOrderAmount() + 1)
                    .bookAmount(statistics.get().getBookAmount() + order.getAmount())
                    .totalPurchasedAmount(statistics.get().getTotalPurchasedAmount() + order.getTotalPrice())
                    .build();
            statisticsRepository.save(newStat);
        } else {
            Statistics newStat = Statistics.builder()
                    .customer(customer)
                    .orderAmount(1)
                    .bookAmount(order.getAmount())
                    .totalPurchasedAmount(order.getTotalPrice())
                    .build();
            statisticsRepository.save(newStat);
        }
    }

    @Override
    public Optional<Statistics> findStatisticByCustomer(String customerId) {
        return statisticsRepository.findAllByCustomer_Id(customerId);
    }

}
