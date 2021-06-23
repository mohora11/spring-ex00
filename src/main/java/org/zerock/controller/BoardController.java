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
		rttr.addFlashAttribute("messagTitle", "등록 성공.");
		rttr.addFlashAttribute("messageBody", board.getBno() + "번 게시물 등록 되었습니다.");
		
		// /board/list redirect
		return "redirect:/board/list";
	}
	
//	@GetMapping("/get")
//	public void get(@RequestParam("bno") Long bno, Model model) {
//		
//		log.info("/get");
//		model.addAttribute("board", service.get(bno));
//	}
	
	@GetMapping({"/get", "/modify"})
	public void get(Long bno, Model model) {
		log.info("board/get method");
		
		//service에게 일 시킴
		BoardVO vo = service.get(bno);
		
		// 결과를 모델에 넣음
		model.addAttribute("board", vo);
		
		// forword
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		// request parameter 수집 (알아서 됨)
		log.info("modify:" + board);
		
		// service 일 시킴
		boolean success = service.modify(board);
		
		// 결과를 모델(또는 FlashMap)에 넣고
		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("messagTitle", "수정 성공.");
			rttr.addFlashAttribute("messageBody", "수정 되었습니다.");
		}
		
		// forward or redirect
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		// parameter 수집
		
		// service
		boolean success = service.remove(bno);
		
		// 결과 담고
		if (success) {
			rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("messagTitle", "삭제 성공.");
			rttr.addFlashAttribute("messageBody", "삭제 되었습니다.");
		}
		return "redirect:/board/list";
	}
	
	@GetMapping("/register")
	public void register() {
		// forward함 WEB-INF/views/board/register.jsp
	}
	
}
