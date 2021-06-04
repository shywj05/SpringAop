package kr.or.ddit.lprod.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.lprod.vo.LprodVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
// 웹브라우져의 모든 요청은 컨트롤러로 들어온다.
public class LprodController {
	@Autowired
	LprodService service;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		log.info("create에 왔다");
		ModelAndView mav = new ModelAndView();

		mav.setViewName("lprod/create");

		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();

		service.insertLprod(map);

		if (map.get("lprodId") == null) {
			mav.setViewName("redirect:/create");
		} else {
			mav.setViewName("redirect:/detail?lprodId=" + map.get("lprodId"));
		}
		return mav;

	}

	// 상세페이지 구현(GET) : {lprodId : 13}
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		log.info("상세페이지에 왔다");
		ModelAndView mav = new ModelAndView();

		String lprodId = (String) map.get("lprodId");
		LprodVO lprodVo = this.service.getLprod(lprodId);

		mav.addObject("lprodVo", lprodVo);
		mav.setViewName("lprod/detail");

		return mav;
	}

	@RequestMapping(value = "/list")
	public ModelAndView list(@RequestParam Map<String, Object> map, ModelAndView mav) {
		log.info("리스트에 왔다");

		List<LprodVO> lprodVo = this.service.getLprodList(map);

		mav.addObject("lprodListVo", lprodVo);
		mav.setViewName("lprod/list");

		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam Map<String, Object> map, ModelAndView mav) {
		log.info("업데이트에 왔다.");

		int result = this.service.updateLprod(map);

		if (result > 0) { // 업데이트가 잘 되었을 때, 이렇게 리턴을 해줘야 확인을 할 수 있다.
			String lprodId = map.get("lprodId").toString();
			mav.setViewName("redirect:/detail?lprodId=" + lprodId + "&updateGu=success");
			mav.addObject("updateGu", "success");
		} else { // 업데이트가 안됐을 때 혹은 대상이 없을 때
			String lprodId = map.get("lprodId").toString();
			mav.setViewName("redirect:/detail?lprodId=" + lprodId + "&updateGu=fail");
		}
		return mav;
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam Map<String, Object> map, ModelAndView mav) {
		log.info("딜리트에 왔다");
		int result = this.service.deleteLprod((String)map.get("lprodId"));
		
		if(result > 0) { // 삭제완료
			mav.setViewName("redirect:/list");
		}else { // 삭제실패
			String lprodId = map.get("lprodId").toString();
			mav.setViewName("redirect:/detail?lprodId=" + lprodId);
		}
		
		return mav;
	}

}
