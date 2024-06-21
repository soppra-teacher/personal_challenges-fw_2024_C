package cashbook.dao.senseki;

import java.util.Map;

import cashbook.dto.common.LoginDto;

/**
 * 戦績DAOインターフェース
 * @author soppra
 */
public interface SensekiDao {
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
	 * セレクトボックス用選手名取得
	 * @return 選手名
	 */
	public Map<String, String> searchSelectboxSenshuNm();
	
	
}
