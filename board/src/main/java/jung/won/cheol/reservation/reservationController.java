package jung.won.cheol.reservation;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jung.won.cheol.root.CommandMap;

@Controller
public class reservationController {
	
	@Resource(name="reservationService")
	reservationService reService;
	
	@RequestMapping(value="reservationForm") //좌석 선택 페이지
	public ModelAndView loginForm(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<Map<String,Object>>board = reService.reservationSelect(commandMap.getMap());	
		mv.addObject("seat", board);
		mv.setViewName("reservation/reservationForm");
		return mv;
		
	}
	
	@RequestMapping(value="SeatAjax") //좌석 ajax
	public ModelAndView SeatAjax(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>>board = reService.reservationSelect(commandMap.getMap());	
		mv.addObject("seat", board);
		return mv;
		
	}
	
	
	
	
	
	
	

}
