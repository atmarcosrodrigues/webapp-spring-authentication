package webapp.spring.auth.backend.security.auth.signin;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


public record AuthSignInRequest(@JsonProperty("username")
                              @NotNull String username,
                                @JsonProperty("password")
                              @NotNull String password) implements Serializable {

}