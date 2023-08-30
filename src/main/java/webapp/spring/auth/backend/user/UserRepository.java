package webapp.spring.auth.backend.user;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query("select case when count(u)> 0 then true else false end from User u where u.username =:username and u.customer.id =:customerId")
    Boolean existsByUsername(String username, UUID customerId);

    @Query("select case when count(u)> 0 then true else false end from User u where u.email =:email and u.customer.id =:customerId")
    Boolean existsByEmail(String email, UUID customerId);
}