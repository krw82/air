package jung.won.cheol.reservation;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jung.won.cheol.login.loginDao;

@Service("reservationService")
public class reservationServiceImpl implements reservationService{
	
	@Resource(name="reservationDao")
	private reservationDao reservationDao;

	@Override
	public List<Map<String, Object>> reservationSelect(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return reservationDao.selectreservation(map);
	}

}
