package cashbook.service.senseki;
import java.util.Map;

import cashbook.dto.common.LoginDto;
import cashbook.dto.senseki.SensekiRegistDto;

/**
 * 戦績サービス
 * @author soppra
 */
public interface SensekiService {

	/**
	 * <p><b>
	 * 戦績メンテ画面
	 * <br>初期表示処理
	 * </b></p>
	 * @return SensekiListDto 戦績メンテDTO
	 */
	public SensekiRegistDto listInit();

	/**
	 * <p><b>
	 * 戦績登録画面
	 * </b></p>
	 * @param  formMap       画面項目
	 * @return SensekiListDto 戦績メンテDTO
	 */
	public SensekiRegistDto registInit(Map<String, Object> formMap);

	/**
	 * <p><b>
	 * 費目マスタ登録画面
	 * <br>登録・更新処理
	 * </b></p>
	 * @param formMap  画面項目
	 * @param loginDto ログイン情報DTO
	 */
	public void registInsUpd(Map<String, Object> formMap, LoginDto loginDto) throws Exception;


	

}