package webapp.spring.auth.backend.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import webapp.spring.auth.backend.product.Product;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link Product} entity
 */
public record ProductDetailsResponse(@JsonProperty("id")
                                     @NotNull UUID id,
                                     @JsonProperty("name")
                                     @NotNull String name,
                                     @JsonProperty("description")
                                     @NotNull String description,
                                     @NotNull @JsonProperty("productType")
                                     String productType) implements Serializable {

}