package com.theus.auth_api.infra.security;

import com.theus.auth_api.user.repositories.UserRepository;
import com.theus.auth_api.user.service.exceptions.TokenExpiratedException;
import com.theus.auth_api.user.service.exceptions.UsernameIncorrectException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.Instant;

@Component
@RequiredArgsConstructor
public class TokenFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recoveryToken(request);
        try {
            if (token != null) {
                var login = this.tokenService.validateToken(token);

                if (login.isEmpty()) {
                    throw new TokenExpiratedException("Access token has expired.");
                }

                UserDetails user = this.userRepository.findByUsername(login);

                if (user == null) {
                    throw new UsernameIncorrectException("User not found for the given token");
                }

                var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(request, response);
        } catch (TokenExpiratedException ex) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write(
                    String.format("{\"timestamp\": \"%s\", \"status\": %d, \"error\": \"Token expired\", \"message\": \"%s\", \"path\": \"%s\"}",
                            Instant.now(),
                            HttpServletResponse.SC_UNAUTHORIZED,
                            ex.getMessage(),
                            request.getRequestURI()
                    )
            );
        } catch (UsernameIncorrectException ex) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write(
                    String.format("{\"timestamp\": \"%s\", \"status\": %d, \"error\": \"Unauthorized\", \"message\": \"%s\", \"path\": \"%s\"}",
                            Instant.now(),
                            HttpServletResponse.SC_UNAUTHORIZED,
                            ex.getMessage(),
                            request.getRequestURI()
                    )
            );
        }
    }

    private String recoveryToken(HttpServletRequest request) {
        var tokenHeader = request.getHeader("Authorization");
        if (tokenHeader != null) {
            return tokenHeader.replace("Bearer ", "");
        } else {
            return null;
        }
    }
}
