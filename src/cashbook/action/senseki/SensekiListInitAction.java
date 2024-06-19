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

		// 個人マスタ登録画面の戻り先をセッションから削除する。
		//request.getSession().removeAttribute(SESSION_REGIST_BACK_SENSEKI);

		// 個人マスタメンテ初期表示情報を取得
		//SensekiListDto dto = sensekiService.listInit();
		

		// 取得した情報をリクエストに設定
		//request.setAttribute(SensekiConst.FORM_SENSEKI_LIST, dto);
		// 取得した情報をセッションに設定
		//request.getSession().setAttribute(SESSION_LIST_DTO_SENSEKI, dto);

		// 処理成功時の遷移先を指定する。
		return map.findForward(ACTION_FOWARD_SUCCESS);
	}
}
