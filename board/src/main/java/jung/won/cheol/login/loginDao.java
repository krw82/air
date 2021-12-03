package jung.won.cheol.login;

import java.util.Map;

import org.springframework.stereotype.Repository;

import jung.won.cheol.root.rootDao;

@Repository("loginDao")
public class loginDao extends rootDao{
	@SuppressWarnings("unchecked")
	public Map<String, Object> login(Map<String, Object> map) throws Exception{
		return (Map<String,Object>)selectOne("goods.selectMemberList",map);
	}

}
