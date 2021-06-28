package org.zerock.controller.lecture.normal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.controller.lecture.domain.User;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex08/*")
@Log4j
public class Ex08Controller {
	
	@RequestMapping("/sub01")
	public void method01(Model model) {
		log.info("ex08, sub01 method");
		
		model.addAttribute("name", "donald");
		model.addAttribute("age", 22);
	}
	
	@RequestMapping("/sub02")
	public void method02(Model model) {
		log.info("ex08, sub02 method");
		
		User user = new User();
		user.setId("bts");
		user.setAge(22);
		
		model.addAttribute("user", user);
	}
	
	@RequestMapping("/sub03")
	public String method03(Model model) {
		log.info("ex08, sub03 method");
		
		User user = new User();
		user.setId("korea");
		user.setAge(5000);
		
//		model.addAttribute("user", user);
		model.addAttribute(user); //주석과 같음 같은일을 함 class명
		
		return "ex08/sub02"; 
	}
	
	@RequestMapping("/sub04")
	public String method04(User user, Model model) {
		log.info("ex08, sub04 method");
		
		model.addAttribute("user", user); //파라미터명은 빼줘도됌
		
		return "ex08/sub02";
	}
	
	@RequestMapping("/sub05")
	public String method05(@ModelAttribute("user") User user, Model model) {
		log.info("ex08, sub05 method");
		
		return "ex08/sub02";
	}
	
	@RequestMapping("/sub06")
	public String method06(@ModelAttribute User user, Model model) {
		log.info("ex08, sub06 method");
		
		return "ex08/sub02";
	}
	
	@RequestMapping("/sub07")
	public String method07(User user, Model model) {
		log.info("ex08, sub07 method");
		
		model.addAttribute("Stirng");
		return "ex08/sub02";
	}
	
	@RequestMapping("/sub08")
	public String method08(User user) {
	
		log.info("ex08, sub08 method");
	
		return "ex08/sub02";
	}
	
	@RequestMapping("/sub09") //각 값의 앞에 @requestparam 없어도 가능
	public void method09(@ModelAttribute("age") int age, @ModelAttribute("name") String name) {
		log.info("ex08, sub09 method"); // 괄호로 명시해주는게 좋음 없을경우 String의 경우 name이 나와버림
		
		log.info(age);
		log.info(name);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
