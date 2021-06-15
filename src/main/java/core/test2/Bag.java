package core.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("bag")// p.66 spring이 제공하는 component 어노테이션
@Component // 뒤의 괄호가 없어도 클래스명으로 자동 빈이 생성된다.
		   // 스프링에서 객체로 만들어서 관리하게 됌
public class Bag {
	
	private Book book;
	
//	public Bag() { 생성자가 1개 있을 경우 autowired 어노테이션이
//					없어도 자동으로 묵시적 생성자 주입
//	}
	
	@Autowired //생성자 타입으로 주입
	public Bag(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Bag [book=" + book + "]";
	}
	
//	@Autowired //빈을 주입해줘라는 표시
	public void setBook(Book book) {
		this.book = book;
	}

}
