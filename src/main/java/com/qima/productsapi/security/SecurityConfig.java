package com.qima.productsapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/v3/api-docs/**",
                    "/v3/api-docs.yaml",
                    "/api/**",
                    "/view/**"
                ).permitAll()
                .requestMatchers("/products").hasAnyRole("SUPERUSER", "USER")
                .requestMatchers("/admin/**").hasRole("SUPERADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .permitAll()
            )
            .logout(LogoutConfigurer::permitAll);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        var superAdmin = org.springframework.security.core.userdetails.User
            .withUsername("superadmin")
            .password(passwordEncoder.encode("superpassword"))
            .roles("SUPERADMIN")
            .build();

        var regularUser = org.springframework.security.core.userdetails.User
            .withUsername("user")
            .password(passwordEncoder.encode("userpassword"))
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(superAdmin, regularUser);
    }
}
