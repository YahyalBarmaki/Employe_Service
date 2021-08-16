package com.employe_service.demo.security;

import com.employe_service.demo.entities.AppUser;
import com.employe_service.demo.filter.CustomAuthenticationFilter;
import com.employe_service.demo.metier.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AccountService accountService;
    private UserDetailsService userDetailsService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
            /*@Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                AppUser appUser = (AppUser) accountService.loadUserByUsername(username);
                Collection<GrantedAuthority> authorities = new ArrayList<>();
                appUser.getAppRoles().forEach(r->{
                    authorities.add(new SimpleGrantedAuthority(r.getNameRole()));
                });
                return new User(appUser.getUsername(),appUser.getPassword(),authorities);
            }*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
       // http.headers().frameOptions().disable();
       // http.formLogin();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().anyRequest().permitAll();
        http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean()));
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}   
