package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.vo.MemberVO;

public interface MemberService {
	public int insertMember(Map<String, Object> map);
	
	public List<MemberVO> getMemberList(Map<String, Object> map);
	
	public int deleteMember(String id);
	
	public MemberVO getMember(String id);
	
	public int updateMember(Map<String, Object> map);
}
