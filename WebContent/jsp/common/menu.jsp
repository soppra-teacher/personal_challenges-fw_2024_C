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
		�\�v�u�[�̃}�l�[�m�[�g�@���j���[
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
						<img src="img/sports_data.png" alt="���Ղԁ[" />
					</td>
				</tr>

				<tr>
					<td colspan="3">
						<span class="company-logo">SOPPRA</span>
					</td>
				</tr>

				<tr>
					<td rowspan="5" class="plr-20">
						<h1>
							�o�c���O
						</h1>
						<h2>
							���ӂ��l��n��
						</h2>
						<h2>
							���ӂ��K�����Ă�
						</h2>
						<h3>
							�T�@�S�ĂɊ��ӂ���o�c
						</h3>
						<h3>
							�U�@�D�ꂽ�l�i���`������o�c
						</h3>
						<h3>
							�V�@�l�X���K���ɂ���o�c
						</h3>
					</td>
					<td class="plr-20">
						<p>
							<html:link action="/KojinRegistInit">�l�}�X�^�o�^</html:link>
						</p>
					</td>
					<td class="plr-20">
						<p>
							<html:link action="/KojinListInit">�l�}�X�^�����e</html:link>
						</p>
					</td>
				</tr>

				<tr>
					<td>
						<p>
							<html:link action="/SetaiRegistInit">���у}�X�^�o�^</html:link>
						</p>
					</td>
					<td>
						<p>
							<html:link action="/SetaiListInit">���у}�X�^�����e</html:link>
						</p>
					</td>
				</tr>

				<tr>
					<td>
						<p>
							<html:link action="/HimokuRegistInit">��ڃ}�X�^�o�^</html:link>
						</p>
					</td>
					<td>
						<p>
							<html:link action="/HimokuListInit">��ڃ}�X�^�����e</html:link>
						</p>
					</td>
				</tr>

				<tr>
					<td>
						<p>
							<html:link action="/ShushiRegistInit">���x�o�^</html:link>
						</p>
					</td>
					<td>
						<p>
							<html:link action="/SeisekiListInit">���у��X�g</html:link>
						</p>
					</td>
				</tr>

				<tr>
					<td>
						<p>
							<html:link action="/ShushiListKobetsuInit">���x�ꗗ�i�ʁj</html:link>
						</p>
					</td>
					<td>
						<p>
							<logic:equal name="loginInfo" property="setainushiFlg" value="<%=Const.SETAINUSHI_ON%>">
								<html:link action="/ShushiListSetaiInit">���x�ꗗ�i���сj</html:link>
							</logic:equal>
							<logic:notEqual name="loginInfo" property="setainushiFlg" value="<%=Const.SETAINUSHI_ON%>">
								&nbsp;
							</logic:notEqual>
						</p>
					</td>
				</tr>

			</table>


			<jsp:include page="/jsp/common/footer.jsp" />
		</div>

	</div>
</body>
</html:html>
