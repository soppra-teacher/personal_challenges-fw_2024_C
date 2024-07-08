package cashbook.action.seiseki;

import static cashbook.util.Const.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import cashbook.action.common.BaseAction;
import cashbook.dto.common.LoginDto;
import cashbook.dto.seiseki.SeisekiListDto;
import cashbook.service.seiseki.SeisekiService;
import cashbook.util.CommonUtil;

/**
 * 成績画面 初期表示アクションクラス
 * @author soppra
 */
public class SeisekiListInitAction extends BaseAction {

	/** 成績サービス */
	private SeisekiService seisekiService;

	/**
	 * 成績サービスを設定する。
	 * @param seisekiService 成績サービス
	 */
	public void setSeisekiService(SeisekiService seisekiService) {
		this.seisekiService = seisekiService;
	}

	/**
	 * <p><b>
	 * 成績画面
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

		
		// セッションからメッセージを取得する。
		String messageKey = CommonUtil.getStr(request.getSession().getAttribute(SESSION_LIST_MESSAGE_SEISEKI));

		// 取得できた場合
		if (!EMPTY.equals(messageKey)) {
			// 取得したメッセージを表示する。
			ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(messageKey));
			saveMessages(request, messages);
			// セッションからメッセージを削除する。
			request.getSession().removeAttribute(SESSION_LIST_MESSAGE_SEISEKI);

		}

		// 成績画面 初期表示処理
		SeisekiListDto dto = seisekiService.listInit(loginDto);

		// 取得した情報をセッションに設定
		request.getSession().setAttribute(SESSION_LIST_DTO_SEISEKI, dto);

		// 処理成功時の遷移先を指定する。
		return map.findForward(ACTION_FOWARD_SUCCESS);
	}
}
