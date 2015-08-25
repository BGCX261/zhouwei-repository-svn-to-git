     //取得web上下文路径



	 function getContextPath()
	  {
	   		var url = location.href;
	   		if(url.indexOf('http://')<0)
		  		return "./";
	   		url = url.substring(url.indexOf('http://') + 7);
	   		if(url.indexOf('/') < 0)
	   			return "";
	   		url = url.substring(url.indexOf('/') + 1);
	   		var pos;
	   		if(url.indexOf('/') >= 0) 
				pos = url.indexOf('/');
	   		else pos = url.length;
	   			url = url.substring(0, pos);
	   		return url;
	  }
 	/**
 	 *弹出或隐藏层js
	*/
	 
	function popDiv(tableName,obj)
	{
		//获得标题头的图像id;去控制图像

     
		 //iconId=document.getElementById('icon');
		var path = getContextPath();
		//alert(key[1]);
		if (tableName.style.display=="none") 
		{
		 obj.src="/"+path+"/themes/themes1/images/main/zd_gray2.gif";
		 tableName.style.display="block";
		}
		else
		{
		 obj.src="/"+path+"/themes/themes1/images/main/zd_gray1.gif";
		 tableName.style.display="none";
		}
	}
	 


    
	
	 
	
	function MM_findObj(n, d) { //v4.01
	  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
		d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
	  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
	  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
	  if(!x && d.getElementById) x=d.getElementById(n); return x;
	}
	
	function MM_showHideLayers() { //v6.0
	  var i,p,v,obj,args=MM_showHideLayers.arguments;
	  for (i=0; i<(args.length-2); i+=3) if ((obj=MM_findObj(args[i]))!=null) { v=args[i+2];
		if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v=='hide')?'hidden':v; }
		obj.visibility=v; }
	}
	
	
    //标签页切换
	function ghbq(td) {
	  var tr = td.parentElement.cells;  //获得td父对象tr的所有单元格数目
      var ob = obody.rows; 
      var curr = '';
      for (var ii = 0; ii < tr.length - 1; ii++) {
      	if(tr[ii].className == "ooihj"){
      		curr = ii;
      		break;
      	}		
     }
	 for (var ii = 0; ii < tr.length - 1; ii++) {
	 	if(td.id.indexOf("ID") != -1){
	   		var strArra = td.id.split("ID");
	   		if(strArra.length > 0){
	   			tr[ii].className = ((strArra[1]-1) == ii) ? "ooihj" : "ooihs";
			    ob[ii].style.display = ((strArra[1]-1)==ii)?"block":"none";
				if(td.cellIndex==ii){
				   k=ii+1;
				   		eval('onClick'+strArra[1]+'("'+curr+'")');
				}
	   			
	   		}
	   } else {
	   		tr[ii].className = (td.cellIndex == ii) ? "ooihj" : "ooihs";
		    ob[ii].style.display = (td.cellIndex==ii)?"block":"none";
			if(td.cellIndex==ii){
			   k=ii+1;
			   
			   		eval('onClick'+k+'("'+curr+'")');
			   
			}
	   }
     }
   }
   
  
   //工具栏点击触发tab页切换时用
   function selectTab(td,src,isNew,isCopy,mainId) {
	  var tr = td.parentElement.cells;  //获得td父对象tr的所有单元格数目
      var table = parent.downFrame.document.all;
      var ob = table.obody.rows;             //
	  for (var ii = 0; ii < tr.length - 1; ii++) {
		tr[ii].className = (td.cellIndex == ii) ? "ooihj" : "ooihs";
	    ob[ii].style.display = (td.cellIndex==ii)?"block":"none";	  
		if(td.cellIndex==ii){
		   k=ii+1;
		   eval("parent.downFrame.onClick"+k+"('"+ src + "','" + isNew+"','"+isCopy+"','"+mainId+"')");
		}
      }
   }
   
  function disableTab(str,sTab){
  		var td   	= parent.downFrame.document.all.ID1;
  		var tr 		= td.parentElement.cells;  //获得td父对象tr的所有单元格数目
      	var table 	= parent.downFrame.document.all;
      	var ob 		= table.obody.rows;          //
	  	var strArra = str.split(",");
	  	for (var ii = 0; ii < tr.length - 1; ii++) {
			if(tr[ii].className == "ooihj" || tr[ii].className == "ooihs"){
				for(var xx = 0; xx < strArra.length ; xx++){
					//if(document.getElementById("ID"+strArra[xx])){
						if(tr[ii].id == "ID"+strArra[xx]){
							tr[ii].style.display = "none";
							parent.downFrame.document.getElementById("iframe"+strArra[xx]).style.display = "none";
						}
					//}
				}
			}
        }
	  	if(sTab != null &&  sTab != "undefined" && sTab != "null" && sTab != ""){
			if(parent.downFrame.document.getElementById("ID"+sTab)){
  				parent.downFrame.document.getElementById("ID"+sTab).className = "ooihj";
  				parent.downFrame.document.getElementById("ID"+sTab).style.display = "block";
  			}
  			if(parent.downFrame.document.getElementById("iframe"+sTab)){
  				parent.downFrame.document.getElementById("iframe"+sTab).style.display = "block";
  				eval("parent.downFrame.onClick"+sTab+"('','true','false')");
  			}
	  	}
	  	
  }
   
   /**
    * 触发非列表页时用于存取全局变量Id的方法

	*
	* @author caojian 2006-12-21
	* @param isNew 是否新增 true or false
	* @return mainId 有则返回id值，无则返回""
	*/
   function dealMainId(isNew){   
	    if (isNew == "true"){
			return "";
		}
		var mainId = "";
		var mygrid = iframe1.mygrid;
		//判断列表对象是否存在  sbt
		if (mygrid == undefined){  		   
		   return "";
		}			
		
		var selectData 	= mygrid.getSelectedRowsData("2");
		if (selectData == ""){
			return "";
		}
		var selectDatas = selectData.split('^');
		mainId = selectDatas[1];		
		return mainId;
   }
   
    /**
    * 得到列表选中行记录方法

	* 
	* @author caojian 2007-1-9
	* @return row 有则返回"^"分割字符串，无则返回""
	*/
   function getSelectRow(){   
		var mygrid = parent.downFrame.iframe1.mygrid;
		if (mygrid == undefined){  		   
		   return "";
		}			
		
		var selectData 	= mygrid.getSelectedRowsData("2");
		if (selectData == ""){
			return "";
		}
		alert(selectData);
		return selectData;
   }    
   
    /**
    * tab页回控工具栏[按钮]
	* 
	* @author majian 2007-4-11
	* @return 
	*/
   function disableButton(str){
	   	var interval = setInterval(operDefineQuery,500);
		function operDefineQuery(){
	  		if(parent.upFrame.aToolBar2){
	  			var buttonArra = new Array("find","new","copy","save","delete","lastRow","nextRow","cancel","transition","report");
	  			var strArra = str.split(",");
	  			for(var i=0; i<strArra.length; i++){
	  				var strName = strArra[i];
	  				parent.upFrame.aToolBar2.disableItem(strName);
	  			}
				for(var x=0; x<buttonArra.length; x++){
					var buttonStr = buttonArra[x];
					if(str.indexOf(buttonStr) == -1){
						parent.upFrame.aToolBar2.enableItem(buttonStr);
					}
				}
	  			clearInterval(interval);
	  		}
	  	}
	}
	
	/**
    * tab页回控工具栏[选择操作][隐藏]
	* 
	* @author majian 2007-4-17
	* @return 
	*/
	function disableMenuItem(str){
		var interval = setInterval(operMenuItem,500);
		function operMenuItem(){
			if(parent.upFrame.disableItem){
				var arrDisable = new Array();
				if(str){
					var arraStr = str.split(",");
					for(var i=0; i<arraStr.length; i++){
						arrDisable[i] = arraStr[i];
					}
				}
        		parent.upFrame.disableItem(arrDisable);
				clearInterval(interval);
			}
		}
	}
	
	/**
    * tab页回控工具栏[选择操作][显示]
	* 
	* @author majian 2007-4-17
	* @return 
	*/
	function enableMenuItem(str){
		var interval = setInterval(operMenuItem,500);
		function operMenuItem(){
			if(parent.upFrame.enableItem){
				var arrEnable = new Array(str);
				if(str){
					var arraStr = str.split(",");
					for(var i=0; i<arraStr.length; i++){
						arrEnable[i] = arraStr[i];
					}
				}  
        		parent.upFrame.enableItem(arrEnable);
				clearInterval(interval);
			}
		}
	}			function selectTabNew(td,src,isNew,isCopy,mainId){     var tr = td.parentElement.cells;  //获得td父对象tr的所有单元格数目      var table = parent.downFrame.document.all;      var ob = table.obody.rows;             //      for (var ii = 0; ii < tr.length - 1; ii++) {           if(tr[ii].className == "ooihj" || tr[ii].className == "ooihs"){              if(tr[ii].id.indexOf("ID") != -1){                  if(td.id == tr[ii].id){                     tr[ii].className = "ooihj";                      ob[ii].style.display = "block";                      var strArra = td.id.split("ID");                     eval("parent.downFrame.onClick"+strArra[1]+"('"+ src + "','" + isNew+"','"+isCopy+"','"+mainId+"')");                  } else {                     tr[ii].className = "ooihs";                      ob[ii].style.display = "none";                  }              }           }        }   }	
 