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
import cashbook.exception.CommonValidateException;
import cashbook.service.senseki.SensekiService;
import cashbook.util.CommonUtil;
import cashbook.util.SensekiConst;

/**
 * 個人マスタメンテ画面検索アクションクラス
 * @author soppra
 */
public class SensekiListSearchAction extends BaseAction {

	/** 個人マスタサービス */
	private SensekiService sensekiService;

	/**
	 * 個人マスタサービスを設定します。
	 * @param sensekiService 個人マスタサービス
	 */
	public void setSensekiService(SensekiService sensekiService) {
		this.sensekiService = sensekiService;
	}

	/**
	 * <p><b>
	 * 個人マスタメンテ画面
	 * <br>検索処理
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
		SensekiListDto dto = sensekiService.listSearch(formMap);

		// 取得した情報をリクエストに登録
		request.setAttribute(SensekiConst.FORM_SENSEKI_LIST, dto);
		// 取得した情報をセッションに登録
		request.getSession().setAttribute(SESSION_LIST_DTO_SENSEKI, dto);

		// 検索結果が存在しない場合
		if (dto.getList().size() == 0) {
			throw new CommonValidateException(MSG_ERRORS_NO_DATA);
		}

		// 処理成功時の遷移先を指定する。
		return map.findForward(ACTION_FOWARD_SUCCESS);
	}
}
