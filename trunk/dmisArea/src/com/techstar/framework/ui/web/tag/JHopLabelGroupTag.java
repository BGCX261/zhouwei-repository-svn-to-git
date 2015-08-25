package com.techstar.framework.ui.web.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

public class JHopLabelGroupTag extends JHopBaseTag {

	/**
	 * <label>的名称字串[以,分隔 例: 标签1,标签2,标签3]
	 */
	private String labelHead;

	/**
	 * <scroll>各iframe是否滚动[以,分隔 例: auto,no,no]
	 */
	private String scroll;

	/**
	 * <table>中部的内容 [内容或路径以,分隔 例: 内容1,内容2,内容3 ]
	 */
	private String innerContent;

	public String getScroll() {
		return scroll;
	}

	public void setScroll(String scroll) {
		this.scroll = scroll;
	}

	public String getInnerContent() {
		return innerContent;
	}

	public void setInnerContent(String innerContent) {
		this.innerContent = innerContent;
	}

	/**
	 * @return the labelHead
	 */
	public String getLabelHead() {
		return labelHead;
	}

	/**
	 * @param labelHead
	 *            the labelHead to set
	 */
	public void setLabelHead(String labelHead) {
		this.labelHead = labelHead;
	}

	public String getScript() {
		String scriptStr = "<script language='javascript'>";
		scriptStr += " onClick1();";
		scriptStr += "</script>	";
		return scriptStr;
	}

	/**
	 * 获得标签组要显示的内容
	 * 
	 * 
	 */
	public String getInnerText(String innerContent, int i, String scroll) {
		String innerText = "";
		innerText += "<iframe name='iframe" + i + "'"
				+ " frameborder='0' width='100%' scrolling='" + scroll
				+ "' height='" + this.height + "' src='" + innerContent + "'>";
		innerText += "</iframe>";
		return innerText;
	}

	/**
	 * 获得选项组的选项标签名称
	 */
	public String getLabelHead(String title) {
		String labelHead = "";
		if (-1 != title.indexOf(",")) {
			String[] titleArra = title.split(",");
			for (int i = 0; i < titleArra.length; i++) {
				if (i == 0) // 显示第一个选项标签
					labelHead += "<td id='ID" + (i + 1)
							+ "' class='ooihj' nowrap onClick='ghbq(this)'>"
							+ titleArra[i] + "</td>";
				else
					labelHead += "<td id='ID" + (i + 1)
							+ "' class='ooihs' nowrap onClick='ghbq(this)'>"
							+ titleArra[i] + "</td>";
			}
		} else {// 如果不含","就将标题直接显示
			labelHead += "<td class='ooihj' nowrap onClick='ghbq(this)'>"
					+ title + "</td>";
		}

		return labelHead;
	}

	/**
	 * 获得标签对应的内容
	 * 
	 * 
	 */
	public String getLabelBody() {
		String labelBody = "";
		if (-1 != labelHead.indexOf(",")) {
			String[] contentArra = labelHead.split(",");
			String[] scrollArra = scroll.split(",");
			for (int i = 0; i < contentArra.length; i++) {
				// System.out.println("content::::" + contentArra[i]);
				if (i == 0) {
					labelBody += "		<tr>";
				} else {
					labelBody += "		<tr style='display: none'>";
				}
				labelBody += "			<td valign='top' align='center'>";
				labelBody += "				<table border='0' cellpadding='0' cellspacing='0'>";
				labelBody += "					<tr>";
				labelBody += "						<td height='0'></td>";
				labelBody += "					</tr>";
				labelBody += "				</table>";
				labelBody += "			 	"
						+ this.getInnerText("", i + 1, scrollArra[i]);
				labelBody += "			</td>";
				labelBody += "		</tr>";
			}
		} else { // 如果传递的参数不包含字符串,渲染显示
			labelBody += "		<tr>";
			labelBody += "			<td valign='top' align='center'>";
			labelBody += "				<table border='0' cellpadding='0' cellspacing='0'>";
			labelBody += "					<tr>";
			labelBody += "						<td height='0'></td>";
			labelBody += "					</tr>";
			labelBody += "				</table>";
			labelBody += "			 	" + this.getInnerText("", 1000, "no");
			labelBody += "			</td>";
			labelBody += "		</tr>";
		}

		return labelBody;
	}

	public String getDivHtml() {
		String htmlStr = "";

		htmlStr += "<div id='div" + labelHead + "' >";
		htmlStr += "	<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">";
		htmlStr += "		<tr>";
		htmlStr += "				<td width=\"5\">";
		htmlStr += "				</td>";
		htmlStr += "	<td>";
		htmlStr += "		<table class='ooih' cellspacing='0' width='100%'>";
		htmlStr += "			<tr>";
		htmlStr += " 			" + this.getLabelHead(labelHead);
		htmlStr += "				<td class='ooihx' width='100%'>&nbsp;</td>";
		htmlStr += "			</tr>";
		htmlStr += "		</table>";
		htmlStr += "		<table class='ooib' id='obody' border='0' cellspacing='0' cellpadding='0'>";
		htmlStr += "				" + this.getLabelBody();
		htmlStr += "		</table>";
		htmlStr += "	</td><td width=\"5\"></td></tr></table>";
		htmlStr += "</div>";
		htmlStr += "<br>";
		htmlStr += this.getScript();
		return htmlStr;
	}

	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().print(this.getDivHtml());

		} catch (Exception e) {
		}

		return (SKIP_BODY);
	}

	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub

		return (EVAL_PAGE);
	}

	public void release() {
		// TODO Auto-generated method stub
		super.release();
		innerContent = null;
		labelHead = null;
		scroll = null;
	}

}
