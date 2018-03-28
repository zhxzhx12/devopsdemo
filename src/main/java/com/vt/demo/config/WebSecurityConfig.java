package com.vt.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.vt.demo.service.CustomUserService;
import com.vt.demo.service.CustomUsernamePasswordAuthenticationFilter;
import com.vt.demo.service.PermissionFilterSecurityInterceptor;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private PermissionFilterSecurityInterceptor filterSecurityInterceptor;
	
	private CustomUsernamePasswordAuthenticationFilter customUsernamePasswordAuthenticationFilter;
	
	@Autowired
	private CustomUserService customUserService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
            .antMatchers("/", "/home").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .failureUrl("/login?error")
            .permitAll()
            .and()
        .logout()
            .permitAll();
		
		customUsernamePasswordAuthenticationFilter = new CustomUsernamePasswordAuthenticationFilter();
		customUsernamePasswordAuthenticationFilter.setAuthenticationManager(this.authenticationManager());
		
//		http.addFilterBefore(customUsernamePasswordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//		.addFilterBefore(filterSecurityInterceptor, FilterSecurityInterceptor.class)
		http.addFilterBefore(filterSecurityInterceptor, FilterSecurityInterceptor.class)
         .csrf().disable();
	}
	
    @SuppressWarnings("deprecation")
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService).passwordEncoder(NoOpPasswordEncoder.getInstance());

    }

//	@Override
//	protected UserDetailsService userDetailsService() {
//		
//		return new CustomUserService();
//	}
//	
	

}
