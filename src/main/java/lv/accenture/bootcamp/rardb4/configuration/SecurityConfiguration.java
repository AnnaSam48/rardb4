package lv.accenture.bootcamp.rardb4.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfiguration implements WebMvcConfigurer {
    PasswordEncoder passwordEncoders =
            PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    public DelegatingPasswordEncoder passwordEncoder(){return (DelegatingPasswordEncoder) passwordEncoders;}
}