<%@ page contentType="text/html; charset=GBK" %>
<html>
<head>
<title>Dmis2006</title>
<link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/style.css">
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/other/tab.js"></script>
</head>
<body bgcolor="#ffffff">

<table class="detailmain" cellspacing="0" cellpadding="0">
  <tr>
    <th colspan="3" class="pt" align="left" height="20">&nbsp;&nbsp;<a href="javascript:popmenu(table0);">
      <img src="<%=request.getContextPath()%>/themes/themes1/images/main/zd.gif"></a>&nbsp;������Ϣ
    </th>
  </tr>
  <tr id="table0">
    <td align="center">
      <TABLE class="detail" width="100%" height="100%" cellspacing="0">
        <TBODY>
          <TR>
            <TD width="15%" bgcolor="#f6f6f6" align="right">&nbsp;�ƻ����</TD>
            <TD width="35%"><label>
              <input name="textfield" type="text" onFocus="this.blur()" value="2006090034">
            </label></TD>
            <TD width="15%" bgcolor="#f6f6f6" align="right">�����ص�</TD>
            <TD width="35%"><label>
              <input name="textfield2" type="text" onFocus="this.blur()" value="����Ȫվ">
            </label></TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;�ƻ�����ʱ��</TD>
            <TD>
              <input type=text name="workstarTime" id="workstarTime" onFocus="this.blur()" size=16 value="2006-09-21 07:00">��
              <input type=text name="workendTime" id="workendTime" onFocus="this.blur()" size=16 value="2006-09-26 17:30">
            </TD>
            <TD bgcolor="#f6f6f6">&nbsp;�ƻ�ͣ��ʱ��*</TD>
            <TD>
              <input type=text name="outagestarTime" id="outagestarTime" onFocus="this.blur()" size=16 value="2006-09-21 07:00">��
              <input type=text name="outageendTime" id="outageendTime" onFocus="this.blur()" size=16 value="2006-09-26 17:30">
            </TD>
          </TR>
        </tbody>
      </table>
    </td>
  </tr>
</table>

<table><tr><td height="8"></td></tr></table>

<table class="detailmain" cellspacing="0" cellpadding="0">
  <tr>
    <th colspan="3" class="pt" align="left" height="20">&nbsp;&nbsp;
      <a href="javascript:popmenu(table1);"><img src="<%=request.getContextPath()%>/themes/themes1/images/main/zd.gif"></a>�շ�ʽ����
    </th>
  </tr>
  <tr id="table1">
    <td align="center">
      <TABLE class="detail" width="100%" height="100%" cellspacing="0">
        <TBODY>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;���¹ʴ�ʩ*</TD>
            <TD colSpan=3>
              <textarea name="counterplan" rows="8" cols="90">����Ȫվ����*****������*****������·���磬������Ȫվ����Ӧ��Ԥ��</textarea>
            </TD>
          </TR>
        </TBODY>
      </TABLE>
    </td>
  </tr>
</table>
</body>
</html>
