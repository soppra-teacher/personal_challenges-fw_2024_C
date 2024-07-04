package cashbook.dao.common;

import java.util.Map;

import cashbook.util.UserConst;

/**
 * ログインDAOクラス
 * @author soppra
 */
public class LoginDaoImpl extends BaseDaoImpl implements LoginDao {

	/**
	 * ログイン情報を取得する
	 * @param formMap フォーム項目
	 * @return ログイン情報
	 */
	public Map<String, String> findLogin(Map<String, Object> formMap) {

		// フォーム項目の入力値でSQLを組み立てる。
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT  COUNT(*) AS USER_ID");
		sql.append("  FROM MST_USER  ");
		sql.append(" WHERE USER_ID = '").append(formMap.get(UserConst.KEY_USER_ID)).append("' ");
		sql.append("   AND PASS = '").append(formMap.get(UserConst.KEY_PASS)).append("' ");

		// 組み立てたSQLで検索処理を行う。
		Map<String, String> result = super.find(sql.toString());
		// 処理結果を返却する。
		return result;
	}
}
