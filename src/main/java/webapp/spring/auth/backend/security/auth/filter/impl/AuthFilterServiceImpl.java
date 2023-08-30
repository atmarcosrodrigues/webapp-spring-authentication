package webapp.spring.auth.backend.security.auth.filter.impl;

import webapp.spring.auth.backend.security.auth.filter.AuthFilterService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthFilterServiceImpl implements AuthFilterService {

    @Value("${web.app.admin-customer.code}")
    private Long adminCode;

    @Override
    public boolean preAuthorizeFilter(Long customerCode) {
        return customerCode == adminCode;
    }
}
