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

		// ユーザーマスタメンテ初期表示情報を取得
		UserRegistDto dto = new UserRegistDto();

		// フォームの値を取得する。
		Map<String, Object> formMap = CommonUtil.getFormMap((DynaActionForm) form);

		try {

			// 登録・更新
			userService.registInsUpd(formMap);
			// 登録成功メッセージをセッションに設定
			request.getSession().setAttribute(SESSION_REGIST_MESSAGE_USER, MSG_SUCCESS_INSERT);

		} catch (CommonValidateException e) {

			ActionErrors errors = new ActionErrors();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getMessageKey()));
			saveErrors(request, errors);
			return map.getInputForward();
		}

		// 新規ユーザー登録成功
		request.setAttribute("FORM_USER_REGIST", dto);
		// ユーザー情報取得
		request.getSession().setAttribute("USER_REGIST_DTO", dto);

		// 処理成功時の遷移先を指定する。
		return map.findForward(Const.ACTION_FOWARD_SUCCESS);

	}
}
