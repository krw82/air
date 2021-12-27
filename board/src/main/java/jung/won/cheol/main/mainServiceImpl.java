package jung.won.cheol.main;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;



@Service("mainService")
public class mainServiceImpl implements mainService{
	
	@Resource(name="mainDao")
	private mainDao mainDao;

	
	@Override
	public List<Map<String, Object>> selectAll(Map<String, Object> map) throws Exception {
		return mainDao.selectAll(map);
	}


	@Override
	public Map<String, Object> ticketAjax(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return mainDao.ticketAjax(map);
	}

}
