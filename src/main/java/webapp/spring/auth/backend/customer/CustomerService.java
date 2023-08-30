package webapp.spring.auth.backend.customer;

import java.util.List;

public interface CustomerService {

    List<CustomerResponse> getAvailableCustomers();

}
