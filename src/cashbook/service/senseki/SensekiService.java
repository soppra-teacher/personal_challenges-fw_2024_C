package cashbook.service.senseki;
import java.util.Map;

import cashbook.dto.common.LoginDto;
import cashbook.dto.senseki.SensekiListDto;
import cashbook.dto.senseki.SensekiRegistDto;

/**
 * 費目マスタサービス
 * @author soppra
 */
public interface SensekiService {

	/**
	 * <p><b>
	 * 費目マスタメンテ画面
	 * <br>初期表示処理
	 * </b></p>
	 * @return SensekiListDto 費目マスタメンテDTO
	 */
	public SensekiListDto listInit();

	/**
	 * <p><b>
	 * 費目マスタメンテ画面
	 * <br>検索処理
	 * </b></p>
	 * @param  formMap       画面項目
	 * @return SensekiListDto 費目マスタメンテDTO
	 */
	public SensekiListDto listSearch(Map<String, Object> formMap);

	/**
	 * <p><b>
	 * 費目マスタメンテ画面
	 * <br>削除処理
	 * </b></p>
	 * @param formMap  画面項目
	 * @param loginDto ログイン情報DTO
	 */
	public void listDelete(Map<String, Object> formMap, LoginDto loginDto);

	/**
	 * <p><b>
	 * 費目マスタ登録画面
	 * <br>検索処理
	 * </b></p>
	 * @param  formMap       画面項目
	 * @return SensekiListDto 費目マスタメンテDTO
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