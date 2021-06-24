package org.zerock.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Setter(onMethod_ = @Autowired)//?
 	private BoardService service;
		
//	@Test
//	public void testExist() {
//		assertNotNull(service);
//	}
//	
//	@Test
//	public void testRegister() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글2");
//		board.setContent("새로 작성하는 내용2");
//		board.setWriter("newbie");
//		
//		service.register(board);
//		
//		assertNotEquals(0, board.getBno()); //이번생성이 57번째면 0이 아니니까 초록불
//		log.info("생성된 게시물의 번호: " + board.getBno());
//	}
//	
	@Test
	public void testGetList() {
		Criteria cri = new Criteria(2, 5);
		
		List<BoardVO> list =  service.getList(cri);
		
		assertNotNull(list);
		assertTrue(list.size() > 0);
		assertEquals(5, list.size());
	}
//	
//	@Test
//	public void testGet() {
//		BoardVO vo = service.get(5L);
//		
//		assertEquals(5L, vo.getBno());
//	}
	
	@Test
	public void testModify() {
		String title = "제목1";
		String content = "안녕";
		String writer = "에바";
		
		BoardVO vo = service.get(5L);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		
		service.modify(vo);
		
		vo = service.get(5L);
		
		assertEquals(title, vo.getTitle());
		assertEquals(content, vo.getContent());
		assertEquals(writer, vo.getWriter());
	}
	
//	@Test
//	public void testRemove() {
//		Long key1 = 4L;
////		Long key2 = 14L; // 두번 실행하면 안됌 14번이 2번삭제되서 실패
//		
//		assertFalse(service.remove(key1));
////		assertTrue(service.remove(key2));
//		
//		/* 하나 입력후 삭제 하는 코드 */
//		BoardVO vo = new BoardVO();
//		vo.setTitle("title");
//		vo.setContent("content");
//		vo.setWriter("writer");
//		
//		service.register(vo);
//		
//		assertTrue(service.remove(vo.getBno()));
//	}
	
	
	

}
