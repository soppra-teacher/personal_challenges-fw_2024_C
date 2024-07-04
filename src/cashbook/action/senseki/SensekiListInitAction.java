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
import cashbook.dto.senseki.SensekiListDto;
import cashbook.service.senseki.SensekiService;
import cashbook.util.CommonUtil;
import cashbook.util.SensekiConst;

/**
 * 個人戦績メンテ画面 初期表示アクションクラス
 * @author soppra
 */
public class SensekiListInitAction extends BaseAction {

	/** 個人戦績サービス */
	private SensekiService sensekiService;

	/**
	 * 個人戦績サービスを設定します。
	 * @param sensekiService 個人戦績サービス
	 */
	public void setSensekiService(SensekiService sensekiService) {
		this.sensekiService = sensekiService;
	}
	
	/**
	 * <p><b>
	 * 個人戦績メンテ画面
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

		// セッションからフォームの値を取得
		Map<String, Object> formMap = CommonUtil.getFormMap((DynaActionForm) request.getSession().getAttribute(SESSION_LIST_DTO_SEISEKI));

		// セッションからメッセージを取得する。
		String messageKey = CommonUtil.getStr(request.getSession().getAttribute(SESSION_LIST_MESSAGE_SENSEKI));

		// 取得できた場合
		if (!EMPTY.equals(messageKey)) {
			// 取得したメッセージを表示する。
			ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(messageKey));
			saveMessages(request, messages);
			// セッションからメッセージを削除する。
			request.getSession().removeAttribute(SESSION_LIST_MESSAGE_SENSEKI);

		}
      
		// 個人戦績画面 検索処理
		SensekiListDto dto = sensekiService.listSearch(formMap,loginDto);

		// 取得した情報をリクエストに登録
		request.setAttribute(SensekiConst.FORM_SENSEKI_LIST, dto);
		// 取得した情報をセッションに登録
		request.getSession().setAttribute(SESSION_LIST_DTO_SENSEKI, dto);

		
		
		//総成績画面からのformを取得し、セッションに設定
		request.getSession().setAttribute(SESSION_LIST_DTO_SEISEKI, form);

		// 処理成功時の遷移先を指定する。
		return map.findForward(ACTION_FOWARD_SUCCESS);
	}
}
