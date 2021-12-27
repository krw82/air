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
		HttpSession session = request.getSession();
		if(session.getAttribute("ID")!=null || session.getAttribute("MEMBER_NUMBER")!=null) {
			mv.setViewName("redirect:/AriplaneSerch");
		}else {
			mv.setViewName("login/loginForm");
		}
		
		
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
		commandMap.put("ID", request.getParameter("ID"));
		Map<String,Object>board = loginService.login(commandMap.getMap());	
		session.setAttribute("ID",request.getParameter("ID"));
		session.setAttribute("MEMBER_NUMBER", board.get("MEMBER_NUMBER"));
		
		mv.setViewName("redirect:/AriplaneSerch");
		return mv;
		
	}
@RequestMapping(value="joinForm") // 회원가입
	
	public ModelAndView join(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/login/join");
		return mv;
		
	}
	
@RequestMapping(value="join",method=RequestMethod.POST) // 회원가입
	
	public ModelAndView joinSubmit(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		loginService.PostMember(commandMap.getMap());
		mv.setViewName("redirect:/login");
		return mv;
		
	}
	
@RequestMapping(value="logout") // 로그아웃
	
	public ModelAndView logout(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		session.invalidate();
		
		mv.setViewName("redirect:/login");
		return mv;
		
	}
	
	
	
	
	

}
