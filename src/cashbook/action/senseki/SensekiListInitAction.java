package cashbook.action.senseki;

import static cashbook.util.Const.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cashbook.action.common.BaseAction;
import cashbook.dto.common.LoginDto;
import cashbook.service.senseki.SensekiService;

/**
 * 個人マスタメンテ画面 初期表示アクションクラス
 * @author soppra
 */
public class SensekiListInitAction extends BaseAction {

	/** 個人マスタサービス */
	//private SensekiService sensekiService;

	/**
	 * 個人マスタサービスを設定します。
	 * @param sensekiService 個人マスタサービス
	 */
	public void setSensekiService(SensekiService sensekiService) {
		//this.sensekiService = sensekiService;
	}

	/**
	 * <p><b>
	 * 個人マスタメンテ画面
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

		//総成績画面からのformを取得し、セッションに設定
		request.getSession().setAttribute(SESSION_LIST_DTO_SEISEKI, form);

		// 処理成功時の遷移先を指定する。
		return map.findForward(ACTION_FOWARD_SUCCESS);
	}
}
