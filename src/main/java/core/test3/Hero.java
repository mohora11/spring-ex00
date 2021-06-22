package core.test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Hero {
	
	private Sword sword; //디펜던시
	
	@Autowired
	@Qualifier("waterSword")
	public void setSwrod(Sword sword) {
		this.sword = sword;
	}
	
	public Sword getSword() {
		return sword;
	}
}
