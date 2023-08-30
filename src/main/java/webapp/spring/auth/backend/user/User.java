package webapp.spring.auth.backend.user;

import webapp.spring.auth.backend.customer.Customer;
import webapp.spring.auth.backend.entity.BaseEntity;
import webapp.spring.auth.backend.role.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users",
        uniqueConstraints = { @UniqueConstraint(columnNames =
                { "username", "customer_id" }),
                @UniqueConstraint(columnNames =
                        { "email", "customer_id" })})
public class User extends BaseEntity implements Serializable {

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @ManyToOne
    private Customer customer;

}
