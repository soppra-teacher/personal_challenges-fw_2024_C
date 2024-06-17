package cashbook.action.user;

import static cashbook.util.Const.*;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;

import cashbook.dto.user.UserRegistDto;
import cashbook.service.user.UserService;
import cashbook.util.CommonUtil;
import cashbook.util.Const;
import cashbook.util.HimokuConst;
import cashbook.util.UserConst;

/**
 * ユーザーマスタ登録画面 初期表示アクションクラス 
 * ログイン後：BaseActionクラスを継承する
 * ログイン前：Actionクラスを継承する
 * Q: 
 * @author soppra
 */
public class UserRegistInitAction extends Action {

	/** ユーザー登録画面マスタサービス */
	private UserService userService;

	
	/**
	 * ユーザー登録サービスを設定します。
	 * @param himokuService 費目マスタサービス
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	
	/**
	 * <p><b>
	 * ログアウト画面
	 * <br>ログアウト処理
	 * </b></p>
	 * struts-configのActionに設定された場合に起動する処理です。<br>
	 *
	 * @param map      アクションマッピング
	 * @param form     フォーム
	 * @param request  リクエスト
	 * @param response レスポンス
	 * @return アクションフォワード
	 * @throws Exception すべての例外
	 */
	@Override
	public ActionForward execute(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		// ログイン成功
		request.setAttribute("userRegistForm", new UserRegistDto());
		//// ログイン情報取得
		request.getSession().setAttribute("USER_REGIST_DTO", new UserRegistDto());
		
		//=========================試し==============================================================================================
		
		
		// フォームの値を取得する。
		Map<String, Object> formMap = CommonUtil.getFormMap((DynaActionForm) form);

		/*-------------------------------------------------*
		 * １．セッションから戻り先のアクションを取得する。*
		 *-------------------------------------------------*/
		// 戻り先をセッションから取得する。
		String backAction = CommonUtil.getStr(request.getSession().getAttribute(SESSION_REGIST_BACK_USER));
		// セッションから取得できない場合
		//if (backAction == null) {
		if (EMPTY.equals(backAction)) {

			// 費目コードがフォームに設定されていない場合
			if (CommonUtil.isNull(CommonUtil.getStr(formMap.get(HimokuConst.KEY_HIMOKU_CD)))) {
				// メニューからの遷移と判定
				backAction = ACTION_FOWARD_BACK_MENU;

			} else {
				// 費目マスタメンテからの遷移の場合
				backAction = ACTION_FOWARD_BACK_LIST;

			}
			// セッションに戻り先を保持する。
			request.getSession().setAttribute(SESSION_REGIST_BACK_HIMOKU, backAction);
		}

		/*---------------------------------------------------*
		 * ２．セッションから再検索用の費目コードを取得する。*
		 *---------------------------------------------------*/
		// 再検索用の費目コードをセッションから取得する。
		Map<String, Object> sessionMap = CommonUtil.getSessionMap(request, SESSION_REGIST_RE_SEARCH_HIMOKU);

		// セッションから取得できた場合
		if (sessionMap != null) {

			// 画面に費目コードを設定する。
			formMap.put(UserConst.KEY_USER_ID, sessionMap.get(UserConst.KEY_USER_ID));
			// セッションに保持している費目コードを削除する。
			request.getSession().removeAttribute(SESSION_REGIST_RE_SEARCH_USER);
		}

		/*---------------------------------------------------*
		 * ３．セッションから表示するメッセージを取得する。  *
		 *---------------------------------------------------*/
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//=====================================試し================================================================================

		// 処理成功時の遷移先を指定する。
		return map.findForward(Const.ACTION_FOWARD_SUCCESS);
	}
}	
