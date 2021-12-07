package jung.won.cheol.reservation;

import java.util.List;
import java.util.Map;

public interface reservationService {
	public List<Map<String, Object>> reservationSelect(Map<String, Object> map) throws Exception;
}
