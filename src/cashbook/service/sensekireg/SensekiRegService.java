package cashbook.service.sensekireg;

import java.util.Map;

import cashbook.dto.common.LoginDto;
import cashbook.dto.sensekireg.SensekiRegistDto;

/**
 * 個人戦績登録サービスインターフェース
 * @author soppra
 *
 */
public interface SensekiRegService {

	/**
	 * <p><b>
	 * 個人戦績登録画面
	 * <br>初期表示
	 * </b></p>
	 * @param  formMap        画面項目
	 * @param  loginDto       ログイン情報DTO
	 * @return SensekiListDto 個人戦績登録DTO
	 */
	public SensekiRegistDto registInit(Map<String, Object> formMap, LoginDto loginDto);

	/**
	 * <p><b>
	 * 個人戦績登録画面
	 * <br>登録処理
	 * </b></p>
	 * @param formMap  画面項目
	 * @param loginDto ログイン情報DTO
	 * @throws Exception
	 */
	public void registInsUpd(Map<String, Object> formMap, LoginDto loginDto) throws Exception;

}