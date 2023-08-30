package webapp.spring.auth.backend.security.auth.signin.impl;

import webapp.spring.auth.backend.security.auth.signin.AuthSignInService;
import webapp.spring.auth.backend.security.auth.signin.AuthSignInRequest;
import webapp.spring.auth.backend.security.auth.AuthJwtResponse;
import webapp.spring.auth.backend.user.impl.UserDetailsImpl;
import webapp.spring.auth.backend.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthSignInServiceImpl implements AuthSignInService {

    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    JwtUtils jwtUtils;

    @Override
    public ResponseEntity<AuthJwtResponse> authenticateUser(AuthSignInRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new AuthJwtResponse(jwt,
                jwtUtils.getTokenType(),
                jwtUtils.getExpirationMS()));
    }

    @Override
    public boolean filter(Long customerCode) {
        return customerCode == 0;
    }
}
