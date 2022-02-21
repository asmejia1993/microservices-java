package com.asmejiaservice.customer;

public record CustomerRequest(
    String firstName,
    String lastName,
    String email) {

}
