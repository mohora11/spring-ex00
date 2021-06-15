package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {
	
	@Setter(onMethod_ = @Autowired) // set 방식
	private Chef chef;
	
//	@Autowired // 생성자 방식
//	public void setChef(Chef chef) {
//		this.chef = chef;
//	}
}
