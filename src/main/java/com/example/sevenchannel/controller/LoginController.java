package com.example.sevenchannel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sevenchannel.domain.model.users.UserForm;

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
		return "login";
	}
	
	/**
	 * ログアウト画面へ遷移
	 * @return logout.html
	 */
	@PostMapping("/logout")
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
	
	/**
	 * ログイン画面下部の新規登録リンクにアクセス
	 * 空のUserFormをViewへ渡し、regist.htmlへ遷移
	 * @param model
	 * @return regist.html
	 */
	@GetMapping("/regist")
	public String regist(Model model) {
		model.addAttribute("form", new UserForm());
		return "regist";
	}
}
