package cashbook.action.sensekireg;

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
import cashbook.service.sensekireg.SensekiRegService;
import cashbook.util.CommonUtil;

/**
 * 戦績登録画面 登録・更新アクションクラス
 * @author soppra
 */
public class SensekiRegistInsUpdAction extends BaseAction {

	/** 戦績サービス */
	private SensekiRegService sensekiRegService;

	/**
	 * 戦績サービスを設定します。
	 * @param sensekiRegService 戦績サービス
	 */
	public void setSensekiRegService(SensekiRegService sensekiRegService) {
		this.sensekiRegService = sensekiRegService;
	}

	/**
	 * <p>
	 * 戦績登録画面
	 * <br>登録・更新処理
	 * </p>
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
		// 登録・更新処理
		sensekiRegService.registInsUpd(formMap, loginDto);

		// 登録成功メッセージをセッションに設定
		request.getSession().setAttribute(SESSION_REGIST_MESSAGE_SENSEKI, MSG_SUCCESS_INSERT);

		// 処理成功時の遷移先を指定する。
		return map.findForward(ACTION_FOWARD_SUCCESS);

	}
}
