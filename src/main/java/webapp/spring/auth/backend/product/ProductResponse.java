package webapp.spring.auth.backend.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import webapp.spring.auth.backend.product.customerproduct.CustomerProduct;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link CustomerProduct} entity
 */
public record ProductResponse(@JsonProperty("product")
                              @NotNull ProductDetailsResponse product,
                              @JsonProperty("price")
                              @NotNull BigDecimal price) implements Serializable {

}