package com.abnb.TestAuthenticationRESTApp.security;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

/**
 * CustomAuthenticationToken
 */
@Component

public class CustomAuthenticationToken implements Authentication{
    
    private String username;
    //private String password;
    private boolean isAuthenticated = false;
     public CustomAuthenticationToken() {
       
     }
 
    public CustomAuthenticationToken(String username) {
        this.username = username;
       // this.password = password;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
       return this.username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
    }

    @Override
    public Object getCredentials() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCredentials'");
    }

    @Override
    public Object getDetails() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDetails'");
    }

    @Override
    public Object getPrincipal() {
        // TODO Auto-generated method stub
        return this.username;
       // throw new UnsupportedOperationException("Unimplemented method 'getPrinciple'");
    }

    @Override
    public boolean isAuthenticated() {
        // TODO Auto-generated method stub
        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        this.isAuthenticated = isAuthenticated;
    }
    
}