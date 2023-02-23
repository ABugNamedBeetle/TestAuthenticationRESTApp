package com.abnb.TestAuthenticationRESTApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
   

    //@Autowired
   // CustomAuthenticationFilter customAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .csrf()
        .disable()
        .authorizeHttpRequests()
        .requestMatchers("/noproc")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        .and()        
        .addFilterBefore(
            new CustomAuthenticationFilter(
                authenticationManager(
                    http.getSharedObject(AuthenticationConfiguration.class))
                ), AnonymousAuthenticationFilter.class);
        //.addFilterAt(graphAuthenticationFilter, AnonymousAuthenticationFilter.class);

    return http.build();
  }

    // @Bean
    // public AuthenticationProvider customAuthenticationProvider() {
    //     return new CustomAuthenticationProvider();
    // }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        //authenticationConfiguration.authenticationManagerBuilder(null, null)
        return authenticationConfiguration.getAuthenticationManager();
    }

    // @Bean
    // public AuthenticationManager authManager(HttpSecurity http) throws Exception {
    //     AuthenticationManagerBuilder authenticationManagerBuilder = 
    //         http.getSharedObject(AuthenticationManagerBuilder.class);
    //     authenticationManagerBuilder.authenticationProvider(authProvider);
    //     return authenticationManagerBuilder.build();
    // }
}
