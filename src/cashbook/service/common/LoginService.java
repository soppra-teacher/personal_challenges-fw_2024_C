package cashbook.service.common;

import java.util.Map;

import cashbook.dto.common.LoginDto;

public interface LoginService {
	
	/**
	 * ログイン実行メソッド
	 * @param formMap
	 * @return ログイン情報DTO
	 */
	public LoginDto execute(Map<String, Object> formMap);
}