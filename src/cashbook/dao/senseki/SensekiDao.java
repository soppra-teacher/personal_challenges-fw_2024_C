package cashbook.dao.senseki;

import java.util.List;
import java.util.Map;

import cashbook.dto.common.LoginDto;

/**
 * 個人マスタDAOインターフェース
 * @author soppra
 */
public interface SensekiDao {

	/**
	 * 個人マスタ一覧を検索する
	 * @param formMap フォーム項目
	 * @return 個人マスタ一覧
	 */
	public List<Map<String, String>> searchSenseki(Map<String, Object> formMap);

	/**
	 * 個人マスタを削除する
	 * @param sensekiId
	 * @param loginDto
	 */
	//public void deleteSenseki(String checkDel, LoginDto loginDto);

	/**
	 * 個人マスタを検索する
	 * @param formMap
	 * @return
	 */
	public Map<String, String> findSenseki(Map<String, Object> formMap);

	/**
	 * 世帯主フラグ確認
	 * @param formMap
	 * @return
	 */
	public boolean checkSetainushiFlg(Map<String, Object> formMap);


	/**
	 * 個人マスタを更新する
	 * @param formMap
	 * @param loginDto
	 */
	public void updateSenseki(Map<String, Object> formMap, LoginDto loginDto);

	/**
	 * 重複チェック
	 * @param formMap
	 * @return
	 */
	public boolean checkOverlapSenseki(Map<String, Object> formMap);

	/**
	 * 行ロック及び、排他チェック
	 * @param formMap
	 * @return
	 */
	public boolean lockSenseki(Map<String, Object> formMap);
	
	
	/*
	 * playername
	 * */
	public String getPlayerName(Map<String, Object> formMap);

	//public void deleteSenseki(String checkDel, LoginDto loginDto);

	public void deleteSenseki(String checkDel, LoginDto loginDto);


}
