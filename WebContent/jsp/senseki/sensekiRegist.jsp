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
		投手戦績登録画面
	</title>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/common.css" />
	<script type="text/javascript" charset="shift_jis" src="js/common.js"></script>
	<!-- フォーカスセット -->
	<!-- <script type="text/javascript">
		window.onload = function(){

			if (eleRevision.defaultValue == ""){
				eleSensekiCd.focus();
			} else {
				eleSensekiNm.focus();
			}
		}
	</script>-->
</head>

<body>

	<bean:define id="inputBean" name="sensekiRegistForm" />
	<bean:define id="viewBean" name="SENSEKI_REGIST_DTO" />
	<bean:define id="backAction" name="SENSEKI_REGIST_BACK" type="java.lang.String" />

	<div class="base-width text-center">

		<html:form action="/SensekiRegistDisp" focus="senshuNmKey">

			<jsp:include page="/jsp/common/header.jsp">
				<jsp:param name="screenTitle" value="投手 戦績登録画面"/>
			</jsp:include>

			<html:hidden property="operation" value="" />
			<html:hidden name="viewBean" property="revision" />

			<div id="contents">

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

				<div>
					<table class="layout-table w-100">
						<tr>
							<td class="w-25 text-right">
								<span class="label-title">
									選手名
								</span>
							</td>
							<td class="w-75 text-left">
							<html:select name="inputBean" property="senshuNmKey" styleClass="input-select-xl ">
									<html:optionsCollection name="viewBean" property="senshuNm" value="key" label="value" />
								</html:select>
							</td>
						</tr>
						<tr>
							<td class="w-25 text-right">
								<span class="label-title">
							      イニング
								</span>
							</td>
							<td class="w-75 text-left">
									<html:text name = "inputBean" property = "ining"  styleClass = "input-text-s" />
									
									
								<html:select name="inputBean" property="iningMiniKey" styleClass="input-select-xl ">
									<html:optionsCollection name="viewBean" property="iningMini" value="key" label="value" />
								</html:select>
									
							</td>
						</tr>
						<tr>
							<td class="w-25 text-right">
								<span class="label-title">
									球数
								</span>
							</td>
							<td class="w-75 text-left">
								<html:text name="inputBean" property="tamakazu"  styleClass="input-text-s" />
							</td>
						</tr>
						<tr>
							<td class="w-25 text-right">
								<span class="label-title">
									被安打
								</span>
							</td>
							<td class="w-75 text-left">
								<html:text name="inputBean" property="hianda"  styleClass="input-text-s" />
							</td>
						</tr>
						<tr>
							<td class="w-25 text-right">
								<span class="label-title">
									与四死球
								</span>
							</td>
							<td class="w-75 text-left">
								<html:text name="inputBean" property="yoshishikyu"  styleClass="input-text-s" />
							</td>
						</tr>
						<tr>
							<td class="w-25 text-right">
								<span class="label-title">
									奪三振
								</span>
							</td>
							<td class="w-75 text-left">
								<html:text name="inputBean" property="datsusanshin"  styleClass="input-text-s" />
							</td>
						</tr>
						<tr>
							<td class="w-25 text-right">
								<span class="label-title">
									失点
								</span>
							</td>
							<td class="w-75 text-left">
								<html:text name="inputBean" property="sitten"  styleClass="input-text-s" />
							</td>
						</tr>
						<tr>
							<td class="w-25 text-right">
								<span class="label-title">
									自責点
								</span>
							</td>
							<td class="w-75 text-left">
								<html:text name="inputBean" property="jisekiten"  styleClass="input-text-s" />
							</td>
						</tr>
						<tr>
							<td class="w-25 text-right">
								<span class="label-title">
									対戦相手
								</span>
							</td>
							<td class="w-75 text-left">
								<html:text name="inputBean" property="taisenNm"  styleClass="input-text-l" />
							</td>
						</tr>
						<tr>
							<td class="w-25 text-right">
								<span class="label-title">
									試合日
								</span>
							</td>
							<td class="w-75 text-left">
								<html:text name="inputBean" property="shiaibi"  styleClass="input-text-m" />
							</td>
						</tr>
						
					</table>
				</div>

				<div class="block-center">
					<logic:empty name="viewBean" property="revision">
						<html:button property="insert" styleClass="btn btn-l" onclick="callAction(this.form, 'insert');">
							登録
						</html:button>
					</logic:empty>
				</div>
				<jsp:include page="/jsp/common/footer.jsp" />
			</div>
		</html:form>
	</div>
</body>
</html:html>