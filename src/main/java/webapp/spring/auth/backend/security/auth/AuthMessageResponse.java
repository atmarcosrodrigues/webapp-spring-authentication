package webapp.spring.auth.backend.security.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


public record AuthMessageResponse(@JsonProperty("message")
                                  @NotNull String message
) implements Serializable {

}