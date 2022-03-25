package com.example.demo.configurations;

import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccountService accountService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable();

        http.authorizeRequests()
            .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
            .antMatchers("/saleman/**").access("hasRole('ROLE_SALE_MAN')")
            .antMatchers("/client/**").access("hasRole('ROLE_CLIENT')")
            .and()
            .formLogin().loginPage("/home")
            .loginProcessingUrl("/account/process-login")
            .defaultSuccessUrl("/account/welcome")
            .failureUrl("/account/login?error")
            .usernameParameter("username")
            .passwordParameter("pass")
            .and()
            .logout().logoutUrl("/account/logout")
            .logoutSuccessUrl("/home?logout")
            ;
    }

    @Autowired
    public void configGlobal(AuthenticationManagerBuilder builder) throws Exception {

        builder.userDetailsService(accountService);

    }
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
