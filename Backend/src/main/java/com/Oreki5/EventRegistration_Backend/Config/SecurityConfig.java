package com.Oreki5.EventRegistration_Backend.Config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Autowired
    private JwtAuthConfig jwtAuthConfig;
    // Creating our own Security Filter Chain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(e -> e.disable())
                .authorizeHttpRequests(request -> {
                    request.requestMatchers("/", "/auth/login", "/auth/register").permitAll();
                    request.requestMatchers("/registrations/**", "/events/**").hasAnyRole("USER", "ADMIN");
                    request.requestMatchers("/admin/**").hasRole("ADMIN");
                    request.anyRequest().authenticated();
                })
                .formLogin(form -> form.disable())
                .httpBasic(Customizer.withDefaults())
                .addFilterBefore(jwtAuthConfig, UsernamePasswordAuthenticationFilter.class) //we added this filter before usernamePasswordAuthFilter because if we hava token, it doesnt need to go with Authenticate again
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // http.cors((Customizer.withDefaults()));

        return http.build();
    }

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    // using our own password encoder

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    // using our custom authentication provider because we use a BCryptEncoder for
    // password
    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(customUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    // Setting up CORS config to use the api endpoints from other origins
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration;
        configuration = new CorsConfiguration();

        
        configuration.setAllowedOrigins(Arrays.asList("")); // List of origins will go here
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "PUT", "DELETE"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

}
