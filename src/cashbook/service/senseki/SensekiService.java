package cashbook.service.senseki;

import java.util.Map;

import cashbook.dto.common.LoginDto;
import cashbook.dto.senseki.SensekiListDto;
import cashbook.dto.senseki.SensekiRegistDto;
/**
 * 個人サービスインターフェース
 * @author soppra
 *
 */
public interface SensekiService {

	/**
	 *
	 * @return
	 */
	public SensekiListDto listInit(Map<String, Object> formMap);

	/**
	 *
	 * @param formMap
	 * @param loginDto
	 * @return
	 */
	public SensekiListDto listSearch(Map<String, Object> formMap,LoginDto loginDto);

	/**
	 *
	 * @param formMap
	 * @param loginDto
	 */
	public void listDelete(Map<String, Object> formMap, LoginDto loginDto);
	
	/**
	 * <p><b>
	 * 戦績画面
	 * <br>初期表示処理
	 * </b></p>
	 * @return SensekiListDto 戦績メンテDTO
	 * @param loginDto
	 */
	public SensekiRegistDto listInit(LoginDto loginDto);

	/**
	 * <p><b>
	 * 戦績登録画面
	 * </b></p>
	 * @param  formMap       画面項目
	 * @return SensekiListDto 戦績メンテDTO
	 * @param loginDto
	 */
	public SensekiRegistDto registInit(Map<String, Object> formMap,LoginDto loginDto);

	/**
	 * <p><b>
	 * 戦績登録画面
	 * <br>登録・更新処理
	 * </b></p>
	 * @param formMap  画面項目
	 * @param loginDto ログイン情報DTO
	 */
	public void registInsUpd(Map<String, Object> formMap, LoginDto loginDto) throws Exception;


	
}
