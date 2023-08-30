package webapp.spring.auth.backend.product.impl;

import webapp.spring.auth.backend.product.ProductMapper;
import webapp.spring.auth.backend.product.ProductResponse;
import webapp.spring.auth.backend.product.ProductService;
import webapp.spring.auth.backend.product.customerproduct.CustomerProduct;
import webapp.spring.auth.backend.product.customerproduct.CustomerProductMapper;
import webapp.spring.auth.backend.product.customerproduct.CustomerProductRepository;
import webapp.spring.auth.backend.product.customerproduct.CustomerProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private CustomerProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CustomerProductMapper customerProductMapper;

    @Override
    public List<ProductResponse> getAvailableProducts(Long customerCode) {
        List<CustomerProduct> products = productRepository.findByTenantCustomer(customerCode);

        return customerProductMapper.productListoProductResponseList(products);
    }

    @Override
    public List<CustomerProductResponse> getAvailableProducts() {
        List<CustomerProduct> products = productRepository.getAllProducts();

        return customerProductMapper.productCustomerListoProductResponseList(products);
    }

}
