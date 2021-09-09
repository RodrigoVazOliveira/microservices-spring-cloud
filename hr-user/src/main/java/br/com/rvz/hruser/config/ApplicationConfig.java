package br.com.rvz.hruser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ApplicationConfig {

    @Bean
    public BCryptPasswordEncoder buildBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}