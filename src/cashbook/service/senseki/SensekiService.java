package cashbook.service.senseki;

import java.util.Map;

import cashbook.dto.common.LoginDto;
import cashbook.dto.senseki.SensekiListDto;
/**
 * 個人戦績インターフェース
 * @author soppra
 *
 */
public interface SensekiService {


	/**
	 * 一覧画面初期表示メソッド
	 * @param formMap
	 * @param loginDto
	 * @return SensekiListDto
	 */
	public SensekiListDto listInit(Map<String, Object> formMap,LoginDto loginDto);

	/**
	 * 一覧画面削除メソッド
	 * @param formMap
	 * @param loginDto
	 */
	public void listDelete(Map<String, Object> formMap, LoginDto loginDto);
	
}
