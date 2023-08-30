package webapp.spring.auth.backend.customer;

import webapp.spring.auth.backend.entity.BaseEntity;
import webapp.spring.auth.backend.product.customerproduct.CustomerProduct;
import webapp.spring.auth.backend.user.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customer")
public class Customer extends BaseEntity implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "active", nullable = false, columnDefinition = "boolean default true")
    @NotNull
    private Boolean active;

    @OneToMany(mappedBy = "customer")
    List<CustomerProduct> customerProducts;

    @OneToMany
    private List<User> users = new ArrayList<>();

}
