package webapp.spring.auth.backend.customer;

import webapp.spring.auth.backend.customer.Customer;
import webapp.spring.auth.backend.customer.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface CustomerMapper {


    @Mapping(source = "code", target = "code")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    CustomerResponse customerToCustomerResponse(Customer entity);

    List<CustomerResponse> customerToCustomerResponse(List<Customer> entities);

    Customer customerToEntity(CustomerResponse response);

}
