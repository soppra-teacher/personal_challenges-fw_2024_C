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
		ソプブーーーーーー　個人マスタメンテ
	</title>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/common.css" />
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/sport.css" />
	<script type="text/javascript" charset="shift_jis" src="js/common.js" ></script>
</head>

<body>
<!--  onload="setDeleteButton();" -->
	<bean:define id="inputBean" name="seisekiListForm" />
	<bean:define id="viewBean" name="SEISEKI_LIST_DTO" />

	<div class="base-width text-center">

		<html:form action="/SeisekiListDisp" focus="seisekiNm">

			<jsp:include page="/jsp/common/header.jsp">
				<jsp:param name="screenTitle" value="総成績一覧"/>
			</jsp:include>

			<html:hidden property="operation" value="" />

			<div class="contents block-center">

				<html:messages id="msg" message="true">
					<p class="msg-info">
						・<bean:write name="msg" ignore="true" filter="false"/>
					</p>
				</html:messages>

				<html:messages id="msg" message="false">
					<p class="msg-err">
						・<bean:write name="msg" ignore="true" filter="false"/>
					</p>
				</html:messages>

				<table class="layout-table">
					<tr>
						<td colspan="2" class="w-50 text-left">
							<span class="label-title">
								新規選手登録
							</span>
							<html:text name="inputBean" property="newSenshuNm" styleClass="input-text-m" />
 						</td>
						<td class="w-90 text-left">
							<html:button property="delete" onclick="callAction(this.form, 'delete');"
								styleClass="button-t">
								登録
							</html:button>
						</td>
						<td class="w-25">
							<html:button property="search" onclick="callAction(this.form, 'search');"
								styleClass="btn btn-l">
								検索
							</html:button>
						</td>
<%-- 						<td colspan="2" class="w-50 text-left">
							<span class="label-title">
								個人名ｶﾅ
							</span>
							<html:text name="inputBean" property="seisekiNmkana" styleClass="input-text-m" />
						</td>
					</tr>
					<tr>
						<td class="w-25 text-left">
							<span class="label-title">
								性別
							</span>
							<html:select name="inputBean" property="seibetsuKbnKey" styleClass="input-select-m">
								<html:optionsCollection name="viewBean" property="seibetsuKbn" value="key" label="value" />
							</html:select>
						</td>
						<td class="w-25 text-left">
							<span class="label-title">
								続柄
							</span>
							<html:select name="inputBean" property="zokugaraKey" styleClass="input-select-m">
								<html:optionsCollection name="viewBean" property="zokugara" value="key" label="value" />
							</html:select>
						</td>
						<td colspan="2" class="w-50 text-left">
							<span class="label-title">
								世帯主
							</span>
							<html:checkbox name='inputBean' property="setaiNusiFlg" styleClass="input-check"/>
						</td> --%>
					</tr>
				</table>

<%-- 				<table class="layout-table block-center w-100">
					<tr>
						<td class="w-25">
							<html:button property="delete" onclick="callAction(this.form, 'delete');"
								styleClass="btn btn-l">
								削除
							</html:button>
						</td>
						<td class="w-50">
							&nbsp;
						</td>
						<td class="w-25">
							<html:button property="search" onclick="callAction(this.form, 'search');"
								styleClass="btn btn-l">
								検索
							</html:button>
						</td>
					</tr>
				</table> --%>

				<table class="l-seiseki table mb-0" >
					<tr class="table-header">
<!-- 						<td class="text-center l-seiseki-del">削除</td> -->
						<td class="text-center l-seiseki-senshu-id">選手ID</td>
						<td class="text-center">選手名</td>
						<td class="text-center l-seiseki-sou-inning">総イニング</td>
						<td class="text-center l-seiseki-sou-shitten">総失点</td>
						<td class="text-center l-seiseki-sou-jisekiten">総自責点</td>
 						<td class="text-center l-seiseki-bougyoritsu">防御率</td>
<!-- 					<td class="text-center l-seiseki-setainushi">世帯主</td> -->
					</tr>
				</table>

				<div class="table-overflow">
					<table class="l-himoku table" >
						<logic:notEmpty name="viewBean" property="list">
							<logic:iterate id="list" name="viewBean" property="list">
								<tr>
									<%-- <td class="text-center l-seiseki-del">
										<input type="checkbox" name="checkDel" value="<bean:write name="list" property="seisekiId" />" />
									</td> --%>
									<td class="l-seiseki-senshu-id">
										<html:link action="/SeisekiRegistInit" paramId="senshuId" paramName="list" paramProperty="seisekiId">
											<bean:write name="list" property="senshuId" />
										</html:link>
									</td>
									<td class="text-center">
										<bean:write name="list" property="senshuNm" />
									</td>
									<td class="l-seiseki-sou-inning">
										<span class="p-10">
											<bean:write name="list" property="souInning" />
										</span>
									</td>
									<td class="l-seiseki-sou-shitten">
										<span class="p-10">
											<bean:write name="list" property="souShitten" />
										</span>
									</td>
									<td class="l-seiseki-sou-jisekiten">
										<bean:write name="list" property="souJisekiten" />
									</td>
 									<td class="l-seiseki-bougyoritsu">
										<bean:write name="list" property="bougyoRitsu" />
									</td>
<%--									<td class="l-seiseki-setainushi">
										<bean:write name="list" property="setaiNusiNm" />
									</td> --%>
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
