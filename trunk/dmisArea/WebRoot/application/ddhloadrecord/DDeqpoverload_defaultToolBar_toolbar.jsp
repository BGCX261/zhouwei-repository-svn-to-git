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
	
		var myGrid = parent.downFrame.iframe1.mygrid;
		var keyStr 	= myGrid.getSelectedRowsData(3);
		var fid ="";
		var version = "";
		if(keyStr.indexOf("@@@") != -1){
			var dataArra 	= keyStr.split("@@@");
			for(var x=0; x<dataArra.length; x++){
				if(dataArra[x].indexOf("^") != -1){
					var name = dataArra[x].split("^")[0];
					var value = dataArra[x].split("^")[1];
					if(name == "fid"){
						fid = value;
					} 
					if(name == "version"){
						version   = value;
					}
				}
			}
			alert(fid);
			alert(version);
			if (fid != "" && version != "")
			{
				var pars        = "fid="+fid+"&version="+version;
				
				var url			= "<%=request.getContextPath()%>/ddHloadrecord.do?method=delete";
				var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
				function callBackGrid(originalRequest)
				{
					if(originalRequest)
					{
						alert(originalRequest.responseText);
						parent.downFrame.iframe1.createGrid('','0','','','','','','');
					}
				}	
			}	
			
		}
				
		
	}
</script>