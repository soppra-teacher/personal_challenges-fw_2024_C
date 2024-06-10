package cashbook.action.user;

import static cashbook.util.Const.*;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;

import cashbook.action.common.BaseAction;
import cashbook.dto.common.LoginDto;
import cashbook.dto.user.UserRegistDto;
import cashbook.service.user.UserService;
import cashbook.util.CommonUtil;
import cashbook.util.UserConst;

/**
 * ユーザーマスタ登録画面 初期表示アクションクラス
 * @author soppra
 */
public class UserRegistInitAction extends BaseAction {

	/** ユーザーマスタサービス */
	private UserService userService;

	/**
	 * ユーザーマスタサービスを設定します。
	 * @param userService ユーザーマスタサービス
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * <p><b>
	 * ユーザーマスタ登録画面
	 * <br>初期表示処理
	 * </b></p>
	 *
	 * @param map      アクションマッピング
	 * @param form     フォーム
	 * @param request  リクエスト
	 * @param response レスポンス
	 * @param loginDto ログイン情報DTO
	 * @return アクションフォワード
	 * @throws Exception すべての例外
	 */
	protected ActionForward doProcess(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response, LoginDto loginDto) throws Exception {

		// フォームの値を取得する。
		Map<String, Object> formMap = CommonUtil.getFormMap((DynaActionForm) form);

		// 戻り先をセッションから取得する。
		String backAction = CommonUtil.getStr(request.getSession().getAttribute(SESSION_REGIST_BACK_USER));

		// セッションから取得できない場合
		if (EMPTY.equals(backAction)) {

			// ユーザーIDがフォームに設定されていない場合
			if (CommonUtil.isNull(CommonUtil.getStr(formMap.get(UserConst.KEY_USER_ID)))) {
				// メニューからの遷移と判定
				backAction = ACTION_FOWARD_BACK_MENU;

			} else {
				// ユーザーマスタメンテからの遷移の場合
				backAction = ACTION_FOWARD_BACK_LIST;

			}
			// セッションに戻り先を保持する。
			request.getSession().setAttribute(SESSION_REGIST_BACK_USER, backAction);
		}

		// 再検索用のユーザーIDをセッションから取得する。
		Map<String, Object> sessionMap = CommonUtil.getSessionMap(request, SESSION_REGIST_RE_SEARCH_USER);

		// セッションから取得できた場合
		if (sessionMap != null) {
			// 画面にユーザーIDを設定する。
			formMap.put(UserConst.KEY_USER_ID, sessionMap.get(UserConst.KEY_USER_ID));
			// セッションに保持しているユーザーIDを削除する。
			request.getSession().removeAttribute(SESSION_REGIST_RE_SEARCH_USER);

		}

		// メッセージをセッションから取得する。
		String messageKey = CommonUtil.getStr(request.getSession().getAttribute(SESSION_REGIST_MESSAGE_USER));

		// セッションから取得できた場合
		if (!EMPTY.equals(messageKey)) {
			ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(messageKey));
			saveMessages(request, messages);
			request.getSession().removeAttribute(SESSION_REGIST_MESSAGE_USER);

		}

		// 初期表示取得
		UserRegistDto dto = userService.registInit(formMap);

		// 取得した情報をリクエストに設定
		request.setAttribute(UserConst.FORM_USER_REGIST, dto);
		// 取得した情報をセッションに設定
		request.getSession().setAttribute(SESSION_REGIST_DTO_USER, dto);

		// 処理成功時の遷移先を指定する。
		return map.findForward(ACTION_FOWARD_SUCCESS);
	}
}
