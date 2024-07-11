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
	 * @return true：正常、false：重複エラー
	 * ※ユーザーIDが重複していないか確認するSQL文を記載する。
	 */
	public boolean checkOverlapUser(Map<String, Object> formMap);

}
