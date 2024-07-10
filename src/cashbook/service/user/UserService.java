package cashbook.service.user;

import java.util.Map;

/**
 * ユーザーサービスインターフェース
 * @author soppra
 *
 */
public interface UserService {

	/**
	 * 登録画面登録・更新メソッド
	 * @param formMap
	 * @throws Exception
	 */
	public void registInsUpd(Map<String, Object> formMap) throws Exception;

}
