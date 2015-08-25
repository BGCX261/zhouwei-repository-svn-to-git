package com.techstar.framework.ui.web.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import com.techstar.framework.ui.web.tag.utils.GridConstant;

public class JHopPageTag extends JHopBaseTag
{
	/**
	 *  每页显示数据条数
	 */
	private String pageSize;
	
	/**
	 *  当前所在页数


	 */
	private String currPage;
	
	/**
	 *  查询的数据总数 
	 */
	private String totalCount;
	
	/**
	 *  查询的总页数


	 */
	private long totalPageCount;
	
	/**
	 *  每组显示的页数


	 */
	private int numberPage = 5;
	
	/**
	 *  当前页所在的页组数


	 */
	private int currPageGroup;
	
	/**
	 *  查询的总页组数
	 */
	private long totalPageGroup;

	
	/**
	 *  执行查询的URL地址
	 */
	private String urlStr;
	
	/**
	 *  是否有上一页


	 */
	private boolean hasPre;
	
	/**
	 *  是否有下一页


	 */
	private boolean hasNext;

	
	/**
	 * 
	 * @return
	 */
	public String getCurrPage() 
	{
		return currPage;
	}

	/**
	 * 
	 * @param currPage
	 */
	public void setCurrPage(String currPage) 
	{
		this.currPage = currPage;
	}

	/**
	 * 
	 * @return
	 */
	public String getPageSize() 
	{
		return pageSize;
	}

	/**
	 * 
	 * @param pageSize
	 */
	public void setPageSize(String pageSize) 
	{
		this.pageSize = pageSize;
	}

	/**
	 * 
	 * @return
	 */
	public String getTotalCount() 
	{
		return totalCount;
	}

	/**
	 * 
	 * @param totalCount
	 */
	public void setTotalCount(String totalCount) 
	{
		this.totalCount = totalCount;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getUrlStr() 
	{
		return urlStr;
	}
	
	/**
	 * 
	 * @param urlStr
	 */
	public void setUrlStr(String urlStr) 
	{
		this.urlStr = urlStr;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isHasNext() 
	{
		return hasNext;
	}

	/**
	 * 
	 * 
	 */
	public void setHasNext() 
	{
		if(Integer.valueOf(this.currPage).intValue() < this.totalPageCount)
		{
			this.hasNext = true;
		}
		else
		{
			this.hasNext = false;
		}
			
	}

	/**
	 * 
	 * @return
	 */
	public boolean isHasPre() 
	{
		return hasPre;
	}

	/**
	 * 
	 *
	 */
	public void setHasPre() 
	{
		if(Integer.valueOf(this.currPage).intValue() > 1)
		{
			this.hasPre = true;
		}
		else
		{
			this.hasPre = false;
		}
	}

	/**
	 *  设置总页数
	 */
	private void setTotalPageCount()
	{
		if(Integer.valueOf(this.totalCount).intValue()%Integer.valueOf(this.pageSize).intValue() == 0)
		{
			this.totalPageCount = Integer.valueOf(this.totalCount).intValue() / Integer.valueOf(this.pageSize).intValue();
		}
		else
		{
			this.totalPageCount = Integer.valueOf(this.totalCount).intValue() / Integer.valueOf(this.pageSize).intValue() + 1;
		}
	}
	
	/**
	 *  设置总组数
	 */
	private void setTotalPageGroup()
	{
		if(this.totalPageCount%this.numberPage == 0)
		{
			this.totalPageGroup = this.totalPageCount / this.numberPage;
		}
		else
		{
			this.totalPageGroup = this.totalPageCount / this.numberPage +1;
		}
	}
	
	/**
	 * 
	 */
	private void setCurrPageGroup()
	{
		
	}
	
	private StringBuffer scriptStr()
	{
		StringBuffer script = new StringBuffer();
		script.append("<script>");
		script.append("		function submitData(pageType){");
		script.append("			var currPage = document.all.currPage.value;");
		script.append("			var totalCount = document.all.totalCount.value;");
		script.append("			var page = document.all.pageSelect.value;");
		script.append("			if(page == null || page == ''){");
		script.append("				page = document.all.pageDefault.value");
		script.append("			}");
		script.append("			var startCount = (parseInt(currPage)-1)*parseInt(page)+1;");
		script.append("		");
		script.append("			var endCount;");
		script.append("			if(parseInt(currPage)*parseInt(page) > parseInt(totalCount)){");
		script.append("				endCount   = parseInt(totalCount);");
		script.append("			}else{");
		script.append("				endCount   = parseInt(currPage)*parseInt(page);");
		script.append("			}");
		//script.append("			alert('C:'+currPage);alert('T:'+totalCount);alert('P:'+page);");
		script.append("			var previous;");
		script.append("			var next;");
		script.append("			var end;");
		script.append("			var totalPage;");
		script.append("			if(parseInt(totalCount)%parseInt(page) == 0){");
		script.append("				totalPage = parseInt(parseInt(totalCount)/parseInt(page));");
		script.append("			} else {");
		script.append("				totalPage = parseInt(parseInt(totalCount)/parseInt(page)+1);");
		script.append("			}");
		//script.append("			alert('TOTAL:'+totalPage);");
		script.append("			");
		script.append("			var currPage;");
		script.append("			if(pageType == 'top'){");
		script.append("				currPage = '1';");
		script.append("			} else if(pageType == 'previous'){");
		script.append("				if(currPage > 1){");
		script.append("					currPage = parseInt(currPage)-1;");
		script.append("				}else{");
		script.append("					pageType = '';");
		script.append("				}");
		script.append("			} else if(pageType == 'previousGroup'){");
		script.append("				if((parseInt(currPage)-5) >=1){");
		script.append("					currPage = parseInt(currPage)-5;");
		script.append("				}else{");
		script.append("					pageType = '';");
		script.append("				}");
		script.append("			} else if(pageType == 'nextGroup'){");
		script.append("				if((parseInt(currPage)+5)<=totalPage){");
		script.append("					currPage = parseInt(currPage)+5;");
		script.append("				}else{");
		script.append("					pageType = '';");
		script.append("				}");
		script.append("			} else if(pageType == 'next'){");
		script.append("				if((parseInt(currPage)+1) <= totalPage){");
		script.append("					currPage = parseInt(currPage)+1;");
		script.append("				}else{");
		script.append("					pageType = '';");
		script.append("				}");
		script.append("			} else if(pageType == 'end'){");
		script.append("				currPage = totalPage;");
		script.append("			} else {");
		script.append("				currPage = 1;");
		script.append("			}");
		script.append("			var filterParams = document.all.filterStr.value;");
		script.append("			document.all.area.innerHTML='['+startCount+'-'+endCount+']';");
		script.append("			document.all.totalNum.innerHTML='['+totalCount+']';");
		script.append("			if(pageType != ''){");
		script.append("				createGrid('','0','',currPage+'^'+page,'','',filterParams,'');");
		script.append("			}");
		script.append("		}");
		//script.append("		submitData('');");
		script.append("</script>");
		return script;
	}
	
	/**
	 *  显示首页链接
	 * 
	 *  @return top
	 */
	public String getTop()
	{
		String 	top  = "";
				top += "<td width='10%'>";
			if(Integer.valueOf(this.currPage).intValue() != 1)
				top += "	<a href='"+this.urlStr+"&pageStr="+this.currPage+"^"+this.pageSize+"'>首页</a>";
			else
				top += "	首页";
				top += "</td>";
		return top;
	}
	
	/**
	 *  显示首页链接[可带参数字串]
	 * 
	 *  @return top
	 */
	public String getTop(String str)
	{
		String 	top  = "";
				top += "<td width='12%'>";
			//if(Integer.valueOf(this.currPage).intValue() > 1){
				//top += "	<a href='"+this.urlStr+"&pageStr=1^"+this.pageSize+"'>"+str+"</a>";
				top += "	<a name='top' id='top' class=hand onClick=submitData('top');>"+str+"</a>";
			//}else{
			//	top += "	"+str+"";
			//}
				top += "</td>";
		return  top;
	}
	
	/**
	 *  显示末页链接
	 * 
	 *  @return end
	 */
	public String getEnd()
	{
		String 	end  = "";
				end += "<td width='10%'>";
			if ((Integer.valueOf(this.currPage).intValue() != 0) && (Integer.valueOf(this.currPage).intValue() != this.totalPageCount))
				end += "	<a href='"+this.urlStr+"&pageStr="+this.currPage+"^"+this.pageSize+"'>末页</a>";
			else
				end += "	末页";
				end += "</td>";
		return  end;
	}
	
	/**
	 *  显示末页链接[可带参数字串]
	 * 
	 *  @return end
	 */
	public String getEnd(String str)
	{
		String 	end  = "";
				end += "<td  width='12%'>";
			//if ((Integer.valueOf(this.currPage).intValue() != 0) && (Integer.valueOf(this.currPage).intValue() != this.totalPageCount)){
				//end += "	<a href='"+this.urlStr+"&pageStr="+(this.totalPageCount)+"^"+this.pageSize+"'>"+str+"</a>";
				end += "	<a id='end' class=hand onClick=submitData('end');>"+str+"</a>";
			//}else{
			//	end += "	"+str+"";
			//}
				end += "</td>";
		return  end;
	}
	
	/**
	 *  显示上一页链接


	 * 
	 *  @return previous
	 */
	public String getPrevious()
	{
		String  previous  = "";
				previous += "<td width='17%'>";
			if(Integer.valueOf(this.currPage).intValue() > 1)
				previous += "	<a href='"+this.urlStr+"&pageStr="+(Integer.valueOf(this.currPage).intValue()-1)+"^"+this.pageSize+"'>&lt;&nbsp;上一页</a>";
			else
				previous += "	&lt;&nbsp;上一页";
				previous += "</td>";
		return previous;
	}
	
	/**
	 *  显示上一页链接[可带参数字串]
	 * 
	 *  @return previous
	 */
	public String getPrevious(String str)
	{
		String  previous  = "";
				previous += "<td  width='10%'>";
			//if(Integer.valueOf(this.currPage).intValue() > 1){
				//previous += "	<a href='"+this.urlStr+"&pageStr="+(Integer.valueOf(this.currPage).intValue()-1)+"^"+this.pageSize+"'>"+str+"</a>";
				previous += "	<a id='previous' class=hand onClick=submitData('previous');>"+str+"</a>";
			//}else{
			//	previous += "	"+str+"";
			//}
				previous += "</td>";
		return previous;
	}
	
	/**
	 *  显示下一页链接
	 * 
	 *  @return next
	 */
	public String getNext()
	{
		String 	next	 = "";
				next    += "<td width='17%'>";
			if ((Integer.valueOf(this.currPage).intValue() != 0) && (Integer.valueOf(this.currPage).intValue() != this.totalPageCount))
				next    += "	<a href='"+this.urlStr+"&pageStr="+this.currPage+"^"+this.pageSize+"'>下一页&nbsp;&gt</a>";
			else
				next 	+= "	下一页&nbsp;&gt";
				next    += "</td>";
		return  next;
	}
	
	/**
	 *  显示下一页链接[可带参数字串]
	 * 
	 *  @return next
	 */
	public String getNext(String str)
	{
		String 	next	 = "";
				next    += "<td  width='10%'>";
			//if ((Integer.valueOf(this.currPage).intValue() != 0) && (Integer.valueOf(this.currPage).intValue() != this.totalPageCount)){
				//next    += "	<a href='"+this.urlStr+"&pageStr="+(Integer.valueOf(this.currPage).intValue()+1)+"^"+this.pageSize+"'>"+str+"</a>";
				next    += "	<a id='next' class=hand onClick=submitData('next');>"+str+"</a>";
			//}else{
			//	next 	+= "	"+str+"";
			//}
				next    += "</td>";
		return  next;
	}
	
	/**
	 *  显示下一组链接
	 * 
	 *  @return next
	 */
	public String getNextGroup()
	{
		String 	next	 = "";
				next    += "<td width='20%'>";
				next    += "	<a href='#'>&lt;&nbsp;下一组</a>";
				next    += "</td>";
		return  next;
	}
	
	/**
	 *  显示下一组链接[可带参数字串]
	 * 
	 * @return next
	 */
	public String getNextGroup(String str)
	{
		String 	next	 = "";
				next    += "<td  width='30'>";
			//if ((Integer.valueOf(this.currPage).intValue()+numberPage) <= this.totalPageCount){
				//next    += "	<a href='"+this.urlStr+"&pageStr="+(Integer.valueOf(this.currPage).intValue()+this.numberPage)+"^"+this.pageSize+"'>"+str+"</a>";
				next    += "	<a id='nextGroup' class=hand onClick=submitData('nextGroup');>"+str+"</a>";
			//}else{
			//	next	+= "	"+str;
			//}
				next    += "</td>";
		return  next;
	}
	
	/**
	 *  显示上一组链接


	 * 
	 *  @return previous
	 */
	public String getPreviousGroup()
	{
		String  previous  = "";
				previous += "<td width='30'>";
				previous += "	<a href='#'>&lt;&nbsp;上一组</a>";
				previous += "</td>";
		return previous;
	}
	
	/**
	 *  显示上一组链接[可带参数字串]
	 * 
	 *  @return previous
	 */
	public String getPreviousGroup(String str)
	{
		String  previous  = "";
				previous += "<td  width='10%'>";
			//if ((Integer.valueOf(this.currPage).intValue()-numberPage) > 0){
				//previous += "	<a href='"+this.urlStr+"&pageStr="+(Integer.valueOf(this.currPage).intValue()-this.numberPage)+"^"+this.pageSize+"'>"+str+"</a>";
				previous += "	<a  id='previousGroup' class=hand onClick=submitData('previousGroup');>"+str+"</a>";
			//}else{
			//	previous += "	"+str;
			//}
				previous += "</td>";
		return previous;
	}
	
	/**
	 *  显示当前页及总页数


	 *  格式[当前页: 1-10]
	 * 
	 * @return str
	 */
	public String echoCurrPage()
	{
		String 	str      = "";
				str     += "<td id='area' width='50' title='当前页记录范围'>";
				str     += "	[";
				str     += ((Integer.valueOf(this.currPage).intValue()-1)*Integer.valueOf(this.pageSize).intValue()+1);
				str     += "-";
			if(!this.currPage.equalsIgnoreCase(""+this.totalPageCount))
				str     +=((Integer.valueOf(this.currPage).intValue())*Integer.valueOf(this.pageSize).intValue());
			else
				str     += this.totalCount;
				str     += "]";
				str     += "</td>";
				str     += "";
		return 	str;
	}
	
	/**
	 *  显示查询出的总记录数
	 *  格式[共102条记录]
	 * 
	 * @return str
	 */
	public String echoTotalPage()
	{
		String 	str       = "";
				str      += "<td id='totalNum' width='50' title='总记录数'>["+this.totalCount+"]</td>";
				str      += "";
		return 	str;
	}
	
	public String echoSelectPage()
	{
		String 	str 	  = "";
				str 	 += "<td width='10%'>";
				str		 += "	<select name='' onChange=alert(this.value)>";
			for(int i=1;i<=this.totalPageCount;i++)
			{
				str		 += "		<option value='"+i+"'>第"+i+"页</option>";
			}
				str		 += "	</select>";
				str		 += "</td>";
		return 	str;		
	}
	
	/**
	 *  显示页组
	 *  格式[1 2 3 4 5]
	 * 
	 * @return
	 */
	public String echoPageGroup(int number)
	{
		String 	str 	 = "";
				str     += "<td width='19%' height='3'>";
				str 	+= "	<a href='#'>"+1+"</a>";
				str		+= "</td>";
		return 	str;
	}
	
	
	/**
	 *  得到分页HTML语句块


	 * 
	 * @return htmlStr
	 */
	public String getPageString() 
	{
		this.contextPath =  ((HttpServletRequest)pageContext.getRequest()).getContextPath();
		String 	pageStr 	 = "";
				pageStr  	+= "<table width='380' cellpadding='0' cellspacing='0' border='0'>";
				pageStr     += "	<tr>";
				pageStr     += "		<td width='19%' height='3'></td>";
				pageStr     += "	</tr>";
				pageStr     += "	<tr>";
				/*
				pageStr     += "		"+this.echoCurrPage();
				pageStr     += "		"+this.getTop();
				pageStr     += "		"+this.getPrevious();
				pageStr     += "		"+this.getNext();
				pageStr     += "		"+this.getEnd();
				pageStr		+= "		"+this.echoTotalPage();
				*/	
				pageStr     += "	";
				///*
				//pageStr		+= "		"+this.echoSelectPage();
				pageStr		+= "	<td width='10%'></td>";
				pageStr     += "		"+this.echoCurrPage();
				pageStr		+= "		"+this.echoTotalPage();	
				pageStr     += "		"+this.getTop("<img src="+contextPath+GridConstant.PAGE_IMAGE_PATH+"arrowleft3_2.gif alt=首页>");
				pageStr     += "		"+this.getPrevious("<img src="+contextPath+GridConstant.PAGE_IMAGE_PATH+"arrowleft3_1.gif alt=上一页>");
				pageStr 	+= "		"+this.getPreviousGroup("<img src="+contextPath+GridConstant.PAGE_IMAGE_PATH+"arrowleft3_3.gif alt=上五页>");
				pageStr 	+= "		"+this.getNextGroup("<img src="+contextPath+GridConstant.PAGE_IMAGE_PATH+"arrowright3_3.gif alt=下五页>");
				pageStr     += "		"+this.getNext("<img src="+contextPath+GridConstant.PAGE_IMAGE_PATH+"arrowright3_1.gif alt=下一页>");
				pageStr     += "		"+this.getEnd("<img src="+contextPath+GridConstant.PAGE_IMAGE_PATH+"arrowright3_2.gif alt=末页>");
				//*/
				pageStr     += "	";
				pageStr     += "	";
				pageStr     += "	</tr>";
				pageStr     += "</table>";
		return pageStr;
	}
	
	/**
	 * 
	 */
	public int doStartTag() throws JspException 
	{
		try 
		{
			this.setTotalPageCount();
			this.setTotalPageGroup();
			this.setHasPre();
			this.setHasNext();
			pageContext.getOut().print(this.getPageString()+this.scriptStr());
		} 
		catch (Exception e) 
		{
		}
		return (SKIP_BODY);
	}
	
	/**
	 * 
	 */
	public int doEndTag() throws JspException 
	{
		// TODO Auto-generated method stub
		return (EVAL_PAGE);
	}
	
	public static void main(String[] args)
	{
		
	}
}
