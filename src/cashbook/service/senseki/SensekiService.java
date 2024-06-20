package cashbook.service.senseki;

import java.util.Map;

import cashbook.dto.common.LoginDto;
import cashbook.dto.senseki.SensekiListDto;
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
	 * @return
	 */
	public SensekiListDto listSearch(Map<String, Object> formMap);

	/**
	 *
	 * @param formMap
	 * @param loginDto
	 */
	public void listDelete(Map<String, Object> formMap, LoginDto loginDto);

}
