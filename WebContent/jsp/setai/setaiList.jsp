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
		�\�v�u�[�̃}�l�[�m�[�g�@���у}�X�^�����e
	</title>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/common.css" />
	<script type="text/javascript" charset="shift_jis" src="js/common.js" /></script>
</head>

<body onload="setDeleteButton();">

	<bean:define id="inputBean" name="setaiListForm" />
	<bean:define id="viewBean" name="SETAI_LIST_DTO" />

	<div class="base-width text-center">
		<html:form action="/SetaiListDisp" focus="setaiNm">

			<jsp:include page="/jsp/common/header.jsp">
				<jsp:param name="screenTitle" value="���у}�X�^�����e"/>
			</jsp:include>

			<html:hidden property="operation" value="" />

			<div class="contents block-center">

				<html:messages id="msg" message="true">
					<p class="msg-info">
						�E<bean:write name="msg" ignore="true" filter="false"/>
					</p>
				</html:messages>

				<html:messages id="msg" message="false">
					<p class="msg-err">
						�E<bean:write name="msg" ignore="true" filter="false"/>
					</p>
				</html:messages>


				<table class="layout-table">
					<tr>
						<td class="w-50 text-left">
							<span class="label-title">
								���і�
							</span>
							<html:text name="inputBean" property="setaiNm" styleClass="input-text-s"/>
						</td>
						<td class="w-50 text-left">
							<span class="label-title">
								���і���
							</span>
							<html:text name="inputBean" property="setaiNmKana" styleClass="input-text-s" />
						</td>
					</tr>
					<tr>
						<td colspan="2" class="w-50 text-left">
							<span class="label-title">
								�Z��
							</span>
							<html:text name="inputBean" property="address" styleClass="input-text-l" />
						</td>
					</tr>
					<tr>
						<td class="w-50 text-left">
							<span class="label-title">
								�X�֔ԍ�
							</span>
							<html:text name="inputBean" property="postNo" styleClass="input-text-s" />
						</td>
						<td class="w-50 text-left">
							<span class="label-title">
								�d�b�ԍ�
							</span>
							<html:text name="inputBean" property="telNo" styleClass="input-text-s" />
						</td>
					</tr>
				</table>

				<table class="layout-table block-center w-100">
					<tr>
						<td class="w-25">
							<html:button property="delete" onclick="callAction(this.form, 'delete');"
								styleClass="btn btn-l">
								�폜
							</html:button>
						</td>
						<td class="w-50">
							&nbsp;
						</td>
						<td class="w-25">
							<html:button property="search" onclick="callAction(this.form, 'search');"
								styleClass="btn btn-l">
								����
							</html:button>
						</td>
					</tr>
				</table>

				<table class="l-setai table mb-0" >
					<tr class="table-header">
						<td class="text-center l-setai-del">�폜</td>
						<td class="text-center l-setai-id">����ID</td>
						<td class="text-center">���і�</td>
						<td class="text-center">���і���</td>
						<td class="text-center l-setai-post">�X��<br />�ԍ�</td>
						<td class="text-center l-setai-addr">�Z��</td>
						<td class="text-center l-setai-tel">�d�b<br />�ԍ�</td>
					</tr>
				</table>

				<div class="table-overflow">
					<table class="l-setai table" >
						<logic:notEmpty name="viewBean" property="list">
							<logic:iterate id="list" name="viewBean" property="list">
								<tr>
									<td class="text-center l-setai-del">
										<input type="checkbox" name="checkDel" value="<bean:write name="list" property="setaiId" />"/>
									</td>
									<td class="text-center l-setai-id">
										<html:link action="/SetaiRegistInit" paramId="setaiId" paramName="list" paramProperty="setaiId">
											<bean:write name="list" property="setaiId" />
										</html:link>
									</td>
									<td class="text-left">
										<span class="p-10">
											<bean:write name="list" property="setaiNm" />
										</span>
									</td>
									<td class="text-left">
										<span class="p-10">
											<bean:write name="list" property="setaiNmKana" />
										</span>
									</td>
									<td class="l-setai-post">
										<bean:write name="list" property="postNo" />
									</td>
									<td class="text-left l-setai-addr">
										<span class="p-10">
											<bean:write name="list" property="address" />
										</span>
									</td>
									<td class="text-center l-setai-tel">
										<bean:write name="list" property="telNo" />
									</td>
								</tr>
							</logic:iterate>
						</logic:notEmpty>
					</table>
				</div>

				<jsp:include page="/jsp/common/footer.jsp" />
			</div>
		</html:form>
	</div>
</body>
</html:html>