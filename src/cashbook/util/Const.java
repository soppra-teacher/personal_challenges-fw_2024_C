package cashbook.util;

/**
 * 共通定数クラス
 * @author soppra
 */
public class Const {

	/** 空文字 */
	public static final String EMPTY = "";

	/** 遷移先 成功 */
	public static final String ACTION_FOWARD_SUCCESS = "success";
	/** 遷移先 失敗 */
	public static final String ACTION_FOWARD_ERROR = "error";
	/** 遷移先 検索 */
	public static final String ACTION_FOWARD_SEARCH = "search";
	/** 遷移先 削除 */
	public static final String ACTION_FOWARD_DELETE = "delete";
	/** 遷移先 登録 */
	public static final String ACTION_FOWARD_INSERT = "insert";
	/** 遷移先 更新 */
	public static final String ACTION_FOWARD_UPDATE = "update";
	/** 遷移先 戻る(メニュー) */
	public static final String ACTION_FOWARD_BACK_MENU = "backMenu";
	/** 遷移先 戻る(一覧) */
	public static final String ACTION_FOWARD_BACK_LIST = "backList";
	/** 遷移先 オペレーション */
	public static final String ACTION_FOWARD_OPERATION = "operation";
	/** 遷移先 戻る(世帯一覧) */
	public static final String ACTION_FOWARD_BACK_LIST_SETAI = "backListSetai";
	/** 遷移先 戻る(個別一覧) */
	public static final String ACTION_FOWARD_BACK_LIST_KOBETSU = "backListKobetsu";
	/** 遷移先 新規ユーザー登録画面(新規) */
	public static final String ACTION_FOWARD_BACK_LIST_USER = "backListUser";

	/** パスワード失敗メッセージ */
	public static final String MSG_ERRORS_PASS_ERROR = "PassForm.error.login";
	/** ログイン失敗メッセージ */
	public static final String MSG_ERRORS_LOGIN_ERROR = "loginForm.error.login";
	/** 検索結果0件メッセージ */
	public static final String MSG_ERRORS_NO_DATA = "errors.noData";
	/** 削除対象なしメッセージ */
	public static final String MSG_ERRORS_NO_DELETE = "errors.checkDel";
	/** キー重複データ存在ありメッセージ */
	public static final String MSG_ERRORS_PRIMARY_KEY = "errors.overLap";
	/** 排他エラーメッセージ */
	public static final String MSG_ERRORS_DATA_LOCK = "errors.lock";

	/** 登録完了メッセージ */
	public static final String MSG_SUCCESS_INSERT = "messages.success.insert";
	/** 更新完了メッセージ */
	public static final String MSG_SUCCESS_UPDATE = "messages.success.update";
	/** 削除完了メッセージ */
	public static final String MSG_SUCCESS_DELETE = "messages.success.delete";


	/** 更新日付 */
	public static final String ITEM_REVISION = "revision";
	/** 削除対象チェックボックス */
	public static final String ITEM_CHECKBOX_DELETE = "checkDel";

	/************* セッション情報 *************/
	/** ログイン画面 DTO */
	public static final String SESSION_LOGIN_DTO = "LOGIN_DTO";


	/** 新規ユーザー登録画面 DTO */
	public static final String SESSION_REGIST_DTO_USER = "USER_REGIST_DTO";
	/** 新規ユーザー登録画面 戻り先 */
	public static final String SESSION_REGIST_BACK_USER = "USER_REGIST_BACK";
	/** 新規ユーザー登録画面 再検索値 */
	public static final String SESSION_REGIST_RE_SEARCH_USER = "USER_REGIST_RE_SEARCH";
	/** 新規ユーザー登録画面 メッセージ */
	public static final String SESSION_REGIST_MESSAGE_USER = "USER_REGIST_MESSAGE";
	/** 新規ユーザー用エラーメッセージ1 */
	public static final String MSG_USER_CONSIS_1 = "errors.user.seigosei1";
	/** 新規ユーザー用エラーメッセージ2 */
	public static final String MSG_USER_CONSIS_2 = "errors.user.seigosei2";

	/** 個人戦績登録画面 DTO */
	public static final String SESSION_REGIST_DTO_SENSEKI = "SENSEKI_REGIST_DTO";
	/** 個人戦績登録画面 戻り先 */
	public static final String SESSION_REGIST_BACK_SENSEKI = "SENSEKI_REGIST_BACK";
	/** 個人戦績登録画面 再検索値 */
	public static final String SESSION_REGIST_RE_SEARCH_SENSEKI = "SENSEKI_REGIST_RE_SEARCH";
	/** 個人戦績登録画面 メッセージ */
	public static final String SESSION_REGIST_MESSAGE_SENSEKI = "SENSEKI_REGIST_MESSAGE";
	/** 個人戦績メンテ画面 DTO */
	public static final String SESSION_LIST_DTO_SENSEKI = "SENSEKI_LIST_DTO";
	/** 個人戦績メンテ画面 再検索値 */
	public static final String SESSION_LIST_RE_SEARCH_SENSEKI = "SENSEKI_LIST_RE_SEARCH";
	/** 個人戦績メンテ画面 メッセージ */
	public static final String SESSION_LIST_MESSAGE_SENSEKI = "SENSEKI_LIST_MESSAGE";

	/** 成績マスタメンテ画面 DTO */
	public static final String SESSION_LIST_DTO_SEISEKI = "SEISEKI_LIST_DTO";
	/** 成績マスタメンテ画面 再検索値 */
	public static final String SESSION_LIST_RE_SEARCH_SEISEKI = "SEISEKI_LIST_RE_SEARCH";
	/** 成績マスタメンテ画面 メッセージ */
	public static final String SESSION_LIST_MESSAGE_SEISEKI = "SEISEKI_LIST_MESSAGE";

	/************* コードマスタ *************/
	/** イニング詳細 */
	public static final String CD_BUNRUI_001 = "001";

}
