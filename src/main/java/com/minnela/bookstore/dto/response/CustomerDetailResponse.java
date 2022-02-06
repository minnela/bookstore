package com.minnela.bookstore.dto.response;

import com.minnela.bookstore.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDetailResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public static CustomerDetailResponse mapper(Customer customer) {
        return CustomerDetailResponse.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .build();
    }
}
