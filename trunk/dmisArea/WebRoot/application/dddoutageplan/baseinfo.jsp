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
      <a href="javascript:popmenu(table0);"><img src="<%=request.getContextPath()%>/themes/themes1/images/main/zd.gif"></a>&nbsp;������Ϣ
    </th>
  </tr>
  <tr id="table0">
    <td align="center">
      <TABLE class="detail" width="100%" height="100%" cellspacing="0">
        <TBODY>
          <TR>
            <TD width=164 bgcolor="#f6f6f6" align="right">&nbsp;�ƻ����</TD>
            <TD width=308><label>
              <input name="textfield" type="text" onFocus="this.blur()" value="2006090034">
            </label></TD>
            <TD width=154 bgcolor="#f6f6f6" align="right">�ƻ�����</TD>
            <TD width=263><label>
            <select name="select">
              <option>���޼ƻ�</option>
              <option>���̼ƻ�</option>
              <option>�Ǽƻ�</option>
            </select>
            </label></TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;�ƻ�����ʱ��*</TD>
            <TD>
              <input type=text name="workstarTime" id="workstarTime" size=16 value="2006-09-21 07:00">&nbsp;
              <img src="<%=request.getContextPath()%>/themes/themes1/images/main/data.gif" name="workstarTime" height="16" border="0" align="middle" style="cursor:hand" onClick="setday(this,'','workstarTime','yy-mm-dd hh:mm')">
              ��
              <input type=text name="workendTime" id="workendTime" size=16 value="2006-09-26 17:30">&nbsp;
              <img src="<%=request.getContextPath()%>/themes/themes1/images/main/data.gif" name="workendTime" height="16" border="0" align="middle" style="cursor:hand" onClick="setday(this,'','workendTime','yy-mm-dd hh:mm')">
            </TD>
            <TD bgcolor="#f6f6f6">&nbsp;�ƻ�ͣ��ʱ��*</TD>
            <TD>
              <input type=text name="outagestarTime" id="outagestarTime" size=16 value="2006-09-21 07:00">&nbsp;
              <img src="<%=request.getContextPath()%>/themes/themes1/images/main/data.gif" name="outagestarTime" height="16" border="0" align="middle" style="cursor:hand" onClick="setday(this,'','outagestarTime','yy-mm-dd hh:mm')">
              ��
              <input type=text name="outageendTime" id="outageendTime" size=16 value="2006-09-26 17:30">&nbsp;
              <img src="<%=request.getContextPath()%>/themes/themes1/images/main/data.gif" name="outageendTime" height="16" border="0" align="middle" style="cursor:hand" onClick="setday(this,'','outageendTime','yy-mm-dd hh:mm')">
            </TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;�ƻ���Դ*</TD>
            <TD><input type=text name="worklocation" id="worklocation" size=20 onFocus="this.blur()" value="���ϼ�"></TD>
            <TD bgcolor="#f6f6f6">&nbsp;��Դ���*</TD>
            <TD><input type=text name="VoltageLevel" id="VoltageLevel" size=20 onFocus="this.blur()" value="0101010101"></TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;��·��</TD>
            <TD><input type=text name="linename" id="linename" size=20 onFocus="this.blur()" value="----">
              <span class="hand" onclick='window.open("<%=request.getContextPath()%>/common/qryeqpbysep/qrymain.jsp","a","scrollbars=yes,resizable=yes,width=1018,height=655,top=0,left=0","popwindow","channelmode","newwindow")'>
              <img src="<%=request.getContextPath()%>/themes/themes1/images/main/mag.gif"></span></TD>
            <TD bgcolor="#f6f6f6">&nbsp;�豸��*</TD>
            <TD><input type=text name="EquipmentName" id="EquipmentName" size=20 onFocus="this.blur()" value="ĸ��">
              <span class="hand" onclick='window.open("<%=request.getContextPath()%>/common/qryeqpbysep/qrymain.jsp","a","scrollbars=yes,resizable=yes,width=1018,height=655,top=0,left=0","popwindow","channelmode","newwindow")'>
              <img src="<%=request.getContextPath()%>/themes/themes1/images/main/mag.gif"></span></TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;�����ص�*</TD>
            <TD><input type=text name="worklocation" id="worklocation" size=20 value="��׼�����ص�"></TD>
            <TD bgcolor="#f6f6f6">&nbsp;��ѹ�ȼ�*</TD>
            <TD><input type=text name="VoltageLevel" id="VoltageLevel" size=20 onFocus="this.blur()" value="10 ��kV��"></TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;���վ*</TD>
            <TD><input type=text name="SubStation" id="SubStation" size=20 onFocus="this.blur()" value="������վ"></TD>
            <TD bgcolor="#f6f6f6">&nbsp;���Ⱥ�*</TD>
            <TD><input type=text name="DispatchingNumber" id="DispatchingNumber" size=20 onFocus="this.blur()" value="203"></TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;ͣ�緶Χ</TD>
            <TD colSpan=3><textarea name="note" rows="4" cols="120">��׼ͣ�緶Χ</textarea></TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;���빤��*</TD>
            <TD>
              <input type=text name="applyworkarea" id="applyworkarea" size=20 value="���޹���">
              <img src="<%=request.getContextPath()%>/themes/themes1/images/main/mag.gif" alt="Ĭ�ϵ�ǰ�û����ڹ���������ѡ��Ϊ��������Ĺ����б�">
            </TD>
            <TD bgcolor="#f6f6f6">&nbsp;������*</TD>
            <TD>
              <input type=text name="applyperson" id="applyperson" size=20 value="������">
              <img src="<%=request.getContextPath()%>/themes/themes1/images/main/mag.gif" alt="Ĭ�ϵ�ǰ�û�������ѡ��Ϊ�����������Աλ�б�">
            </TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;���뵥λ*</TD>
            <TD>
              <input type=text name="applyunit" id="applyunit" size=20 value="������˾">
              <img src="<%=request.getContextPath()%>/themes/themes1/images/main/mag.gif" alt="Ĭ�ϵ�ǰ�û����ڵ�λ������ѡ��Ϊ��������ĵ�λ�б�">
            </TD>
            <TD bgcolor="#f6f6f6">&nbsp;����ʱ��*</TD>
            <TD><input type=text name="applyTime" id="applyTime" size=16 value="2006-09-18 09:00">
              <img src="<%=request.getContextPath()%>/themes/themes1/images/main/data.gif" name="applyTime" height="16" border="0" align="middle" style="cursor:hand" onClick="setday(this,'','applyTime','yy-mm-dd hh:mm')"></TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;�ϱ�����*</TD>
            <TD><input type=text name="reportTime" id="reportTime" size=16 value="2006-09-18 09:19">
              <img src="<%=request.getContextPath()%>/themes/themes1/images/main/data.gif" name="applyTime" height="16" border="0" align="middle" style="cursor:hand" onClick="setday(this,'','reportTime','yy-mm-dd hh:mm')"></TD>
            <TD bgcolor="#f6f6f6">&nbsp;ִ��״̬*</TD>
            <TD>
              <input type=text name="applyunit" id="applyunit" size=20 onFocus="this.blur()" value="δִ��">
            </TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;δִ��ԭ��</TD>
            <TD colSpan=3><textarea name="note" rows="2" cols="90">�������α���ȡ��[2003��]���ֵ�[108]��</textarea></TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;��ע</TD>
            <TD colSpan=3><textarea name="note" rows="2" cols="90">���������ˣ֣������ɵ�����ĸ��</textarea></TD>
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
      </a>&nbsp;��������
    </th>
    <th class="pt" align="center" height="20" width="10%">
      <img src="<%=request.getContextPath()%>/themes/themes1/images/main/txt01.gif" alt="����">&nbsp;&nbsp;
      <img src="<%=request.getContextPath()%>/themes/themes1/images/main/as.gif" alt="����">&nbsp;&nbsp;
      <img src="<%=request.getContextPath()%>/themes/themes1/images/main/delet.gif" alt="ɾ��">
    </th>
  </tr>
  <tr id="table1">
    <td align="center" colspan="5">
      <TABLE class="detail" width="100%" height="100%" cellspacing="0">
        <tr>
          <th width="20%" align="center">��ѹ�ȼ�</th>
          <th width="20%" align="center">�豸����</th>
          <th width="20%" align="center">���Ⱥ�</th>
          <th colspan="2" align="center">��������</th>
        </tr>
        <TR>
          <TD width="20%">110Kv</TD>
          <TD width="20%">1������ѹ��</TD>
          <td width="20%">1#</td>
          <td width="20%">����</td>
          <td width="20%"><input name="operation" type="text" size="16" value="������"/></td>
        </TR>
        <TR>
          <TD width="20%">110Kv</TD>
          <TD width="20%">2212����</TD>
          <td width="20%">2212</td>
          <td width="20%">��ɨ</td>
          <td width="20%"><input name="operation" type="text" size="16" value="�����������"/></td>
        </TR>
        <TR>
          <TD width="20%">110Kv</TD>
          <TD width="20%">����</TD>
          <td width="20%">����</td>
          <td width="20%">����</td>
          <td width="20%"><input name="operation" type="text" size="16" value="������Ϣ"/></td>
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
      <img src="<%=request.getContextPath()%>/themes/themes1/images/main/zd.gif"></a>&nbsp;ͣ����˳��
    </th>
    <th class="pt" align="center" height="20" width="10%">
      <img src="<%=request.getContextPath()%>/themes/themes1/images/main/as.gif" alt="����">
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
