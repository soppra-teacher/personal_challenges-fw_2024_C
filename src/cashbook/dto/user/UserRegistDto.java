package cashbook.dto.user;

public class UserRegistDto {

	/** ユーザーID */
	private String userId;

	/** パスワード */
	private String pass;
	
	/** パスワード */
	private String pass2;

	
	/**
	 * ユーザーIDを取得します。
	 * @return ユーザーID
	 */

	public String getUserId() {
		return userId;
	}

	/**
	 * ユーザーIDを設定します。
	 * @param userId ユーザーID
	 */

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * パスワードを取得します。
	 * @return パスワード
	 */
	public String getPass() {
		return pass;
	}
	

	/**
	 * パスワードを設定します。
	 * @param pass パスワード
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	/**
	 * パスワードを取得します。
	 * @return パスワード
	 */
	public String getPass2() {
		return pass2;
	}

	/**
	 * パスワードを設定します。
	 * @param pass2 パスワード
	 */
	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}
}
