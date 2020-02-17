package com.gongchuangsu.helloweb.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import SimpleAuthenticationSuccessHandler.SimpleAuthenticationSuccessHandler;




@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication()
	      .dataSource(dataSource)
	      .usersByUsernameQuery("select employeeId, password, enabled "
	        + "from users "
	        + "where employeeId = ?")
	      .authoritiesByUsernameQuery("select employeeId as username, admin_position as role "
	        + "from users "
	        + "where employeeId=?");
	}	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
				.antMatchers("/static/**", "/register", "/", "/reset_password", "/handle_resetpassword", "/api/**").permitAll()
				.antMatchers("/sessions", "/trainee", "/detail/**", "/archives").hasAnyRole("ADMIN","admin","superadmin","super_admin")
				.antMatchers("/admin", "/add_admin").hasRole("super_admin")
				.anyRequest().authenticated()
				.and()	
			.formLogin().usernameParameter("employeeId")           
			.passwordParameter("password").loginPage("/login").loginProcessingUrl("/process_login_custom").failureUrl("/login?error=true").successHandler(new SimpleAuthenticationSuccessHandler())
			//defaultSuccessUrl("/admin", true)
			.permitAll().and()
			.logout()                                    
			.logoutSuccessUrl("/login")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID")
			.and()
			.exceptionHandling().accessDeniedPage("/login?access=denied")
			.and().csrf().disable(); 
	}
	
	
}