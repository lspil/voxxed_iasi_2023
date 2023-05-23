package com.example.vdi_e3_rs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    http.oauth2ResourceServer(
//        c -> c.opaqueToken(
//            x -> x.introspectionUri("http://localhost:8080/oauth2/introspect")
//                .introspectionClientCredentials("client", "secret")
//        )
//    );

    http.oauth2ResourceServer(
        c -> c.jwt(
            x -> x.jwkSetUri("http://localhost:8080/oauth2/jwks")
        )
    );

//    http.oauth2ResourceServer(
//        c -> c.authenticationManagerResolver()
//    );

    http.authorizeHttpRequests(c -> c.anyRequest().authenticated());

    return http.build();
  }
}
