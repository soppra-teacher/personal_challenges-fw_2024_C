package cashbook.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cashbook.dto.user.UserRegistDto;
import cashbook.util.Const;

/**
 * ユーザーマスタ登録画面 初期表示アクションクラス 
 * ログイン後：BaseActionクラスを継承する
 * ログイン前：Actionクラスを継承する
 * Q: 
 * @author soppra
 */
public class UserRegistInitAction extends Action {

	
	
	/**
	 * <p><b>
	 * ログアウト画面
	 * <br>ログアウト処理
	 * </b></p>
	 * struts-configのActionに設定された場合に起動する処理です。<br>
	 *
	 * @param map      アクションマッピング
	 * @param form     フォーム
	 * @param request  リクエスト
	 * @param response レスポンス
	 * @return アクションフォワード
	 * @throws Exception すべての例外
	 */
	@Override
	public ActionForward execute(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("userRegistForm", new UserRegistDto());
		
		request.getSession().setAttribute("USER_REGIST_DTO", new UserRegistDto());

		
		// 処理成功時の遷移先を指定する。
		return map.findForward(Const.ACTION_FOWARD_SUCCESS);
	}
	

//	/** ユーザーマスタサービス */
//	private UserService userService;
//
//	/**
//	 * ユーザーマスタサービスを設定します。
//	 * @param userService ユーザーマスタサービス
//	 */
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
//// =======================================自分で追加した機能==================================================
//	
//	protected ActionForward doProcess(ActionMapping map, ActionForm form,
//		HttpServletRequest request, HttpServletResponse response, LoginDto loginDto) throws Exception {
//		
//		
//		request.setAttribute("userRegistForm", new UserRegistDto());
//		
//		request.getSession().setAttribute("USER_REGIST_DTO", new UserRegistDto());
		
//		// 処理成功時の遷移先を指定する。
//		return map.findForward(Const.ACTION_FOWARD_SUCCESS);
//		
//		
//	}
}	
