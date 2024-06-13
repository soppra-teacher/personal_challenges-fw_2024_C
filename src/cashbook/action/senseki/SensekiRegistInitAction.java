package cashbook.action.senseki;

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
import cashbook.dto.senseki.SensekiRegistDto;
import cashbook.service.senseki.SensekiService;
import cashbook.util.CommonUtil;
import cashbook.util.SensekiConst;

/**
 * 戦績登録画面 初期表示アクションクラス
 * @author soppra
 */
public class SensekiRegistInitAction extends BaseAction {

	/** 戦績サービス */
	private SensekiService sensekiService;

	/**
	 * 戦績サービスを設定します。
	 * @param sensekiService 戦績サービス
	 */
	public void setSensekiService(SensekiService sensekiService) {
		this.sensekiService = sensekiService;
	}

	/**
	 * <p><b>
	 * 戦績登録画面
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

		/*-------------------------------------------------*
		 * １．セッションから戻り先のアクションを取得する。*
		 *-------------------------------------------------*/
		// 戻り先をセッションから取得する。
		String backAction = CommonUtil.getStr(request.getSession().getAttribute(SESSION_REGIST_BACK_SENSEKI));
		// セッションから取得できない場合
		//if (backAction == null) {
		if (EMPTY.equals(backAction)) {

			// 戦績コードがフォームに設定されていない場合
			if (CommonUtil.isNull(CommonUtil.getStr(formMap.get(SensekiConst.KEY_SENSEKI_CD)))) {
				// メニューからの遷移と判定
				backAction = ACTION_FOWARD_BACK_MENU;

			} else {
				// 戦績からの遷移の場合
				backAction = ACTION_FOWARD_BACK_LIST;

			}
			// セッションに戻り先を保持する。
			request.getSession().setAttribute(SESSION_REGIST_BACK_SENSEKI, backAction);
		}

		/*---------------------------------------------------*
		 * ２．セッションから再検索用の戦績コードを取得する。*
		 *---------------------------------------------------*/
		// 再検索用の戦績コードをセッションから取得する。
		Map<String, Object> sessionMap = CommonUtil.getSessionMap(request, SESSION_REGIST_RE_SEARCH_SENSEKI);

		// セッションから取得できた場合
		if (sessionMap != null) {

			// 画面に戦績コードを設定する。
			formMap.put(SensekiConst.KEY_SENSEKI_CD, sessionMap.get(SensekiConst.KEY_SENSEKI_CD));
			// セッションに保持している戦績コードを削除する。
			request.getSession().removeAttribute(SESSION_REGIST_RE_SEARCH_SENSEKI);
		}

		/*---------------------------------------------------*
		 * ３．セッションから表示するメッセージを取得する。  *
		 *---------------------------------------------------*/
		// メッセージをセッションから取得する。
		String messageKey = CommonUtil.getStr(request.getSession().getAttribute(SESSION_REGIST_MESSAGE_SENSEKI));

		// セッションから取得できた場合
		if (!EMPTY.equals(messageKey)) {

			ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(messageKey));
			saveMessages(request, messages);
			request.getSession().removeAttribute(SESSION_REGIST_MESSAGE_SENSEKI);
		}

		// 初期表示取得
		System.out.println("--------------初期表示取得-----------------");
		SensekiRegistDto dto = sensekiService.registInit(formMap);

		// 取得した情報をリクエストに設定
		request.setAttribute(SensekiConst.FORM_SENSEKI_REGIST, dto);
		// 取得した情報をセッションに設定
		request.getSession().setAttribute(SESSION_REGIST_DTO_SENSEKI, dto);

		// 処理成功時の遷移先を指定する。
		return map.findForward(ACTION_FOWARD_SUCCESS);
	}
}
