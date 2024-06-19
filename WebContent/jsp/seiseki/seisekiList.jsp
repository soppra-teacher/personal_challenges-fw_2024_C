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
							<html:button property="insert" onclick="callAction(this.form, 'insert');"
								styleClass="button-t">
								登録
							</html:button>
						</td>
					</tr>
				</table>



				<table class="l-seiseki table mb-0" >
					<tr class="table-header">
						<td class="text-center l-seiseki-senshu-id">選手ID</td>
						<td class="text-center">選手名</td>
						<td class="text-center l-seiseki-sou-inning">総イニング</td>
						<td class="text-center l-seiseki-sou-shitten">総失点</td>
						<td class="text-center l-seiseki-sou-jisekiten">総自責点</td>
 						<td class="text-center l-seiseki-bougyoritsu">防御率</td>
					</tr>
				</table>

				<div class="table-overflow">
					<table class="l-himoku table" >
						<logic:notEmpty name="viewBean" property="list">
							<logic:iterate id="list" name="viewBean" property="list">
								<tr>
									<td class="l-seiseki-senshu-id">
										<bean:write name="list" property="senshuId" />	
									</td>
									<td class="text-center">
										<html:link action="/SensekiListInit" paramId="senshuId" paramName="list" paramProperty="senshuId">
											<bean:write name="list" property="senshuNm" />
										</html:link>
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
