package webapp.spring.auth.backend.security.auth.filter;

public interface AuthFilterService {

    boolean preAuthorizeFilter(Long customerCode);
}
