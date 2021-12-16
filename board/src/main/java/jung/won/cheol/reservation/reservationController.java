package jung.won.cheol.reservation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		session.setAttribute("SEAT",request.getParameter("check") );
		session.setAttribute("FLYING_NUMBER",board.get("FLYING_NUMBER"));
		mv.addObject("SEAT", request.getParameter("check"));
		
		
		mv.addObject("MAP",board);
		mv.addObject("ID","jung");
		mv.setViewName("reservation/reservationCheck");
		return mv;
		
	}
	@RequestMapping(value="pay") //카카오페이
	public ModelAndView pay(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		HttpSession session = request.getSession();
		//아이디, member_number
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		String ticket_number=format.format(new Date());
		
		
		commandMap.put("SEAT",request.getParameter("SEAT"));
		commandMap.put("TICKET_NUMBER",ticket_number);
		commandMap.put("FLYING_NUMBER",request.getParameter("FLYING_NUMBER"));
		commandMap.put("MEMBER_NUMBER","01");
		
		reService.insertTicket(commandMap.getMap());
		
		
		
		Map<String,Object>board = reService.selectId(commandMap.getMap());
		
		//세션 아이디 넣어야함!!!!!!
		mv.addObject("SEAT", request.getParameter("SEAT"));
		mv.addObject("FLYING_NUMBER", request.getParameter("FLYING_NUMBER"));
		System.out.println(board);
		request.setAttribute("name", (String)board.get("NAME"));
		request.setAttribute("email", (String)board.get("EMAIL"));
		request.setAttribute("phone", (String)board.get("PHONE_NUMBER"));
		request.setAttribute("address", (String)board.get("ADDRESS"));
		mv.setViewName("reservation/pay");
		
		
		
		System.out.println(request.getParameter("SEAT")+"@##@!#"+request.getParameter("FLYING_NUMBER"));
		return mv;
		
	}
	
	@RequestMapping(value="payFa") //결제 실패시 넘어오는 페이지
	public ModelAndView payFa(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		HttpSession session=request.getSession();
		System.out.println("payFa ***********");
		commandMap.put("SEAT",session.getAttribute("SEAT"));
		commandMap.put("FLYING_NUMBER",session.getAttribute("FLYING_NUMBER"));
		
		session.removeAttribute("SEAT");
		session.removeAttribute("FLYING_NUMBER");
		reService.FalTicket(commandMap.getMap());
		//세션 아이디 넣어야함!!!!!!
		System.out.println("payFadfdsf");
//		mv.setViewName("reservation/reservationCheck");
		return mv;
		
	}
	
	
	
	
	

	
	
	
	
	
	
	

}
