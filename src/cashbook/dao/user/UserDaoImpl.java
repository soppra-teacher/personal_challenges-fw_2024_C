package cashbook.dao.user;

import java.util.Map;

import cashbook.dao.common.BaseDaoImpl;
import cashbook.util.UserConst;

/**
 * ユーザーDAOクラス
 * @author soppra
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	/**
	 * ユーザーマスタを登録する ここを変更する
	 * @param formMap
	 */

	public void registUser(Map<String, Object> formMap) {

		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO MST_USER ( ");
		sql.append("     USER_ID ");
		sql.append("   , PASS ");
		sql.append(" ) VALUES ( ");
		sql.append("     '").append(formMap.get(UserConst.KEY_USER_ID)).append("' ");
		sql.append("   , '").append(formMap.get(UserConst.KEY_PASS)).append("' ");
		sql.append(" ) ");
		super.update(sql.toString());

	}

	/**
	 * 重複チェック
	 * @return true：正常、false：重複エラー
	 * ※ユーザーIDが重複していないか確認するSQL文を記載する。
	 */
	public boolean checkOverlapUser(Map<String, Object> formMap) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(M1.USER_ID)");
		sql.append("  FROM MST_USER M1 ");
		sql.append(" WHERE M1.USER_ID = '").append(formMap.get(UserConst.KEY_USER_ID)).append("' ");
		//sql.append("   AND ROWNUM = 1 ");

		return super.find(sql.toString()).toString().equals("{COUNT(M1.USER_ID)=0}");
	}

	/**
	 * ユーザーID確認　＜＝　ユーザーID
	 * @return false：正常、true：整合性エラー
	 */
	public boolean checkSetainushiFlg(Map<String, Object> formMap) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT USER_ID ");
		sql.append("  FROM MST_USER  ");
		sql.append(" WHERE USER_ID != '").append(formMap.get(UserConst.KEY_USER_ID)).append("' ");
		return super.find(sql.toString()).size() != 0;
	}
}
