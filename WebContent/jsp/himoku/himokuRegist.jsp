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
		�\�v�u�[�̃}�l�[�m�[�g ��ڃ}�X�^�o�^
	</title>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/common.css" />
	<script type="text/javascript" charset="shift_jis" src="js/common.js"></script>
	<!-- �t�H�[�J�X�Z�b�g -->
	<script type="text/javascript">
		window.onload = function(){
			var eleRevision = document.himokuRegistForm.revision;
			var eleHimokuCd = document.himokuRegistForm.himokuCd;
			var eleHimokuNm = document.himokuRegistForm.himokuNm;

			if (eleRevision.defaultValue == ""){
				eleHimokuCd.focus();
			} else {
				eleHimokuNm.focus();
			}
		}
	</script>
</head>

<body>

	<bean:define id="inputBean" name="himokuRegistForm" />
	<bean:define id="viewBean" name="HIMOKU_REGIST_DTO" />
	<bean:define id="backAction" name="HIMOKU_REGIST_BACK" type="java.lang.String" />

	<div class="base-width text-center">

		<html:form action="/HimokuRegistDisp" focus="himokuCd">

			<jsp:include page="/jsp/common/header.jsp">
				<jsp:param name="screenTitle" value="��ڃ}�X�^�o�^"/>
			</jsp:include>

			<html:hidden property="operation" value="" />
			<html:hidden name="viewBean" property="revision" />

			<div id="contents">

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

				<div>
					<table class="layout-table w-100">
						<tr>
							<td class="w-25 text-right">
								<span class="label-title">
									���CD
								</span>
							</td>
							<td class="w-75 text-left">
								<logic:empty name="viewBean" property="revision">
									<html:text name="inputBean" property="himokuCd" styleClass="input-text-s" />
								</logic:empty>
								<logic:notEmpty name="viewBean" property="revision">
									<html:text name="inputBean" property="himokuCd" styleClass="input-text-s" readonly ="true" />
								</logic:notEmpty>
							</td>
						</tr>
						<tr>
							<td class="w-25 text-right">
								<span class="label-title">
									��ږ�
								</span>
							</td>
							<td class="w-75 text-left">
								<html:text name="inputBean" property="himokuNm"  styleClass="input-text-m" />
							</td>
						</tr>
						<tr>
							<td class="w-25 text-right">
								<span class="label-title">
									��ڋ敪
								</span>
							</td>
							<td class="w-75 text-left">
								<html:select name="inputBean" property="himokuKbnKey" styleClass="input-select-m ">
									<html:optionsCollection name="viewBean" property="himokuKbn" value="key" label="value" />
								</html:select>
							</td>
						</tr>
					</table>
				</div>

				<div class="block-center">
					<logic:empty name="viewBean" property="revision">
						<html:button property="insert" styleClass="btn btn-l" onclick="callAction(this.form, 'insert');">
							�o�^
						</html:button>
					</logic:empty>
					<logic:notEmpty name="viewBean" property="revision">
						<html:button property="insert" styleClass="btn btn-l" onclick="callAction(this.form, 'update');">
							�X�V
						</html:button>
					</logic:notEmpty>
				</div>

				<div>
					<html:button property="back" styleClass="btn btn-l" onclick='<%= "callAction(this.form, \'" + backAction + "\');"%>'>
						�߂�
					</html:button>
				</div>

				<jsp:include page="/jsp/common/footer.jsp" />
			</div>
		</html:form>
	</div>
</body>
</html:html>
