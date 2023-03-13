package io.com.josepaulo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {   

    @Autowired
    private Environment environment;
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
                .formLogin()
                .disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();


    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

}
