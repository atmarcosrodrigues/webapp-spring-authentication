package webapp.spring.auth.backend.security.auth.filter;

import org.springframework.beans.factory.annotation.Autowired;

public class AuthFilterController {

    @Autowired
    AuthFilterService authFilterService;
    public boolean preAuthorizeFilter(Long customerCode) {
        return authFilterService.preAuthorizeFilter(customerCode);
    }
}
