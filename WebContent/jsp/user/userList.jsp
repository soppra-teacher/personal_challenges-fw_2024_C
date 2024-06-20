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
<title>スポーツDATA ユーザーマスタメンテ</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/common.css" />
<script type="text/javascript" charset="shift_jis" src="js/common.js"></script>
</head>

<body onload="setDeleteButton();">

	<bean:define id="inputBean" name="userListForm" />
	<bean:define id="viewBean" name="USER_LIST_DTO" />

	<div class="base-width text-center">

		<html:form action="/UserListDisp" focus="userNm">

			<jsp:include page="/jsp/common/header.jsp">
				<jsp:param name="screenTitle" value="ユーザーマスタメンテ" />
			</jsp:include>

			<html:hidden property="operation" value="" />

			<div class="contents block-center">

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

				<table class="layout-table">
					<tr>
						<td colspan="2" class="w-50 text-left"><span
							class="label-title"> ユーザー名 </span> <html:text name="inputBean"
								property="userNm" styleClass="input-text-s" /></td>
						<td colspan="2" class="w-50 text-left"><span
							class="label-title"> ユーザー名ｶﾅ </span> <html:text name="inputBean"
								property="userNmkana" styleClass="input-text-m" /></td>
					</tr>
					<tr>
						<td class="w-25 text-left"><span class="label-title">
								性別 </span> <html:select name="inputBean" property="seibetsuKbnKey"
								styleClass="input-select-m">
								<html:optionsCollection name="viewBean" property="seibetsuKbn"
									value="key" label="value" />
							</html:select></td>
						<td class="w-25 text-left"><span class="label-title">
								続柄 </span> <html:select name="inputBean" property="zokugaraKey"
								styleClass="input-select-m">
								<html:optionsCollection name="viewBean" property="zokugara"
									value="key" label="value" />
							</html:select></td>
						<td colspan="2" class="w-50 text-left"><span
							class="label-title"> 世帯主 </span> <html:checkbox name='inputBean'
								property="setaiNusiFlg" styleClass="input-check" /></td>
					</tr>
				</table>

				<table class="layout-table block-center w-100">
					<tr>
						<td class="w-25"><html:button property="delete"
								onclick="callAction(this.form, 'delete');"
								styleClass="btn btn-l">
								削除
							</html:button></td>
						<td class="w-50">&nbsp;</td>
						<td class="w-25"><html:button property="search"
								onclick="callAction(this.form, 'search');"
								styleClass="btn btn-l">
								検索
							</html:button></td>
					</tr>
				</table>

				<table class="l-user table mb-0">
					<tr class="table-header">
						<td class="text-center l-user-del">削除</td>
						<td class="text-center l-user-user-id">ユーザーID</td>
						<td class="text-center l-user-setai-id">世帯ID</td>
						<td class="text-center">ユーザー名</td>
						<td class="text-center">ユーザー名ｶﾅ</td>
						<td class="text-center l-user-sex">性別</td>
						<td class="text-center l-user-zokugara">続柄</td>
						<td class="text-center l-user-setainushi">世帯主</td>
					</tr>
				</table>

				<div class="table-overflow">
					<table class="l-himoku table">
						<logic:notEmpty name="viewBean" property="list">
							<logic:iterate id="list" name="viewBean" property="list">
								<tr>
									<td class="text-center l-user-del"><input type="checkbox"
										name="checkDel"
										value="<bean:write name="list" property="userId" />" /></td>
									<td class="l-user-user-id"><html:link
											action="/UserRegistInit" paramId="userId" paramName="list"
											paramProperty="userId">
											<bean:write name="list" property="userId" />
										</html:link></td>
									<td class="l-user-setai-id"><bean:write name="list"
											property="setaiId" /></td>
									<td class="text-left"><span class="p-10"> <bean:write
												name="list" property="userNm" />
									</span></td>
									<td class="text-left"><span class="p-10"> <bean:write
												name="list" property="userNmkana" />
									</span></td>
									<td class="l-user-sex"><bean:write name="list"
											property="seibetsuNm" /></td>
									<td class="l-user-zokugara"><bean:write name="list"
											property="zokugaraNm" /></td>
									<td class="l-user-setainushi"><bean:write name="list"
											property="setaiNusiNm" /></td>
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
