package cashbook.service.seiseki;

import java.util.Map;

import cashbook.dto.common.LoginDto;
import cashbook.dto.seiseki.SeisekiListDto;

/**
 * 成績マスタサービスインターフェース
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
	 * @param loginDto
	 * @return
	 */
	public SeisekiListDto listSearch(LoginDto loginDto);

	/**
	 * @param formMap
	 * @param loginDto
	 * @throws Exception
	 */
	public void registNewSenshu(Map<String, Object> formMap, LoginDto loginDto) throws Exception;
}
