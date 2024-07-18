package cashbook.dao.senseki;

import java.util.List;
import java.util.Map;

import cashbook.dto.common.LoginDto;

/**
 * 個人戦績DAOインターフェース
 * @author soppra
 */
public interface SensekiDao {

	/**
	 * 個人戦績一覧を検索する
	 * @param formMap フォーム項目
	 * @param loginDto
	 * @param formMap
	 * @return 個人戦績一覧
	 */
	public List<Map<String, String>> searchSenseki(Map<String, Object> formMap,LoginDto loginDto);
	
	/**
	 * 個人戦績を削除する
	 * @param matchId
	 * @param loginDto
	 */
	public void deleteSenseki(String matchId, LoginDto loginDto);
	
	/**
	 * 選手名を検索する
	 * @param formMap
	 * @return 選手名
	 */
	public String getPlayerName(Map<String, Object> formMap);

}
