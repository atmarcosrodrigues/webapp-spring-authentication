package webapp.spring.auth.backend.product;

import webapp.spring.auth.backend.entity.BaseEntity;
import webapp.spring.auth.backend.product.customerproduct.CustomerProduct;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product extends BaseEntity implements Serializable {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "productType")
    private String productType;

    @Column(name = "active", nullable = false, columnDefinition = "boolean default true")
    @NotNull
    private Boolean active;

    @OneToMany(mappedBy = "product")
    List<CustomerProduct> customerProducts;

}
