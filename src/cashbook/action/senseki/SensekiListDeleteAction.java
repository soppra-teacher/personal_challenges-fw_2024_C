package cashbook.action.senseki;

import static cashbook.util.Const.*;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import cashbook.action.common.BaseAction;
import cashbook.dto.common.LoginDto;
import cashbook.service.senseki.SensekiService;
import cashbook.util.CommonUtil;

/**
 * 個人戦績画面削除アクションクラス
 * @author soppra
 */
public class SensekiListDeleteAction extends BaseAction {

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
	 * 個人戦績画面
	 * <br>削除処理
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
		
		// フォームの値を取得
		Map<String, Object> formMap = CommonUtil.getFormMap((DynaActionForm) form);
		
		// 削除対象チェック
		if (checkDeleteTarget((String[]) formMap.get(ITEM_CHECKBOX_DELETE), request)) {
			return map.getInputForward();
		}

		// 削除処理
		sensekiService.listDelete(formMap, loginDto);

		// 削除完了メッセージをセッションに保持
		request.getSession().setAttribute(SESSION_LIST_MESSAGE_SENSEKI, MSG_SUCCESS_DELETE);

		// 処理成功時の遷移先を指定する。
		return map.findForward(ACTION_FOWARD_SUCCESS);
	}
}
