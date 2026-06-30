package com.example.sevenchannel.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.sevenchannel.service.BoardService;
import com.example.sevenchannel.service.ThreadService;

/**
 * 掲示板＆スレッド コントローラー
 * @author koki_shinzato
 */
@Controller
public class BoardAndThreadController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ThreadService threadService;
	
	/**
	 * 掲示板一覧へアクセス
	 * 全掲示板リストを取得してmodelへ渡す → boards.htmlへ遷移
	 * リクエストパラメータが存在した場合、値に該当したスレッドリストを取得してmodelへ渡す
	 * @param model
	 * @return 掲示板一覧（boards.html)
	 */
	@GetMapping("/boards")
	public String boardList(@RequestParam(value="boardId", required=false) Integer boardId, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    System.out.println("★認証中か？: " + auth.isAuthenticated());
	    System.out.println("★ユーザー情報: " + auth.getPrincipal());
		model.addAttribute("boards", boardService.findAll());
		
		if(Objects.nonNull(boardId)) {
			model.addAttribute("threads", threadService.findById(boardId));
		}
			
		return "boards";
	}
	
	/**
	 * 掲示板リストの掲示板名（リンク）を押下
	 * 掲示板IDに該当するスレッドリストを取得して/boardsへリダイレクト
	 * @param boardId
	 * @param redirect
	 * @return リダイレクト（/boards）
	 */
	@GetMapping("/threads")
	public String addThreadList(@RequestParam("boardId") Integer boardId, RedirectAttributes redirect) {
		redirect.addAttribute("boardId", boardId);
		return "redirect:/boards";
	}
}
