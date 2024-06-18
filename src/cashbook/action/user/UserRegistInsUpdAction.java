package cashbook.action.user;

import static cashbook.util.Const.*;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;

import cashbook.dto.user.UserRegistDto;
import cashbook.exception.CommonValidateException;
import cashbook.service.user.UserService;
import cashbook.util.CommonUtil;
import cashbook.util.Const;

/**
 * ユーザーマスタ登録画面 登録・更新アクションクラス
 * @author soppra
 */
public class UserRegistInsUpdAction extends Action {
	
	/** ユーザーマスタサービス */
	private UserService userService;
	
	/**
	 * ユーザーマスタサービスを設定します。
	 * @param userService ユーザーマスタサービス
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	
	@Override
	public ActionForward execute(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// ログイン成功
		request.setAttribute("userRegistForm", new UserRegistDto());
		// ログイン情報取得
		request.getSession().setAttribute("USER_REGIST_DTO", new UserRegistDto());

		// フォームの値を取得する。
		Map<String, Object> formMap = CommonUtil.getFormMap((DynaActionForm) form);
		
		
		
		//try-catch 書く
		
		try {

			// 登録・更新
			userService.registInsUpd(formMap);
			System.out.println("UserRegistInsUpdActionの登録・更新");
			// 登録成功メッセージをセッションに設定
			request.getSession().setAttribute(SESSION_REGIST_MESSAGE_USER, MSG_SUCCESS_INSERT);
			//追加
			//request.getSession().setAttribute(SESSION_REGIST_MESSAGE_USER, MSG_SUCCESS_LOGOUT);
			System.out.println("UserRegistInsUpdActionの登録成功メッセージをセッションに設定後");
		} catch (CommonValidateException e) {
		
			ActionErrors errors = new ActionErrors();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getMessageKey()));
			saveErrors(request, errors);
			return map.getInputForward();
		}
		
		// 処理成功時の遷移先を指定する。
		return map.findForward(Const.ACTION_FOWARD_SUCCESS);
	    
		
	}
	
	/**
	 * <p>
	 * ユーザーマスタ登録画面
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
//	protected ActionForward doProcess(ActionMapping map, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response, LoginDto loginDto) throws Exception {

		
		
		// フォームの値を取得する。
	//	Map<String, Object> formMap = CommonUtil.getFormMap((DynaActionForm) form);

		// 世帯主フラグ有無チェック ・いらない
//		if (SETAINUSHI_FLG_ON.equals(formMap.get(UserConst.KEY_SETAINUSI_FLG))) {
//			// チェック済みの場合、パラメータを"1"に設定する。
//			formMap.put(UserConst.KEY_SETAINUSI_FLG_VALUE, SETAINUSHI_ON);
//
//		} else {
//			// 未チェック済の場合、パラメータを"0"に設定する。
//			formMap.put(UserConst.KEY_SETAINUSI_FLG_VALUE, SETAINUSHI_OFF);
//
//		}

		// 世帯ＩＤを設定する　ユーザーIDを設定する
//		formMap.put(SetaiConst.KEY_SETAI_ID, formMap.get(SetaiConst.KEY_SETAI_NM_KEY));
		// 登録・更新
		
//		userService.registInsUpd(formMap, loginDto);

		// フォーム．リビジョンが未設定の場合
//		if (CommonUtil.isNull(CommonUtil.getStr(formMap.get(ITEM_REVISION)))) {
//			// 登録成功メッセージをセッションに設定
//			request.getSession().setAttribute(SESSION_REGIST_MESSAGE_USER, MSG_SUCCESS_INSERT);
//
//		} else {
//			// 更新成功メッセージをセッションに設定
//			request.getSession().setAttribute(SESSION_REGIST_MESSAGE_USER, MSG_SUCCESS_UPDATE);
//
//		}

		// 検索条件をセッションに保持（再検索用）
//		request.getSession().setAttribute(SESSION_REGIST_RE_SEARCH_USER, formMap);

//		return map.findForward(ACTION_FOWARD_SUCCESS);
	//}
}
