package webapp.spring.auth.backend.product.customerproduct;

import webapp.spring.auth.backend.product.customerproduct.CustomerProduct;
import webapp.spring.auth.backend.product.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface CustomerProductMapper {


    @Mapping(source = "product", target = "product")
    @Mapping(source = "price", target = "price")
    ProductResponse productToProductResponse(CustomerProduct entity);

    List<ProductResponse> productListoProductResponseList(List<CustomerProduct> entities);

    List<CustomerProductResponse> productCustomerListoProductResponseList(List<CustomerProduct> entities);


    CustomerProduct productResponseToEntity(ProductResponse response);

}
