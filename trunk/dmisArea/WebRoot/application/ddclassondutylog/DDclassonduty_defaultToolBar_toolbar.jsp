<%@ page contentType="text/html; charset=utf-8" language="java"%>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/prototype.js"></script>
<script type="text/javascript">
	/**
	*交接班


	*/
	function turnOver(itemId,itemValue)
	{
		var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
	    if(!rows){	           
	           alert("请选择一条操作票记录");
	           var td1    = parent.downFrame.document.all.ID1;
			   selectTab(td1, '', 'true','false');
			   parent.downFrame.iframe1.createGrid('','0','','','','','','');
	           return false;
	    }
	    if(rows.length>1){    
	       alert("您只能选择一条操作记录!!!");
	       var td1    = parent.downFrame.document.all.ID1;
		   selectTab(td1, '', 'true','false');
		   parent.downFrame.iframe1.createGrid('','0','','','','','','');
		   return false; 
	    }
		var myGrid = parent.downFrame.iframe1.mygrid;
		var keyStr 	= myGrid.getSelectedRowsData(3);
		
		var fid ="";
		var version = "";
		fid = myGrid.getValueByName("fid");
		var sign = confirm(" 您确认将交接班?");
		if(sign){
			if (fid != "")
			{
				var pars        = "fid="+fid;
				var url			= "<%=request.getContextPath()%>/ddClassondutylog.do?method=turnover";
				var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
				function callBackGrid(originalRequest)
				{
					if(originalRequest)
					{
						parent.parent.location="<%=request.getContextPath()%>/index.jsp";
						//alert(originalRequest.responseText);
						//parent.downFrame.iframe1.createGrid('','0','','','','','','');
					}
				}	
			}	
		}
			
			
			
			
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
		fid = myGrid.getValueByName("fid");
		version = myGrid.getValueByName("version");
		
		if (fid != "" && version != "")
		{
			var pars        = "fid="+fid+"&version="+version;
			
			var url			= "<%=request.getContextPath()%>/ddClassondutylog.do?method=delete";
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
</script>