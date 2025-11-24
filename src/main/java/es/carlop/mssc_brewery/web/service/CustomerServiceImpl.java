package es.carlop.mssc_brewery.web.service;

import es.carlop.mssc_brewery.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById(UUID customerId) {
        log.debug("Fetching customer with ID: {}", customerId);
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name(String.format("Customer %s", customerId.toString()))
                .build();
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        log.debug("Creating customer: {}", customerDTO);
        return CustomerDTO.builder()
                .id(customerDTO.id())
                .name(customerDTO.name())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDTO customerDTO) {
        log.debug("Updating customer with ID: {}. New data: {}", customerId, customerDTO);
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        log.debug("Deleting customer with ID: {}", customerId);
    }
}
