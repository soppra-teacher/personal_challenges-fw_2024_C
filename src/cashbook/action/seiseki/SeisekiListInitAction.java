package cashbook.action.seiseki;

import static cashbook.util.Const.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cashbook.action.common.BaseAction;
import cashbook.dto.common.LoginDto;
import cashbook.dto.seiseki.SeisekiListDto;
import cashbook.service.seiseki.SeisekiService;

/**
 * 成績マスタメンテ画面 初期表示アクションクラス
 * @author soppra
 */
public class SeisekiListInitAction extends BaseAction {

	/** 成績マスタサービス */
	private SeisekiService seisekiService;

	/**
	 * 成績マスタサービスを設定します。
	 * @param seisekiService 成績マスタサービス
	 */
	public void setSeisekiService(SeisekiService seisekiService) {
		this.seisekiService = seisekiService;
	}

	/**
	 * <p><b>
	 * 成績マスタメンテ画面
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

		// 成績マスタ登録画面の戻り先をセッションから削除する。
		request.getSession().removeAttribute(SESSION_REGIST_BACK_KOJIN);

		// 成績マスタメンテ初期表示情報を取得
		SeisekiListDto dto = seisekiService.listInit();

		// 取得した情報をセッションに設定
		request.getSession().setAttribute(SESSION_LIST_DTO_SEISEKI, dto);

		// 処理成功時の遷移先を指定する。
		return map.findForward(ACTION_FOWARD_SUCCESS);
	}
}
