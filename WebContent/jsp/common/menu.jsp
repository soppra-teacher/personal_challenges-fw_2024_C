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
<title>�X�|�[�cDATA ���j���[</title>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/common.css" />
<script type="text/javascript"></script>
</head>

<body>

	<div class="base-width text-center">
		<jsp:include page="/jsp/common/header.jsp">
			<jsp:param name="screenTitle" value="���j���[" />
		</jsp:include>

		<div class="contents block-center">

			<table class="layout-table block-center">

				<tr>
					<td colspan="3"><span class="company-logo">�X�|�[�cDATA</span></td>
				</tr>

				<tr>
					<td class="plr-20">
						<p>
							<html:link action="/SensekiRegistInit">�������ʓo�^���</html:link>
						</p>
					</td>
				</tr>

				<tr>
					<td>
						<p>
							<html:link action="/SeisekiListInit">��ѕ\�����</html:link>
						</p>
					</td>
				</tr>


			</table>
			<jsp:include page="/jsp/common/menufooter.jsp" />
		</div>

	</div>
</body>
</html:html>
