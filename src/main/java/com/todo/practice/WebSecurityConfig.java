package com.todo.practice;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.todo.practice.handler.FailureHandler;
import com.todo.practice.handler.SuccessHandler;
import com.todo.practice.service.UserDetailsServiceImpl;

@EnableWebSecurity
@Configuration

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	public void setUserDetailsServiceImpl(UserDetailsServiceImpl userDetailsServiceImpl) {
		this.userDetailsServiceImpl = userDetailsServiceImpl;
	}

	@Autowired
	SuccessHandler successHandler;

	@Autowired
	FailureHandler failureHandler;


//	@Autowired
//	CustomAuthenticationProvider authenticationProvider;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		// ヘッダーにトークンを表示されるようにする
		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("http://localhost:8081"));
		// 認証情報送信許可の登録(Access-Control-Allow-Credentials)
		// AllowedOriginsがワイルドカード("*")でないときにCredentialsをtrueにする
		configuration.setAllowCredentials(true);
		    configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		configuration.setAllowedHeaders(Arrays.asList("X-Authenticated-token", "content-type"));
		configuration.setExposedHeaders(Arrays.asList("X-Authenticated-token"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder encoder = passwordEncoder();

		auth.eraseCredentials(true).userDetailsService(userDetailsServiceImpl).passwordEncoder(encoder);

//		auth.authenticationProvider(authenticationProvider);
//		auth.inMemoryAuthentication()
//			.withUser("user")
//			.password(encoder.encode("user"))
//			.roles("GENERAL");

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**").antMatchers("/js/**").antMatchers("/img/**");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();

		http.authorizeRequests().antMatchers("/", "/user/signup/activate", "/user/signup", "/todo/read").permitAll()
				.anyRequest().authenticated();

		http.formLogin().loginProcessingUrl("/").loginPage("/").usernameParameter("emailaddress")
				.passwordParameter("password").successHandler(successHandler).failureHandler(failureHandler);

		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/home");

		http.csrf().csrfTokenRepository(new CookieCsrfTokenRepository())
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

		http.cors(); // 追記

//		CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
//		filter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/", "POST"));
//		filter.setAuthenticationManager(authenticationManagerBean());
//		http.addFilterBefore(filter, CustomAuthenticationFilter.class);

	}

	
}
