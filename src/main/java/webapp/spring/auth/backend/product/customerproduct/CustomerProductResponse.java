package webapp.spring.auth.backend.product.customerproduct;

import com.fasterxml.jackson.annotation.JsonProperty;
import webapp.spring.auth.backend.customer.CustomerResponse;
import webapp.spring.auth.backend.product.ProductDetailsResponse;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link CustomerProduct} entity
 */
public record CustomerProductResponse(@JsonProperty("product")
                              @NotNull ProductDetailsResponse product,
                                      @JsonProperty("customer")
                                      @NotNull CustomerResponse customer,
                                      @JsonProperty("price")
                              @NotNull BigDecimal price) implements Serializable {

}