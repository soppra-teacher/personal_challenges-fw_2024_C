package cashbook.dao.user;

import java.util.Map;

/**
 * ユーザーマスタDAOインターフェース
 * @author soppra
 */
public interface UserDao {

	/**
	 * ユーザーマスタを登録する
	 * @param formMap
	 */
	public void registUser(Map<String, Object> formMap);

	/**
	 * 重複チェック
	 * @param formMap
	 * @return
	 */
	public boolean checkOverlapUser(Map<String, Object> formMap);

}
