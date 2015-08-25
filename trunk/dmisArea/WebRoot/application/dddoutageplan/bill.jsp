<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp" %>
<%@ page language="java" buffer="18kb"%>

<html>
<head>
  <title>gridtest</title> 
    <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/style.css">
    <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/default.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/components/tag/grid/twoGridDemo.js"></script>
</head>
<body bgcolor="#ffffff">
<table class="detailmain" cellspacing="0" cellpadding="0">
  <tr>
    <th colspan="3" class="pt" align="left" height="20">&nbsp;&nbsp;<a href="javascript:popmenu(table0);">
      <img src="<%=request.getContextPath()%>/themes/themes1/images/main/zd.gif"></a>&nbsp;基本信息
    </th>
  </tr>
  <tr id="table0">
    <td align="center">
      <TABLE class="detail" width="100%" height="100%" cellspacing="0">
        <TBODY>
          <TR>
            <TD width="15%" bgcolor="#f6f6f6" align="right">&nbsp;计划编号</TD>
            <TD width="35%"><label>
              <input name="textfield" type="text" onFocus="this.blur()" value="2006090034">
            </label></TD>
            <TD width="15%" bgcolor="#f6f6f6" align="right">工作地点</TD>
            <TD width="35%"><label>
              <input name="textfield2" type="text" onFocus="this.blur()" value="新温泉站">
            </label></TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;计划工作时间</TD>
            <TD>
              <input type=text name="workstarTime" id="workstarTime" onFocus="this.blur()" size=16 value="2006-09-21 07:00">到
              <input type=text name="workendTime" id="workendTime" onFocus="this.blur()" size=16 value="2006-09-26 17:30">
            </TD>
            <TD bgcolor="#f6f6f6">&nbsp;计划停电时间*</TD>
            <TD>
              <input type=text name="outagestarTime" id="outagestarTime" onFocus="this.blur()" size=16 value="2006-09-21 07:00">到
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
    <th colspan="3" class="pt" align="left" height="20">&nbsp;&nbsp;<a href="javascript:popmenu(table1);">
      <img src="<%=request.getContextPath()%>/themes/themes1/images/main/zd.gif"></a>&nbsp;保护定值单
    </th>
  </tr>
  <tr id="table1">
    <td align="center">
      <iframe id="test1" src="fixedvaluebill.jsp" width="100%" height="105" frameborder="0" scrolling="no"></iframe>
    </td>
  </tr>
  <tr>
    <td>
      <iframe id="test2" src="billdetail.jsp" width="100%" height="195" frameborder="0" scrolling="no"></iframe>
    </td>
  </tr>
</table>

</body>
</html>
