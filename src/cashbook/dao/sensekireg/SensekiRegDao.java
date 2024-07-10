package cashbook.dao.sensekireg;

import java.util.Map;

import cashbook.dto.common.LoginDto;

/**
 * 個人戦績登録DAOインターフェース
 * @author soppra
 */
public interface SensekiRegDao {
	/**
	 * <p><b>
	 * 戦績登録画面
	 * <br>登録処理
	 * </b></p>
	 * @param formMap フォーム項目
	 * @param loginDto ログイン情報DTO
	 */
	public void registSenseki(Map<String, Object> formMap, LoginDto loginDto);
	
	/**
	 * セレクトボックス用選手名取得
	 * @param loginDtoログイン情報DTO
	 * @return 選手名
	 */
	public Map<String, String> searchSelectboxSenshuNm(LoginDto loginDto);
	
	
}