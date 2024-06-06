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
    ソプブーのマネーノート　個人マスタ登録
  </title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/common.css" />
<script language="JavaScript" type="text/javascript" charset="shift_jis" src="js/common.js" ></script>
<script type="text/javascript">
</script>
<!-- フォーカスセット -->
<script type="text/javascript">
  window.onload = function(){
    var eleRevision = document.yuzaRegistForm.revision;
    var eleYuzaId  = document.yuzaRegistForm.yuzaId;
    var elePassword = document.yuzaRegistForm.pass;

    if (eleRevision.defaultValue == ""){
      eleYuzaId.focus();
    } else {
      elePassword.focus();
    }
  }
</script>
</head>

<body>

  <bean:define id="inputBean" name="yuzaRegistForm" />
  <bean:define id="viewBean" name="YUZA_REGIST_DTO" />
  <bean:define id="backAction" name="YUZA_REGIST_BACK" type="java.lang.String" />

  <div class="base-width text-center">

    <html:form action="/YuzaRegistDisp" focus="yuzaId">

      <jsp:include page="/jsp/common/header.jsp">
        <jsp:param name="screenTitle" value="個人マスタ登録"/>
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
                  個人ＩＤ
                </span>
              </td>
              <td class="w-75 text-left">
                <logic:empty name="viewBean" property="revision">
                  <html:text name="inputBean" property="yuzaId" styleClass="input-text-s" />
                </logic:empty>
                <logic:notEmpty name="viewBean" property="revision">
                  <html:text name="inputBean" property="yuzaId" styleClass="input-text-s" readonly="true" />
                </logic:notEmpty>
              </td>
            </tr>

            <tr>
              <td class="w-25 text-right">
                <span class="label-title">
                  パスワード
                </span>
              </td>
              <td class="w-75 text-left">
                <html:password name="inputBean" property="pass" styleClass="input-text-m" />
              </td>
            </tr>
           <tr>
              <td class="w-25 text-right">
                <span class="label-title">
                  パスワード再入力
                </span>
              </td>
              <td class="w-75 text-left">
                <html:password name="inputBean" property="pass" styleClass="input-text-m" />
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
          <logic:notEmpty name="viewBean" property="revision">
            <html:button property="insert" styleClass="btn btn-l" onclick="callAction(this.form, 'update');">
              更新
            </html:button>
          </logic:notEmpty>
        </div>

        <div class="block-center">
          <html:button property="back" styleClass="btn btn-l" onclick='<%= "callAction(this.form, \'" + backAction + "\');"%>'>
            戻る
          </html:button>
        </div>

        <jsp:include page="/jsp/common/footer.jsp" />
       </div>
    </html:form>
  </div>
</body>
</html:html>