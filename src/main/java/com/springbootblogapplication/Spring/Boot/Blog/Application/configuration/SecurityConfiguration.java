package com.springbootblogapplication.Spring.Boot.Blog.Application.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
//    @Autowired
//    private LoginServiceImpl loginService;
//    @Autowired
//    private JwtFilter jwtFilter;
//    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for Swagger testing
                .authorizeHttpRequests(auth -> auth
                        // ✅ Allow Swagger & OpenAPI endpoints
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html"
                        ).permitAll()
                     // ✅ Allow Login API publicly
                    .requestMatchers("/user").permitAll()
                        // ✅ Secure all other endpoints
                        .anyRequest().authenticated()
                )
                // ✅ Use new DSL syntax for HTTP Basic
                .httpBasic(Customizer.withDefaults())
        // Optional: if you use login form
        // .formLogin(Customizer.withDefaults())
        ;
        return http.build();
    }
}
