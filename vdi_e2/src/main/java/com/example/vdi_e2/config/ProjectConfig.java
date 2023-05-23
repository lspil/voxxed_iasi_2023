package com.example.vdi_e2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
//@EnableWebSecurity(debug = true)
@EnableMethodSecurity
// @EnableGlobalMethodSecurity(prePostEnable= true)
public class ProjectConfig {

  @Value("${cors.origins}")
  private String corsOrigins;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    // Authentication
    http.httpBasic(Customizer.withDefaults())
        .formLogin(Customizer.withDefaults());
//        .oauth2ResourceServer(Customizer.withDefaults());

    // Authorization

    http.authorizeHttpRequests(
        c -> c
            .requestMatchers(HttpMethod.POST, "/user").permitAll()
            .anyRequest().authenticated()

    );

    http.csrf(c -> c.ignoringRequestMatchers("/user"));

    http.cors(c -> c.configurationSource(
        r -> {
          CorsConfiguration configuration = new CorsConfiguration();
          configuration.setAllowedOrigins(List.of(corsOrigins));
          configuration.setAllowedMethods(List.of("*"));
          configuration.setAllowedHeaders(List.of("*"));
          return configuration;
        }
    ));

    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
