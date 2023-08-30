package webapp.spring.auth.backend.product.customerproduct;

import webapp.spring.auth.backend.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerProductRepository extends JpaRepository<CustomerProduct, UUID> {

    @Query("SELECT c from CustomerProduct c where c.customer.code =:code")
    List<CustomerProduct> findByTenantCustomer(@Param("code") Long code);

    @Query("SELECT c from CustomerProduct c")
    List<CustomerProduct> getAllProducts();

}
