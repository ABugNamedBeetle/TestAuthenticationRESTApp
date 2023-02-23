package com.abnb.TestAuthenticationRESTApp.security;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter {


    AuthenticationManager authenticationManager;
  
    public CustomAuthenticationFilter(AuthenticationManager authManager){
        this.authenticationManager = authManager;
   } 
        

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        System.out.println("[CUSTOM authentication filter]");
        String encodedCreds = request.getHeader("Authorization").toString().substring(6);
        

        System.out.println("<"+encodedCreds+">");
       

        Authentication authentication = authenticationManager.authenticate(new CustomAuthenticationToken(encodedCreds));
       
        SecurityContextHolder.getContext().setAuthentication(authentication);


        filterChain.doFilter(request, response);
    }
}
