<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<table width="395" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td align="center" class="text"><img src="<%=request.getContextPath()%>/images/blank.gif" width="1" height="3"></td>
        </tr>
      </table>
      <table width="395" border="0" cellpadding="0" cellspacing="1" bgcolor="#000000">
        <tr>
          <td height="200" align="center" bgcolor="#eeeeee"><img src="<%=request.getContextPath()%>/images/laugh.gif" width="141" height="141"><br>
            <br>
            <span class="black"></span>
	     <tr>
	     <td>
	     <table>
	     <tr><bean:write name="AddTedaOrgForm" property="message" filter="flase"/></tr>
	     </table>
	     </td>
	     </tr>
      </table>
