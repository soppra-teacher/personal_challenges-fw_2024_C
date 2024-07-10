package cashbook.service.user;

import static cashbook.util.Const.*;

import java.util.Map;

import cashbook.dao.user.UserDao;
import cashbook.exception.CommonValidateException;
import cashbook.util.CommonUtil;
import cashbook.util.UserConst;

/**
 * ユーザーマスタサービス
 * @author soppra
 */
public class UserServiceImpl implements UserService {

	/** ユーザーマスタDao */
	private UserDao userDao;

	/**
	 * DAOのsetter
	 * @param userDao
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 登録画面登録・更新メソッド
	 * @param formMap
	 */ 
	public void registInsUpd(Map<String, Object> formMap) throws Exception {

		String user_pass = CommonUtil.getStr(formMap.get(UserConst.KEY_PASS));
		String user_pass2 = CommonUtil.getStr(formMap.get(UserConst.KEY_PASS2));

		//パスワードのチェックをおこなう
		if (!user_pass.equals(user_pass2)) {
			throw new CommonValidateException(MSG_ERRORS_PASS_ERROR);
		}
		// 存在チェック
		if (!userDao.checkOverlapUser(formMap)) {
			throw new CommonValidateException(MSG_ERRORS_PRIMARY_KEY);
		}
		userDao.registUser(formMap);
	}

}