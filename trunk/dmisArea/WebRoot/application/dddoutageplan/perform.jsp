<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map"%>
<%@ include file="/common/init_tag.jsp"%>
<html>
	<head>
		<html:base />
		<title>自动化设备缺陷详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
	</head>
	<body bgcolor="#ffffff">

		<jhop:ctrlgroup
			ctrlId="UIControlGroupXPanel2941c258bf014ce0b83a7c5da5440e8a"
			title="基本信息">
		</jhop:ctrlgroup>

		<table class="detailmain" cellspacing="0" cellpadding="0">
			<tr id="UIControlGroupXPanel2941c258bf014ce0b83a7c5da5440e8a">
				<td align="center">
					<table class="detail" width="100%" height="100%" cellspacing="0">
						<TR>
							<td height="23" class="tab_0" width="12%">
								&nbsp;计划编号
							</TD>
							<td height="23" width="38%">
								<input name="textfield" type="text" onFocus="this.blur()"
									value="2006090034">
							</TD>
							<td height="23" class="tab_0" width="12%">
								工作地点
							</TD>
							<td height="23" width="38%">
								<input name="textfield2" type="text" onFocus="this.blur()"
									value="新温泉站">
							</TD>
						</TR>
						<TR>
							<TD class="tab_0">
								&nbsp;计划工作时间
							</TD>
							<TD>
								<input type=text name="workstarTime" id="workstarTime"
									onFocus="this.blur()" size=16 value="2006-09-21 07:00">
								到
								<input type=text name="workendTime" id="workendTime"
									onFocus="this.blur()" size=16 value="2006-09-26 17:30">
							</TD>
							<TD class="tab_0">
								&nbsp;计划停电时间*
							</TD>
							<TD>
								<input type=text name="outagestarTime" id="outagestarTime"
									onFocus="this.blur()" size=16 value="2006-09-21 07:00">
								到
								<input type=text name="outageendTime" id="outageendTime"
									onFocus="this.blur()" size=16 value="2006-09-26 17:30">
							</TD>
						</TR>
					</table>
				</td>
			</tr>
		</table>

		<table>
			<tr>
				<td height="8"></td>
			</tr>
		</table>

		<jhop:ctrlgroup ctrlId="dianzizhang" title="电子章"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="dianzizhang">
				<td colspan="2">
					<table align="center" width="100%">
						<tr>
							<td height="30" width="20%" align="center">
								<img src="chart1.jpg" alt="12" height="40">
							</td>
							<td>
								<iframe id="test1" src="cooperate.jsp" width="100%" height="100"
									frameborder="0" scrolling="no"></iframe>
							</td>
						</tr>
						<tr valign="middle">
							<td colspan="2">
								<label>
									<input type="checkbox" name="checkbox" value="checkbox">
								</label>
								<img src="chart2.jpg" alt="" height="40">
								&nbsp;&nbsp;
								<label>
									<input type="checkbox" name="checkbox2" value="checkbox">
								</label>
								<img src="chart3.jpg" alt="" height="40">
								&nbsp;&nbsp;
								<select name="dzz">
									<option>
										请选择需要加盖的电子章
									</option>
									<option>
										线路有电？？？
									</option>
									<option>
										线路有电！！！
									</option>
									<option>
										线路有电@^@
									</option>
								</select>
							</td>
						</tr>
					</table>
				</td>
			</tr>
</table>
			<tr>
				<td height="8"></td>
			</tr>
		</table>

		<jhop:ctrlgroup ctrlId="xialingshouling" title="下令收令情况"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="xialingshouling">
				<td align="center" colspan="4">
					<TABLE class="detail" cellSpacing="0" cellPadding="3" width="100%"
						align="center">
						<tr>
							<td colspan="6">
								<iframe id="test1" src="orderrecord.jsp" width="100%"
									height="150" frameborder="0" scrolling="no"></iframe>
							</td>
						</tr>
					</TABLE>
					<table width="100%">
						<tr>
							<td align="left" width="100%">
								<select name="operation">
									<option>
										完成
									</option>
									<option>
										未完成
									</option>
								</select>
								（原因：
								<input type="text" size="80" name="textfield3">
								）
								<input type="submit" name="Submit2" value="确认">
							</td>
						</tr>
					</table>
				</td>
			</tr>
</table>
		<table>
			<tr>
				<td height="8"></td>
			</tr>
		</table>
<jhop:ctrlgroup ctrlId="zdml" title="中调命令"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="zdml">
				<td align="center" colspan="4">
					<TABLE class="detail" width="100%" height="100%" cellspacing="0">
						<TBODY>
							<TR>
								<TD width="13%" bgcolor="#f6f6f6">
									&nbsp;中调下令时间
								</TD>
								<TD width="20%">
									<input type=text name="workstarTime" id="workstarTime"
										onFocus="this.blur()" size=16 value="2006-09-21 07:00">
									&nbsp;
								</TD>
								<TD width="13%" bgcolor="#f6f6f6">
									&nbsp;中调下令人
								</TD>
								<TD width="20%">
									<input type=text name="workendTime" id="workendTime" size=16
										onFocus="this.blur()" value="姓名">
								</TD>
								<TD width="13%" bgcolor="#f6f6f6">
									&nbsp;市调接令人姓名
								</TD>
								<TD width="20%">
									<input type=text name="workstarTime" id="workstarTime" size=16
										onFocus="this.blur()" value="姓名">
								</TD>
							</TR>
							<TR>
								<TD bgcolor="#f6f6f6">
									&nbsp;中调下令内容
								</TD>
								<TD colSpan=5>
									<input type=text name="workstarTime" id="workstarTime"
										onFocus="this.blur()" size=100 value="">
								</TD>
							</TR>
							<TR>
								<TD width="13%" bgcolor="#f6f6f6">
									&nbsp;向中调交令时间
								</TD>
								<TD width="20%">
									<input type=text name="workstarTime" id="workstarTime" size=16
										onFocus="this.blur()" value="2006-09-21 07:00">
									&nbsp;
								</TD>
								<TD width="13%" bgcolor="#f6f6f6">
									&nbsp;中调收令人
								</TD>
								<TD width="20%">
									<input type=text name="workendTime" id="workendTime" size=16
										value="姓名">
								</TD>
								<TD width="13%" bgcolor="#f6f6f6">
									&nbsp;市调交令人姓名
								</TD>
								<TD width="20%">
									<input type=text name="workendTime" id="workendTime" size=16
										onFocus="this.blur()" value="姓名">
								</TD>
							</TR>
							<TR>
								<TD bgcolor="#f6f6f6">
									&nbsp;向中调交令内容
								</TD>
								<TD colSpan=5>
									<input type=text name="workstarTime" id="workstarTime" size=100
										onFocus="this.blur()" value="">
								</TD>
							</TR>
						</TBODY>
					</TABLE>
				</td>
			</tr>
</table>

		<table>
			<tr>
				<td height="8"></td>
			</tr>
		</table>

		<jhop:ctrlgroup ctrlId="jhyq" title="计划延期"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	 <tr id="jhya">
				<td colspan="4">
					<iframe id="test2" src="delay.jsp" width="100%" height="150"
						frameborder="0" scrolling="no"></iframe>
				</td>
			</tr>
</table>
	</body>
</html>
