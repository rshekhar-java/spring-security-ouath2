package com.rs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;


/**
 * created by rs 4/7/2022.
 */
@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * /myAccount - Secured
     * /myBalance - Secured
     * /myLoans - Secured
     * /myCards - Secured
     * /notices - Not Secured
     * /contact - Not Secured
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());

        http.cors().configurationSource(new CorsConfigurationSource() {
                @Override
                public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                    config.setAllowedMethods(Collections.singletonList("*"));
                    config.setAllowCredentials(true);
                    config.setAllowedHeaders(Collections.singletonList("*"));
                    config.setMaxAge(3600L);
                    return config;
                }
            }).and()
                    .authorizeRequests()
                    .antMatchers("/myAccount").hasRole("USER")
                    .antMatchers("/myBalance").hasAnyRole("ADMIN")
                    .antMatchers("/myLoans").authenticated()
                    .antMatchers("/myCards").hasAnyRole("USER","ADMIN")
//                    .antMatchers("/myCards").authenticated()
                    .antMatchers("/notices").permitAll()
                    .antMatchers("/contact").permitAll()
                    .and()
                    .csrf().disable()
                    .oauth2ResourceServer()
                    .jwt().jwtAuthenticationConverter(jwtAuthenticationConverter);

        /**
         * This configuration is needed to view the /h2-console with out any issues.
         * Since H2 Console uses frames to display the UI, we need to allow the frames.
         * Otherwise since by default Spring Security consider X-Frame-Options: DENY
         * to avoid Clickjacking attacks, the /h2-console will not work properly.
         * More details can be found at
         * https://docs.spring.io/spring-security/site/docs/5.0.x/reference/html/headers.html#headers-frame-options
         */
        http.headers().frameOptions().sameOrigin();

    }
}
