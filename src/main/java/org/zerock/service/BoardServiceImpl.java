package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service //하위에 component 가 포함됨
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper; 
	
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
	public boolean remove(Long bno) {
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
		
	}
	
}
