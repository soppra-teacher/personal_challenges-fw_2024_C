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
		�X�|�[�cDATA�@���j���[��ʂ����
	</title>

	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/common.css" />
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/menu.css" />
	<script type="text/javascript"></script>
</head>

<body>

	<div class="base-width text-center">

		<bean:define id="loginInfo" name="LOGIN_DTO" />

		<jsp:include page="/jsp/common/header.jsp">
			<jsp:param name="screenTitle" value="���j���[" />
		</jsp:include>

		<div class="contents block-center">

			<table class="layout-table block-center">
             
				<tr>
					<td colspan="3">
						<span class="company-logo">SOPPRA</span>
					</td>
				</tr>

				<tr>
					<td class="plr-20">
						<p>
							<html:link action="/UserRegistInit">�I��o�^���</html:link>
						</p>
					</td>
				</tr>

				<tr>
					<td>
						<p>
							<html:link action="/SetaiRegistInit">�������ʓo�^���</html:link>
						</p>
					</td>
				</tr>

				<tr>
					<td>
						<p>
							<html:link action="/HimokuRegistInit">��ѕ\�����</html:link>
						</p>
					</td>
				</tr>
				
				<tr>
					<td>
						<p>
							<html:link action="/KojinRegistInit">�l�}�X�^�o�^���</html:link>
						</p>
					</td>
				</tr>
			</table>
			<jsp:include page="/jsp/common/footer.jsp" />
		</div>

	</div>
</body>
</html:html>