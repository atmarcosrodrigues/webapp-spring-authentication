package webapp.spring.auth.backend.security.auth;


import webapp.spring.auth.backend.security.auth.filter.AuthFilterController;
import webapp.spring.auth.backend.security.auth.signin.AuthSignInService;
import webapp.spring.auth.backend.security.auth.signup.AuthSignUpService;
import webapp.spring.auth.backend.security.auth.signin.AuthSignInRequest;
import webapp.spring.auth.backend.security.auth.signup.AuthSignupRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Tag(name = "AuthorizationApi", description = "Signup and signin in Web Application")
@RestController
@RequestMapping("/api/auth")
public class AuthController extends AuthFilterController {

    @Autowired
    AuthSignUpService authSignUpService;

    @Autowired
    AuthSignInService authSignInService;

    @Operation(summary = "SignIn (Public method)", description = "Log in to the application with a previously registered user (public method)")
    @PostMapping("/signin")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = AuthSignInRequest.class),
            examples = {@ExampleObject(name = "Admin User", description = AuthLoginExamples.ADMIN_USER_DESCRIPTION, value = AuthLoginExamples.ADMIN_USER_CREDENTIALS),
                    @ExampleObject(name = "Client User", description = AuthLoginExamples.CLIENT_USER_DESCRIPTION, value = AuthLoginExamples.CLIENT_USER_CREDENTIALS)
            }))
    public ResponseEntity<AuthJwtResponse> authenticateUser(@Valid @RequestBody AuthSignInRequest loginRequest) {
        return authSignInService.authenticateUser(loginRequest);
    }

    @Operation(summary = "SignUp (Public method)", description = "Register a new user in the application (public method)")
    @PostMapping("/signup")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = AuthSignupRequest.class),
            examples = {@ExampleObject(name = "User Signup", description = AuthLoginExamples.USER_SIGNUP_DESCRIPTION, value = AuthLoginExamples.USER_SIGNUP_CREDENTIALS)
            }))
    public ResponseEntity<?> registerUser(@Valid @RequestBody AuthSignupRequest signUpRequest) {
        return authSignUpService.registerUser(signUpRequest, false);
    }

    @Operation(summary = "SignUp Admin (Need authentication)", description = "Register a new user with administrator privileges in the application (you need to be previously logged in with a user that has administrator privileges)",
            security = {
                    @SecurityRequirement(name = "Bearer")})
    @PostMapping("/signup/admin")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = AuthSignupRequest.class),
            examples = {@ExampleObject(name = "User Signup", description = AuthLoginExamples.USER_SIGNUP_ADMIN_DESCRIPTION, value = AuthLoginExamples.USER_SIGNUP_ADMIN_CREDENTIALS)
            }))
    @PreAuthorize("hasRole('ADMIN') and #this.this.preAuthorizeFilter(principal.getCustomerCode)")
    public ResponseEntity<?> registerUserAdmin(@Valid @RequestBody AuthSignupRequest signUpRequest) {
        return authSignUpService.registerUser(signUpRequest, true);
    }

}