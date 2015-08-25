<%@ page contentType="text/html; charset=GBK"%>
<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
  <head>
  
 	<meta http-equiv="Content-Type" content="text/html; charset=GBK"> 	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/frame.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/ext-all.css" />
	<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/interface/frame_service.js'></script>
  	<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/engine.js'></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/ext/ext-base.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/ext/ext-all.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/ext/jquery.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/ext/frame.js" ></script>
	

  </head>
  
  <body >
	<div id="header" >
		<!-- <img src="${pageContext.request.contextPath}/images/logo.gif" title="111"/> -->
		<!-- <span style="width:210;height:40">
		<img src="${pageContext.request.contextPath}/images/frame/logo.gif" title="111" width="100" style="margin: 10,5,5,5"/>
		</span> -->
		<table align="left" width="100%" height="60">
		<tr>
		<td width="200" valign="middle">
			&nbsp;<img src="${pageContext.request.contextPath}/images/frame/logo.gif" title="111" width="100" />
		</td>
		<td valign="bottom" id="menubar">
			&nbsp;
		</td>
		</tr>
		</table>
	</div>
	<iframe src="" id="frame1" height="100%" width="100%" frameborder=0></iframe>
	
  </body>
  <script type="text/javascript">
    $(DWREngine.setActiveReverseAjax(true));
    $(DWREngine.setAsync(false));   
    
   var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Please wait..."});
	

  	Ext.BLANK_IMAGE_URL = '/images/default/s.gif"';

	Ext.onReady(function(){
		myMask.show();
		getFrameMenu();
		myMask.hide();
	})
  
  function getFrameMenuNode(e){
  	  myMask.show();
  	  frame_service.getFrameMenuNode(e.target.name,callbackFn2);
  	  myMask.hide();
  }
  
  function getFrameMenu(){
  	  myMask.show();
  	  frame_service.getFrameMenu(callbackFn);
  	  myMask.hide();
  }
  
  function callbackFn(data){
  	  frame.init(data);
  }
  
  function callbackFn2(data){
  	  var temp = frame.buildDatas(data);
  	  frame.updateMenu(temp);
  }
  
 
  </script>
</html>
