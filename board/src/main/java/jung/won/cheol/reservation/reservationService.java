package jung.won.cheol.reservation;

import java.util.List;
import java.util.Map;

public interface reservationService {
	public List<Map<String, Object>> reservationSelect(Map<String, Object> map) throws Exception;
	
	public Map<String, Object> selectAir(Map<String, Object> map) throws Exception;
	
	public Map<String, Object> selectId(Map<String, Object> map) throws Exception;
	
	public void insertTicket(Map<String, Object> map) throws Exception;
	
	public void FalTicket(Map<String, Object> map) throws Exception;
}
