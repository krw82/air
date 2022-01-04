package jung.won.cheol.login;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


@Service("loginService")
public class loginServiceImpl implements loginservice{

	@Resource(name="loginDao")
	private loginDao loginDao;

	@Override
	public Map<String, Object> login(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return loginDao.login(map);
	}
	
}
