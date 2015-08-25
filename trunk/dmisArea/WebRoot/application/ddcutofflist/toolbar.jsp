<%@ page contentType="text/html; charset=utf-8" language="java"%>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/prototype.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/application/ddmoutageplan/DDMonthplan.js"> </script>
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

    function deleteData(temId,itemValue){

		var primaryStr = parent.downFrame.iframe1.mygrid.getSelectedRowsData(3);
		alert(primaryStr);
		if(!primaryStr)return false;
		var primaryId   = "";
		var version 	= "";
		if(primaryStr.indexOf("@@@") != -1){
			var dataArra 	= primaryStr.split("@@@");
			for(var x=0; x<dataArra.length; x++){
				if(dataArra[x].indexOf("^") != -1){
					var name = dataArra[x].split("^")[0];
					var value = dataArra[x].split("^")[1];
					if(name == "fid"){
						primaryId = value;
					}
					if(name == "version"){
						version   = value;
					}
				}
			}
		}

        var para ="fid="+primaryId+"&version="+version;
        alert(para);
		var url="<%=request.getContextPath()%>/ddCutofflist.do?method=delete";
		var myAjax = new Ajax.Request(url,{method: 'post', parameters: para,  onComplete: showResponse});
		     function showResponse(originalRequest)
	       {
	          var deleSuccess = originalRequest.responseText;
	          alert(deleSuccess);
	          //
	          var td1    = parent.downFrame.document.all.ID1;
              selectTab(td1, '', 'true','false');
              //
              parent.downFrame.iframe1.createGrid('','0','','','','','','');
	       }

	}


</script>
