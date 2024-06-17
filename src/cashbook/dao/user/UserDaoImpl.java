package cashbook.dao.user;

import static cashbook.util.Const.*;

import java.util.List;
import java.util.Map;

import org.springframework.dao.CannotAcquireLockException;

import cashbook.dao.common.BaseDaoImpl;
import cashbook.dto.common.LoginDto;
import cashbook.util.UserConst;

/**
 * ユーザーDAOクラス
 * @author soppra
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	
	/**
	 * ユーザーマスタを検索する
	 * @return ユーザーマスタ
	 */
	public Map<String, String> findUser(Map<String, Object> formMap) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT M1.USER_ID ");
		sql.append("     , M1.PASS ");
		sql.append("  FROM MST_USER M1 ");
		sql.append("  WHERE M1.USER_ID = '").append(formMap.get(UserConst.KEY_USER_ID)).append("' ");

		return super.find(sql.toString());
	}

	/**
	 * ユーザーマスタを登録する ここを変更する
	 * @throws Exception
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
		
		System.out.println(sql);  
	}
	

	
	/**
	 * 重複チェック
	 * @return true：正常、false：重複エラー
	 * ※ユーザーIDが重複していないか確認するSQL文を記載する。
	 */
	public boolean checkOverlapUser(Map<String, Object> formMap) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT M1.USER_ID ");
		sql.append("  FROM MST_USER M1 ");
		sql.append(" WHERE M1.USER_ID = '").append(formMap.get(UserConst.KEY_USER_ID)).append("' ");
		sql.append("   AND ROWNUM = 1 ");
		
		//　Q：AND ROWNUM = 1 が何をしているのか聞く
		System.out.println("UserDaoImplのcheckOverlapUser" + sql);
		return super.find(sql.toString()).size() == 0;
	}

	/**
	 * 行ロック及び、排他チェック
	 * @return true：正常、false：排他エラー
	 */
	public boolean lockUser(Map<String, Object> formMap) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT M1.USER_ID ");
		sql.append("  FROM MST_USER M1 ");
		sql.append(" WHERE M1.USER_ID = '").append(formMap.get(UserConst.KEY_USER_ID)).append("' ");
		sql.append("   AND M1.REVISION = '").append(formMap.get(ITEM_REVISION)).append("' ");
		sql.append("   FOR UPDATE NOWAIT ");
		try {

			return super.find(sql.toString()).size() != 0;

		} catch (CannotAcquireLockException e) {
			// 対象データがロックされている場合はエラー
			return false;
		}
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
	
	//以下の3つの @Overrideがないとエラーになる
	
	@Override
	public List<Map<String, String>> searchUser(Map<String, Object> formMap) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void deleteUser(String kojinId, LoginDto loginDto) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void updateUser(Map<String, Object> formMap, LoginDto loginDto) {
		// TODO 自動生成されたメソッド・スタブ
		
	}



}
