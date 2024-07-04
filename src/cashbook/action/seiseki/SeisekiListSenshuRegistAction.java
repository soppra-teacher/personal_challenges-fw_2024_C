package cashbook.action.seiseki;

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
import cashbook.service.seiseki.SeisekiService;
import cashbook.util.CommonUtil;

/**
 * 成績画面登録アクションクラス
 * @author soppra
 */
public class SeisekiListSenshuRegistAction extends BaseAction {

	/** 成績サービス */
	private SeisekiService seisekiService;

	/**
	 * 成績サービスを設定します。
	 * @param seisekiService 成績サービス
	 */
	public void setSeisekiService(SeisekiService seisekiService) {
		this.seisekiService = seisekiService;
	}

	/**
	 * <p><b>
	 * 成績画面
	 * <br>登録処理
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

		// 選手登録処理
		seisekiService.registNewSenshu(formMap, loginDto);
		
		// 登録完了メッセージをセッションに保持
		request.getSession().setAttribute(SESSION_LIST_MESSAGE_SEISEKI, MSG_SUCCESS_INSERT);
		
		// 処理成功時の遷移先を指定する。
		return map.findForward(ACTION_FOWARD_SUCCESS);
	}
}
