package kr.or.ddit.lprod.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.lprod.mapper.LprodMapper;
import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.lprod.vo.LprodVO;

@Service
public class LprodServiceImpl implements LprodService {
	@Autowired
	LprodMapper mapper;
	
	@Override
	public int insertLprod(Map<String, Object> map) {
		return mapper.insert(map);
	}

	@Override
	public List<LprodVO> getLprodList(Map<String, Object> map) {
		List<LprodVO> lprodVo = mapper.readAll(map);
		return lprodVo;
	}

	@Override
	public int deleteLprod(String id) {
		return mapper.delete(id);
	}

	@Override
	public LprodVO getLprod(String id) {
		LprodVO lprodVo = mapper.read(id);
		return lprodVo;
	}

	@Override
	public int updateLprod(Map<String, Object> map) {
		return mapper.update(map);
	}
	

}
