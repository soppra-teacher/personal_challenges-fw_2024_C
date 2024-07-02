package cashbook.dao.common;

import java.util.Map;

/**
 * ログインDAOクラス
 * @author soppra
 */
public class LoginSampleDaoImol extends BaseDaoImpl implements LoginDao {

	/**
	 * ログイン情報を取得する
	 * @param formMap フォーム項目
	 * @return ログイン情報
	 */
	public Map<String, String> findLogin(Map<String, Object> formMap) {

		// フォーム項目の入力値でSQLを組み立てる。
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * ");
		sql.append("  FROM MST_USER  ");
		sql.append(" WHERE USER_ID = '").append(formMap.get("userId")).append("' ");
		sql.append("   AND PASS = '").append(formMap.get("pass")).append("' ");

		// 組み立てたSQLで検索処理を行う。
		Map<String, String> result = super.find(sql.toString());

		// 処理結果を返却する。
		return result;
	}
}
