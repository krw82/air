package jung.won.cheol.main;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import jung.won.cheol.root.rootDao;
@Repository("mainDao")
public class mainDao extends rootDao{
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectAll(Map<String, Object> map) throws Exception{
		return (List<Map<String,Object>>)selectList("getUtils.selectAirplane",map);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> ticketAjax(Map<String, Object> map) throws Exception{
		return (Map<String,Object>)selectOne("getUtils.ticketAjax",map);
	}
	
	
	
	
}
