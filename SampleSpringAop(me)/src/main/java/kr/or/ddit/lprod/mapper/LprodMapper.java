package kr.or.ddit.lprod.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.lprod.vo.LprodVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class LprodMapper {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int insert(Map<String, Object> map) {
		// namespace가 lprod이고 id가 insert인 xml을 찾아서 간다.
		return this.sqlSessionTemplate.insert("lprod.insert", map);
	};

	public List<LprodVO> readAll(Map<String, Object> map) {
		// namespace가 lprod이고 id가 select_list인 xml을 찾아서 간다.
		List<LprodVO> list = this.sqlSessionTemplate.selectList("lprod.select_list", map);
		log.info("list : " + list);
		return list;
	};

	public int update(Map<String, Object> map) {
		return this.sqlSessionTemplate.update("lprod.update", map);
	};

	public int delete(String id) {
		return this.sqlSessionTemplate.delete("lprod.delete", id);
	};

	public LprodVO read(String id) {
		LprodVO vo = this.sqlSessionTemplate.selectOne("lprod.select_detail", id);

		log.info("vo : " + vo.toString());

		return vo;
	};
}
