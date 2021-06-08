package kr.or.ddit.member.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.member.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MemberMapper {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int insert(Map<String, Object> map) {
		// namespace가 lprod이고 id가 insert인 xml을 찾아서 간다.
		return this.sqlSessionTemplate.insert("member.insert", map);
	};

	public List<MemberVO> readAll(Map<String, Object> map) {
		// namespace가 lprod이고 id가 select_list인 xml을 찾아서 간다.
		List<MemberVO> list = this.sqlSessionTemplate.selectList("member.select_list", map);
		log.info("멤버의 list : " + list);
		return list;
	};

	public int update(Map<String, Object> map) {
		return this.sqlSessionTemplate.update("member.update", map);
	};

	public int delete(String id) {
		return this.sqlSessionTemplate.delete("member.delete", id);
	};

	public MemberVO read(String id) {
		MemberVO vo = this.sqlSessionTemplate.selectOne("member.select_detail", id);

		log.info("vo : " + vo.toString());

		return vo;
	};
	
	public List<Map<String, Object>> selectListEtc(String id) {
		return this.sqlSessionTemplate.selectList("member.select_list_etc", id);
	}

	public int count() {
		return this.sqlSessionTemplate.selectOne("member.select_count");
	};
}
