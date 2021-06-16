package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

@Component //spring api
@ToString
@Getter
public class SampleHotel {
	
	private Chef chef;
	
//	@Autowired
	public SampleHotel(Chef chef) { // 생성자가 하나뿐이라 자동주입 
		
		this.chef = chef;
	}
}
