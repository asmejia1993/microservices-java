package com.asmejiaservice.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final RestTemplate restTemplate;

    public Customer registerCustomer(CustomerRequest request) {
        
        //todo: validate request


        Customer customer = Customer.builder()
                            .firstName(request.firstName())
                            .lastName(request.lastName())
                            .email(request.email())
                            .build();
        
        repository.saveAndFlush(customer);
       FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                            "http://FRAUD/api/v1/fraud-check/{customerId}", 
                            FraudCheckResponse.class, 
                            customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        return customer;

        //todo: send Notification
    }

}
