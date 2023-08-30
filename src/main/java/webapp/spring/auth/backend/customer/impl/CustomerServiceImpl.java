package webapp.spring.auth.backend.customer.impl;

import webapp.spring.auth.backend.customer.Customer;
import webapp.spring.auth.backend.customer.CustomerMapper;
import webapp.spring.auth.backend.customer.CustomerResponse;
import webapp.spring.auth.backend.customer.CustomerRepository;
import webapp.spring.auth.backend.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<CustomerResponse> getAvailableCustomers() {
        List<Customer> customers = customerRepository.findAll();

        return customerMapper.customerToCustomerResponse(customers);
    }

}
