package cashbook.dao.seiseki;

import java.util.List;
import java.util.Map;

import cashbook.dto.common.LoginDto;

/**
 * 成績DAOインターフェース
 * @author soppra
 */
public interface SeisekiDao {

	/**
	 * 成績一覧を検索する
	 * @param loginDto
	 * @return 成績一覧
	 */
	public List<Map<String, String>> searchSeiseki(LoginDto loginDto);


	/**
	 * 選手マスタに新規選手登録する
	 * @param loginDto
	 */
	public void registSenshu(Map<String, Object> formMap, LoginDto loginDto);

}
