package jung.won.cheol.reservation;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import jung.won.cheol.root.rootDao;

@Repository("reservationDao")
public class reservationDao extends rootDao{
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectreservation(Map<String, Object> map) throws Exception {
		return (List<Map<String, Object>>) selectList("reservation.selectReservation", map);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectAir(Map<String, Object> map) throws Exception {
		return (Map<String, Object>) selectOne("reservation.selectAir", map);
	}
	
}
