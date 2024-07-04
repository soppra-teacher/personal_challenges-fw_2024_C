package cashbook.dto.common;

/**
 * ログイン情報DTOクラス
 * @author soppra
 */
public class LoginDto {

	/** ユーザーID 取得 */
	private String userId;
	/** パスワード 取得 */
	private String pass;

	/**
	 * ユーザーＩＤを取得します。
	 * @return ユーザーＩＤ
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * ユーザーＩＤを設定します。
	 * @param userId ユーザーＩＤ
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * パスワードを取得します。
	 * @return パスワード
	 */
	public String Pass() {
		return pass;
	}

	/**
	 * パスワードを設定します。
	 * @param pass パスワード
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
}
