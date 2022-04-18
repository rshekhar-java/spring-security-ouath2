package com.rs.config;

import com.rs.filter.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,  jsr250Enabled = true)
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
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors().configurationSource(new CorsConfigurationSource() {
                @Override
                public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                    config.setAllowedMethods(Collections.singletonList("*"));
                    config.setAllowCredentials(true);
                    config.setAllowedHeaders(Collections.singletonList("*"));
                    config.setExposedHeaders(Arrays.asList("Authorization"));
                    config.setMaxAge(3600L);
                    return config;
                }
            }).and()
                    .csrf().disable()
                    .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
                    .addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
                    .addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class)
                    .addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
                    .addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class)
    //                .and()
                    .authorizeRequests()
                    .antMatchers("/myAccount").hasRole("USER")
                    .antMatchers("/myBalance").hasAnyRole("USER","ADMIN")
                    .antMatchers("/myLoans").authenticated()
                    .antMatchers("/myCards").authenticated()
                    .antMatchers("/user").authenticated()
                    .antMatchers("/notices").permitAll()
                    .antMatchers("/contact").permitAll()
    //                .and()
    //                .formLogin()
                    .and()
                    .httpBasic();


    }

/*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
*/
//        super.configure(http);
        /**
         * Default configurations which will secure all the requests
         */

        /*
         * http .authorizeRequests()
         *      .anyRequest()
         *      .authenticated()
         *      .and()
         *      .formLogin()
         *      .and()
         *      .httpBasic();
         */

        /**
         * Custom configurations as per our requirement
         */


//        http .authorizeRequests()
//                .antMatchers("/myAccount").authenticated()
//                .antMatchers("/myBalance").authenticated()
//                .antMatchers("/myLoans").authenticated()
//                .antMatchers("/myCards").authenticated()
//                .antMatchers("/notices").permitAll()
//                .antMatchers("/contact").permitAll()
//                .and()
//                .formLogin()
//                .and()
//                .httpBasic();

        /**
         * Configuration to deny all the requests
         */

        /*
         * http .authorizeRequests() .anyRequest().denyAll() .and() .formLogin().and()
         * .httpBasic();
         */

        /**
         * Configuration to permit all the requests
         */
/*        http
                .authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic();*/

//    }

/*
    //in memory Authentication using AuthenticationManager Builder

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth .inMemoryAuthentication()
                .withUser("admin")
                .password("admin")
                .authorities("admin")
                .and()
                .withUser("user")
                .password("password")
                .authorities("read")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

*/

/*    //	Configuring user using inMemoryUserDetailsManager
      @Override
      protected void configure(AuthenticationManagerBuilder auth) throws Exception {
          InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
          UserDetails user = User.withUsername("admin").password("admin").authorities("admin").build();
          UserDetails user1 = User.withUsername("user").password("password").authorities("read").build();
          userDetailsService.createUser(user);
          userDetailsService.createUser(user1);
          auth.userDetailsService(userDetailsService);
      }*/

//for jdbc only
/*
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
      return new JdbcUserDetailsManager(dataSource);
      }
*/

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }



}
