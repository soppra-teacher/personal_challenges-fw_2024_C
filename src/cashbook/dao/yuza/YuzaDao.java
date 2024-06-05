package cashbook.dao.yuza;

import java.util.List;
import java.util.Map;

import cashbook.dto.common.LoginDto;

/**
 * ユーザーマスタDAOインターフェース
 * @author soppra
 */
public interface YuzaDao {

	/**
	 * ユーザーマスタ一覧を検索する
	 * @param formMap フォーム項目
	 * @return ユーザーマスタ一覧
	 */
	public List<Map<String, String>> searchYuza(Map<String, Object> formMap);

	/**
	 * ユーザーマスタを削除する
	 * @param kojinId
	 * @param loginDto
	 */
	public void deleteYuza(String kojinId, LoginDto loginDto);

	/**
	 * ユーザーマスタを検索する
	 * @param formMap
	 * @return
	 */
	public Map<String, String> findYuza(Map<String, Object> formMap);

	/**
	 * 世帯主フラグ確認 ＊いらない
	 * @param formMap
	 * @return
	 */
	public boolean checkSetainushiFlg(Map<String, Object> formMap);

	/**
	 * ユーザーマスタを登録する
	 * @param formMap
	 * @param loginDto
	 */
	public void registYuza(Map<String, Object> formMap, LoginDto loginDto);

	/**
	 * ユーザーマスタを更新する
	 * @param formMap
	 * @param loginDto
	 */
	public void updateYuza(Map<String, Object> formMap, LoginDto loginDto);

	/**
	 * 重複チェック
	 * @param formMap
	 * @return
	 */
	public boolean checkOverlapYuza(Map<String, Object> formMap);

	/**
	 * 行ロック及び、排他チェック
	 * @param formMap
	 * @return
	 */
	public boolean lockYuza(Map<String, Object> formMap);

}
