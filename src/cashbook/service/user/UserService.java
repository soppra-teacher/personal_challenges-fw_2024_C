package cashbook.service.user;

import java.util.Map;

import cashbook.dto.common.LoginDto;
import cashbook.dto.user.UserListDto;
import cashbook.dto.user.UserRegistDto;

/**
 * ユーザーサービスインターフェース
 * @author soppra
 *
 */
public interface UserService {

	/**
	 *
	 * @return
	 */
	public UserListDto listInit();

	/**
	 *
	 * @param formMap
	 * @return
	 */
	public UserListDto listSearch(Map<String, Object> formMap);

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
	public UserRegistDto registInit(Map<String, Object> formMap);
	
	
	
	
	public UserRegistDto registInit();

	
	
	
	
	/**
	 *
	 * @param formMap
	 * @throws Exception
	 */
	public void registInsUpd(Map<String, Object> formMap) throws Exception;
}
