package cashbook.dao.seiseki;

import java.util.List;
import java.util.Map;

import cashbook.dto.common.LoginDto;

/**
 * 成績マスタDAOインターフェース
 * @author soppra
 */
public interface SeisekiDao {

	/**
	 * 成績マスタ一覧を検索する
	 * @param formMap フォーム項目
	 * @return 成績マスタ一覧
	 */
	public List<Map<String, String>> searchSeiseki(LoginDto loginDto);


	/**
	 * 選手マスタを登録する
	 * @throws Exception
	 */
	public void registSenshu(Map<String, Object> formMap, LoginDto loginDto);

}
