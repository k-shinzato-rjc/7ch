package com.example.sevenchannel.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.sevenchannel.domain.model.posts.PostForm;
import com.example.sevenchannel.service.PostService;

/**
 * 投稿管理コントローラー
 * @author koki_shinzato
 */
@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/posts")
	public String postList(@RequestParam("threadId") Integer threadId, Model model) {
		
		model.addAttribute("posts", postService.findById(threadId));
		model.addAttribute("form", new PostForm());
		return "post";
	}
	
	/**
	 * スレッド内からポスト投稿ボタンを押下
	 * 入力チェックをし、エラーがあれあ元の画面 問題無ければ/postsへリダイレクト
	 * @param form
	 * @param result
	 * @param model
	 * @param redirect
	 * @return post.html or /postsリダイレクト
	 */
	@PostMapping("/post/upload")
	public String postUpload(@Valid @ModelAttribute("form") PostForm form,
		BindingResult result, Model model, RedirectAttributes redirect) {
		redirect.addAttribute("threadId", form.getThreadId());
		
		if(result.hasErrors()) {
			model.addAttribute("form", form);
			return "redirect:/posts";
		}
		
		postService.save(form.toDto());
		redirect.addFlashAttribute("success", "ポストを投稿しました");
		return "redirect:/posts";
	}
}
