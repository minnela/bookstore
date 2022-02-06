package com.minnela.bookstore.controller;

import com.minnela.bookstore.service.StatisticsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookstore/statistic")
@AllArgsConstructor
@Tag(name = "bookstore/statistic", description = "Endpoints for managing statistic")
public class StatisticController {
    private StatisticsService statisticsService;

    @GetMapping()
    public ResponseEntity listStatsOfCustomer(@RequestParam("id") String customerId) {
        return new ResponseEntity(statisticsService.findStatisticByCustomer(customerId), HttpStatus.OK);
    }
}
