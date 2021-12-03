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
	private loginservice loginservice;
	
	@RequestMapping(value="login") 
	public ModelAndView loginForm(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("views/loginForm");
		return mv;
		
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST) 
	public ModelAndView login(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		HttpSession session= request.getSession();
		Map<String,Object>member = loginservice.good(commandMap.getMap());
		session.setAttribute("MEMBER_ID", member.get("ID"));
		mv.addObject("MEMBER",member);
		mv.setViewName("views/loginForm");
		return mv;
		
	}

}
