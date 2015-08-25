<%@ page contentType="text/html; charset=UTF-8" %>
<% 
						/*********************************************/
						//           通用查询模板-保存查询条件页         //
						//         @author MaJian 2007-01-08         //
						/*********************************************/
%>
<html>
<head>
<title>保存查询条件</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<meta http-equiv="Content-Language" content="zh-CN" />
	<link href="<%=request.getContextPath()%>/themes/themes1/style.css" rel="stylesheet" type="text/css" />
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/SysUiGridFacade.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
	<STYLE>
   		.userData {behavior:url(#default#userdata);}
	</STYLE>
	<script>
		var param 	 = window.dialogArguments;
		var wheres   = param.wheres;
	</script>
	<script>
		function enterData()
		{
			var name = document.all.content.value;
			if(name != "" && name != null){
				
				var user 	= param.userSign;
				var busName = param.busName;
				var subName = param.subName;
				//此处去数据库查询字串
				SysUiGridFacade.getAdvanceQueryXml(user,busName,subName,callBackHunter);
				function callBackHunter(data){
					var xmlString = data;
					var sign = false;
						var xdoc = createDom();	
						xdoc.loadXML(xmlString);
						var rootElem 	= xdoc.getElementsByTagName("advancequery")[0];
						if((rootElem != null)){ //&& (rootElem != "") && (rootElem != "undefined")
							var childElem	= rootElem.childNodes;
							//if(childElem != null && childElem != "" && (childElem != "undefined")){
								for(var i=0;i<childElem.length;i++){
									var child = childElem[i];
									//if(child != null && child != "" && (child != "undefined")){
										var childName  = child.getAttribute("name");
										if(name == childName){
											sign = true;
											if(confirm("在列表中已经存在此名,要覆盖吗?") == false){
												return false;
											}
										}
									//}
								}
							//}
						}
						if(sign == false){
						//存储查询字串
							SysUiGridFacade.saveAdvanceQueryData(user,busName,subName,xmlString,name,wheres,"add",callBack);
						}else{
							//覆盖查询字串
							SysUiGridFacade.saveAdvanceQueryData(user,busName,subName,xmlString,name,wheres,"cover",callBack);
						}
						function callBack(data){
							alert("存储完成");
						}
					
					
					var paramObj = new Object();
						paramObj.title = "saveName";
						paramObj.name  = name;
					
					window.returnValue = paramObj;
					window.close();
				}
			}else{
				document.all.message.innerHTML = "请输入查询名称!";
			}
		}
		
		/**
		 * 获得DOM对象
		 */
		function createDom(){
			var signatures = new Array("Microsoft.XMLDOM","Msxm12.DOMDocument.5.0","Msxm12.DOMDocument.4.0","Msxm12.DOMDocument.3.0","Msxm12.DOMDocument");
			var xmldoc ;
			for(var i =0;i<signatures.length;i++){
				try{
					xmldoc = new ActiveXObject(signatures[i]);
					xmldoc.async = false;
					return xmldoc;
				}catch(e){
					//忽略错误，继续循环取下一格版本；
				}
			}
			if(xmldoc==null){
				alert("没有取到Dom对象");
			}  
		}
		
		/**
	   *  去除String前后空格
	   */
		function String.prototype.Trim() 
		{
			return this.replace(/(^\s*)|(\s*$)/g,"");
		}
	</script>
</head>
<body>
	<div id="docuData" class=userData></div>
<table class="noborder" cellspacing="0" cellpadding="0">
  <tr class="p1">
    <th colspan="3" class="pt" align="left" height="30">&nbsp;&nbsp;&nbsp;&nbsp;请添写保存名称：</th>
  </tr>
  <tr>
  	<td></td>
  </tr>
  
  <tr>
    <td align="center">
		<table>
			<tr align="center">
				<td>
					<div id="message"></div>
					<input type="text" name="content" style="display:block">
				</td>
			</tr>
			<tr>
  				<td></td>
  			</tr>
			<tr align="center">
				<td>
					<input type="button" class="inputbutton" name="enter" value=" 确定 " onClick="enterData()">
					<input type="button" class="inputbutton" name="cannle" value=" 取消 " onClick="window.close()">
				</td>
			</tr>
    	</table>
    </td>
  </tr>
   <tr>
  	<td></td>
  </tr>
  <tr class="p1">
    <th colspan="3" class="pt" align="left" height="30">&nbsp;&nbsp;&nbsp;&nbsp;</th>
  </tr>
</table>
<script>
		if(wheres == "")
		{
			document.all.content.style.display = "none";
			document.all.enter.style.display   = "none";
			document.all.message.innerHTML = "没有进行高级查询,无法保存!";
		}
</script>
</body>
</html>