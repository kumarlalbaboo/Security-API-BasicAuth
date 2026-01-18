package com.llb.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyAppSecurityConfig {

    @Bean
    public SecurityFilterChain securityChain(HttpSecurity http)  {

        http.authorizeHttpRequests(req -> req
                .requestMatchers("/contact", "/aboutus").permitAll()
                .anyRequest().authenticated()
        ).httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUsers() {
        UserDetails u1 = User.withDefaultPasswordEncoder()
                .username("abhimanyu")
                .password("abhimanyu@11")
                .build();

        UserDetails u2 = User.withDefaultPasswordEncoder()
                .username("pritam")
                .password("pritam@11")
                .build();

        UserDetails u3 = User.withDefaultPasswordEncoder()
                .username("bharti")
                .password("bharti@11")
                .build();

        return new InMemoryUserDetailsManager(u1, u2, u3);
    }

}
