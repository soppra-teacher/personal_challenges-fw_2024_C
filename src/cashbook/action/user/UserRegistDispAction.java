package cashbook.action.user;

import static cashbook.util.Const.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * ユーザーマスタ登録画面 ディスパッチアクションクラス
 * @author soppra
 */
public class UserRegistDispAction extends DispatchAction {

	/** 登録 */
	public ActionForward insert(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward(ACTION_FOWARD_INSERT);
	}

}