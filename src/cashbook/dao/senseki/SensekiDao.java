package cashbook.dao.senseki;

import java.util.List;
import java.util.Map;

import cashbook.dto.common.LoginDto;

/**
 * 戦績DAOインターフェース
 * @author soppra
 */
public interface SensekiDao {

	/**
	 * <p><b>
	 * 戦績画面
	 * <br>検索処理
	 * </b></p>
	 * @param formMap フォーム項目
	 * @return List<Map<String, String>> 検索結果
	 */
	public List<Map<String, String>> searchSensekiList(Map<String, Object> formMap);

	/**
	 * <p><b>
	 * 戦績画面
	 * <br>削除処理(論理削除)
	 * </b></p>
	 * @param sensekiCd 戦績コード
	 * @param loginDto ログイン情報DTO
	 */
	public void deleteSenseki(String sensekiCd, LoginDto loginDto);

	/**
	 * <p><b>
	 * 戦績登録画面
	 * <br>検索処理
	 * </b></p>
	 * @param formMap フォーム項目
	 * @return Map<String, String> 検索結果
	 */
	public Map<String, String> findSenseki(Map<String, Object> formMap);

	/**
	 * <p><b>
	 * 戦績登録画面
	 * <br>登録処理
	 * </b></p>
	 * @param フォーム項目
	 * @param ログイン情報DTO
	 */
	public void registSenseki(Map<String, Object> formMap, LoginDto loginDto);

	/**
	 * <p><b>
	 * 戦績登録画面
	 * <br>更新処理
	 * </b></p>
	 * @param フォーム項目
	 * @param ログイン情報DTO
	 */
	public void updateSenseki(Map<String, Object> formMap, LoginDto loginDto);

	/**
	 * <p><b>
	 * 戦績登録画面
	 * <br>重複チェック
	 * </b></p>
	 * @param フォーム項目
	 */
	public boolean checkOverlapSenseki(Map<String, Object> formMap);

	/**
	 * 行ロック及び、排他チェック
	 * @param formMap フォーム項目
	 * @return true：正常、false：排他エラー
	 */
	public boolean lockSenseki(Map<String, Object> formMap);
	
	/**
	 * セレクトボックス用選手名取得
	 * @return 選手名
	 */
	public Map<String, String> searchSelectboxSenshuNm();
	
	/**
	 * セレクトボックス用イニング取得
	 * @return 選手名
	 */
	public Map<String, String> searchSelectboxIning();
}
