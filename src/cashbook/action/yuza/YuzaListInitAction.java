package cashbook.action.yuza;

import static cashbook.util.Const.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cashbook.action.common.BaseAction;
import cashbook.dto.common.LoginDto;
import cashbook.dto.yuza.YuzaListDto;
import cashbook.service.yuza.YuzaService;
import cashbook.util.YuzaConst;

/**
 * ユーザーマスタメンテ画面 初期表示アクションクラス
 * @author soppra
 */
public class YuzaListInitAction extends BaseAction {

	/** ユーザーマスタサービス */
	private YuzaService yuzaService;

	/**
	 * ユーザーマスタサービスを設定します。
	 * @param yuzaService ユーザーマスタサービス
	 */
	public void setYuzaService(YuzaService yuzaService) {
		this.yuzaService = yuzaService;
	}

	/**
	 * <p><b>
	 * ユーザーマスタメンテ画面
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

		// ユーザーマスタ登録画面の戻り先をセッションから削除する。
		request.getSession().removeAttribute(SESSION_REGIST_BACK_YUZA);

		// ユーザーマスタメンテ初期表示情報を取得
		YuzaListDto dto = yuzaService.listInit();

		// 取得した情報をリクエストに設定
		request.setAttribute(YuzaConst.FORM_YUZA_LIST, dto);
		// 取得した情報をセッションに設定
		request.getSession().setAttribute(SESSION_REGIST_DTO_KOJIN, dto);

		// 処理成功時の遷移先を指定する。
		return map.findForward(ACTION_FOWARD_SUCCESS);
	}
}
