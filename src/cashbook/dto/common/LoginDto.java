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
	 * @return 個人ＩＤ
	 */
	public String getUserId() {
	    return userId;
	}
	
	/**
	 * 個人名を設定します。
	 * @param kojinNm 個人名
	 */
	public void setUserId(String userId) {
	    this.userId = userId;
	}
	
	/**
	 * パスワードを取得します。
	 * @return 個人ＩＤ
	 */
	public String Pass() {
	    return pass;
	}
	
	/**
	 * パスワードを設定します。
	 * @param kojinNm 個人名
	 */
	public void setPass(String pass) {
	    this.pass = pass;
	}
}
	




