package kr.or.ddit.member.vo;

import java.util.List;

public class MemberPage {
	private int total;
	private int currentPage;
	private List<MemberVO> content;
	private int totalPage;
	private int startPage;
	private int endPage;

	public MemberPage(int total, int currentPage, int size, List<MemberVO> content) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		
		if(total == 0) {
			totalPage = 0;
			startPage = 0;
			endPage = 0;
		}else {
			total = total / size;
			if(total % size > 0) {
				totalPage++;
			}
			int modVal = currentPage % 5; // 한 번에 5개 페이지를 보고 다음 페이지 부터는 6부터 시작 할 수 있게
			startPage = currentPage / 5 * 5 + 1;
			if(modVal == 0) startPage -= 5;
			
			endPage = startPage + 4;
			if(endPage > totalPage) endPage = totalPage;
		}
	}

	public int getTotal() {
		return total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public List<MemberVO> getContent() {
		return content;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}
	
	
	
	
}
