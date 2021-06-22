package org.zerock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
@Log4j
public class BoardController {
	
	private BoardService service;
	
	/*
	@Autowired
	public BoardController(BoardService service) {
		this.service = service
	}
	 allargs 때문에 필요없음 */
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("board/list method......");
		
		// servcie getList() 실행결과를
		List<BoardVO> list = service.getList();
		// model에 attribute로 넣고
		model.addAttribute("list", list);
		
		// view로 포워드 함 
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		// service에게 등록업무
		service.register(board); // board객체가 가지고있는 프로퍼티 title,content,writer
		
		rttr.addFlashAttribute("result", board.getBno());
		
		// /board/list redirect
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model) {
		
		log.info("/get");
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify:" + board);
		
		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
}
