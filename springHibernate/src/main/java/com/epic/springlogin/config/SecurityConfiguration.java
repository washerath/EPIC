package com.epic.springlogin.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	CustomSuccessHandler customSuccessHandler;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username,password, enabled from users where username=?")
				.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
		/*
		 * auth.inMemoryAuthentication().withUser("bill").password("abc123").
		 * roles("USER");
		 * auth.inMemoryAuthentication().withUser("admin").password("root123").
		 * roles("ADMIN");
		 * auth.inMemoryAuthentication().withUser("dba").password("root123").
		 * roles("ADMIN","DBA");
		 */
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/", "/home").permitAll().antMatchers("/admin/**")
				.access("hasRole('ROLE_ADMIN')").antMatchers("/db/**")
				.access("hasRole('ROLE_ADMIN') or hasRole('DBA')").and().formLogin().loginPage("/login").successHandler(customSuccessHandler)
				.usernameParameter("ssoId").passwordParameter("password").and().csrf().and().exceptionHandling()
				.accessDeniedPage("/Access_Denied");
	}
}
