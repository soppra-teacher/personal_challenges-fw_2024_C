package cashbook.dao.user;

import java.util.List;
import java.util.Map;

import cashbook.dto.common.LoginDto;

/**
 * ユーザーマスタDAOインターフェース
 * @author soppra
 */
public interface UserDao {

	/**
	 * ユーザーマスタ一覧を検索する
	 * @param formMap フォーム項目
	 * @return ユーザーマスタ一覧
	 */
	public List<Map<String, String>> searchUser(Map<String, Object> formMap);

	/**
	 * ユーザーマスタを削除する いらない
	 * @param kojinId
	 * @param loginDto
	 */
	public void deleteUser(String kojinId, LoginDto loginDto);

	/**
	 * ユーザーマスタを検索する
	 * @param formMap
	 * @return
	 */
	public Map<String, String> findUser(Map<String, Object> formMap);

	/**
	 * 世帯主フラグ確認 ＊いらない
	 * @param formMap
	 * @return
	 */
	public boolean checkSetainushiFlg(Map<String, Object> formMap);

	/**
	 * ユーザーマスタを登録する
	 * @param formMap
	 */
	public void registUser(Map<String, Object> formMap);

	/**
	 * ユーザーマスタを更新する いらない
	 * @param formMap
	 * @param loginDto
	 */
	public void updateUser(Map<String, Object> formMap, LoginDto loginDto);

	/**
	 * 重複チェック
	 * @param formMap
	 * @return
	 */
	public boolean checkOverlapUser(Map<String, Object> formMap);

	/**
	 * 行ロック及び、排他チェック
	 * @param formMap
	 * @return
	 */
	public boolean lockUser(Map<String, Object> formMap);

}
