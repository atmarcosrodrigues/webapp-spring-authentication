package webapp.spring.auth.backend.security.auth.signin;

import webapp.spring.auth.backend.security.auth.AuthJwtResponse;
import org.springframework.http.ResponseEntity;

public interface AuthSignInService {

    ResponseEntity<AuthJwtResponse> authenticateUser(AuthSignInRequest loginRequest);

    boolean filter(Long customerCode);
}
