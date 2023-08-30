package webapp.spring.auth.backend.product;

import webapp.spring.auth.backend.product.customerproduct.CustomerProductResponse;

import java.util.List;

public interface ProductService {

    List<ProductResponse> getAvailableProducts(Long customerCode);

    List<CustomerProductResponse> getAvailableProducts();

}
