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

	/** 更新 */
	public ActionForward update(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return mapping.findForward(ACTION_FOWARD_UPDATE);
	}

	/**
	 * 戻る（一覧(ユーザー)）
	 * 自分で追加した
	 */
	public ActionForward backListUser(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return mapping.findForward(ACTION_FOWARD_BACK_LIST_USER);
	}

}
