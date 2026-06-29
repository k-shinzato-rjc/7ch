package com.example.sevenchannel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ログインコントローラー
 * @author koki_shinzato
 */
@Controller
public class LoginController {
	
	/**
	 * ログイン画面遷移
	 * @return login.html
	 */
	@GetMapping("/login")
	public String loginView() {
		System.out.println("aaaaa");
		return "login";
	}
	
	/**
	 * ホーム画面へ遷移
	 * @return home.html
	 */
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	/**
	 * ログアウト画面へ遷移
	 * @return logout.html
	 */
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
	
	/**
	 * エラー画面へ遷移
	 * @return error.html
	 */
	@GetMapping("/error")
	public String error() {
		return "error";
	}
}
