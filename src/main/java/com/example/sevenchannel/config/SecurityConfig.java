package com.example.sevenchannel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security 設定
 * @author koki_shinzato
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	/**
	 * 認証設定
	 * @param http
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		// リクエストごとの認証設定
		http
		.authorizeHttpRequests(auth -> auth
			.requestMatchers("/login").permitAll()
			.requestMatchers("/home").permitAll()
			.requestMatchers("/regist").permitAll()
			.anyRequest().authenticated()
		)
		// ログイン画面・ログイン成功・失敗時のリクエスト
		.formLogin(form -> form
			.loginPage("/login")
			.usernameParameter("id")
			.passwordParameter("pwdHash")
			.defaultSuccessUrl("/home")
			.failureUrl("/login?error=true")
			.permitAll()
		)
		// ログアウト画面・ログアウト成功・失敗時のリクエスト
		.logout(logout -> logout
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login?logout=true")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID")
			.permitAll()
		);
		
		return http.build();
	}
	
	/**
	 * パスワードのハッシュ化
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
