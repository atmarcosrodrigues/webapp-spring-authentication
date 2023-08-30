package webapp.spring.auth.backend.security.auth.signup;

import webapp.spring.auth.backend.security.auth.AuthMessageResponse;
import org.springframework.http.ResponseEntity;

public interface AuthSignUpService {

    ResponseEntity<AuthMessageResponse> registerUser(AuthSignupRequest signUpRequest, boolean isAdmin);
}
