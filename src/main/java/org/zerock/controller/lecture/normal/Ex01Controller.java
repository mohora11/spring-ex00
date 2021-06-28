package org.zerock.controller.lecture.normal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;


@Controller //서블릿에서 사용하는 컨트롤러라고 명시
@RequestMapping("/ex01/*") //컨트롤러가 일하는 경로 명시
@Log4j
public class Ex01Controller {
	
	@RequestMapping("/sub01")
	//아래 메소드가 
	public void method01() {
//		System.out.println("ex01, sub01 method");
		log.info("ex01, sub01 method");	
		
	//ex01/sub01 경로로 갔을때 일을 하는걸 확인
	}
	
	@RequestMapping("/sub02")
	public void method02() {
		log.info("ex01, sub02 method");
	}
	
	//get방식으로만 일하게 하는 법
	@RequestMapping(value = "/sub03", method = RequestMethod.GET)
	public void method03() {
		log.info("ex01, sub03 get method");
	}
	
	//post 방식
	@RequestMapping(value = "/sub03", method = RequestMethod.POST)
	public void method04() {
		log.info("ex01, sub03 post method");
	}
	
	//get방식의 단순화
	@GetMapping("/sub05") 
	public void method05() {
		log.info("ex01, sub05 get method");
	}
	
	//post방식의 단순화
	@PostMapping("/sub06")
	public void method06() {
		log.info("ex01, sub06 post method");
	}
}	
