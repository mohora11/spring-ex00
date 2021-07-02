package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service //하위에 component 가 포함됨
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper; 
	private ReplyMapper replyMapper;
	
//	@Autowired 없어도됌
//	public BoardServiceImpl(BoardMapper mapper) {
//		this.mapper = mapper;
//	} 위코드는 클래스위의 allargsconstructor로 인해 없어도됌
	
	@Override
	public void register(BoardVO board) {
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		return mapper.update(board) == 1;
	}

	@Override
	@Transactional
	public boolean remove(Long bno) { //이 메소드로 댓글과 게시물이 동시에 삭제됨
		// 댓글 삭제 
		replyMapper.deleteByBno(bno);
		// 게시물 삭제
		int cnt = mapper.delete(bno);
		
		return cnt == 1;
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}
	
}
