package webapp.spring.auth.backend.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    protected UUID id;

    @Column(name = "createdAt", nullable = false, updatable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @NotNull
    @Setter(AccessLevel.PROTECTED)
    protected Timestamp createdAt;

    @Column(name = "updatedAt", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @NotNull
    @Setter(AccessLevel.PROTECTED)
    protected Timestamp updatedAt;

    @Column(name = "deletedAt", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    protected Timestamp deletedAt;

    @PrePersist
    public void onCreate() {
        createdAt = updatedAt = Timestamp.from(Instant.now());
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = Timestamp.from(Instant.now());
    }
}
