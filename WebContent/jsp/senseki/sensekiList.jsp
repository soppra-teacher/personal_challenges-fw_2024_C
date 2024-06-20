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
		�X�|�[�c�f�[�^�@�l���
	</title>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/common.css" />
	<script type="text/javascript" charset="shift_jis" src="js/common.js" ></script>
</head>

<body onload="setDeleteButton();">

	<bean:define id="inputBean" name="sensekiListForm" />
	<bean:define id="viewBean" name="SENSEKI_LIST_DTO" />

	<div class="base-width text-center">

		<html:form action="/SensekiListDisp" focus="sensekiNm">

			<jsp:include page="/jsp/common/header.jsp">
				<jsp:param name="screenTitle" value="�l���"/>
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


				<table class="layout-table block-center w-auto">
				
						<td class="text-left l-shushi-shunyu">
							<span class="p-10">
								<h1>
							<bean:write name="viewBean" property="playerNm" /> 
								</h1>
								
							</span>
						</td>
										
						<td class="w-25">
							<html:button property="delete" onclick="callAction(this.form, 'delete');"
								styleClass="btn btn-l">
								�폜
							</html:button>
						</td>
					</tr>
				</table>

				<table class="l-himoku table mb-0" >
					<tr class="table-header">

						<td class="text-center l-senseki-match-date">������</td>
						<td class="text-center l-senseki-e-team">�ΐ푊��</td>
						<td class="text-center ">�C�j���O</td>						
						<td class="text-center ">����</td>
						<td class="text-center ">�����</td>
						<td class="text-center ">�^�l����</td>
						<td class="text-center ">�D�O�U</td>
						<td class="text-center ">���_</td>
						<td class="text-center ">���ӓ_</td>
						<td class="text-center ">�폜</td>
						
					</tr>
				</table>

				<div class="table-overflow">
					<table class="l-kojin table" >
						<logic:notEmpty name="viewBean" property="list">
							<logic:iterate id="list" name="viewBean" property="list">
								<tr>	
								
									<td class="l-senseki-match-date ">
										<bean:write name="list" property="matchDate" />
									</td>								
									<td class="l-senseki-e-team">
										<bean:write name="list" property="eTeam" />
									</td>									
									<td class="text-center">
										<span class="p-10">
											<bean:write name="list" property="inning" />
										</span>
									<td class="text-center">
										<span class="p-10">
											<bean:write name="list" property="tamakazu" />
										</span>
									</td>
									<td class="text-center">
										<bean:write name="list" property="hianda" />
									</td>
									<td class="text-center">
										<bean:write name="list" property="yoshikyu" />
									</td>
									<td class="text-center">
										<bean:write name="list" property="datsusanshin" />
									</td>
									<td class="text-center">
										<bean:write name="list" property="sittenNm" />
									</td>
									<td class="text-center">
										<bean:write name="list" property="jisekitenNm" />
									</td>
									<td class="text-center">
										<input type="checkbox" name="checkDel" value="<bean:write name="list" property="matchId" />" />
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
