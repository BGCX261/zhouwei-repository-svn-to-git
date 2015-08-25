<%@ page contentType="text/html; charset=utf-8" language="java"%>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/prototype.js"></script>
<script type="text/javascript">
	function operation1(itemId,itemValue)
	{
		alert("operation1");
	}
	function operation2(itemId,itemValue){
		alert("operation2");
	}	
	function operation3(itemId,itemValue){
		alert("operation3");
	}	
	function operation4(itemId,itemValue){
		alert("operation4");
	}
	//删除数据	
	function deleteData(itemId,itemValue)
	{
		var gridId 		= parent.downFrame.iframe1.mygrid;
		var rows 		= gridId.getSelectedRows();
		var primaryId = "";
		var version   = ""; 
		var fstatus    = "";
		if(rows != null && rows != "undefined" && rows != ""){
			for (row = 0;row<rows.length;row++){ 
				//获取指定行的主键列的列值

				var colValue = gridId.getValByRC(rows[row],'fid');
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
				
			}
		}
		if (primaryId == ""){  	      
			alert("没有找到主键值!"); 	      
			return false; 	   
		} 
		if (version == ""){  	      
			alert("没有找到版本值!"); 	      
			return false; 	   
		} 
		
		var sign = confirm(" 您确认将删除选中数据?");
		if(sign){
			
			if(version != null && version != "" && primaryId != null && primaryId != ""){
				var pars        = "fid="+primaryId;
					pars	   += "&version="+version;
				var url			= "<%=request.getContextPath()%>/ddWaterheight.do?method=delete";
				var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
				function callBackGrid(originalRequest){
					if(originalRequest){
						alert(originalRequest.responseText);
						var td1    = parent.downFrame.document.all.ID1;
						selectTab(td1, '', 'true','false');
						parent.downFrame.iframe1.createGrid('','0','','','','','','');
					}
				}
			}
		}
		
		
	}		
</script>