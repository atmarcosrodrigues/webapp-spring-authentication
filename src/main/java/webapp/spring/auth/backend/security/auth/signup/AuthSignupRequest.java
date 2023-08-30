package webapp.spring.auth.backend.security.auth.signup;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;


public record AuthSignupRequest(@JsonProperty("username")
                                @Size(min = 3, max = 20)
                                @NotNull String username,
                                @JsonProperty("email")
                                @Size(max = 50)
                                @Email
                                @NotNull String email,
                                @JsonProperty("password")
                                @NotNull String password,
                                @JsonProperty("role")
                                @NotNull Set<String> role,
                                @JsonProperty("customerCode")
                                Long customerCode) implements Serializable {

}