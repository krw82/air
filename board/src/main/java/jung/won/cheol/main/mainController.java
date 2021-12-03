package jung.won.cheol.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jung.won.cheol.root.CommandMap;
@Controller




public class mainController {
	@Resource(name="mainService")
	private mainService mainservice;
	
	@RequestMapping(value="AriplaneSerch") 
	public ModelAndView AriplaneSerch(CommandMap commandMap) throws Exception { //비행기 스케쥴 검색
		ModelAndView mv = new ModelAndView();
		List<Map<String,Object>>board = mainservice.selectAll(commandMap.getMap());	
		mv.addObject("board",board);
		mv.setViewName("");
		return mv;
		
	}
	
	@RequestMapping(value="AriplaneSerchAjax") 
	public ModelAndView AriplaneSerchAjax(CommandMap commandMap) throws Exception { //비행기 스케쥴 검색
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>>board = mainservice.selectAll(commandMap.getMap());	
		mv.addObject("board",board);
		return mv;
		
	}
	
	@RequestMapping(value="main") 
	public ModelAndView select(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("views/main");
		return mv;
		
	}
	
	
	
	
	
}
