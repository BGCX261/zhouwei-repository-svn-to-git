/**
 * 一个多文件上传的页面表现.
 */
package com.techstar.framework.ui.web.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import com.techstar.framework.ui.web.tag.utils.GridConstant;

/**
 * @author njt
 * 
 */
public class JHopUploadTag extends JHopBaseTag {
	/**
	 * 上传文件框文件名,当增加多个上传文件框,文件名形式为 fileName1, fileName2..fileName3; *
	 */
	private String name;
	/**
	 * 生成一个文本框还是多个yes是生成一个 no为多个
	 */
	private String multiValue;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the multiValue
	 */
	public String getMultiValue() {
		return multiValue;
	}

	/**
	 * @param multiValue
	 *            the multiValue to set
	 */
	public void setMultiValue(String multiValue) {
		this.multiValue = multiValue;
	}

	/**
	 * 增加删除文本框的js代码
	 */
	public String getScript() {
		String img1 = contextPath + GridConstant.PAGE_IMAGE_PATH+"qbz.gif";
		StringBuffer strbuffer = new StringBuffer("");
		strbuffer.append("<script language=\"javascript\" >");
		strbuffer.append(" 	function fclick(obj){");
		strbuffer.append("  with(obj){ ");
		strbuffer.append("  style.posTop= event.y+document.body.scrollTop-event.offsetY;	 ");
		strbuffer.append(" style.posLeft=event.x+document.body.scrollLeft-event.offsetX;  ");
		strbuffer.append(" } ");
		strbuffer.append(" }");
		strbuffer.append(" ");

		strbuffer.append(" function "+this.name+"addRow()");
		strbuffer.append("{ ");
		strbuffer.append("  oTR="+this.name+"_idTB.insertRow(-1);");
		strbuffer.append("   tmpNum=oTR.rowIndex;");
		strbuffer.append("  oTD=oTR.insertCell(0);");
		strbuffer.append(" var strText=\"  <input id="+this.name+"_f_file\"+tmpNum+ \">\"; ");
		strbuffer
				.append("  var strFile=\"<input name='"+this.name+"' type='file' \" ;");
		strbuffer
				.append(" strFile+=\"style='position:absolute;filter:alpha(opacity=0);width:70px;' \";");
		strbuffer
				.append("  strFile+=\"id="
						+ this.name 
						+ "\"+tmpNum+ \" onpropertychange='  "+this.name+"_f_file\"+tmpNum+\".value=this.value'  hidefocus>\";");
		strbuffer
				.append("  var strImage=\"<input type='image' style='cursor:pointer' src='"
						+ img1
						+ "' onmouseover='fclick("
						+ this.name
						+ "\"+tmpNum+\")' >\";");
		strbuffer.append(" oTD.innerHTML=strText+strImage+strFile; ");
		strbuffer.append(" ");
		strbuffer.append(" return true; ");
		strbuffer.append("} ");
		strbuffer.append(" ");

		strbuffer.append(" function addSingleRow()");
		strbuffer.append("{ ");
		strbuffer.append(" up.style.display='block'");
		strbuffer.append("} ");
		strbuffer.append(" ");

		strbuffer.append(" function delSingleRow()");
		strbuffer.append("{ ");
		strbuffer.append("up.style.display='none' ");
		strbuffer.append("} ");
		// strbuffer.append("} ");

		strbuffer.append("function "+this.name+"delRow(){ ");
		strbuffer.append("  sIndex=oTR.rowIndex;  ");
		strbuffer.append(" if(sIndex==''){");
		strbuffer.append(" sIndex="+this.name+"_idTB.rows.length-1; ");
		strbuffer.append("  }else{");
		strbuffer.append(" sIndex=parseInt(sIndex)-1; ");
		strbuffer.append("  }");
		strbuffer.append("  if(sIndex>=0) ");
		strbuffer.append(" {    ");
		strbuffer.append("   "+this.name+"_idTB.deleteRow(sIndex); ");
		strbuffer.append(" } ");
		strbuffer.append(" } ");
		strbuffer.append(" </script>");
		return strbuffer.toString(); 
	}

	/**
	 * 生成HTML文件
	 */
	public String getDivHtml() {
		String img1 = contextPath + GridConstant.PAGE_IMAGE_PATH+"qbz.gif";
		// 上传文件的样式
		// System.out.println("img= " + img1);
		String strFile = "<input name='"+this.name+"' type='file' ";
		strFile += "style='position:absolute;filter:alpha(opacity=0);width:50px;' ";
		strFile += "id="+this.name
				+ " onpropertychange=' "+this.name+"_f_file.value=this.value'  hidefocus>";
		String strImage = "<input type='image'  style='cursor:pointer' src='"
				+ img1 + "' onmouseover='fclick("+this.name+")' >";
		String strText = "  <input id="+this.name+"_f_file>";
		String str = strText + strImage + strFile;
		StringBuffer htmlStr = new StringBuffer("");
		htmlStr.append(this.getScript());
		if (this.multiValue.equalsIgnoreCase("yes")) {// 多个文件上传
			htmlStr
					.append("<table  width=\"100%\"  border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\"  id=\"idTB1\">");
			htmlStr.append("<tr>");
			htmlStr.append(" <td  nowrap=\"nowrap\">");
			htmlStr
					.append("<a   onclick=\""+this.name+"addRow()\"  style=\"cursor: pointer;\">添加附件</a>   ");
			htmlStr
					.append(" &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;<a   onclick=\""+this.name+"delRow()\" style=\"cursor: pointer;\"> 删除附件</a>");
			htmlStr.append("  </td> ");
			htmlStr.append(" </tr> ");
			htmlStr.append("</table> ");
		}
		htmlStr
				.append("<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" id=\""+this.name+"_idTB\">");
		if (this.multiValue.equalsIgnoreCase("no")) { // 只有一个上传框时候输出
			htmlStr.append(" <tr id='up' >");

			htmlStr.append(" <td>");
			htmlStr.append(str);
			htmlStr.append(" </td> ");
			htmlStr.append(" </tr> ");
		}
		htmlStr.append("</table> ");

		htmlStr.append(" ");
		htmlStr.append(" ");
		return htmlStr.toString();
	}

	public int doStartTag() throws JspException {
		try {
			contextPath = ((HttpServletRequest) pageContext.getRequest())
					.getContextPath();
			System.out.println(contextPath);
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
		name = null;
		multiValue = null;
	}
}
