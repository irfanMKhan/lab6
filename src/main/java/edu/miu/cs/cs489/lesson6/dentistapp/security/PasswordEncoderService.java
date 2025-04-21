package edu.miu.cs.cs489.lesson6.dentistapp.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderService extends ApplicationPasswordEncoder implements PasswordEncoder {

    public PasswordEncoderService() {
        super();
    }

    public PasswordEncoderService(EncodeAlgorithm algorithm) {
        super(algorithm);
    }

}
