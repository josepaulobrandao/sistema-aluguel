package io.com.josepaulo.config;


import io.com.josepaulo.Security.JWTAuthenticatorFilter;
import io.com.josepaulo.Security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {   

    @Autowired
    private Environment environment;


    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;
    private org.springframework.security.authentication.AuthenticationManager AuthenticationManager;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception {

        if(Arrays.asList(environment.getActiveProfiles()).contains("test")){
            http
                    .headers()
                    .frameOptions()
                    .disable();

        }

        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/h2-console/**")
                .permitAll()

                    .antMatchers(HttpMethod.DELETE)
                .authenticated()
                    .antMatchers(HttpMethod.PUT)
                .authenticated().
                    antMatchers(HttpMethod.GET)
                .authenticated()
                    .antMatchers(HttpMethod.POST)
                .authenticated()
                    .antMatchers(HttpMethod.OPTIONS)

                .anonymous()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .formLogin().disable()
                .addFilter(new JWTAuthenticatorFilter(AuthenticationManager, jwtUtil))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);



        return http.build();


    }



    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

}
