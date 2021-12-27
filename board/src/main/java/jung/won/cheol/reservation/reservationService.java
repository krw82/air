package jung.won.cheol.reservation;

import java.util.List;
import java.util.Map;

public interface reservationService {
	//db 작업 할것들 모듈화 하여 객체지향
	public List<Map<String, Object>> reservationSelect(Map<String, Object> map) throws Exception;
	
	public Map<String, Object> selectAir(Map<String, Object> map) throws Exception;
	
	public Map<String, Object> selectId(Map<String, Object> map) throws Exception;
	
	public void insertTicket(Map<String, Object> map) throws Exception;
	
	public void FalTicket(Map<String, Object> map) throws Exception;
	
	public  Map<String, Object> selectTicket(Map<String, Object> map) throws Exception;
	
}
