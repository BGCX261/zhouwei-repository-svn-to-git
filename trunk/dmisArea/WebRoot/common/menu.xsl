<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="Menu | MenuItem">
<HTML>
<HEAD>
<TITLE> </TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta name="Author" content="宝玉(webuc.net)" />
<meta name="Description" content="使用ie5.5+中的popup结合xml创建的无限菜单——菜单可以超出浏览器区域、可以不用担心会被下拉选择框等东西挡住" />

<style>
body,td{
	font-size:9pt;
}
.PopMenuOutset{border:0px solid;border-color: #e1e1e1;}
.PopMenuInset{border:1px solid;border-color: #999999;}
.PopMenu{background-color: #F0F0F0;}
.PopMenuItem{height:22px;cursor:default;}
.PopMenuItemOver{height:22px;background-color: highlight;color:highlighttext;cursor:default;}
</style>
</HEAD>

<BODY leftmargin="0" topmargin="0" scroll="no" style="border:0">
<script>
<![CDATA[
// 当前展开的菜单项
var preObj = null;

// 创建当前窗体（可以是IE窗体也可以是Popup窗体）的Popup对象
// 这个Popup对象就是用来存储子菜单数据的
var oPopup = document.parentWindow.createPopup(); 

// 装载xsl
var stylesheet = new ActiveXObject("Microsoft.XMLDOM");
stylesheet.async = false;
stylesheet.load( "menu.xsl" );	

// 预装载图片
var img = new Image;
img.src = "../themes/themes1/images/menu/ArrowRHighlight.gif";

function ItemClick(obj)
{   var divno  = obj.getElementsByTagName("div")[1];
	var textnode = divno.firstChild;
	if(textnode==null||textnode==''){
		return false;
	}
	doAction(textnode.nodeValue);
}

function  doAction(url){
	parent.doAction(url);
}

// 鼠标经过菜单项
function ItemOver(obj)
{
	// 隐藏已经打开的菜单项
	if (preObj != null)
	{
		if (preObj == obj)
			return;
		oPopup.hide();
		
		// 要清空原Popup中的数据——document.write()方法是接着原来的内容往里面写，所以如果不清空会出现重复数据
		oPopup = document.parentWindow.createPopup();
		
		// 恢复前一个菜单项的状态
		ItemNormal(preObj);
		preObj = null;
	}

	obj.className='PopMenuItemOver';
	if (obj.cells(2).children.length > 0) //有子菜单
	{
		obj.cells(2).children(0).src = "../themes/themes1/images/menu/ArrowRHighlight.gif";

		// 获取子菜单xml数据
		var subMenuData = obj.all.tags("xml")(0).XMLDocument;	
		
		// 根据子菜单xml数据和当前xsl文档生成HTML
		var sHtml = subMenuData.transformNode(stylesheet);	
		// 将解析出来的HTML全部输出到Popup中，在Popup中，又可以利用这些脚本再Popup……
		oPopup.document.write(sHtml); 

		// 计算popup内容的实际宽度高度
		oPopup.show(0, 0, 1, 1, obj);
		var width = oPopup.document.body.scrollWidth;
		var height = oPopup.document.body.scrollHeight;
		oPopup.hide();
		oPopup.document.body.style.border="solid black 0px";
		// 显示菜单
		oPopup.show(obj.offsetWidth, 0, width, height, obj);
		
		preObj = obj;
	}
}

// 鼠标移出菜单项
function ItemOut(obj)
{
	if (oPopup.isOpen && preObj == obj) // 如果子菜单被打开则跳过
		return;
	ItemNormal(obj);
}

// 恢复到菜单项的默认状态
function ItemNormal(obj)
{
	obj.className='PopMenuItem';
	if (obj.cells(2).children.length > 0)
	{
		obj.cells(2).children(0).src = "../themes/themes1/images/menu/ArrowR.gif";
	}
}


]]>
</script>
<table border="0" cellpadding="0" cellspacing="0" width="170" class="PopMenuOutset">
	<tr>
		<td>	
			<table border="0" cellpadding="1" cellspacing="0" width="100%" class="PopMenuInset">
				<tr>
					<td class="PopMenu">
						<table border="0" cellpadding="0" cellspacing="0" width="100%" onselectstart="return false;">
							<!-- 遍历子菜单 -->
							<xsl:for-each select="MenuItem">
								<xsl:choose>
									<!-- 有href属性 -->
									<xsl:when test="@href!=''">
										<tr height="22" onmouseover="ItemOver(this)" onmouseout="ItemOut(this);" onclick="ItemClick(this)">
											<td width="20" align="center">
												<IMG SRC="../themes/themes1/images/menu/spacer.gif" WIDTH="6" HEIGHT="6" BORDER="0" ALT=""/>
											</td>
											<td>
												<div style="display:none"><xsl:value-of select="@id"/></div>
												<div style="display:none"><xsl:value-of select="@href"/></div>
												<xsl:value-of select="@Text" />
												<xsl:if test="count(MenuItem) > 0">
												<!-- 这里用来存储子菜单的xml数据 -->
													<xml>			
														<xsl:copy-of select="."/>
													</xml>
												</xsl:if>

											</td>
											
											
											<td width="8" align="right" valign="top" style="padding-right: 6px; padding-top:4px;">
												<!-- 如果有子菜单则显示箭头 -->
												<xsl:if test="count(MenuItem) > 0">
													<img src="../themes/themes1/images/menu/ArrowR.gif"/>
												</xsl:if>
											</td>
										
										
										</tr>
									</xsl:when>
									<!-- 无href属性 -->
									<xsl:otherwise>
										<tr height="22" onmouseover="ItemOver(this)" onmouseout="ItemOut(this);" >
											
											
											<td width="20" align="center">
												<IMG SRC="../themes/themes1/images/menu/spacer.gif" WIDTH="6" HEIGHT="6" BORDER="0" ALT=""/>
											</td>
											
											
											
											<td>
												<div style="display:none"><xsl:value-of select="@id"/></div>
												<div style="display:none"><xsl:value-of select="@href"/></div>
												<xsl:value-of select="@Text" />
											 	<xsl:if test="count(MenuItem) > 0">
													<!-- 这里用来存储子菜单的xml数据 -->
													<xml>			
														<xsl:copy-of select="."/>
													</xml>
												</xsl:if>
											</td>
									
		
											<td width="8" align="right" valign="top" style="padding-right: 6px; padding-top:4px;">
												<!-- 如果有子菜单则显示箭头 -->
												<xsl:if test="count(MenuItem) > 0">
													<img src="../themes/themes1/images/menu/ArrowR.gif"/>
												</xsl:if>
											</td>
									  </tr>
								   </xsl:otherwise>
								</xsl:choose>
							</xsl:for-each>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</BODY>
</HTML>
</xsl:template>

</xsl:stylesheet>