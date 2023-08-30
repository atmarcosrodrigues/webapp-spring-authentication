package webapp.spring.auth.backend.security.auth;

public class AuthLoginExamples {

    public static final String ADMIN_USER_DESCRIPTION = "Valid Admin User";
    public static final String ADMIN_USER_CREDENTIALS = """
            {
              "username": "admin",
              "password": "34rh9977sdfc#"
            }
                """;
    public static final String CLIENT_USER_DESCRIPTION = "Valid Client User";
    public static final String CLIENT_USER_CREDENTIALS = """
            {
              "username": "client01",
              "password": "z8#2Ra8714Ldc"
            }
                """;

    public static final String USER_SIGNUP_DESCRIPTION = """
    Valid User Signup. 
    
    Example of valid roles:
      - \"user\" (Role with basic client privileges), 
      - \"mod\" (Role with moderator privileges),       
      
    Valid values to customerCode:
      - 1 (Customer 01), 
      - 2 (Customer 02)
      
      To get all available customers request: /api/customers 
    """;
    public static final String USER_SIGNUP_CREDENTIALS = """
            {
              "username": "mariana_silva",
              "email": "mariana_silva@gmail.com",
              "password": "abc123#pswd",
              "customerCode": 1,
              "role": [
                "mod", "user"
              ]
            }
                """;

    public static final String USER_SIGNUP_ADMIN_DESCRIPTION = """
    Valid User Signup. 
    
    Example of valid roles: 
       - \"user\" (Role with basic client privileges), 
       - \"mod\" (Role with moderator privileges), 
       - \"admin\" (Role with administrator privileges).
    
    
    Valid values to customerCode:
      - 0 (Administration),
      - 1 (Customer 01),
      - 2 (Customer 02)
      
      To get all available customers request: /api/customers 
    """;
    public static final String USER_SIGNUP_ADMIN_CREDENTIALS = """
            {
              "username": "daniela_silva",
              "email": "daniela_silva@gmail.com",
              "password": "abc123#pswd",
              "customerCode": 0,
              "role": [
                "admin", "mod", "user"
              ]
            }
                """;
}
