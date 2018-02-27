package com.unireg.app;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import com.unireg.utils.Constants;

@Configuration
public class LoginConfig extends WebSecurityConfigurerAdapter {
	private static final Logger LOG = LoggerFactory.getLogger(LoginConfig.class);
	@Autowired
	private UserDetailsService uds;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		try{
			final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
			authProvider.setUserDetailsService(uds);
			authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
			auth.userDetailsService(uds).and().authenticationProvider(authProvider);
		} catch(Exception e){
			LOG.info("Exception: " + e);
		}
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		try{
			http.csrf()
					.disable()
					.exceptionHandling()
					.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint(Constants.LOGIN_ENDPOINT.getStr()))
					.and()
					.authorizeRequests()
					.antMatchers(Constants.VAADIN_SERVLET_ENDPOINT.getStr(), Constants.VAADIN_ENDPOINT.getStr(),
							Constants.PUSH_ENDPOINT.getStr(), Constants.UIDL_ENDPOINT.getStr(),
							Constants.LOGIN_ENDPOINT.getStr(), Constants.LOGIN_CHILDREN_ENDPOINT.getStr(),
							Constants.LOGOUT_ENDPOINT.getStr(), Constants.SIGNUP_ENDPOINT.getStr()).permitAll()
					.antMatchers(Constants.UI_ENDPOINT.getStr(), Constants.UI_CHILDREN_ENDPOINT.getStr())
					.fullyAuthenticated();
		} catch(Exception e){
			LOG.info("Exception: " + e);
		}
	}
	
	@Bean
	public DaoAuthenticationProvider createDaoAuthenticationProvider(){
		try{
			DaoAuthenticationProvider prov = new DaoAuthenticationProvider();
			prov.setUserDetailsService(uds);
			prov.setPasswordEncoder(passwordEncoder());
			return prov;
		} catch(Exception e){
			LOG.info("Exception: " + e);
			return null;
		}
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
