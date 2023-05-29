package br.com.desafio.msdesafio.service.impl;

import br.com.desafio.msdesafio.model.Customer;
import br.com.desafio.msdesafio.repository.CustomerRepository;
import br.com.desafio.msdesafio.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(final Long id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(final Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(final Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(final Long id) {
        customerRepository.deleteById(id);
    }
}


