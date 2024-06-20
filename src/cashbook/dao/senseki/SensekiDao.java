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
	 * 個人戦績一覧を検索する
	 * @return 選手名
	 */
	public String getPlayerName(Map<String, Object> formMap);


	/**
	 * 個人戦績を削除する
	 * @param checkDel
	 * @param loginDto
	 */
	public void deleteSenseki(String checkDel, LoginDto loginDto);


}
