package cashbook.service.yuza;

import java.util.Map;

import cashbook.dto.common.LoginDto;
import cashbook.dto.yuza.YuzaListDto;
import cashbook.dto.yuza.YuzaRegistDto;

/**
 * ユーザーサービスインターフェース
 * @author soppra
 *
 */
public interface YuzaService {

	/**
	 *
	 * @return
	 */
	public YuzaListDto listInit();

	/**
	 *
	 * @param formMap
	 * @return
	 */
	public YuzaListDto listSearch(Map<String, Object> formMap);

	/**
	 *
	 * @param formMap
	 * @param loginDto
	 */
	public void listDelete(Map<String, Object> formMap, LoginDto loginDto);

	/**
	 *
	 * @param formMap
	 * @return
	 */
	public YuzaRegistDto registInit(Map<String, Object> formMap);

	/**
	 *
	 * @param formMap
	 * @param loginDto
	 * @throws Exception
	 */
	public void registInsUpd(Map<String, Object> formMap, LoginDto loginDto) throws Exception;
}
