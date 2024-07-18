<%@ page pageEncoding="Windows-31J"%>
<%@ page contentType="text/html;charset=Windows-31J"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page import="cashbook.util.Const"%>

<!DOCTYPE html>
<html:html lang="ja">
<head>

<meta content="ja" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>スポーツDATA 新規ユーザー登録</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/common.css" />
<script language="JavaScript" type="text/javascript" charset="shift_jis"
	src="js/common.js"></script>
<script type="text/javascript">
	
</script>
</head>

<body>

	<bean:define id="inputBean" name="userRegistForm" />

	<div class="base-width text-center">

		<html:form action="/UserRegistDisp" focus="userId">

			<jsp:include page="/jsp/common/header.jsp">
				<jsp:param name="screenTitle" value="新規ユーザー登録" />
			</jsp:include>

			<html:hidden property="operation" value="" />

			<div id="contents">
				<html:messages id="msg" message="true">
					<p class="msg-info">
						・
						<bean:write name="msg" ignore="true" filter="false" />
					</p>
				</html:messages>

				<html:messages id="msg" message="false">
					<p class="msg-err">
						・
						<bean:write name="msg" ignore="true" filter="false" />
					</p>
				</html:messages>

				<div>
					<table class="layout-table w-100">

						<tr>
							<td class="w-25 text-right"><span class="label-title">
									ユーザーＩＤ </span></td>
							<td class="w-75 text-left"><html:text name="inputBean"
									property="userId" styleClass="input-text-s" /></td>
						</tr>

						<tr>
							<td class="w-25 text-right"><span class="label-title">
									パスワード </span></td>
							<td class="w-75 text-left"><html:password name="inputBean"
									property="pass" styleClass="input-text-m" /></td>
						</tr>
						<tr>
							<td class="w-25 text-right"><span class="label-title">
									パスワード再入力 </span></td>
							<td class="w-75 text-left"><html:password name="inputBean"
									property="pass2" styleClass="input-text-m" /></td>
						</tr>

					</table>
				</div>

				<div class="block-center">

					<html:button property="insert" styleClass="btn btn-l"
						onclick="callAction(this.form, 'insert');">登録
            </html:button>
				</div>
				<jsp:include page="/jsp/common/newUser_footer.jsp" />
			</div>
		</html:form>
	</div>
</body>
</html:html>