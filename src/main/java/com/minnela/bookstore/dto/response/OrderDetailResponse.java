package com.minnela.bookstore.dto.response;

import com.minnela.bookstore.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailResponse {
    private String id;
    private String status;
    private int amount;
    private String startedDate;
    private String updatedDate;
    private String endDate;
    private String customerName;

    public static OrderDetailResponse mapper(Order order) {
        return OrderDetailResponse.builder()
                .id(order.getId())
                .status(order.getStatus())
                .amount(order.getAmount())
                .startedDate(order.getStartedDate())
                .updatedDate(order.getUpdatedDate())
                .endDate(order.getEndDate())
                .customerName(order.getCustomer().getFirstName() + " " +
                        order.getCustomer().getLastName()).build();
    }
}
