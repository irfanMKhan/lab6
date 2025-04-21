package edu.miu.cs.cs489.lesson6.dentistapp.security;


import edu.miu.cs.cs489.lesson6.dentistapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenManagerService tokenManager;

    private static CorsConfiguration getCorsConfiguration() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "PUT", "OPTIONS", "PATCH", "DELETE"));
        corsConfiguration.setExposedHeaders(Collections.singletonList("Authorization"));
        corsConfiguration.setAllowedOriginPatterns(Collections.singletonList("*"));
        return corsConfiguration;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoderService();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationTokenFilter authenticationTokenFilter() {
        return new AuthenticationTokenFilter(userService, tokenManager);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(passwordEncoder());
        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

        CorsConfiguration corsConfiguration = getCorsConfiguration();

        http.csrf(AbstractHttpConfigurer::disable);
        http.formLogin(AbstractHttpConfigurer::disable);
        http.httpBasic(AbstractHttpConfigurer::disable);

        http.cors(cors -> cors.configurationSource(request -> corsConfiguration));


        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        http.authorizeHttpRequests(request -> request
                .requestMatchers("*").authenticated()
                .requestMatchers("*").permitAll()
                .anyRequest().permitAll());


        http.authenticationManager(authenticationManager);

        return http.build();
    }


}

