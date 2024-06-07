package cashbook.dao.seiseki;

import java.util.List;
import java.util.Map;

import cashbook.dto.common.LoginDto;

/**
 * 成績マスタDAOインターフェース
 * @author soppra
 */
public interface SeisekiDao {

	/**
	 * 成績マスタ一覧を検索する
	 * @param formMap フォーム項目
	 * @return 成績マスタ一覧
	 */
	public List<Map<String, String>> searchSeiseki(Map<String, Object> formMap);

	/**
	 * 成績マスタを削除する
	 * @param seisekiId
	 * @param loginDto
	 */
	public void deleteSeiseki(String seisekiId, LoginDto loginDto);

	/**
	 * 成績マスタを検索する
	 * @param formMap
	 * @return
	 */
	public Map<String, String> findSeiseki(Map<String, Object> formMap);

	/**
	 * 世帯主フラグ確認
	 * @param formMap
	 * @return
	 */
	public boolean checkSetainushiFlg(Map<String, Object> formMap);

	/**
	 * 成績マスタを登録する
	 * @param formMap
	 * @param loginDto
	 */
	public void registSeiseki(Map<String, Object> formMap, LoginDto loginDto);

	/**
	 * 選手マスタを登録する
	 * @throws Exception
	 */
	public void registSenshu(Map<String, Object> formMap, LoginDto loginDto);
	
	
	/**
	 * 成績マスタを更新する
	 * @param formMap
	 * @param loginDto
	 */
	public void updateSeiseki(Map<String, Object> formMap, LoginDto loginDto);

	/**
	 * 重複チェック
	 * @param formMap
	 * @return
	 */
	public boolean checkOverlapSeiseki(Map<String, Object> formMap);

	/**
	 * 行ロック及び、排他チェック
	 * @param formMap
	 * @return
	 */
	public boolean lockSeiseki(Map<String, Object> formMap);

}
