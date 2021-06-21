package org.zerock.domain;

import lombok.Data;


// 보통 vo는 bean 을 담당한다
@Data
public class Test1VO {
	
	private long id;
	private String name;
	private int age;
}
