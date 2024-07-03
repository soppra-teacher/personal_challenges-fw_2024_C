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
import cashbook.util.CommonUtil;
import cashbook.util.Const;

/**
 * ユーザーマスタ登録画面 初期表示アクションクラス 
 * ログイン後：BaseActionクラスを継承する
 * ログイン前：Actionクラスを継承する
 * @author soppra
 */
public class UserRegistInitAction extends Action {

	/** ユーザー登録画面マスタサービス */
//	private UserService userService;

	/**
	 * ユーザー登録サービスを設定します。
	 * @param himokuService 費目マスタサービス
	 */
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}

	/**
	 * <p><b>
	 * ユーザー登録画面
	 * <br>登録処理
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

		// フォームの値を取得する。
		Map<String, Object> formMap = CommonUtil.getFormMap((DynaActionForm) form);

		/*-------------------------------------------------*
		 * １．セッションから戻り先のアクションを取得する。*
		 *-------------------------------------------------*/
		// 戻り先をセッションから取得する。
		String backAction = CommonUtil.getStr(request.getSession().getAttribute(SESSION_REGIST_BACK_USER));

		/*---------------------------------------------------*
		 * 2．セッションから表示するメッセージを取得する。  *
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

		// 処理成功時の遷移先を指定する。
		return map.findForward(Const.ACTION_FOWARD_SUCCESS);
	}
}
