package org.zerock.mapper;

import static org.junit.Assert.assertEquals;
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

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		assertNotNull(mapper);
		
		List<BoardVO> list = mapper.getList();
		
//		assertEquals(5, list.size());
		assertTrue(list.size() > 0);
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		int cnt = mapper.insert(board);
		
		assertEquals(1, cnt); // row 하나씩
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		assertEquals(0, board.getBno());
		// bno  값은 없다
		
		int cnt = mapper.insertSelectKey(board); // 여기까진 넣는것
		
		assertEquals(1, cnt);
		assertNotEquals(0, board.getBno()); // 여긴 확인절차
		// 위 값을 넣어줬으므로 bno는 0이 아님
	}
	
	@Test
	public void testRead() {
		BoardVO vo = mapper.read(1); // 1은 bno를 뜻함
		
		assertNotNull(vo);
		assertEquals(1, vo.getBno());
		
		/* insert, 자동 증가 키값 확인 */
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		assertEquals(0, board.getBno());
		
		
		int cnt = mapper.insertSelectKey(board);
		
		long key = board.getBno();
		
		BoardVO newBoard = mapper.read(key);
		
		assertNotNull(newBoard);
		assertEquals(key, newBoard.getBno());		
	}
	
	@Test
	public void testDelete() {
		int cnt = mapper.delete(0);
		
		assertEquals(0, cnt);
		
//		cnt = mapper.delete(13);
//		assertEquals(1, cnt);
		
		BoardVO board = new BoardVO();
		board.setTitle("title");
		board.setContent("content");
		board.setWriter("writer");
		
		mapper.insertSelectKey(
				board);
		
		cnt = mapper.delete(board.getBno());
		assertEquals(1, cnt);
	}
	
	@Test
	public void testUpdate() {
		long bno = 5;
		
		BoardVO board = new BoardVO();
		board.setBno(bno);
		board.setTitle("title");
		board.setContent("content");
		board.setWriter("user00");
		
		int cnt = mapper.update(board);
		
		assertEquals(1,  cnt);
		
		BoardVO board5 = mapper.read(bno);
		assertEquals(board.getTitle(), board5.getTitle());
		assertEquals(board.getContent(), board5.getContent());
		assertEquals(board.getWriter(), board5.getWriter());
	}
}