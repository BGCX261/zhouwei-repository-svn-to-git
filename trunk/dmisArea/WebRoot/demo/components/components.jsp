<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%
	String path = request.getContextPath();
%> 
<%@ include file="../../common/init_tag.jsp"%>
 <html>
<head> 
<html:base/>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>标签测试页面</title>
<link href="<%=path %>/themes/themes1/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=path %>/script/tabs/tab.js"></script>
<script language="JavaScript" src="<%=path %>/script/selectdate.js"></script>
<script LANGUAGE="JavaScript"> 
<!-- 
function openwin() { 
window.open ("movelist.jsp", "newwindow", "height=550, width=550, top=10 ,left=10, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no") 
//写成一行 
} 
//--> 
</script> 

</head>

<body>
         <jhop:ctrlgroup ctrlId="table0" name="标签控件"   status="yes" ></jhop:ctrlgroup>
         <div id="table0" >
		     <TABLE width="100%" align=center cellPadding=3 cellSpacing=0 border="1">
					  <TBODY>
					    <tr><td></td><td><b>控件例子</b></td><td></td></tr>
						<TR>
						  <TD align="center">开始时间:  <jhop:selectdate startName="start" type="no" endName="end" dataFormat="yy年mm月dd日 hh时mm分"></jhop:selectdate></TD>
						  <TD align="center"> 结束时间: <jhop:selectdate startName="start"  type="yes" endName="end" dataFormat="yy年mm月dd日 hh时mm分"></jhop:selectdate></TD></TR>
						
						<TR class=gridStyle-tr-alt-data>
						  <TD align="center">普通下拉列表控件: </TD>
						  <TD align="center"></TD>
						  <TD align="center"></TD>
						</TR>
						<TR class=gridStyle-tr-alt-data>
						  <TD align="center">级联下拉列表控件: </TD>
						  <TD align="center"></TD>
						  <TD align="center"></TD>
						</TR>
						<TR class=gridStyle-tr-data>
						
						  <TD align="center">列表互动控件: </TD>
<TD align="center"><img title="点击弹出" src="<%=request.getContextPath()%>/themes/themes1/images/main/mag.gif" onclick="openwin()" ></TD>
						   
						</TR>
					  </TBODY>
					</TABLE>
		    </div>
         
		 <jhop:ctrlgroup ctrlId="table1" name="计划执行"   status="yes" ></jhop:ctrlgroup>
		 
			<div id="table1" >
		     <TABLE width="100%" align=center cellPadding=3 cellSpacing=0>
					  <TBODY>
						<TR>
						  <TD align="center">序号 </TD>
						  <TD align="center">变电站</TD>
						  <TD align="center">被保护对象</TD>
						  <TD align="center">被保护对象调度号</TD>
						  <TD align="center">保护名称</TD>
						  <TD align="center">整定时间 </TD>
						  <TD align="center">定值单原件 </TD>
						</TR>
						<TR class=gridStyle-tr-data>
						  <TD align=middle><A href="javascript:planDayQuery.Plan_number.value='100012441';planDayQuery.submit();">1</A> </TD>
						  <TD>新温泉站</TD>
						  <TD>变压器</TD>
						  <TD>1#</TD>
						  <TD>四方保护</TD>
						  <TD>2006-9-12</TD>
						  <TD><img src="../../images/main/qbz.gif" ></TD>
						</TR>
						<TR class=gridStyle-tr-alt-data>
						  <TD align="center"><A href="javascript:planDayQuery.Plan_number.value='300011950';planDayQuery.submit();">2</A> </TD>
						  <TD>新温泉站</TD>
						  <TD>变压器</TD>
						  <TD>1#</TD>
						  <TD>南瑞保护</TD>
						  <TD>2006-9-13</TD>
						  <TD><img src="../../images/main/qbz.gif" ></TD>
						</TR>
					  </TBODY>
					</TABLE>
		    </div>
		   
		   
		    <jhop:ctrlgroup ctrlId="table2" name="基本信息"  status="yes"></jhop:ctrlgroup>
		   <div id="table2" > 
		        <TABLE class="detail" width="100%" height="100%" cellspacing="0">
        <TBODY>
          <TR>
            <TD width=164 bgcolor="#f6f6f6" align="right">&nbsp;计划编号</TD>
            <TD width=308>&nbsp;&nbsp;</TD>
            <TD width=154 bgcolor="#f6f6f6" align="right">计划来源类型</TD>
            <TD width=263>&nbsp;来自月计划</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;计划工作开始时间*</TD>
            <TD>&nbsp;2006-09-21 08:00[日期时间型]</TD>
            <TD bgcolor="#f6f6f6">&nbsp;计划工作结束时间*</TD>
            <TD>
            <jhop:date  dataFormat="yy年mm月dd日 hh时mm分" genText="yes"  name="endText"></jhop:date>
           </TD>
              
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;计划停电开始时间*</TD>
            <TD>&nbsp;2006-09-21 07:00[日期时间型]</TD>
            <TD bgcolor="#f6f6f6">&nbsp;计划停电恢复时间*</TD>
            <TD>&nbsp;2006-09-26 17:30[日期时间型]</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;停电范围*</TD>
            <TD colSpan=3>
              <textarea name="textarea" rows="2" cols="90">1#变保护传动,110KV自投传动,1#变、110KV49CVT、35KV01LA预试。更换112CT、101CT,110KV中性点LA更换放电间隙。发电后停1#变差动保护测差动向量,10KV4#母线及开关预试,112开关渗油处缺</textarea>            </TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;工作地点*</TD>
            <TD colSpan=3>&nbsp;东北郊站</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;工作内容*</TD>
            <TD colSpan=3>&nbsp;停新温泉站112－2刀闸以下</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;线路名</TD>
            <TD>&nbsp;&nbsp;</TD>
            <TD bgcolor="#f6f6f6">&nbsp;设备名*</TD>
            <TD>&nbsp;母线[标准输入]<img src="<%=request.getContextPath()%>/themes/themes1/images/main/mag.gif"></TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;变电站*</TD>
            <TD>&nbsp;东北郊站[标准输入]<img src="<%=request.getContextPath()%>/themes/themes1/images/main/mag.gif"></TD>
            <TD bgcolor="#f6f6f6">&nbsp;调度号*</TD>
            <TD>&nbsp;203</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;电压等级*</TD>
            <TD>&nbsp;10 kV [标准输入]<img src="<%=request.getContextPath()%>/themes/themes1/images/main/mag.gif"></TD>
            <TD bgcolor="#f6f6f6">&nbsp;申请工区*</TD>
            <TD>&nbsp;检修工区</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;申请单位*</TD>
            <TD>默认填报人所在单位，可以修改 [标准输入]</TD>
            <TD bgcolor="#f6f6f6">&nbsp;申请时间*</TD>
            <TD>&nbsp;2006-09-18 09:00</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;申请人*</TD>
            <TD>&nbsp;默认填报人，可以修改</TD>
            <TD bgcolor="#f6f6f6">&nbsp;上报日期*</TD>
            <TD>&nbsp;2006-09-18 09:19</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;附图</TD>
            <TD colSpan=3>（支持ＧＩＦ，文件小于１Ｍ）<a href="#" target="_blank"><img src="<%=request.getContextPath()%>/themes/themes1/images/main/qbz.gif"><a></TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;</TD>
            <TD colSpan=3>&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#f6f6f6">&nbsp;备注</TD>
            <TD colSpan=3>&nbsp;&nbsp;将１１０ＫＶ５＃负荷倒４＃母线</TD>
          </TR>
        </TBODY>
      </TABLE>
       </div>
	</body>
</html>
 