<%@ page contentType="text/html; charset=utf-8" language="java"  %>
<html>
<head>
<title>DMIS项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="StyleSheet" href="skins/winclassic.css" />
<link href="<%=request.getContextPath()%>/themes/themes1/style.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/other/topmenu.js"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/toolbar/dhtmlXProtobar.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/script/menu/poslib.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/script/menu/scrollbutton.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/script/menu/menu4.js"></script>

</head>
<%

	String xmle =(String)request.getSession().getAttribute("headmenu");
 %>




<body>
<table class="head" cellspacing="0">  
  <tr>
    <td width="365" rowspan="3">
      <img class="logo" src="<%=request.getContextPath()%>/themes/themes1/images/logo/logo.gif">
    </td>
    <td width="36" rowspan="3"><img src="<%=request.getContextPath()%>/themes/themes1/images/main/head_line.gif"></td>
    <td width="228" height="35" valign="bottom">欢迎信息</td>
    <td width="400" rowspan="3" align="right" valign="top">
      <table width="100%" cellspacing="0" class="menu">
        <tr align="center">
          <td height="45"  valign="bottom" >
            <img src="<%=request.getContextPath()%>/themes/themes1/images/main/workbench/menu_work01.gif" border="0" > </td>
          <td valign="bottom">
            <a href="#"><img src="<%=request.getContextPath()%>/themes/themes1/images/main/workbench/menu_work02.gif"></a>
          </td>
          <td valign="bottom">
            <a href="#"><img src="<%=request.getContextPath()%>/themes/themes1/images/main/workbench/menu_work03.gif"></a>
          </td>
          <td valign="bottom">
            <a href="#"><img src="<%=request.getContextPath()%>/themes/themes1/images/main/workbench/menu_work04.gif"></a>
          </td>
          <td valign="bottom">
            <a href="../plan/help.html" target="_blank"><img src="<%=request.getContextPath()%>/themes/themes1/images/main/workbench/menu_work05.gif"></a>
          </td>
          <td valign="bottom">
            <a href="#"><img src="<%=request.getContextPath()%>/themes/themes1/images/main/workbench/menu_work06.gif"></a>
          </td>
        </tr>
        <tr align="center">
          <td height="25" >
           <a href="#" id ="cd"></a>
          </td>
          <td><a href="#">报表</a></td>
          <td><a href="<%=request.getContextPath()%>/application/mywork/index.jsp" target=_parent>工作台</a></td>
          <td>
            <a href="#" class="hand" onclick='window.open("../../../yangshi.jsp","a","scrollbars=0,resizable=yes,width=400,height=300,top=200,left=300","popwindow","channelmode","newwindow")' >设置</a>
          </td>
          <td>
            <a href="#" onclick='window.open("../../common/help.jsp","a","scrollbars=yes,resizable=yes,width=800,height=600,top=0,left=0,titlebar=0","popwindow","channelmode","newwindow")'>帮助</a>
          </td>
          <td><a href="#">退出</a></td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td class="red" height="25">
      <marquee scrollamount=2  scrolldelay=3>最新消息：DMIS系统正式上线。</marquee>
    </td>
  </tr>
  <tr>
    <td height="10"></td>
  </tr>
</table>
<script type="text/javascript">
	var xdoc = createDom();
	xdoc.loadXML("<%=xmle%>");
	//xdoc.load("menuV1.xml");
	//获得根路径

	var root = xdoc.getElementsByTagName("Menu")[0];
	//设置css
	Menu.prototype.cssFile = "<%=request.getContextPath()%>/themes/themes1/style.css";
	
	var sm = new Menu();
	
	sm = createChildItems(root,sm);
	
	var menuBar = new MenuBar();
	
	var tmp;
	
	//menuBar.add( tmp = new MenuButton('<img src=\"\/frame\/themes\/themes1\/images\/main\/workbench\/menu_work01.gif\" border=\"0\" >', sm) );
	
	menuBar.add( tmp = new MenuButton('菜单', sm) );
	
	tmp.mnemonic = 's';
	
    menuBar.write(document.getElementById('cd'));
    
    
    //获得DOM对象
	function createDom(){
	
			 var signatures = new Array("Microsoft.XMLDOM","Msxm12.DOMDocument.5.0","Msxm12.DOMDocument.4.0","Msxm12.DOMDocument.3.0","Msxm12.DOMDocument");
			 var xmldoc ;
			 for(var i =0;i<signatures.length;i++)
			 {
			 	try{
			 		
			 		 xmldoc = new ActiveXObject(signatures[i]);
			 		 xmldoc.async = false;
			 		 return xmldoc;
			 	}catch(e){
			 		//忽略错误，继续循环取下一格版本；
			 	}
			 	
			 	
			 }
			 if(xmldoc==null){
			 	lert("没有取到Dom对象");
			 }
             
	}
	
	//创建Menu
	function  createChildItems(fatherNode,menu)
	{   
	    //循环子节点


		for(var i=0;i<fatherNode.childNodes.length; i++)
		{  
			var tmp1 = new Menu();
			var menuitem;
			var child = fatherNode.childNodes[i];
			if(child.hasChildNodes())
			{   //有子节点
				tmp1 = createChildItems(child,tmp1);
				menu.add(menuitem=new MenuItem(child.getAttribute("Text"),changeUrl,null,tmp1));
			}
			else
			{	//没有子节点


				menu.add(menuitem = new MenuItem(child.getAttribute("Text"),changeUrl));
			}
			menuitem.mnemonic=child.getAttribute("href");
		}
	
		return menu;
	}
	
	
	//点击事件
	function changeUrl(){
	    if(this.mnemonic!=null&&this.mnemonic!='')
	    	parent.mainFrame.location.href='<%=request.getContextPath()%>'+this.mnemonic
	    else
	    	return false;
	}
	
</script>
</body>
</html>
