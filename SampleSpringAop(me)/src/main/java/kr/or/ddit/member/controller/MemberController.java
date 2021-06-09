package kr.or.ddit.member.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.MappingSqlQueryWithParameters;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.vo.MemberPage;
import kr.or.ddit.member.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
// 웹브라우져의 모든 요청은 컨트롤러로 들어온다.
public class MemberController {
	@Autowired
	MemberService service;
	private int size = 10;

	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public ModelAndView login() {
		log.info("login하는 곳");
		ModelAndView mav = new ModelAndView();

		mav.setViewName("member/loginForm");

		return mav;
	}

	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public ModelAndView memberLoginPost(@RequestParam Map<String, Object> map, HttpServletRequest req) {
		log.info("login하는 곳");
		ModelAndView mav = new ModelAndView();

		MemberVO memberVo = service.getMember((String) map.get("memberid"));

		if (memberVo != null) {
			if (memberVo.getPassword().equals((String) map.get("password"))) {
				req.getSession().setAttribute("memberVo", memberVo);
			}

		}
		mav.setViewName("redirect:/member/login");
		return mav;
	}

	@RequestMapping(value = "/member/list")
	public ModelAndView memberList(@RequestParam Map<String, Object> map, ModelAndView mav) {
		log.info("회원목록 보는 곳");
		
		int total = this.service.selectCount();
		
		String startPageNum = (String)(map.get("pageNum") == null? "1" : map.get("pageNum"));
		int pageNum = Integer.parseInt(startPageNum);
		map.put("pageNum", pageNum);
		List<MemberVO> memberList = this.service.getMemberList(map);
		System.out.println("멤버VO리스트의 값은 : " + memberList);
		mav.addObject("memberInfo", memberList);
		mav.addObject("selectOpt", map.get("selectOpt"));
		mav.addObject("memberListVo", new MemberPage(total, pageNum, size, memberList));
		mav.setViewName("member/list");

		return mav;
	}

	@RequestMapping(value = "/member/logout", method = RequestMethod.POST)
	public ModelAndView memberLogout(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = req.getSession(false);

		if (session != null) {
			session.invalidate();
		}
		mav.setViewName("redirect:/member/list");

		return mav;
	}

	@RequestMapping(value = "/member/signup", method = RequestMethod.GET)
	public ModelAndView sign() {
		log.info("sigunup 하는 곳");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/sign");

		return mav;
	}

	@RequestMapping(value = "/member/insert", method = RequestMethod.POST)
	public ModelAndView addMember(@RequestParam Map<String, Object> map, ModelAndView mav) {
		System.out.println("map : " + map.toString());
		int result = this.service.insertMember(map);
		log.info("insert 하는 곳");
		if (result > 0) {
			mav.setViewName("redirect:/member/list");
		} else {
			log.info("insert 실패");
			mav.setViewName("redirect:/member/insert");
		}
		return mav;
	}

	@RequestMapping(value = "/member/detailMem", method = RequestMethod.GET)
	public ModelAndView detailMem(@RequestParam Map<String, Object> map, ModelAndView mav) {

		log.info("detailMem에 왔다.");
		String memberid = (String) map.get("memberid");
		MemberVO memberVo = this.service.getMember(memberid);
		mav.addObject("memberVo", memberVo);
		mav.setViewName("member/detail");

		return mav;
	}

	@RequestMapping(value = "/member/update", method = RequestMethod.POST)
	public ModelAndView detailUpdate(@RequestParam Map<String, Object> map, ModelAndView mav) {

		log.info("update에 왔다");
		System.out.println(map.toString());
		int result = this.service.updateMember(map);
		String memberid = (String) map.get("memberid");
		System.out.println("result의 값 : " + result);

		if (result > 0) {
			mav.setViewName("redirect:/member/detailMem?memberid="+ memberid + "&updateOk=success");
		} else {
			mav.setViewName("redirect:/member/detailMem?memberid="+ memberid + "&updateOk=fail");
		}
		return mav;
	}

	@RequestMapping(value = "/member/delete", method = RequestMethod.POST)
	public ModelAndView detailDel(@RequestParam Map<String, Object> map, ModelAndView mav) {

		log.info("detailDel에 왔다.");
		String memberid = (String) map.get("memberid");
		System.out.println("memberid는 " + memberid);
		int result = this.service.deleteMember(memberid);

		if (result > 0) {
			mav.setViewName("redirect:/member/list");
		} else {
			mav.setViewName("redirect:/member/detailMem?memberid=" + memberid);
		}

		return mav;
	}

}
