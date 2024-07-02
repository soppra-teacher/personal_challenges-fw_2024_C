package cashbook.service.user;

import java.util.Map;

/**
 * ユーザーサービスインターフェース
 * @author soppra
 *
 */
public interface UserService {

	/**
	 *
	 * @param formMap
	 * @throws Exception
	 */
	public void registInsUpd(Map<String, Object> formMap) throws Exception;

}
