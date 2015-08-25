/*
 * Commpany:     techstar
 * Project:      FrameDemoWeb
 * Copyright:    0.1
 * Creat by:     yjb
 * Creat dat:    Jan 18, 2006
 * Modify by:    
 * Modify dat:   
 * Description:
 */

package com.techstar.framework.ui.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class PPSTurnpageTag extends BodyTagSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// records be displayed per page
    int pageSize;

    // total records
    int totalCount;

    // current page Number
    int pageNum;

    // URL and it's Parameters
    String strUrl;

    // first record Number in Current Page
    int startNum;

    // the Last Record Number in Current Page
    int endNum;

    // total Pages
    int pages;

    private String classname;
    
    
    
    public String getStrUrl() {
        return strUrl;
    }
    public void setStrUrl(String strUrl) {
        this.strUrl = strUrl;
    }
    
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    public void setPageNum(int pageNum){
        this.pageNum = pageNum;
    }
    public int getPageNum() {
        return pageNum;
    }

    public void setTotalCount(int totalCount){
        this.totalCount = totalCount;
    }
    public int getTotalCount() {
        return totalCount;
    }
    
    public void setClassname(String classname) {
        this.classname = classname;
    }
    public String getClassname() {
        return classname;
    }    
    

    public String top(String str) {
        String url = "";
        if (pageNum != 1) {
            url = "<a href=\"" + strUrl + "&pageNum=1&pageSize="+pageSize+"\">" + str + "</a>";
        } else {
            url = str;
        }
        return url;
    }

    public String top() {
        String url = "";
        if (pageNum != 1) {
            url = "<a href=\"" + strUrl + "&pageNum=1&pageSize="+pageSize+"\">��ҳ</a>";
        } else {
            url = "��ҳ";
        }
        return url;
    }

    public String end(String str) {
        String url = "";
        if ((pages != 0) && (pages != pageNum)) {
            url = "<a href=\"" + strUrl + "&pageNum=" + pages + "&pageSize="+pageSize+"\">" + str
                    + "</a>";
        } else {
            url = str;
        }
        return url;
    }

    public String end() {
        String url = "";
        if ((pages != 0) && (pages != pageNum)) {
            url = "<a href=\"" + strUrl + "&pageNum=" + pages + "&pageSize="+pageSize+"\">βҳ</a>";
        } else {
            url = "βҳ";
        }
        return url;
    }

    public String previous(String str) {
        String url = "";
        if (pageNum != 1) {
            url = "<a href=\"" + strUrl + "&pageNum=" + (pageNum - 1) + "&pageSize="+pageSize+"\">"
                    + str + "</a>";
        } else {
            url = str;
        }
        return url;
    }

    public String previous() {
        String url = "";
        if (pageNum != 1) {
            url = "<a href=\"" + strUrl + "&pageNum=" + (pageNum - 1)
                    + "&pageSize="+pageSize+"\">��һҳ</a>";
        } else {
            url = "��һҳ";
        }
        return url;
    }

    public String next(String str) {
        String url = "";
        if (pageNum < pages) {
            url = "<a href=\"" + strUrl + "&pageNum=" + (pageNum + 1) + "&pageSize="+pageSize+"\">"
                    + str + "</a>";
        } else {
            url = str;
        }
        return url;
    }

    public String next() {
        String url = "";
        if (pageNum < pages) {
            url = "<a href=\"" + strUrl + "&pageNum=" + (pageNum + 1)
                    + "&pageSize="+pageSize+"\">��һҳ</a>";
        } else {
            url = "��һҳ";
        }
        return url;
    }

    public int getPages() {
        return pages;
    }

    public int getStartNum() {
        return startNum;
    }

    public int getEndNum() {
        return endNum;
    }



    public String getPageString() {

        String className = this.getClassname();
        if (className == null || className.equalsIgnoreCase("")) {
            className = "black";
        }
        //System.out.println(" get top() is" + top());
        //System.out.println(" get next() is" + next());
        //System.out.println(" get next() is"+next());
        String url = "<table width=100%><tr><td align=right class=\""
                + className + "\">" + top() + "&nbsp;" + previous() + "&nbsp;"
                + next() + "&nbsp;" + end() + " ҳ�Σ�" + getPageNum() + "/"
                + getPages() + "ҳ ��" + getTotalCount() + "�� "
                + "</td></tr></table>";

        return url;
    }




    public int doStartTag() throws JspException {
        // TODO Auto-generated method stub
        try {
            
            if (this.strUrl.indexOf("?") == -1)
                this.strUrl += "? ";
            startNum = (int) pageSize * (pageNum - 1);
            endNum = (int) pageSize * pageNum;
            if (endNum > totalCount)
                endNum = totalCount;
            pages = totalCount / pageSize;
            if (totalCount % pageSize != 0)
                pages++;
            
            pageContext.getOut().print(this.getPageString());
        } catch (IOException e) {
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
        this.pageNum = 0;
        this.pageSize = 0;
        this.strUrl = null;
        this.classname = null;
        this.totalCount = 0;
    }

}
