package com.luv2code.springboot.cruddemo.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class demoSecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager userDetailsManager=new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setAuthoritiesByUsernameQuery("select user_id, pw, active from members where user_id=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
        return userDetailsManager;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer->
                configurer.
                        requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();
    }
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails saka= User.builder()
//                .username("saka")
//                .password("{noop}test123")
//                .roles("EMPLOYEE")
//                .build();
//        UserDetails Martin= User.builder().username("Martin")
//                .password("{noop}test123")
//                .roles("EMPLOYEE","MANAGER")
//                .build();
//        UserDetails David= User.builder().username("David")
//                .password("{noop}test123")
//                .roles("EMPLOYEE","MANAGER","ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(saka,Martin,David);
//    }
}
