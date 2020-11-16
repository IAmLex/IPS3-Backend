package com.lex.ips3backend.configs;

import com.lex.ips3backend.services.JwtTokenService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    final private JwtTokenService _jwtTokenService;

    public JwtRequestFilter (JwtTokenService jwtTokenService) {
        this._jwtTokenService = jwtTokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
    throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        System.out.print(String.format("%s %s ", request.getMethod(), request.getRequestURL()));
        System.out.println(token);

        if (token != null && !request.getRequestURL().toString().contains("api/authentication/login")) {
            this._jwtTokenService.validateToken(token);
        }

        chain.doFilter(request, response);
    }
}
