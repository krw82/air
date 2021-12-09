package jung.won.cheol.reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		mv.addObject("se", board);
		System.out.println(board+"sedfdsafdsafdasfdsafdsafdsaf");
		List arr=new ArrayList();
		for(int i=0; i<51; i++) {
			arr.add(i,0);
		}
		
		List arr2= new ArrayList();
		for (Map obj : board) {
			arr2.add(obj.get("SEAT"));
			System.out.println(obj.get("SEAT"));
			
		}
		
		mv.addObject("SEAT", arr2);
		mv.addObject("arr", arr);
		
		Map map=(Map) request.getAttribute("map");

		mv.addObject("map", map);
		
		
		
		mv.setViewName("reservation/reservationForm");
		return mv;
		
	}
	
	@RequestMapping(value="SeatAjax") //좌석 ajax
	
	public ModelAndView SeatAjax(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String,Object>>board = reService.reservationSelect(commandMap.getMap());	
		List arr2= new ArrayList();
		for (Map obj : board) {
			arr2.add(obj.get("SEAT"));
			System.out.println("ajax");
			
		}
		mv.addObject("SEAT", arr2);
		mv.addObject("seat", board);
		return mv;
		
	}
	
	@RequestMapping(value="reservationCheck") //좌석 예약 확인 페이지
	public ModelAndView reservationCheck(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		Map<String,Object>board = reService.selectAir(commandMap.getMap());
		HttpSession session = request.getSession();
		//세션 아이디 넣어야함!!!!!!
		
		
		
		mv.addObject("map",board);
		mv.addObject("ID","jung");
		mv.setViewName("reservation/reservationCheck");
		return mv;
		
	}
	
	
	
	

	
	
	
	
	
	
	

}
