package org.zerock.controller.lecture.normal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/ex06/*")
public class Ex06Controller {

	@RequestMapping("/sub01")
	public String method01() {

		log.info("ex06, sub01 method");

		return "ex06/sub01";

		// request.getRequestDispatcher("/WEB-INF/views/ex06/sub01.jsp).forward(request,
		// response);
		// jsp에서 포워딩 할려면 이런 긴 코드를 썻는데 아주 간단해짐
		// /WEB_INF/views/ex06-sub01.jsp
	}

	@RequestMapping("/sub02")
	public void method2() {

		log.info("ex06, sub02 method");
	}
	
	@RequestMapping("/sub03")
	public String method03() {
		log.info("ex06, sub03 method");
		
		return "forward:/ex06/sub02";
		// /sub03에서 먼저 일하고 sub02경로로 감 그러나 주소창엔 /sub03으로 나옴
		// forward는 한번의 요청 redirect는 2번의 요청
	}
	
	@RequestMapping("/sub04")
	public String method04() {
		log.info("ex06, sub04 method");
		
		// response.sendRedirect(request.getContextPath() + "/otherPath");
		//                       /        생략가능       / 
		return "redirect:/ex06/sub02";
		// forward와는 다르게 주소창이 변함
	}
}














