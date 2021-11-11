package acc.projman.security;

import javax.persistence.Basic;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity 
public class SecurityJdbcConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		//Tables Created by SpringSecurity
		/*
		auth.jdbcAuthentication().dataSource(dataSource)
			.withDefaultSchema()	//Create at the DB some tables to support Authentication/Authorization
			.withUser("manaseses")
				.password("wiener")
				.roles("USER")
			.and()
			.withUser("mijotron")
				.password("moustache")
				.roles("USER")
			.and()
			.withUser("babas")
				.password("german")
				.roles("ADMIN");
		*/
	
		//Tables Created For the DB
		auth.jdbcAuthentication().dataSource(dataSource)
			//Authentication
			.usersByUsernameQuery("select username, password, enabled from user_accounts where username = ?")
			.authoritiesByUsernameQuery("select username, role from user_accounts where username=?")
			.passwordEncoder(bCryptEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity hs) throws Exception {
		hs.authorizeRequests()
			.antMatchers("/projects/new").hasRole("ADMIN")	//to not havae ROLE_ADMIN, use hasAuthority("ADMIN"), instead of hasRole()
			.antMatchers("/employees/new").hasRole("ADMIN")
			.antMatchers("/projects/save").hasRole("ADMIN")
			.antMatchers("/employees/save").hasRole("ADMIN")
			.antMatchers("/","/**").permitAll()
			.and()
			.formLogin(); 				//Define that a Login with forms is required
			//.loginPage("/login-page");	//Define the default URL for en Login Page
		
		//JUST FOR TEST WITH H2 DATABASE
			//hs.csrf().disable();
			//hs.headers().frameOptions().disable();
	}		
}


