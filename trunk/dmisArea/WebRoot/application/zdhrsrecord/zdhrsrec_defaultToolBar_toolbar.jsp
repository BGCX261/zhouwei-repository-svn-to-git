<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_grid.jsp" %>
<%@ page import="com.techstar.dmis.util.DateUtil" %>
<%@ page import="java.sql.Date" %>
<%
	String dateStr = DateUtil.getCurrentTimestamp().toLocaleString();
	dateStr = dateStr.split(" ")[0];
	//System.out.println("##########################@@!@@@@"+dateStr);
%>
<script type="text/javascript">
	function selectAccidnt(itemId,itemValue){
		var param  = "accidenttime^timestamp^4^<%=dateStr%>^^desc###";
		parent.downFrame.iframe1.createGrid('','0','','','',param,'','');
	}
	
	function deleteData(itemId,itemValue){
		var gridId 		= parent.downFrame.iframe1.mygrid;
		var rows 		= gridId.getSelectedRows();
		var primaryId = "";
		var version   = ""; 
		var fstatus    = "";
		if(rows != null && rows != "undefined" && rows != ""){
			for (row = 0;row<rows.length;row++){ 
				//获取指定行的主键列的列值
				var colValue = gridId.getValByRC(rows[row],'recordid');
				if (colValue == "" || colValue == null) { continue;}
				if (primaryId == ""){ 
					primaryId = colValue;
				} else {
					primaryId += '^'+colValue;
				}
				var colVersion = gridId.getValByRC(rows[row],'version');
				if (colVersion == "" || colVersion == null) { continue;}
				if (version == ""){ 
					version = colVersion;
				} else {
					version += '^'+colVersion;
				}
				//var statusVersion = gridId.getValByRC(rows[row],'fstatus');
				//if (statusVersion == "" || statusVersion == null) { continue;}
				//if (fstatus == ""){ 
				//	fstatus = statusVersion;
				//} else {
				//	fstatus += '^'+statusVersion;
				//}
			}
		}
		if (primaryId == ""){  	      
			dealAlertMessage("没有找到主键值!"); 	      
			return false; 	   
		} 
		if (version == ""){  	      
			dealAlertMessage("没有找到版本值!"); 	      
			return false; 	   
		} 
		//alert("#######:"+primaryId+":#######:"+version+":#######:");
		//var statusArra = fstatus.split("^");
		//for(var i=0; i<statusArra.length; i++){
		//	if(statusArra[i] != "草稿"){
		//		alert("只有状态为草稿的可以删除!!!");
		//		return false;
		//	}
		//}
		var sign = confirm(" 您确认将删除选中数据?");
		if(sign){
			if(version != null && version != "" && primaryId != null && primaryId != ""){
				var pars        = "recordid="+primaryId;
					pars	   += "&version="+version;
				var url			= "<%=request.getContextPath()%>/zdhRsrecord.do?method=delete";
				var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
				function callBackGrid(originalRequest){
					if(originalRequest){
						dealAlertMessage(originalRequest.responseText);
						var td1    = parent.downFrame.document.all.ID1;
						selectTab(td1, '', 'true','false');
						parent.downFrame.iframe1.createGrid('','0','','','','','','');
					}
				}
			}
		}
	}
	
	/**
	 * 上一条操作
	 */
	function preRow(){
		operToolbarRow("iframe1","zdhRsrecord","previous");
	}
	/**
	 * 下一条操作
	 */
	function nextRow(){
		operToolbarRow("iframe1","zdhRsrecord","next");
	}
</script>