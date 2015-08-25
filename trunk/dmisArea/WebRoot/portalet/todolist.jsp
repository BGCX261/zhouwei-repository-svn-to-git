<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
<title>todolist</title>
<link href="<%=request.getContextPath()%>/themes/themes1/style.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/tab.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
<body bgcolor="#ffffff">
        <table class="worktab" cellspacing="0" cellpadding="0">
          <tr class="table3">
            <td colspan="2">
              <table class="win_list" cellpadding="" cellspacing="3">
                <tr>
                  <td width="3%"></td>
                  <td width="3%"><img src="<%=request.getContextPath()%>/themes/themes1/images/main/workbench/mess.gif"></td>
                  <td width="21%" class="gre"><a href="#">通知消息</a>（<font class="red">5</font>&nbsp;/&nbsp;12）</td>
                  <td width="3%"><img src="<%=request.getContextPath()%>/themes/themes1/images/main/workbench/pro.gif"></td>
                  <td width="20%" class="gre"><a href="#">日计划）</a>（<font class="red">5</font>&nbsp;/&nbsp;12）</td>
                  <td width="3%"><img src="<%=request.getContextPath()%>/themes/themes1/images/main/workbench/pro.gif"></td>
                  <td width="18%" class="gre"><a href="#">故障票</a>（<font class="red">3</font>&nbsp;/&nbsp;11）</td>
                  <td width="3%"><img src="<%=request.getContextPath()%>/themes/themes1/images/main/workbench/pro.gif"></td>
                  <td width="26%" class="gre"><a href="#">方式变更单</a>（<font class="red">1</font>&nbsp;/&nbsp;2）</td>
                </tr>
              </table>
            </td>
          </tr>
        </table>
</body>
</html>
