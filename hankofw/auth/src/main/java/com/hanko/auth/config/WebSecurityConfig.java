
package com.hanko.auth.config;

import cn.hutool.core.convert.Convert;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author hanko
 * @date
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private final UserDetailsService userDetailsService;
	private final IgnoreUrlsProperties ignoreUrlsProperties;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder());
	}
	@Override
	@SneakyThrows
	protected void configure(HttpSecurity http) {
		http.formLogin()
			.loginPage("/token/login")
			.loginProcessingUrl("/token/form")
			.successForwardUrl("/token/success")
			.and()
			.logout()
			.deleteCookies("JSESSIONID")
			.invalidateHttpSession(true)
			.and()
			.authorizeRequests()
			//token**自定义登录地址
			.antMatchers("/token/**").permitAll()
			// oauth oauth2默认地址
			.antMatchers("/oauth/**").permitAll()
			.antMatchers("/rsa/publicKey").permitAll()
			.anyRequest().authenticated()
			.and().csrf().disable();
	}

	/**
	 * 增加白名单，如 css js swagger等
	 * @param web
	 */
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers(
				Convert.toStrArray(ignoreUrlsProperties.getUrls()));
	}

	@Bean
	@Override
	@SneakyThrows
	public AuthenticationManager authenticationManagerBean() {
		return super.authenticationManagerBean();
	}



	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
