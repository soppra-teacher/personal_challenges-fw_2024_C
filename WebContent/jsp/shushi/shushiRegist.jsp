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
		�\�v�u�[�̃}�l�[�m�[�g�@���x�o�^
	</title>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/common.css" />
	<script language="JavaScript" type="text/javascript" charset="shift_jis" src="js/common.js" ></script>
	<script type="text/javascript">
		// ��������
		window.onload = function(){
			document.getElementsByName('himokuKbnKey').item(0).disabled = true;
			if (document.getElementsByName('himokuNmKey').item(0).value != null &&
				document.getElementsByName('himokuNmKey').item(0).value != "") {
				changeHimokuKbn(document.getElementsByName('himokuNmKey').item(0).value.substring(2,3));
			}
		};

		// ��ږ��ύX����
		function changeHimokuNmKey(element) {
			changeHimokuKbn(element.value.substring(2, 3));
		}

		// ��ڋ敪�ύX����
		function changeHimokuKbn(value) {
			document.getElementsByName('himokuKbnKey').item(0).value = value;
		};

		// �o�^�E�X�V�{�^������
		function pressButton(frm, mode) {
			var himokuCdPlus = document.getElementsByName('himokuNmKey').item(0).value;
			if (himokuCdPlus != "") {
				document.getElementsByName('himokuCd').item(0).value = himokuCdPlus.substring(0,2);
			} else {
				document.getElementsByName('himokuCd').item(0).value = null;
			}
			callAction(frm, mode);
		}

	</script>
</head>

<body>

	<bean:define id="inputBean"  name="shushiRegistForm" />
	<bean:define id="viewBean"   name="SHUSHI_REGIST_DTO" />
	<bean:define id="backAction" name="SHUSHI_REGIST_BACK" type="java.lang.String" />

	<div class="base-width text-center">

		<html:form action="/ShushiRegistDisp" focus="ymd">

			<jsp:include page="/jsp/common/header.jsp">
				<jsp:param name="screenTitle" value="���x�o�^"/>
			</jsp:include>

			<html:hidden property="operation" value="" />
			<html:hidden name="viewBean" property="revision" />
			<html:hidden name="inputBean" property="shushiKey" />
			<html:hidden name="inputBean" property="shushiId" />
			<html:hidden name="inputBean" property="shushiDtlId" />
			<html:hidden name="inputBean" property="kojinId" />

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
									���t
								</span>
							</td>
							<td class="w-75 text-left">
								<logic:empty name="viewBean" property="revision">
									<html:text name="inputBean" property="ymd" styleClass="input-text-s" />
								</logic:empty>
								<logic:notEmpty name="viewBean" property="revision">
									<html:text name="inputBean" property="ymd" styleClass="input-text-s" readonly="true" />
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
								<html:select name="inputBean" property="himokuNmKey" styleClass="input-select-xl"
									onchange="changeHimokuNmKey(this)">
									<html:optionsCollection name="viewBean" property="himokuNm" value="key" label="value" />
								</html:select>
								<span class="label-title">
									��ڋ敪
								</span>
								<html:select name="inputBean" property="himokuKbnKey" styleClass="input-select-m">
									<html:optionsCollection name="viewBean" property="himokuKbn" value="key" label="value" />
								</html:select>
								<html:hidden name="inputBean" property="himokuCd" />

							</td>
						</tr>

						<tr>
							<td class="w-25 text-right">
								<span class="label-title">
									���z
								</span>
							</td>
							<td class="w-75 text-left">
								<html:text name="inputBean" property="kingaku" styleClass="input-text-s" />
							</td>
						</tr>

					</table>

				</div>

				<div class="block-center">
					<logic:empty name="viewBean" property="revision">
						<html:button property="insert" onclick="pressButton(this.form, 'insert');"
							styleClass="btn btn-l">
							�o�^
						</html:button>
					</logic:empty>
					<logic:notEmpty name="viewBean" property="revision">
						<html:button property="insert" onclick="pressButton(this.form, 'update');"
							styleClass="btn btn-l">
							�X�V
						</html:button>
					</logic:notEmpty>
						<html:button property="back" onclick='<%= "callAction(this.form, \'" + backAction + "\');"%>'
							styleClass="btn btn-l">
							�߂�
						</html:button>
				</div>
				<jsp:include page="/jsp/common/footer.jsp" />
			</div>
			</html:form>
		</div>
	</body>
</html:html>