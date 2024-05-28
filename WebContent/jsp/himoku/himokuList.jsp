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
		�\�v�u�[�̃}�l�[�m�[�g�@��ڃ}�X�^�����e
	</title>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/common.css" />
	<script type="text/javascript" charset="shift_jis" src="js/common.js" ></script>
</head>

<body onload="setDeleteButton();">

	<bean:define id="inputBean" name="himokuListForm" />
	<bean:define id="viewBean" name="HIMOKU_LIST_DTO" />

	<div class="base-width text-center">
		<html:form action="/HimokuListDisp" focus="himokuNm">

			<jsp:include page="/jsp/common/header.jsp">
				<jsp:param name="screenTitle" value="��ڃ}�X�^�����e"/>
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
						<td class="w-50">
							<span class="label-title">
								��ږ�
							</span>
							<html:text name="inputBean" property="himokuNm" styleClass="input-text-m"  />
						</td>
						<td class="w-50">
							<span class="label-title">
								��ڋ敪
							</span>
							<html:select name="inputBean" property="himokuKbnKey" styleClass="input-select-m">
								<html:optionsCollection name="viewBean" property="himokuKbn" value="key" label="value" />
							</html:select>
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
								styleClass="btn  btn-l">
								����
							</html:button>
						</td>
					</tr>
				</table>

				<table class="l-himoku table mb-0" >
					<tr class="table-header">
						<td class="text-center l-himoku-del">�폜</td>
						<td class="text-center l-himoku-cd">���CD</td>
						<td class="text-center">��ږ�</td>
						<td class="text-center l-himoku-kb">��ڋ敪</td>
					</tr>
				</table>

				<div class="table-overflow">
					<table class="l-himoku table" >
						<logic:notEmpty name="viewBean" property="list">
							<logic:iterate id="list" name="viewBean" property="list">
								<tr>
									<td class="l-himoku-del">
										<input type="checkbox" name="checkDel" value="<bean:write name='list' property='himokuCd' />" />
									</td>
									<td class="l-himoku-cd">
										<html:link action="/HimokuRegistInit" paramId="himokuCd" paramName="list" paramProperty="himokuCd">
											<bean:write name="list" property="himokuCd" />
										</html:link>
									</td>
									<td class="text-left">
										<span class="p-10">
											<bean:write name="list" property="himokuNm" />
										</span>
									</td>
									<td class="l-himoku-kb">
										<bean:write name="list" property="himokuKbnNm" />
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
