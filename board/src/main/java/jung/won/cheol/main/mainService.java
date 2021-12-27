package jung.won.cheol.main;

import java.util.List;
import java.util.Map;

public interface mainService {
	public List<Map<String, Object>> selectAll(Map<String, Object> map) throws Exception;
	
	public Map<String, Object> ticketAjax(Map<String, Object> map) throws Exception;
	
}
