package jung.won.cheol.login;


import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jung.won.cheol.root.CommandMap;

@Controller
public class loginController {
	@Resource(name="loginService")
	private loginservice loginService;
	
	
@RequestMapping(value="login", method=RequestMethod.GET)//로그인 폼 이동
	
	public ModelAndView login(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login/loginForm");
		
		return mv;
		
	}
	
	
	@RequestMapping(value="loginAjax") // 로그인 ajax
	
	public ModelAndView loginAjax(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		Map<String,Object>board = loginService.login(commandMap.getMap());	
		mv.addObject("member",board);
		System.out.println("로그인 ajax 실행");
		return mv;
		
	}
	@RequestMapping(value="success") // 로그인 성공
	
	public ModelAndView success(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		session.setAttribute("ID",request.getParameter("ID"));
		mv.setViewName("search/search");
		return mv;
		
	}

}
