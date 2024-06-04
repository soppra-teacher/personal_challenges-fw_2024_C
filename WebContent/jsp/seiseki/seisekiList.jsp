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
		\vu[[[[[[@Βl}X^e
	</title>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/common.css" />
	<script type="text/javascript" charset="shift_jis" src="js/common.js" ></script>
</head>

<body onload="setDeleteButton();">

	<bean:define id="inputBean" name="seisekiListForm" />
	<bean:define id="viewBean" name="SEISEKI_LIST_DTO" />

	<div class="base-width text-center">

		<html:form action="/SeisekiListDisp" focus="seisekiNm">

			<jsp:include page="/jsp/common/header.jsp">
				<jsp:param name="screenTitle" value="¬Ρκ"/>
			</jsp:include>

			<html:hidden property="operation" value="" />

			<div class="contents block-center">

				<html:messages id="msg" message="true">
					<p class="msg-info">
						E<bean:write name="msg" ignore="true" filter="false"/>
					</p>
				</html:messages>

				<html:messages id="msg" message="false">
					<p class="msg-err">
						E<bean:write name="msg" ignore="true" filter="false"/>
					</p>
				</html:messages>

				<table class="layout-table">
					<tr>
						<td colspan="2" class="w-50 text-left">
							<span class="label-title">
								ΒlΌ
							</span>
							<html:text name="inputBean" property="seisekiNm" styleClass="input-text-s" />
						</td>
						<td colspan="2" class="w-50 text-left">
							<span class="label-title">
								ΒlΌΆΕ
							</span>
							<html:text name="inputBean" property="seisekiNmkana" styleClass="input-text-m" />
						</td>
					</tr>
					<tr>
						<td class="w-25 text-left">
							<span class="label-title">
								«Κ
							</span>
							<html:select name="inputBean" property="seibetsuKbnKey" styleClass="input-select-m">
								<html:optionsCollection name="viewBean" property="seibetsuKbn" value="key" label="value" />
							</html:select>
						</td>
						<td class="w-25 text-left">
							<span class="label-title">
								±Ώ
							</span>
							<html:select name="inputBean" property="zokugaraKey" styleClass="input-select-m">
								<html:optionsCollection name="viewBean" property="zokugara" value="key" label="value" />
							</html:select>
						</td>
						<td colspan="2" class="w-50 text-left">
							<span class="label-title">
								’Ρε
							</span>
							<html:checkbox name='inputBean' property="setaiNusiFlg" styleClass="input-check"/>
						</td>
					</tr>
				</table>

				<table class="layout-table block-center w-100">
					<tr>
						<td class="w-25">
							<html:button property="delete" onclick="callAction(this.form, 'delete');"
								styleClass="btn btn-l">
								ν
							</html:button>
						</td>
						<td class="w-50">
							&nbsp;
						</td>
						<td class="w-25">
							<html:button property="search" onclick="callAction(this.form, 'search');"
								styleClass="btn btn-l">
								υ
							</html:button>
						</td>
					</tr>
				</table>

				<table class="l-seiseki table mb-0" >
					<tr class="table-header">
						<td class="text-center l-seiseki-del">ν</td>
						<td class="text-center l-seiseki-seiseki-id">ΒlID</td>
						<td class="text-center l-seiseki-setai-id">’ΡID</td>
						<td class="text-center">ΒlΌ</td>
						<td class="text-center">ΒlΌΆΕ</td>
						<td class="text-center l-seiseki-sex">«Κ</td>
						<td class="text-center l-seiseki-zokugara">±Ώ</td>
						<td class="text-center l-seiseki-setainushi">’Ρε</td>
					</tr>
				</table>

				<div class="table-overflow">
					<table class="l-himoku table" >
						<logic:notEmpty name="viewBean" property="list">
							<logic:iterate id="list" name="viewBean" property="list">
								<tr>
									<td class="text-center l-seiseki-del">
										<input type="checkbox" name="checkDel" value="<bean:write name="list" property="seisekiId" />" />
									</td>
									<td class="l-seiseki-seiseki-id">
										<html:link action="/SeisekiRegistInit" paramId="seisekiId" paramName="list" paramProperty="seisekiId">
											<bean:write name="list" property="seisekiId" />
										</html:link>
									</td>
									<td class="l-seiseki-setai-id">
										<bean:write name="list" property="setaiId" />
									</td>
									<td class="text-left">
										<span class="p-10">
											<bean:write name="list" property="seisekiNm" />
										</span>
									</td>
									<td class="text-left">
										<span class="p-10">
											<bean:write name="list" property="seisekiNmkana" />
										</span>
									</td>
									<td class="l-seiseki-sex">
										<bean:write name="list" property="seibetsuNm" />
									</td>
									<td class="l-seiseki-zokugara">
										<bean:write name="list" property="zokugaraNm" />
									</td>
									<td class="l-seiseki-setainushi">
										<bean:write name="list" property="setaiNusiNm" />
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
