package com.example.sevenchannel.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.sevenchannel.domain.model.users.UserForm;
import com.example.sevenchannel.service.UserService;

/**
 * ユーザーコントローラー
 * @author koki_shinzato
 */
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * ユーザー登録画面で登録ボタン押下
	 * バリデーションを行い、DB登録
	 * @param form
	 * @param result
	 * @param model
	 * @param redirect
	 * @return ログイン画面表示へリダイレクト（正常） or 登録画面へ戻る（異常）
	 */
	@PostMapping("/regist")
	public String save(@Valid @ModelAttribute("form") UserForm form, BindingResult result,
			Model model, RedirectAttributes redirect) {
		
		if(result.hasErrors()) {
			model.addAttribute("error", "入力内容に不備がありました。");
			return "regist";
		}
		
		userService.save(form.toDto());
		redirect.addFlashAttribute("success", "登録完了しました。");
		return "redirect:/login";
	}
}
