<%@ page pageEncoding="Windows-31J" %>
<%@ page contentType="text/html;charset=Windows-31J" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html>
<html:html>
<head>

	<meta content="ja" http-equiv="Content-Language" />
	<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
	<title>
		�\�v�u�[�̃}�l�[�m�[�g�@���O�C��
	</title>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/common.css" />
	<script type="text/javascript" charset="shift_jis" src="js/common.js" ></script>

</head>

<body onload="document.forms[0].elements[0].focus();">

	<div class="base-width bg-yellow text-center">

		<html:form action="/Login?getKey=aaa" focus="kojinId">

			<img class="top-img" src="img/login.png" />

			<div class="contents block-center">
				<html:messages id="msg" message="false">
					<p class="msg-err">
						�E<bean:write name="msg" ignore="true" filter="false"/>
					</p>
				</html:messages>

				<table class="block-center layout-table">
					<tr>
						<th class="login_field">
							���O�C��ID:
						</th>
						<td class="login_field">
							<html:text property="kojinId" styleClass="input-text-m" tabindex="1" />
						</td>
					</tr>
					<tr>
						<th class="login_field">
							�p�X���[�h:
						</th>
						<td class="login_field">
							<html:password property="pass" styleClass="input-text-m" tabindex="2" />
						</td>
					</tr>
				</table>

				<html:submit value="���O�C��" styleClass="btn" tabindex="3" />
			</div>

		</html:form>
	</div>
</body>
</html:html>
