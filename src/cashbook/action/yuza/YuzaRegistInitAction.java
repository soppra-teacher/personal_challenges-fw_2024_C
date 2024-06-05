package cashbook.action.yuza;

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
import cashbook.dto.yuza.YuzaRegistDto;
import cashbook.service.yuza.YuzaService;
import cashbook.util.CommonUtil;
import cashbook.util.YuzaConst;

/**
 * ユーザー登録画面 初期表示アクションクラス
 * @author soppra
 */
public class YuzaRegistInitAction extends BaseAction {

	/** ユーザーマスタサービス */
	private YuzaService yuzaService;

	/**
	 * ユーザーマスタサービスを設定します。
	 * @param yuzaService ユーザーマスタサービス
	 */
	public void setYuzaService(YuzaService yuzaService) {
		this.yuzaService = yuzaService;
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
		String backAction = CommonUtil.getStr(request.getSession().getAttribute(SESSION_REGIST_BACK_YUZA));

		// セッションから取得できない場合
		if (EMPTY.equals(backAction)) {

			// ユーザーIDがフォームに設定されていない場合
			if (CommonUtil.isNull(CommonUtil.getStr(formMap.get(YuzaConst.KEY_YUZA_ID)))) {
				// メニューからの遷移と判定
				backAction = ACTION_FOWARD_BACK_MENU;

			} else {
				// ユーザーマスタメンテからの遷移の場合
				backAction = ACTION_FOWARD_BACK_LIST;

			}
			// セッションに戻り先を保持する。
			request.getSession().setAttribute(SESSION_REGIST_BACK_YUZA, backAction);
		}

		// 再検索用のユーザーIDをセッションから取得する。
		Map<String, Object> sessionMap = CommonUtil.getSessionMap(request, SESSION_REGIST_RE_SEARCH_YUZA);

		// セッションから取得できた場合
		if (sessionMap != null) {
			// 画面にユーザーIDを設定する。
			formMap.put(YuzaConst.KEY_YUZA_ID, sessionMap.get(YuzaConst.KEY_YUZA_ID));
			// セッションに保持しているユーザーIDを削除する。
			request.getSession().removeAttribute(SESSION_REGIST_RE_SEARCH_YUZA);

		}

		// メッセージをセッションから取得する。
		String messageKey = CommonUtil.getStr(request.getSession().getAttribute(SESSION_REGIST_MESSAGE_YUZA));

		// セッションから取得できた場合
		if (!EMPTY.equals(messageKey)) {
			ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(messageKey));
			saveMessages(request, messages);
			request.getSession().removeAttribute(SESSION_REGIST_MESSAGE_YUZA);

		}

		// 初期表示取得
		YuzaRegistDto dto = yuzaService.registInit(formMap);

		// 取得した情報をリクエストに設定
		request.setAttribute(YuzaConst.FORM_YUZA_REGIST, dto);
		// 取得した情報をセッションに設定
		request.getSession().setAttribute(SESSION_REGIST_DTO_YUZA, dto);

		// 処理成功時の遷移先を指定する。
		return map.findForward(ACTION_FOWARD_SUCCESS);
	}
}
