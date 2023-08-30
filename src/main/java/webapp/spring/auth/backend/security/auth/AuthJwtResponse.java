package webapp.spring.auth.backend.security.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


public record AuthJwtResponse(@JsonProperty("accessToken")
                              @NotNull String accessToken,
                              @JsonProperty("tokenType")
                              @NotNull String tokenType,
                              @JsonProperty("expiresIn")
                              @NotNull int expiresIn)
        implements Serializable {

}