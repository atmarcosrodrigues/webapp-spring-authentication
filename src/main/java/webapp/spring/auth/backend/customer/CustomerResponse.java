package webapp.spring.auth.backend.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import webapp.spring.auth.backend.product.customerproduct.CustomerProduct;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link CustomerProduct} entity
 */
public record CustomerResponse(@JsonProperty("code")
                              @NotNull Long code,
                               @JsonProperty("name")
                                @NotNull String name,
                               @JsonProperty("description")
                              @NotNull String description) implements Serializable {

}