package com.abnb.TestAuthenticationRESTApp.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        //String password = authentication.getCredentials().toString();
 
        // perform custom authentication logic here
        // ...
        System.out.println("[CUSTOM authentication provider ] "+username);
        CustomAuthenticationToken cToken = new CustomAuthenticationToken(username);;
        if(username.equals("YTph")){

             
             cToken.setAuthenticated(true);
        }
        return cToken;
        
        
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // TODO Auto-generated method stub
        return authentication.equals(CustomAuthenticationToken.class);
    }
    
}
