package adem.springframework.msccbrewery.services;

import adem.springframework.msccbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);
}
