package kr.or.ddit.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
// 웹브라우져의 모든 요청은 컨트롤러로 들어온다.
public class MemberController {
	@Autowired
	MemberService service;

	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public ModelAndView login() {
		log.info("login하는 곳");
		ModelAndView mav = new ModelAndView();

		mav.setViewName("member/loginForm");

		return mav;
	}
	
}
