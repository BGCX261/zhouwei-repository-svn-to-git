package com.techstar.framework.ui.web.tag;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.techstar.framework.ui.web.tag.utils.GridConstant;

public class JHopOptionTransferTag extends JHopBaseTag {

	/**
	 *   select选择框的名称
	 */
	private String title;

	/**
	 *  左列选择框的数据  以键值对
	 */

	private Map startData;

	/**
	 *   右列选择框的数据 以键值对
	 */
	private Map endData;

	/**
	 *  样式表style字串
	 */
	String styleStr;

	/**
	 *  Javascript字串
	 */
	String scriptStr;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Map getStartData() {
		return startData;
	}

	public void setStartData(Map startData) {
		this.startData = startData;
	}

	public Map getEndData() {
		return endData;
	}

	public void setEndData(Map endData) {
		this.endData = endData;
	}

	public String getStyle() {
		styleStr = "<style>               			";
		styleStr += "body";
		styleStr += "{";
		styleStr += "	SCROLLBAR-FACE-COLOR: #dfdfdf;";
		styleStr += "	SCROLLBAR-HIGHLIGHT-COLOR: #f4f4f4;";
		styleStr += "	SCROLLBAR-SHADOW-COLOR: #ffffff;";
		styleStr += "	SCROLLBAR-ARROW-COLOR: #5b5b5b;";
		styleStr += "	scrollbar-dark-shadow-color: #ffffff;";
		styleStr += "	scrollbar-3d-light-color: #ffffff;";
		styleStr += "	margin-left: 0px;";
		styleStr += "	margin-top: 0px;";
		styleStr += "	margin-right: 0px;";
		styleStr += "	margin-bottom: 0px;";
		styleStr += "	text-align:center;";
		styleStr += "}";
		styleStr += "table";
		styleStr += "{";
		styleStr += "	WORD-BREAK:break-all;";
		styleStr += "	font-size: 12px;";
		styleStr += "	font-family:Arial, Helvetica, sans-serif,宋体;";
		styleStr += "}";
		styleStr += "a:link";
		styleStr += "{";
		styleStr += "	font-family:Arial, Helvetica, sans-serif;";
		styleStr += "	color:#000000;";
		styleStr += "	text-decoration:none;";
		styleStr += "}";
		styleStr += "a:visited";
		styleStr += "{";
		styleStr += "	font-family:Arial, Helvetica, sans-serif;";
		styleStr += "	color:#000000;";
		styleStr += "	text-decoration:none;";
		styleStr += "}";
		styleStr += ".pt";
		styleStr += "{";
		styleStr += "	padding-top:1px;";
		styleStr += "}";
		styleStr += ".hand";
		styleStr += "{";
		styleStr += "	cursor:hand;";
		styleStr += "}";
		styleStr += ".label_top";
		styleStr += "{";
		styleStr += "	width:100%;";
		styleStr += "}";
		styleStr += ".ooib";
		styleStr += "{";
		styleStr += "	width:960px;";
		styleStr += "	height:300px;"; //设置表格高度
		styleStr += "	border-width: 1px;";
		styleStr += "	border-style: none solid solid;";
		styleStr += "	border-color: #dadada;";
		styleStr += "}";
		styleStr += ".hr";
		styleStr += "{";
		styleStr += "	color:#ffffff;";
		styleStr += "}";
		styleStr += ".ooih td";
		styleStr += "{";
		styleStr += "	border-width: 1px;";
		styleStr += "	padding:10px 5px 3px 5px;";
		styleStr += "}";
		styleStr += ".ooihj";
		styleStr += "{";
		styleStr += "	color: #000000;";
		styleStr += "	background-color: #ffffff;";
		styleStr += "	border-style: solid solid none;";
		styleStr += "	border-color: #dadada;";
		styleStr += "	text-decoration:none;";
		styleStr += "	font-weight:bolder;";
		styleStr += "	padding-left:10px;";
		styleStr += "}";
		styleStr += ".ooihs";
		styleStr += "{																	 ";
		styleStr += "	color: #006f6a;													 ";
		styleStr += "	background-color: #f9ffff;										 ";
		styleStr += "	border-style: solid;											 ";
		styleStr += "	border-color: #dadada #dadada #dadada;							 ";
		styleStr += "	cursor: hand;													 ";
		styleStr += "	text-decoration:underline;										 ";
		styleStr += "}																	 ";
		styleStr += ".ooihx																 ";
		styleStr += "{																	 ";
		styleStr += "	border-style: none none solid;									 ";
		styleStr += "	border-color: #dadada;											 ";
		styleStr += "}																	 ";
		styleStr += "#lable2															 ";
		styleStr += "{																	 ";
		styleStr += "	width:100%;														 ";
		styleStr += "	height:30px;													 ";
		styleStr += "	border-style:none;												 ";
		styleStr += "}																	 ";
		styleStr += "</style>															 ";
		return styleStr;
	}

	public String getScript() {
		scriptStr = "<script language='javascript'>									                         ";
		scriptStr += "	function openOptionTransfer(objectId)							                         ";
		scriptStr += "	{														                                 ";
		scriptStr += "		var elem = document.getElementById(objectId);				                         ";
		scriptStr += "	    var top  = elem.offsetTop+elem.offsetHeight;                                         ";
		scriptStr += "		var left = elem.offsetLeft;							                                 ";
		scriptStr += "		var o    = objectId+'div';						                                     ";
		scriptStr += "		var oElem    = document.getElementById(o);              						     ";
		scriptStr += "		oElem.style.top   = top;	                                                         ";
		scriptStr += "		oElem.style.left  = left;                                                            ";
		scriptStr += "      oElem.style.visibility ='visible';                                                   ";
		scriptStr += "	}																                         ";
		scriptStr += "	function moveOption(titleDiv)										                             ";
		scriptStr += "	{														                                 ";
		scriptStr += "		var elem = event.srcElement;				                                         ";
		scriptStr += " 		var startDiv  = titleDiv+'start';									                 ";
		scriptStr += " 		var endDiv    = titleDiv+'end';									                     ";
		scriptStr += "		var startElem = document.getElementById(startDiv);				                     ";
		scriptStr += "		var endElem =   document.getElementById(endDiv);					                 ";
		scriptStr += "	    if(elem.id=='mLeft')                                                                 ";
		scriptStr += "		{						                                                             ";
		scriptStr += "			var length = endElem.length;                                                     ";
		scriptStr += "		    for(var x=0;x<length;x++)                                                        ";
		scriptStr += "		    {                                                                                ";
		scriptStr += " 				var optionText = endElem.options[x].text;                                    ";
		scriptStr += "		    	var optionValue= endElem.options[x].value;                                   ";
		scriptStr += "		   		startElem.options[startElem.length] = new Option(optionText,optionValue);    ";
		scriptStr += "		    }                                                                                ";
		scriptStr += "		    endElem.length = 0;                                                              ";
		scriptStr += "		}                                                                                    ";
		scriptStr += "		else if(elem.id=='oLeft')                                                            ";
		scriptStr += "		{                                                                                    ";
		scriptStr += "			for(var x=0;x<endElem.length;x++)                                                ";
		scriptStr += "			{															                     ";
		scriptStr += "				if(endElem.options[x].selected == true)						                 ";
		scriptStr += "				{					                                                         ";
		scriptStr += "		    		var optionText  = endElem.options[x].text;                               ";
		scriptStr += "		    		var optionValue = endElem.options[x].value;                              ";
		scriptStr += "		    		startElem.options[startElem.length] = new Option(optionText,optionValue);";
		scriptStr += "		    		endElem.options[x] = null;                                               ";
		scriptStr += "		    		x--;                                                                     ";
		scriptStr += " 				}			                                                                 ";
		scriptStr += " 			}			                                                                     ";
		scriptStr += " 		}			                                                                         ";
		scriptStr += " 		else if(elem.id=='mRight')			                                                 ";
		scriptStr += " 		{			                                                                         ";
		scriptStr += "			var length = startElem.length;                                                   ";
		scriptStr += "		   for(var x=0;x<length;x++)                                                         ";
		scriptStr += "		    {                                                                                ";
		scriptStr += " 				var optionText = startElem.options[x].text;                                  ";
		scriptStr += "		    	var optionValue= startElem.options[x].value;                                 ";
		scriptStr += "		   		endElem.options[endElem.length] = new Option(optionText,optionValue);        ";
		scriptStr += "		    }                                                                                ";
		scriptStr += "		    	startElem.length = 0;                                                        ";
		scriptStr += " 		}			                                                                         ";
		scriptStr += " 		else if(elem.id=='oRight')			                                                 ";
		scriptStr += " 		{			                                                                         ";
		scriptStr += "			for(var x=0;x<startElem.length;x++)                                              ";
		scriptStr += "			{																	             ";
		scriptStr += "				if(startElem.options[x].selected == true)								     ";
		scriptStr += "				{					                                                         ";
		scriptStr += "		    		var optionText  = startElem.options[x].text;                             ";
		scriptStr += "		    		var optionValue = startElem.options[x].value;                            ";
		scriptStr += "		    		endElem.options[endElem.length] = new Option(optionText,optionValue);    ";
		scriptStr += "		    		startElem.options[x] = null; ;                                           ";
		scriptStr += "		    		x--;                                                                     ";
		scriptStr += " 				}			                                                                 ";
		scriptStr += " 			}			                                                                     ";
		scriptStr += " 					                                                                         ";
		scriptStr += " 		}			                                                                         ";
		//scriptStr += "      alert(startElem.length+'#'+endElem.length);                                        ";
		scriptStr += "	}																                         ";
		scriptStr += "</script>															                         ";
		return scriptStr;
	}

	/**
	 * 获得左列表的显示
	 * */
	public String getStartStr(Map startData) {
		Object[] startDataKey = startData.keySet().toArray();
		Object[] startDataValue = startData.values().toArray();

		String startStr = "";
		startStr += "<select name='"
				+ title
				+ "start' id='start' size='16' multiple style='width:150; border:none; outline:none;' >";
		for (int i = 0; i < startDataKey.length; i++)
			startStr += "	<option value='" + startDataValue[i] + "'>"
					+ startDataKey[i] + "</option>";
		startStr += "</select>";

		return startStr;
	}

	/**
	 * 获得右列表的显示
	 * */
	public String getEndStr(Map endData) {
		Object[] endDataKey = endData.keySet().toArray();
		Object[] endDataValue = endData.values().toArray();

		String endStr = "";
		endStr += "<select name='" + title
				+ "end' id='end' size='16' multiple style='width:150;'>";
		for (int i = 0; i < endDataKey.length; i++)
			endStr += "	<option value='" + endDataValue[i] + "'>"
					+ endDataKey[i] + "</option>";
		endStr += "</select>";
		return endStr;
	}

	public String getDivHtml() {
		String htmlStr = "";
		htmlStr += this.getScript();
		htmlStr += this.getStyle();
		htmlStr += "<div id='"
				+ title
				+ "div' class='showdiv' style='position:absolute; top:150px; left:150px; width:97px; height:100px; z-index:8888; background-color:#ffffff; visibility:visible' onMouseOut=''>";
		htmlStr += "   <table border='1' align='center' cellpadding='0' cellspacing='0' bordercolor='#dadada' bgcolor='#FFFFFF' class='tableborder'><tr align='center'><td align='center'>";
		htmlStr += "	<table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		htmlStr += "		<tr>";
		htmlStr += "			<td width='20' bgcolor='#f3f3f3'>&nbsp;</td>";
		htmlStr += "			<td height='30' bgcolor='#f3f3f3'><b>请选择欲统计字段：</b></td>";
		htmlStr += "			<td width='30' bgcolor='#f3f3f3'></td>";
		htmlStr += "		</tr>";
		htmlStr += "	</table>";
		htmlStr += "	<table width='100%' border='0' cellspacing='10' cellpadding='0'>";
		htmlStr += "		<tr>";
		htmlStr += "			<td>";
		htmlStr += "				<table width='100%' border='1' align='center' cellpadding='0' cellspacing='0' bordercolor='#dadada' bgcolor='#FFFFFF' class='tableborder'>";
		htmlStr += "					<tr>";
		htmlStr += "						<td height='18' id='table3'>";
		htmlStr += "							<table width='100%' border='0' cellpadding='0' cellspacing='3'>";
		htmlStr += "								<tr>";
		htmlStr += "									<td>";
		htmlStr += "										<table width='100%' border='1' cellpadding='2' cellspacing='0' bordercolor='#dadada' class='tableborder'>";
		htmlStr += "											<tr>";
		htmlStr += "												<td align='center'>";
		htmlStr += "													<table width='97%' border='0' align='center' cellpadding='3' cellspacing='0'>";
		htmlStr += "														<tr>";
		htmlStr += "															<td bgcolor='#f7f7f7'><div align='center'>待选字段</div></td>";
		htmlStr += "															<td bgcolor='#f7f7f7'>&nbsp;</td>";
		htmlStr += "															<td bgcolor='#f7f7f7'><div align='center'>已选字段</div></td>";
		htmlStr += "														</tr>";
		htmlStr += "														<tr>";
		htmlStr += "														</tr>";
		htmlStr += "														<tr>";
		htmlStr += "															<td width='158'>";
		htmlStr += "																" + this.getStartStr(startData);
		htmlStr += "															</td>";
		htmlStr += "															<td width='18' align='center' bgcolor='#f7f7f7'>";
		htmlStr += "																<img class='hand' id='mLeft' src='"
				+ contextPath
				+ GridConstant.PAGE_IMAGE_PATH+"select_left.gif' onClick=moveOption('"
				+ title + "');>";
		htmlStr += "																<br>";
		htmlStr += "																<img class='hand' id='oLeft' src='"
				+ contextPath
				+ GridConstant.PAGE_IMAGE_PATH+"select2_left.gif' onClick=moveOption('"
				+ title + "');>";
		htmlStr += "																<br>";
		htmlStr += "																<img class='hand' id='oRight' src='"
				+ contextPath
				+ GridConstant.PAGE_IMAGE_PATH+"select2_right.gif' onClick=moveOption('"
				+ title + "');>";
		htmlStr += "																<br>";
		htmlStr += "																<img class='hand' id='mRight' src='"
				+ contextPath
				+ GridConstant.PAGE_IMAGE_PATH+"select_right.gif' onClick=moveOption('"
				+ title + "');>";
		htmlStr += "															</td>";
		htmlStr += "															<td width='159'>";
		htmlStr += "																" + this.getEndStr(endData);
		htmlStr += "															</td>";
		htmlStr += "														</tr>";
		htmlStr += "													</table>";
		htmlStr += "												</td>";
		htmlStr += "											</tr>";
		htmlStr += "										</table>";
		htmlStr += "									</td>";
		htmlStr += "								</tr>";
		htmlStr += "							</table>";
		htmlStr += "						</td>";
		htmlStr += "					</tr>";
		htmlStr += "				</table>";
		htmlStr += "				<table width='100%'  cellpadding='0'>";
		htmlStr += "					<tr>";
		htmlStr += "						<td>&nbsp;</td>";
		htmlStr += "					</tr>";
		htmlStr += "					<tr>";
		htmlStr += "						<td align='right'>";
		htmlStr += "							<span style='text-align:right' class='hand' onclick=''>";
		htmlStr += "								<img class='hand' onClick=" + title
				+ "div.style.visibility='hidden' src='" + contextPath
				+ GridConstant.PAGE_IMAGE_PATH+"ok.gif'>";
		htmlStr += "							</span>&nbsp;";
		htmlStr += "							<img class='hand' onClick=" + title
				+ "div.style.visibility='hidden' src='" + contextPath
				+ GridConstant.PAGE_IMAGE_PATH+"reset.gif'>";
		htmlStr += "							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		htmlStr += "						</td>";
		htmlStr += "					</tr>";
		htmlStr += "				</table>";
		htmlStr += "			<td>";
		htmlStr += "		</tr>";
		htmlStr += "	</table>";
		htmlStr += " 	</td></tr></table>";
		htmlStr += "</div>";
		//htmlStr  += "<br>";
		return htmlStr;
	}

	public int doStartTag() throws JspException {
		try {
			contextPath = ((HttpServletRequest) pageContext.getRequest())
				.getContextPath();
			pageContext.getOut().print(this.getDivHtml());
		} catch (Exception e) {
		}

		return (SKIP_BODY);
	}

	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub

		return (EVAL_PAGE);
	}
}
