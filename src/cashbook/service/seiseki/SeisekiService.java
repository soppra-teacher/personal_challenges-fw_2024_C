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
	 * 成績画面初期表示メソッド
	 * @param loginDto
	 */
	public SeisekiListDto listInit(LoginDto loginDto);

	/**
	 * 新規選手登録メソッド
	 * @param formMap
	 * @param loginDto
	 */
	public void registNewSenshu(Map<String, Object> formMap, LoginDto loginDto) throws Exception;
}
