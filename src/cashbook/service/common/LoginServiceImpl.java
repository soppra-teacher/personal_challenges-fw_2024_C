package cashbook.service.common;

import java.util.Map;

import cashbook.dao.common.LoginDao;
import cashbook.dto.common.LoginDto;

/**
 * ログインサービス
 * @author soppra
 */
public class LoginServiceImpl implements LoginService {
	private LoginDao loginDao;

	/**
	 * DAOのsetter
	 * @param loginDao
	 */
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	/**
	 * ログイン実行メソッド
	 * @param formMap
	 * @return ログイン情報DTO
	 */

	public LoginDto execute(Map<String, Object> formMap) {
		LoginDto result = new LoginDto();
		Map<String, String> map = loginDao.findLogin(formMap);

		//ログインするためにユーザーマスタからユーザーIDを取得する COUNT(*)
		result.setUserId(map.get("USER_ID"));

		return result;
	}

}