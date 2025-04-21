package edu.miu.cs.cs489.lesson6.dentistapp.security;


import org.springframework.stereotype.Component;

@Component
public class TokenManagerService extends TokenManager {

    public TokenManagerService() {
        super();
    }

    public TokenManagerService(String SECRET_KEY, Long EXPIRATION_HOUR) {
        super(SECRET_KEY, EXPIRATION_HOUR);
    }

}
