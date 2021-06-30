package org.zerock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
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
	public void list(@ModelAttribute("cri") Criteria cri, Model model) {
		log.info("board/list method......");
		int total = service.getTotal(cri);
		
		// servcie getList() 실행결과를
		List<BoardVO> list = service.getList(cri);
		// model에 attribute로 넣고
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		
		// view로 포워드 함 
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		
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
	public void get(@RequestParam("bno") Long bno, 
			@ModelAttribute("cri") Criteria cri, 
			Model model) {
		log.info("board/get method");
		
		//service에게 일 시킴
		BoardVO vo = service.get(bno);
		
		// 결과를 모델에 넣음
		model.addAttribute("board", vo);
		
		// forword
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, Criteria cri, RedirectAttributes rttr) {
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
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		
		// forward or redirect
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(Long bno, Criteria cri, RedirectAttributes rttr) {
		// parameter 수집
		
		// service
		boolean success = service.remove(bno);
		
		// 결과 담고
		if (success) {
				rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("messagTitle", "삭제 성공.");
			rttr.addFlashAttribute("messageBody", "삭제 되었습니다.");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/register")
	public void register(@ModelAttribute("cri") Criteria cri) {
		// forward함 WEB-INF/views/board/register.jsp
	}
	
}
