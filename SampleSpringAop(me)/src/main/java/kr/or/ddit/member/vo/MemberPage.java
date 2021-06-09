package kr.or.ddit.member.vo;

import java.util.List;
import java.util.Map;

public class MemberPage {
	private int totalContent; // 전체 글갯수
	private int currentPage; // 현재 페이지 번호
	private List<MemberVO> content; // 멤버의 목록 데이터
	private int totalPages; // 전체 페이지의 수
	private int startPage; // 첫 페이지 번호
	private int endPage; // 마지막 페이지 번호

	public MemberPage(int total, int currentPage, int size, List<MemberVO> memberList) {
		this.totalContent = total;
		this.currentPage = currentPage;
		this.content = memberList;

		if (total == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;

		} else {
			totalPages = total / size;
			if (total % size > 0) {
				totalPages++;
			}
			int modVal = currentPage % 5; // 한 번에 5개 페이지를 보고 다음 페이지 부터는 6부터 시작 할 수 있게
			startPage = currentPage / 5 * 5 + 1;
			if (modVal == 0)
				startPage -= 5;

			endPage = startPage + 4;
			if (endPage > totalPages)
				endPage = totalPages;
		}
	}

	public int getTotal() {
		return totalContent;
	}

	public boolean hasArticles() {
		return totalContent > 0;
	}

	public boolean hasNoArticles() {
		return totalContent == 0;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public List<MemberVO> getContent() {
		return content;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

}
