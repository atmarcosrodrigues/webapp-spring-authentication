package webapp.spring.auth.backend.product.customerproduct;

import webapp.spring.auth.backend.customer.Customer;
import webapp.spring.auth.backend.entity.BaseEntity;
import webapp.spring.auth.backend.product.Product;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
@Entity
@Table(name = "customerProduct")
public class CustomerProduct extends BaseEntity implements Serializable {


    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @MapsId("customerId")
    @JoinColumn(name = "customer_id")
    Customer customer;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    Product product;

    @Column(name = "price", precision = 15, scale = 4)
    private BigDecimal price;
}
