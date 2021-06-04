package kr.or.ddit.lprod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.vo.LprodVO;

public interface LprodService {
	public int insertLprod(Map<String, Object> map);
	
	public List<LprodVO> getLprodList(Map<String, Object> map);
	
	public int deleteLprod(String id);
	
	public LprodVO getLprod(String id);
	
	public int updateLprod(Map<String, Object> map);
}
