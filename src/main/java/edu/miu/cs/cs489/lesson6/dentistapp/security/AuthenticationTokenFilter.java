package edu.miu.cs.cs489.lesson6.dentistapp.security;


import edu.miu.cs.cs489.lesson6.dentistapp.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationConverter;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Collections;

public class AuthenticationTokenFilter extends AuthenticationFilter {
    private static final String dateTimeFormatter = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    private final UserService userService;
    private final TokenManagerService tokenManager;

    public AuthenticationTokenFilter(UserService userService, TokenManagerService tokenManager) {
        super(
                new ProviderManager(Collections.singletonList(new DaoAuthenticationProvider())),
                new BasicAuthenticationConverter()
        );
        this.userService = userService;
        this.tokenManager = tokenManager;
    }


    private String getToken(HttpServletRequest httpServletRequest) {
        String requestHeader = httpServletRequest.getHeader("Authorization");

        if (StringUtils.hasText(requestHeader) && requestHeader.startsWith("Bearer")) {
            return requestHeader.substring(7);
        }

        throw new RuntimeException("Token is missing from the request header.");
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        String URI = request.getRequestURI();
        String HOST_IP = request.getRemoteAddr();

        final String authHeader = request.getHeader("Authorization");
        String username = null;
        String jwt = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            jwt = authHeader.substring(7);
            username = tokenManager.getUsername(jwt);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userService.loadUserByUsername(username);
            if (tokenManager.validateToken(jwt).getStatus()) {
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        chain.doFilter(request, response);
    }

}
