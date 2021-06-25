package org.zerock.sample;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringSplitTest {

	@Test
	public void test() {
		String str1 = "java,spring,css"; //콤마 기준으로 java는 0번 index~~2번 index3
		
		String[] arr1 = str1.split(","); //배열의 split이란 메소드가 위의 기능을 함
		
		assertEquals("java", arr1[0]);
		assertEquals("spring", arr1[1]);
		assertEquals("css", arr1[2]);
	}
	
	@Test
	public void test2() {
		String str1 = "TWC";
		String[] arr1 = str1.split("");
		
		assertEquals(3, arr1.length);
		assertEquals("T", arr1[0]);
		assertEquals("W", arr1[1]);
		assertEquals("C", arr1[2]);
		
	}

}
