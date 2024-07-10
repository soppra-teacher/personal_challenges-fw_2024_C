package cashbook.action.sensekireg;

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
import cashbook.dto.sensekireg.SensekiRegistDto;
import cashbook.service.sensekireg.SensekiRegService;
import cashbook.util.CommonUtil;
import cashbook.util.SensekiRegConst;

/**
 * 戦績登録画面 初期表示アクションクラス
 * @author soppra
 */
public class SensekiRegistInitAction extends BaseAction {

	/** 戦績サービス */
	private SensekiRegService sensekiRegService;

	/**
	 * 戦績サービスを設定します。
	 * @param sensekiService 戦績サービス
	 */
	public void setSensekiRegService(SensekiRegService sensekiRegService) {
		this.sensekiRegService = sensekiRegService;
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

		/*---------------------------------------------------*
		 * 1．セッションから表示するメッセージを取得する。  *
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
		SensekiRegistDto dto = sensekiRegService.registInit(formMap,loginDto);

		// 取得した情報をリクエストに設定
		request.setAttribute(SensekiRegConst.FORM_SENSEKI_REGIST, dto);
		// 取得した情報をセッションに設定
		request.getSession().setAttribute(SESSION_REGIST_DTO_SENSEKI, dto);

		// 処理成功時の遷移先を指定する。
		return map.findForward(ACTION_FOWARD_SUCCESS);
	}
}