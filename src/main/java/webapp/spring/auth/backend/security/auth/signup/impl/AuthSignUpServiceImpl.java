package webapp.spring.auth.backend.security.auth.signup.impl;

import io.netty.util.SuppressForbidden;
import webapp.spring.auth.backend.customer.Customer;
import webapp.spring.auth.backend.customer.CustomerRepository;
import webapp.spring.auth.backend.enums.RoleEnum;
import webapp.spring.auth.backend.role.Role;
import webapp.spring.auth.backend.role.RoleRepository;
import webapp.spring.auth.backend.security.auth.signup.AuthSignUpService;
import webapp.spring.auth.backend.security.auth.signup.AuthSignupRequest;
import webapp.spring.auth.backend.security.auth.AuthMessageResponse;
import webapp.spring.auth.backend.user.User;
import webapp.spring.auth.backend.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthSignUpServiceImpl implements AuthSignUpService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder encoder;

    @Value("${web.app.admin-customer.code}")
    private Long adminCode;

    @Override
    public ResponseEntity<AuthMessageResponse> registerUser(AuthSignupRequest signUpRequest, boolean isAdmin) {

        List<Customer> customers = customerRepository.findByCode(signUpRequest.customerCode());
        if (customers.size() == 0) {
            return ResponseEntity
                    .badRequest()
                    .body(new AuthMessageResponse("Error: Customer not found!"));
        }

        if (userRepository.existsByUsername(signUpRequest.username(), customers.get(0).getId())) {
            return ResponseEntity
                    .badRequest()
                    .body(new AuthMessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.email(), customers.get(0).getId())) {
            return ResponseEntity
                    .badRequest()
                    .body(new AuthMessageResponse("Error: Email is already in use!"));
        }

        if (!isAdmin && signUpRequest.customerCode() == adminCode)
            return ResponseEntity
                    .badRequest()
                    .body(new AuthMessageResponse("Error: You are not allowed to register users for this customer!"));


        User user = new User(signUpRequest.username(),
                signUpRequest.email(),
                encoder.encode(signUpRequest.password()),
                new HashSet<>(),
                customers.get(0)
                );

        Set<String> strRoles = signUpRequest.role();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER.name())
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        if (isAdmin) {
                            Role adminRole = roleRepository.findByName(RoleEnum.ROLE_ADMIN.name())
                                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                            roles.add(adminRole);
                            break;
                        }
                        else {
                            throw new RuntimeException(String.format("You are not allowed to create users with admin privileges", role));
                        }
                    case "user":
                        Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER.name())
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(RoleEnum.ROLE_MODERATOR.name())
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        throw new RuntimeException(String.format("Error: Role [%s] is not found.", role));
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new AuthMessageResponse("User registered successfully!"));
    }
}
