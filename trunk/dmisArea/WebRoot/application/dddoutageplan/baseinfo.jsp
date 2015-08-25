<%@page contentType="text/html; charset=GBK"%>
<html>
<head>
<title>Dmis2006</title>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/other/topmenu.js"></script>
</head>
<body bgcolor="#ffffff">
<table class="detailmain" cellspacing="0" cellpadding="0">
  <tr>
    <th colspan="3" class="pt" align="left" height="20">&nbsp;&nbsp;
      <a href="javascript:popmenu(table0);"><img src="<%=request.getContextPath()%>/themes/themes1/images/main/zd.gif"></a>&nbsp;基本信息
    </th>
  </tr>
  <tr id="table0">
    <td align="center">
      <TABLE class="detail" width="100%" height="100%" cellspacing="0">
        <TBODY>
          <TR>
            <TD width=164 bgcolor="#f6f6f6" align="right">&nbsp;计划编号</TD>
            <TD width=308><label>
              <input name="textfield" type="text" onFocus="this.blur()" value="2006090034">
            </label></TD>
            <TD width=154 bgcolor="#f6f6f6" align="right">计划分类</TD>
            <TD width=263><label>
            <select name="select">
              <option>检修计划</option>
              <option>工程计划</option>
              <option>非计划</option>
            </select>
            </label></TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;计划工作时间*</TD>
            <TD>
              <input type=text name="workstarTime" id="workstarTime" size=16 value="2006-09-21 07:00">&nbsp;
              <img src="<%=request.getContextPath()%>/themes/themes1/images/main/data.gif" name="workstarTime" height="16" border="0" align="middle" style="cursor:hand" onClick="setday(this,'','workstarTime','yy-mm-dd hh:mm')">
              至
              <input type=text name="workendTime" id="workendTime" size=16 value="2006-09-26 17:30">&nbsp;
              <img src="<%=request.getContextPath()%>/themes/themes1/images/main/data.gif" name="workendTime" height="16" border="0" align="middle" style="cursor:hand" onClick="setday(this,'','workendTime','yy-mm-dd hh:mm')">
            </TD>
            <TD bgcolor="#f6f6f6">&nbsp;计划停电时间*</TD>
            <TD>
              <input type=text name="outagestarTime" id="outagestarTime" size=16 value="2006-09-21 07:00">&nbsp;
              <img src="<%=request.getContextPath()%>/themes/themes1/images/main/data.gif" name="outagestarTime" height="16" border="0" align="middle" style="cursor:hand" onClick="setday(this,'','outagestarTime','yy-mm-dd hh:mm')">
              至
              <input type=text name="outageendTime" id="outageendTime" size=16 value="2006-09-26 17:30">&nbsp;
              <img src="<%=request.getContextPath()%>/themes/themes1/images/main/data.gif" name="outageendTime" height="16" border="0" align="middle" style="cursor:hand" onClick="setday(this,'','outageendTime','yy-mm-dd hh:mm')">
            </TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;计划来源*</TD>
            <TD><input type=text name="worklocation" id="worklocation" size=20 onFocus="this.blur()" value="故障简报"></TD>
            <TD bgcolor="#f6f6f6">&nbsp;来源编号*</TD>
            <TD><input type=text name="VoltageLevel" id="VoltageLevel" size=20 onFocus="this.blur()" value="0101010101"></TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;线路名</TD>
            <TD><input type=text name="linename" id="linename" size=20 onFocus="this.blur()" value="----">
              <span class="hand" onclick='window.open("<%=request.getContextPath()%>/common/qryeqpbysep/qrymain.jsp","a","scrollbars=yes,resizable=yes,width=1018,height=655,top=0,left=0","popwindow","channelmode","newwindow")'>
              <img src="<%=request.getContextPath()%>/themes/themes1/images/main/mag.gif"></span></TD>
            <TD bgcolor="#f6f6f6">&nbsp;设备名*</TD>
            <TD><input type=text name="EquipmentName" id="EquipmentName" size=20 onFocus="this.blur()" value="母线">
              <span class="hand" onclick='window.open("<%=request.getContextPath()%>/common/qryeqpbysep/qrymain.jsp","a","scrollbars=yes,resizable=yes,width=1018,height=655,top=0,left=0","popwindow","channelmode","newwindow")'>
              <img src="<%=request.getContextPath()%>/themes/themes1/images/main/mag.gif"></span></TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;工作地点*</TD>
            <TD><input type=text name="worklocation" id="worklocation" size=20 value="标准工作地点"></TD>
            <TD bgcolor="#f6f6f6">&nbsp;电压等级*</TD>
            <TD><input type=text name="VoltageLevel" id="VoltageLevel" size=20 onFocus="this.blur()" value="10 （kV）"></TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;变电站*</TD>
            <TD><input type=text name="SubStation" id="SubStation" size=20 onFocus="this.blur()" value="朝阳门站"></TD>
            <TD bgcolor="#f6f6f6">&nbsp;调度号*</TD>
            <TD><input type=text name="DispatchingNumber" id="DispatchingNumber" size=20 onFocus="this.blur()" value="203"></TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;停电范围</TD>
            <TD colSpan=3><textarea name="note" rows="4" cols="120">标准停电范围</textarea></TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;申请工区*</TD>
            <TD>
              <input type=text name="applyworkarea" id="applyworkarea" size=20 value="检修工区">
              <img src="<%=request.getContextPath()%>/themes/themes1/images/main/mag.gif" alt="默认当前用户所在工区，输入选项为曾经输入的工区列表">
            </TD>
            <TD bgcolor="#f6f6f6">&nbsp;申请人*</TD>
            <TD>
              <input type=text name="applyperson" id="applyperson" size=20 value="李清照">
              <img src="<%=request.getContextPath()%>/themes/themes1/images/main/mag.gif" alt="默认当前用户，输入选项为曾经输入的人员位列表">
            </TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;申请单位*</TD>
            <TD>
              <input type=text name="applyunit" id="applyunit" size=20 value="朝阳公司">
              <img src="<%=request.getContextPath()%>/themes/themes1/images/main/mag.gif" alt="默认当前用户所在单位，输入选项为曾经输入的单位列表">
            </TD>
            <TD bgcolor="#f6f6f6">&nbsp;申请时间*</TD>
            <TD><input type=text name="applyTime" id="applyTime" size=16 value="2006-09-18 09:00">
              <img src="<%=request.getContextPath()%>/themes/themes1/images/main/data.gif" name="applyTime" height="16" border="0" align="middle" style="cursor:hand" onClick="setday(this,'','applyTime','yy-mm-dd hh:mm')"></TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;上报日期*</TD>
            <TD><input type=text name="reportTime" id="reportTime" size=16 value="2006-09-18 09:19">
              <img src="<%=request.getContextPath()%>/themes/themes1/images/main/data.gif" name="applyTime" height="16" border="0" align="middle" style="cursor:hand" onClick="setday(this,'','reportTime','yy-mm-dd hh:mm')"></TD>
            <TD bgcolor="#f6f6f6">&nbsp;执行状态*</TD>
            <TD>
              <input type=text name="applyunit" id="applyunit" size=20 onFocus="this.blur()" value="未执行">
            </TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;未执行原因</TD>
            <TD colSpan=3><textarea name="note" rows="2" cols="90">由于政治保电取消[2003年]保字第[108]号</textarea></TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;备注</TD>
            <TD colSpan=3><textarea name="note" rows="2" cols="90">将１１０ＫＶ５＃负荷倒４＃母线</textarea></TD>
          </TR>
        </TBODY>
      </TABLE>
    </td>
  </tr>
</table>
<table><tr><td height="8"></td></tr></table>
<table class="detailmain" cellspacing="0" cellpadding="0">
  <tr>
    <th colspan="4" class="pt" align="left" height="20">&nbsp;&nbsp;
      <a href="javascript:popmenu(table1);">
        <img src="<%=request.getContextPath()%>/themes/themes1/images/main/zd.gif">
      </a>&nbsp;工作内容
    </th>
    <th class="pt" align="center" height="20" width="10%">
      <img src="<%=request.getContextPath()%>/themes/themes1/images/main/txt01.gif" alt="增加">&nbsp;&nbsp;
      <img src="<%=request.getContextPath()%>/themes/themes1/images/main/as.gif" alt="保存">&nbsp;&nbsp;
      <img src="<%=request.getContextPath()%>/themes/themes1/images/main/delet.gif" alt="删除">
    </th>
  </tr>
  <tr id="table1">
    <td align="center" colspan="5">
      <TABLE class="detail" width="100%" height="100%" cellspacing="0">
        <tr>
          <th width="20%" align="center">电压等级</th>
          <th width="20%" align="center">设备名称</th>
          <th width="20%" align="center">调度号</th>
          <th colspan="2" align="center">工作任务</th>
        </tr>
        <TR>
          <TD width="20%">110Kv</TD>
          <TD width="20%">1＃主变压器</TD>
          <td width="20%">1#</td>
          <td width="20%">中修</td>
          <td width="20%"><input name="operation" type="text" size="16" value="完善性"/></td>
        </TR>
        <TR>
          <TD width="20%">110Kv</TD>
          <TD width="20%">2212开关</TD>
          <td width="20%">2212</td>
          <td width="20%">清扫</td>
          <td width="20%"><input name="operation" type="text" size="16" value="处理铁板过热"/></td>
        </TR>
        <TR>
          <TD width="20%">110Kv</TD>
          <TD width="20%">……</TD>
          <td width="20%">……</td>
          <td width="20%">……</td>
          <td width="20%"><input name="operation" type="text" size="16" value="补充信息"/></td>
        </TR>
      </TABLE>
    </td>
  </tr>
</table>
<table>
  <tr><td height="8"></td></tr>
</table>

<table class="detailmain" cellspacing="0" cellpadding="0">
  <tr>
    <th class="pt" align="left" height="20">&nbsp;&nbsp;<a href="javascript:popmenu(table2);">
      <img src="<%=request.getContextPath()%>/themes/themes1/images/main/zd.gif"></a>&nbsp;停发电顺序
    </th>
    <th class="pt" align="center" height="20" width="10%">
      <img src="<%=request.getContextPath()%>/themes/themes1/images/main/as.gif" alt="保存">
    </th>
  </tr>
  <tr id="table2">
    <td colspan="4">
      <textarea name="counterplan" rows="2" cols="120"></textarea>
    </td>
  </tr>
</table>

</body>
</html>
