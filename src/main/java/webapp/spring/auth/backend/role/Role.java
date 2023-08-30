package webapp.spring.auth.backend.role;

import webapp.spring.auth.backend.entity.BaseEntity;
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
@Table(name = "role")
public class Role extends BaseEntity implements Serializable {

    @Column(name = "name", nullable = false)
    private String name;

}
