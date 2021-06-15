package core.test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
	public static void main(String[] args) {
		// dependency injection (의존성 주입)
		
		System.out.println("프로그램 실행1");
		
//		Desk desk = new Desk(); 
//		위 코드처럼 안만들고 Spring에 직접 시킬거임
		// 설명서를 만들거임
		String path = "core/test1/core-test1.xml"; // - 설명서 경로
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		Object o = context.getBean("desk");
		System.out.println(o);
		
		Object o2 = context.getBean("leg");
		System.out.println(o2);
		
		Object o3 = context.getBean("chair");
		System.out.println(o3);
	}
}

