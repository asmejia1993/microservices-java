package com.asmejiaservice.customer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService service;

    @PostMapping
    public Customer registerCustomer(@RequestBody CustomerRequest request) {
        log.info("new customer registration {}", request);
        var customer = service.registerCustomer(request);
        log.info("customer saved {}", customer);
        return customer;
    }

}
