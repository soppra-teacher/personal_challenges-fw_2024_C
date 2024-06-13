<%@ page pageEncoding="Windows-31J" %>
<%@ page contentType="text/html;charset=Windows-31J" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page import="cashbook.util.Const"%>

<!DOCTYPE html>
<html:html lang="ja">
<head>

	<meta content="ja" http-equiv="Content-Language" />
	<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
	<title>
		ソプブーのマネーノート メニュー
	</title>

	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/common.css" />
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/menu.css" />
	<script type="text/javascript"></script>
</head>

<body>

	<div class="base-width text-center">

		<bean:define id="loginInfo" name="LOGIN_DTO" />

		<jsp:include page="/jsp/common/header.jsp">
			<jsp:param name="screenTitle" value="メニュー" />
		</jsp:include>

		<div class="contents block-center">

			<table class="layout-table block-center">
					
				
					<td>
						<p>
							<html:link action="/SensekiRegistInit">投手戦績登録</html:link>
						</p>
					</td>
				</tr>


			</table>


			<jsp:include page="/jsp/common/footer.jsp" />
		</div>

	</div>
</body>
</html:html>
