package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.lprod.vo.LprodVO;

public class LprodPage {
	private int total;
	private int currenPage;
	private List<LprodVO> content;
	private int totalPages;
	private int startPage;
	private int endPage;
	
	public LprodPage(int totoal, int currentPage, int size, List<LprodVO> content) {
		this.total = total;
		this.currenPage = currentPage;
		this.content = content;
		if(total == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		}else {
			totalPages = total / size;
			if(total % size > 0) {
				totalPages++;
			}
			int modVal = currentPage % 5;
			startPage = currentPage / 5 * 5 + 1;
			if(modVal == 0) {
				startPage = 5;
			}
		}
	}
	
	
}
