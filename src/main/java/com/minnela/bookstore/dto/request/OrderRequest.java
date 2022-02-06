package com.minnela.bookstore.dto.request;

import lombok.Data;
import java.util.Map;

@Data
public class OrderRequest {
    private int amount;
    private Map<String, Integer> bookIdsAndAmounts;
    private String customerId;
}
