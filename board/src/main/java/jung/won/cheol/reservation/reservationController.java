package jung.won.cheol.reservation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	
	@Autowired
	private JavaMailSender mailSender; //메일로 티켓전송
	
	@RequestMapping(value = "/sendMail")
    public ModelAndView sendMail(CommandMap commandMap, HttpServletRequest request)throws Exception{
		ModelAndView mv = new ModelAndView();
		Map<String,Object>board = reService.selectTicket(commandMap.getMap());
		HttpSession session=request.getSession();
		
        String subject = "test 메일";
        String content = "<table border =\"1\">\n"
        		+ "<tr>\n"
        		+ "<th>ID </th>\n"
        		+ "<th>스케쥴번호</th>\n"
        		+ "<th>비행기 </th>\n"
        		+ "<th>출발일 </th>\n"
        		+ "<th>도착일 </th>\n"
        		+ "<th>출발지 </th>\n"
        		+ "<th>경유지 </th>\n"
        		+ "<th>도착지 </th>\n"
        		+ "<th>가격 </th>\n"
        		+ "<th>좌석 </th>\n"
        		+ "<tr>\n"
        		+ "<td>"+session.getAttribute("ID")+"</td>\n"
        		+ "<td>"+board.get("FLYING_NUMBER")+"</td>\n"
        		+ "<td>"+board.get("AIRPLANE")+"</td>\n"
        		+ "<td>"+board.get("START_DATE")+"</td>\n"
        		+ "<td>"+board.get("END_DATE") +"</td>\n"
        		+ "<td>"+board.get("START_POINT")+"</td>\n"
        		+ "<td>"+board.get("STOPOVER")+"</td>\n"
        		+ "<td>"+board.get("END_POINT")+"</td>\n"
        		+ "<td>"+board.get("PRICE")+"</td>\n"
        		+ "<td>"+board.get("SEAT")+"</td>\n"
        		+ "\n"
        		+ "</tr>\n"
        		+ "</table>";
        
        String from = "dnjscjf0323@naver.com";
        String to =   "dnjscjf5882@gmail.com";// 받는사람은 그냥 고정
        
        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper mailHelper = new MimeMessageHelper(mail,true,"UTF-8");
            // true는 멀티파트 메세지를 사용하겠다는 의미
            
            /*
               * 단순한 텍스트 메세지만 사용시엔 아래의 코드도 사용 가능 
             * MimeMessageHelper mailHelper = new MimeMessageHelper(mail,"UTF-8");
             */
            
            mailHelper.setFrom(from);
            // 빈에 아이디 설정한 것은 단순히 smtp 인증을 받기 위해 사용 따라서 보내는이(setFrom())반드시 필요
            // 보내는이와 메일주소를 수신하는이가 볼때 모두 표기 되게 원하신다면 아래의 코드를 사용하시면 됩니다.
            //mailHelper.setFrom("보내는이 이름 <보내는이 아이디@도메인주소>");
            mailHelper.setTo(to);
            mailHelper.setSubject(subject);
            mailHelper.setText(content, true);
            // true는 html을 사용하겠다는 의미입니다.
            
            /*
             * 단순한 텍스트만 사용하신다면 다음의 코드를 사용하셔도 됩니다. mailHelper.setText(content);
             */
           
            mailSender.send(mail);
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("reservation/reservationForm");
        return mv;
        
    }
	
	
	
	
	

	
	
	
	
	
	
	

}
