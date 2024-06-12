package cashbook.service.seiseki;

import java.util.Map;

import cashbook.dto.common.LoginDto;
import cashbook.dto.seiseki.SeisekiListDto;

/**
 * 成績サービスインターフェース
 * @author soppra
 *
 */
public interface SeisekiService {

	/**
	 *
	 * @return
	 */
	public SeisekiListDto listInit();

	/**
	 *
	 * @param formMap
	 * @return
	 */
	public SeisekiListDto listSearch(Map<String, Object> formMap,LoginDto loginDto);

	/**
	 *
	 * @param formMap
	 * @param loginDto
	 * @throws Exception
	 */
	public void registInsUpd(Map<String, Object> formMap, LoginDto loginDto) throws Exception;
	
	/**
	 * @param formMap
	 * @param loginDto
	 * @throws Exception
	 */
	public void registNewSenshu(Map<String, Object> formMap, LoginDto loginDto) throws Exception;
}
