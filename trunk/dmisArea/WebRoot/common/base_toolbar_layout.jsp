<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/common/init_tag.jsp" %>

<% 
	/**
	*  获得在业务Action中定义的工具栏初始化参数
	*  1.  Business:  id->业务标识   name->业务名称
	*  2.  ReportUrl: 报表地址
	*  3.  OperItem:  Text->操作名称  id->操作标识  href->操作连接地址或方法名  title->功能描述
	*/
	String xmlData = (String)request.getAttribute("xmlData");
%>
<tiles:importAttribute/>
<HTML>
<HEAD>
<html:base/>
<META http-equiv="Content-Type" content="text/html; charset=utf-8">
<TITLE></TITLE> 
<link href="../themes/themes1/style.css" rel="stylesheet" type="text/css">
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/toolbar/dhtmlXProtobar.js"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/toolbar/dhtmlXToolbar.js"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/dhtmlXCommon.js"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/toolbar/toolbar.js"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/public.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/script/menu/poslib.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/script/menu/scrollbutton.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/script/menu/menu4.js"></script>

<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/SysUiGridFacade.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
<STYLE>
   .userData {
   		behavior:url(#default#userdata);
   }
</STYLE>
</HEAD>
<BODY >
	<div id="displayDiv" class=userData></div>
	<div id="searchDiv" class=userData></div>
	<div id="searchListDiv" class=userData></div>
	<form name="userData" method="post">
		<input type="hidden" name="hiddId">
		<input type="hidden" name="hiddUrlStr">
		<input type="hidden" name="hiddPageStr">
		<input type="hidden" name="hiddParamStr">
		<input type="hidden" name="hiddSearchName">
		<input type="hidden" name="hiddSearchList">
		<input type="hidden" name="hiddColNamesTypes">
		
		<input type="hidden" name="gridObj">
		<input type="hidden" name="pageObj">
		<input type="hidden" name="currPage">
		<input type="hidden" name="beforePage">
		<input type="hidden" name="selectId">
	</form>
	<div id="toolbardiv" style="width:100%; height:50; border :1px solid Silver;"></div>
	<tiles:insert attribute="toolbar"/>
	<script>
	   /**
		*
		*/
		
		/**
		 *  获得已定义查询数据

		 *  按要求XML格式生成XML子串
		 */
		//==================================--[已定义查询]--=====================================//
	   function defineQuery(user,busname,subname){
		    SysUiGridFacade.getAdvanceQueryXml(user,busname,subname,callBackHunter);
			function callBackHunter(data){
				var queryStr = getQueryListXML(data);
				var xdoc = createDom();
				xdoc.loadXML(queryStr);
				var root = xdoc.getElementsByTagName("Menu")[0];
				Menu.prototype.cssFile = "<%=request.getContextPath()%>/themes/themes1/style.css";
				var sm = new Menu();
				sm = createChildItems(root,sm,"query");
				var menuBar = new MenuBar();
				var tmp;
				menuBar.add( tmp = new MenuButton('<img src="<%=request.getContextPath()%>/themes/themes1/images/main/select01.gif">', sm) );
				tmp.mnemonic = 's';
			    menuBar.write(document.getElementById('divSelect1')); 
			}
		}
		//=====================================================================================//
		/**
	    *  获得选择操作数据
	    *  解析XML字串按格式要求生成新XML子串
	    */
	    //==================================--[选择操作]--=====================================//
	    var operArra = getSelectOperXml("<%=xmlData%>");
	    var busId     = operArra[0];
	    var busName   = operArra[1];
	    var reportUrl = operArra[2];
	    var xmlData   = operArra[3];
	    
	    var xdoc2 = createDom();
	    xdoc2.loadXML(xmlData);
	    var root2 = xdoc2.getElementsByTagName("Menu")[0];
	    Menu.prototype.cssFile = "<%=request.getContextPath()%>/themes/themes1/style.css";
	    var sm2 = new Menu();
		sm2 = createChildItems(root2,sm2,"operate");
		var menuBar2 = new MenuBar();
		var tmp2;
		menuBar2.add( tmp2 = new MenuButton('<img src="<%=request.getContextPath()%>/themes/themes1/images/main/select02.gif">', sm2) );
   		tmp2.mnemonic = 's';
		//=====================================================================================//
   
		/**
		*  初始化工具栏信息
		*  生成工具栏元素对象

		*/
		//:::::::::::::::::::::::::::::::::::::::::::::TOOLBAR::::::::::::::::::::::::::::::::::::::::::::::://
		aToolBar2=new dhtmlXToolbarObject("toolbardiv",'100%',20,"");
		
		aToolBar2.setGfxPath("<%=request.getContextPath()%>/themes/themes1/images/main/");
		aToolBar2.setToolbarCSS("tools","toolbarName");
		aToolBar2.setOnClickHandler(onButtonClick);
		
		aToolBar2.addItem(new dhtmlXToolbarDividerTextXObject('div_text','','25','20'));
		aToolBar2.addItem(new dhtmlXToolbarDividerTextXObject('div_text',busName,'25','150'));
		aToolBar2.addItem(new dhtmlXToolbarDividerDivXObject('<%=request.getContextPath()%>/themes/themes1/images/main/select01.gif','divSelect1','150','25'));
		aToolBar2.addItem(new dhtmlXToolbarDividerTextXObject('div_text','','25','10'));
		aToolBar2.addItem(new dhtmlXToolbarDividerTextXObject('div_text','查找:','25','40'));
		aToolBar2.addItem(new dhtmlXToolbarInputTextXObject('inputText','100'));
		aToolBar2.addItem(new dhtmlXImageButtonObject('<%=request.getContextPath()%>/themes/themes1/images/main/search3.gif',25,20,0,'find','查找','','<%=request.getContextPath()%>/themes/themes1/images/main/search3.gif'));
		aToolBar2.addItem(new dhtmlXToolbarDividerImgXObject('<%=request.getContextPath()%>/themes/themes1/images/main/point_line.gif','div_4',25,5));
		aToolBar2.addItem(new dhtmlXImageButtonObject('<%=request.getContextPath()%>/themes/themes1/images/main/new.gif',25,30,0,'new','新建','','<%=request.getContextPath()%>/themes/themes1/images/main/new2.gif'));
		aToolBar2.addItem(new dhtmlXImageButtonObject('<%=request.getContextPath()%>/themes/themes1/images/main/copy.gif',25,30,0,'copy','复制','','<%=request.getContextPath()%>/themes/themes1/images/main/copy2.gif'));
		aToolBar2.addItem(new dhtmlXImageButtonObject('<%=request.getContextPath()%>/themes/themes1/images/main/save.gif',25,30,0,'save','保存','','<%=request.getContextPath()%>/themes/themes1/images/main/save2.gif'));
		aToolBar2.addItem(new dhtmlXImageButtonObject('<%=request.getContextPath()%>/themes/themes1/images/main/delete.gif',25,30,0,'delete','删除','','<%=request.getContextPath()%>/themes/themes1/images/main/delete2.gif'));
		aToolBar2.addItem(new dhtmlXImageButtonObject('<%=request.getContextPath()%>/themes/themes1/images/main/cancel.gif',25,30,0,'cancel','取消','','<%=request.getContextPath()%>/themes/themes1/images/main/cancel2.gif'));
		aToolBar2.addItem(new dhtmlXToolbarDividerImgXObject('<%=request.getContextPath()%>/themes/themes1/images/main/point_line.gif','div_5',25,5));
		aToolBar2.addItem(new dhtmlXToolbarDividerDivXObject('<%=request.getContextPath()%>/themes/themes1/images/main/select02.gif','divSelect2','150','25'));	
		aToolBar2.addItem(new dhtmlXImageButtonObject('<%=request.getContextPath()%>/themes/themes1/images/main/edit01.gif',25,25,0,'transition','工作流转','','<%=request.getContextPath()%>/themes/themes1/images/main/edit02.gif'));
		aToolBar2.addItem(new dhtmlXToolbarDividerImgXObject('<%=request.getContextPath()%>/themes/themes1/images/main/point_line.gif','div_5',25,5));
		//aToolBar2.addItem(new dhtmlXToolbarDividerTextXObject('div_text','','25','10'));
		aToolBar2.addItem(new dhtmlXImageButtonObject('<%=request.getContextPath()%>/themes/themes1/images/main/arrow_left.gif',25,30,0,'lastRow','上一条','','<%=request.getContextPath()%>/themes/themes1/images/main/arrow_left.gif'));
		aToolBar2.addItem(new dhtmlXImageButtonObject('<%=request.getContextPath()%>/themes/themes1/images/main/arrow_right.gif',25,30,0,'nextRow','下一条','','<%=request.getContextPath()%>/themes/themes1/images/main/arrow_right.gif'));	
		aToolBar2.addItem(new dhtmlXToolbarDividerTextXObject('div_text','','25','400'));
		aToolBar2.addItem(new dhtmlXImageButtonObject('<%=request.getContextPath()%>/themes/themes1/images/main/tab.gif',25,25,0,'report','查看报表','','<%=request.getContextPath()%>/themes/themes1/images/main/tab.gif'));
		aToolBar2.addItem(new dhtmlXToolbarDividerTextXObject('div_text','','25','10'));
		aToolBar2.showBar();
		//选择操作相关
		menuBar2.write(document.getElementById('divSelect2'));
			
			/**
			*  工具栏对应元素的点击事件入口
			*/
			function onButtonClick(itemId,itemValue){
				var gridObj 		= document.all.gridObj.value;
				var queryPath   	= parent.downFrame.iframe1.document.all.queryPath.value;
				var colNamesTypes 	= parent.downFrame.iframe1.document.all.colNamesTypes.value;
				//var selectColNames  = parent.downFrame.iframe1.document.all.selectColNames.value;
				var colName			= parent.downFrame.iframe1.document.all.colName.value;
				var colType			= parent.downFrame.iframe1.document.all.colType.value;
				var page	 		= parent.downFrame.iframe1.document.all.pageDefault.value;
				
				/**
				*  全局通用查找功能
				*/
				if(itemId == "find")
				{
					var searchParam = document.getElementById("inputText").value;
					if(parent.downFrame.ID1.className == "ooihj"){
						var wheres 		= "";
						if(colName != null && colName != ""){
							if(colName.indexOf(",") != -1){
								var colNameArra = colName.split(",");
								var colTypeArra = colType.split(",");
								for(var i=0;i<colNameArra.length;i++){
									var colTypeStr = colTypeArra[i].toLowerCase()
									//alert("::::::::::::::::::::"+colNameArra[i]+":::::::::"+colTypeStr);
									if(wheres == ""){
										wheres += colNameArra[i]+"^"+colTypeStr+"^9^"+searchParam+"^^desc";
									}else{
										wheres += "@@@"+colNameArra[i]+"^"+colTypeStr+"^9^"+searchParam+"^^desc";
									}
								}
								if(wheres != null && wheres != "undefined" && wheres != "null" && wheres != ""){
									wheres	+= "###";
								}
							}
						}
						parent.downFrame.iframe1.createGrid('','1','','','',wheres,'','');
					}else{
						alert("只有在列表页可实现查找功能");
					}
				}
				/**
				*  新建按钮功能
				*/
				else if(itemId == "new")
				{
					var td2    = parent.downFrame.document.all.ID2;
					
					//调用tab.js中方法

					selectTab(td2, '', 'true','false');
				}
				/*************************************************************************************************/
				else if(itemId == "copy")
				{
					var td1	  = parent.downFrame.document.all.ID1;
					if (td1.className == "ooihs"){
						alert("请首先选中浏览页的记录！");
						return;
					}
					var td2   = parent.downFrame.document.all.ID2;
					selectTab(td2, '', 'false','true');
				}
				/*************************************************************************************************/
				else if(itemId == "save")
				{	
					//保存时，判断当前选中的tab页中是否存在“onSaveForm”方法，有则调用
				    var tds = parent.downFrame.document.getElementsByTagName("td");
					for (var i=0; i<tds.length; i++){
						var td = tds[i];
						var tdName = tds[i].id;
						if (tdName.indexOf('ID') != -1){
							if (td.className == "ooihj"){
								var index = tdName.substring(2,tdName.length);
								var func = eval("parent.downFrame.iframe"+index+".onSaveForm");
								if (typeof(func) == "function"){
									eval("parent.downFrame.iframe"+index+".onSaveForm('/" + getContextPath() + "');");
								}
							}	
						}
					}
				}
				/*************************************************************************************************/
				else if(itemId == "delete")
				{
					deleteData(itemId,itemValue);
				
					//删除时，判断当前选中的tab页中是否存在“onGridDelete”方法，有则调用
				   /** var tds = parent.downFrame.document.getElementsByTagName("td");
					for (var i=0; i<tds.length; i++){
						var td = tds[i];
						var tdName = tds[i].id;
						if (tdName.indexOf('ID') != -1){
							if (td.className == "ooihj"){
								var index = tdName.substring(2,tdName.length);
								var func = eval("parent.downFrame.iframe"+index+".onGridDelete");
								if (typeof(func) == "function"){
									eval("parent.downFrame.iframe"+index+".onGridDelete();");
								}
							}	
						}
					}	*/			
				}
				/*************************************************************************************************/
				else if(itemId == "cancel")
				{
					//重置时，判断当前选中的tab页中是否存在“onResetForm”方法，有则调用
				    var tds = parent.downFrame.document.getElementsByTagName("td");
					for (var i=0; i<tds.length; i++){
						var td = tds[i];
						var tdName = tds[i].id;
						if (tdName.indexOf('ID') != -1){
							if (td.className == "ooihj"){
								var index = tdName.substring(2,tdName.length);
								var func = eval("parent.downFrame.iframe"+index+".onResetForm");
								if (typeof(func) == "function"){
									eval("parent.downFrame.iframe"+index+".onResetForm();");
								}
							}	
						}
					}
				}
				/*************************************************************************************************/
				else if(itemId == "lastRow")
				{
					//var currentPage = document.all.currPage.value;			
					var td2	  = parent.downFrame.document.all.ID2;
					if (td2.className == "ooihj"){
						preRow();
						/*
						var myGrid 	= parent.downFrame.iframe1.mygrid;
						var rowSel  = myGrid.getSelectedId();

						var dataNum;
						if(rowSel != null){
							if(rowSel.indexOf(",") != -1){
								var rowArra = rowSel.split(",");
								dataNum = myGrid.cells(Number(rowArra[0]),0).getValue().split("^")[0];
							}
							else{
								dataNum = myGrid.cells(Number(rowSel),0).getValue().split("^")[0];
							}
							if((parseInt(dataNum) > 0) && (parseInt(dataNum) < (parseInt(pageStr)+1))){
								var beforePage = document.all.beforePage.value;
								var selectId   = document.all.selectId.value;
								if(currentPage == "" || currentPage == null || parseInt(beforePage) != parseInt(currPage) || parseInt(selectId) != parseInt(dataNum) ){	
									document.all.selectId.value   = dataNum;
									document.all.beforePage.value = parseInt(currPage);
									currentPage = (parseInt(currPage)-1)*parseInt(pageStr)+parseInt(dataNum);
								}
							
								if(parseInt(currentPage) <= parseInt(totalNum) && parseInt(currentPage) >= 1){
									if(parseInt(currentPage) != 1){
										document.all.currPage.value   = (parseInt(currentPage)-1);
									}
									var hunter = new Object();
										hunter["KEY_COLNAMES"] 		= selectColNames;
										hunter["KEY_FILTER"] 		= "";
										hunter["KEY_SORTONLYCOL"] 	= "";
										hunter["KEY_WHERE"] 		= "";
										hunter["KEY_PAGE"] 			= (parseInt(currentPage)-1)+"^1";
										hunter["KEY_DOMAINNAME"] 	= domainName;
										hunter["KEY_QUERYTYPE"] 	= "0";
										hunter["KEY_DELPARAMS"] 	= "";
										hunter["KEY_OPARAMS"] 		= otherparams;
									CommonQueryHunter.hunter(hunter,callBackHunter);
									function callBackHunter(data){
										var mainId = data[0]["t.id"];
										selectTab(td2, '', 'false','true',mainId);
									}
								}
							}
							else{
								alert("选择了不合适的区域");
							}
							*/
					}
				}
				/*************************************************************************************************/
				else if(itemId == "nextRow")
				{
					//var currentPage = document.all.currPage.value;			
					var td2	  = parent.downFrame.document.all.ID2;
					if (td2.className == "ooihj")
					{
						nextRow();
					/*
						var myGrid 	= parent.downFrame.iframe1.mygrid;
						var rowSel  = myGrid.getSelectedId();

						var dataNum;
						if(rowSel != null)
						{
							if(rowSel.indexOf(",") != -1)
							{
								var rowArra = rowSel.split(",");
								dataNum = myGrid.cells(Number(rowArra[0]),0).getValue().split("^")[0];
							}
							else
							{
								dataNum = myGrid.cells(Number(rowSel),0).getValue().split("^")[0];
							}
							//alert("currPage:"+currPage+":totalCount:"+totalNum+":pageStr:"+pageStr+":dataNum:"+dataNum);
							if((parseInt(dataNum) > 0) && (parseInt(dataNum) < (parseInt(pageStr)+1)))
							{
								var beforePage = document.all.beforePage.value;
								var selectId   = document.all.selectId.value;
								if(currentPage == "" || currentPage == null || parseInt(beforePage) != parseInt(currPage) || parseInt(selectId) != parseInt(dataNum) )
								{
									document.all.selectId.value   = dataNum;
									document.all.beforePage.value = parseInt(currPage);
									currentPage = (parseInt(currPage)-1)*parseInt(pageStr)+parseInt(dataNum);
								}	
								if((parseInt(currentPage) <= parseInt(totalNum)) && (parseInt(currentPage) >= 1))
								{
									if(parseInt(currentPage) != parseInt(totalNum)){
										document.all.currPage.value   = (parseInt(currentPage)+1);
									}
									var hunter = new Object();
										hunter["KEY_COLNAMES"] 		= selectColNames;
										hunter["KEY_FILTER"] 		= "";
										hunter["KEY_SORTONLYCOL"] 	= "";
										hunter["KEY_WHERE"] 		= "";
										hunter["KEY_PAGE"] 			= (parseInt(currentPage)+1)+"^1";
										hunter["KEY_DOMAINNAME"] 	= domainName;
										hunter["KEY_QUERYTYPE"] 	= "0";
										hunter["KEY_DELPARAMS"] 	= "";
										hunter["KEY_OPARAMS"] 		= otherparams;
									CommonQueryHunter.hunter(hunter,callBackHunter);
									function callBackHunter(data)
									{
										var mainId = data[0]["t.id"];
										selectTab(td2, '', 'false','true',mainId);
									}
								}
							}
							else
							{
								alert("选择了不合适的区域");
							}
						}
						*/
					}
					
				}
				
				else if(itemId == "transition"){
					workTransition(itemId,itemValue);
				}
				/*************************************************************************************************/
				else if(itemId == "report")
				{
					document.reportForm.action = reportUrl;
					document.reportForm.target = "blank";
					document.reportForm.submit();
				}
				/*************************************************************************************************/
			};
	</script>
	<form name="reportForm" method="post">
	</form>
</BODY>
</HTML>