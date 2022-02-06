package com.minnela.bookstore.controller;

import com.minnela.bookstore.dto.request.CustomerRequest;
import com.minnela.bookstore.dto.response.CustomerDetailResponse;
import com.minnela.bookstore.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookstore/customer")
@AllArgsConstructor
@Tag(name = "bookstore/customer", description = "Endpoints for managing customers")
public class CustomerController {
    private final CustomerService customerService;

    @Operation(summary = "Create a customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns created customer with its id",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomerDetailResponse.class))}),
            @ApiResponse(responseCode = "409", description = "Data conflict",
                    content = @Content)})
    @PostMapping("/create")
    public ResponseEntity<CustomerDetailResponse> createCustomer(@RequestBody CustomerRequest customerRequest) {
        return new ResponseEntity(customerService.createCustomer(customerRequest), HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<Page<CustomerDetailResponse>> listAllOrdersOfCustomer(@RequestParam("id") String customerId,
                                                                                @RequestParam("page") int page,
                                                                                @RequestParam("size") int size) {
        return new ResponseEntity(customerService.listAllOrders(customerId,
                PageRequest.of(page, size, Sort.by("createdAt").descending())), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity findCustomerById(@RequestParam("id") String customerId) {
        return new ResponseEntity(customerService.findCustomerById(customerId), HttpStatus.OK);
    }

}
