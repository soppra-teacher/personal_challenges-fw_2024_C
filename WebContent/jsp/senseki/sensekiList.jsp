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
		�l���
	</title>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/common.css" /
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


				<table class="layout-table block-center w-100">
					<tr>
						<td class="w-25 text-left">
							<span class="label-title">
								�I�薼
							</span>

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
						<td class="w-50">
							&nbsp;
						</td>						
						<td class="w-25">
							<html:button property="delete" onclick="callAction(this.form, 'delete');"
								styleClass="btn btn-l">
								�폜
							</html:button>
						</td>
					</tr>
				</table>
				<table class="l-senseki table mb-0" >
					<tr class="table-header">
						<td class="text-center l-senseki-del">�폜</td>
						<td class="text-center l-senseki-match-id">������</td>
						<td class="text-center l-senseki-e_team-id">�ΐ푊��</td>
						<td class="text-center l-senseki-inning">�C�j���O</td>
						<td class="text-center l-senseki-tamakazu">����</td>
						<td class="text-center l-senseki-hianda">�����</td>
						<td class="text-center l-senseki-yoshikyu">�^�l����</td>
						<td class="text-center l-senseki-datsusanshin">�D�O�U</td>
						<td class="text-center l-senseki-sitten">���_</td>
						<td class="text-center l-senseki-jisekiten">���ӓ_</td>

					</tr>
				</table>


				<div class="table-overflow">
					<table class="l-himoku table" >
						<logic:notEmpty name="viewBean" property="list">
							<logic:iterate id="list" name="viewBean" property="list">
								<tr>
									<td class="text-center l-senseki-del">
										<input type="checkbox" name="checkDel" value="<bean:write name="list" property="sensekiId" />" />
									</td>
									
									
									<td class="l-senseki-match-id">
										<span class="p-10">
											<bean:write name="list" property="matchId" />
										</span>
									</td>
									
									
									<td class="l-senseki-e_team-id">
										<span class="p-10">
											<bean:write name="list" property="eTeamId" />
										</span>
									</td>

									<td class="l-senseki-inning">
										<span class="p-10">
											<bean:write name="list" property="inning" />
										</span>
									</td>
									
									<td class="l-senseki-tamakazu">
										<span class="p-10">
											<bean:write name="list" property="tamaKazu" />
										</span>
									</td>		
									
									<td class="l-senseki-hianda">
										<span class="p-10">
											<bean:write name="list" property="hiAnda" />
										</span>
									</td>				
									
									<td class="l-senseki-yoshikyu">
										<span class="p-10">
											<bean:write name="list" property="yoShikyu" />
										</span>
									</td>
												
									<td class="l-senseki-datsusanshin">
										<span class="p-10">
											<bean:write name="list" property="datsuSanshin" />
										</span>
									</td>			
									
									<td class="l-senseki-sitten">
										<span class="p-10">
											<bean:write name="list" property="sitTen" />
										</span>
									</td>		
									
									
									<td class="l-senseki-jisekiten">
										<span class="p-10">
											<bean:write name="list" property="jisekiTen" />
										</span>
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
