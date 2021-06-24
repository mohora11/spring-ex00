package org.zerock.domain;

import lombok.Getter;

@Getter
public class PageDTO {

//	private int pageNum;
// 	private int amount;
	private Criteria cri;
	
	private int startPage; // 현재 페이지 기준 시작 페이지
	private int endPage; // 현재 페이지 기준 마지막 페이지
	
	private boolean prev; // '이전페이지'버튼 표시 유무
	private boolean next; // '다음페이지'버튼 표시 유무
	
	private int total; // 총게시물 숫자 가령 16페이지 에서 끝나면 endpage가 20이 출력이안됌
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		
		int current = cri.getPageNum();
		int numPerPage = cri.getAmount();
		
		// 현재 페이지가 1~10 이면
		// 시작은 1, 마지막은 10
		this.endPage = ((current-1) / 10 + 1) * 10;
		this.startPage = endPage - 9; // 가령 1--10이면 10에서 9를 빼면 1이니까
		
		int realEnd = total / numPerPage;
		
		// 가장 마지막 페이지
		if (total % numPerPage != 0) {
			realEnd = realEnd + 1;
		}
		
		// '마지막 페이지' 와 '가장 마지막 페이지' 비교 했을 때 적은 숫자
		this.endPage = Math.min(endPage, realEnd);
		
		// 이전, 다음 버튼 표시 여부
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
