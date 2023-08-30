package webapp.spring.auth.backend.product;

import webapp.spring.auth.backend.product.Product;
import webapp.spring.auth.backend.product.ProductDetailsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface ProductMapper {


    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    ProductDetailsResponse productToProductResponse(Product entity);

    List<ProductDetailsResponse> productToProductResponse(List<Product> entities);

    Product productDtoToEntity(ProductDetailsResponse response);

}
