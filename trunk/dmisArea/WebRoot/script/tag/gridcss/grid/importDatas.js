	   	/**
	   	 * 导入数据对象，根据对应关系把导入的数据格式转化为需要的数据格式
	   	 */
		function importDatasObj(url,relation,gridname,param,title,scoll,height,width){
			//relation 为原数据字段与表格字段的对应关系{"原数据字段":"表格字段","原数据字段":"表格字段"}
	   	    if(relation)
	   	    	this.relation = relation;
	   	    else
	   	        this.relation = new Object();
	   		
	   		this.url = url;
	   		
	   		
	   		if(param)
	   			this.param = param;
	   		else 
	   		    this.param = new Object();
	   		    
	   		    
	   		if(title)
	   		    this.title = title;
	   		else
	   		    this.title='导入数据项';
	   		    
	   		    
	   		if(scoll)
	   			this.scoll = scoll;
	   		else
	   		    this.scoll = "auto";
	   		    
	   		    
	   		if(height)
	   			this.height = height;
	   		else
	   			this.height =500;
	   			
	   			
	   		this.gridname=gridname;
	   		
	   	    if(width)
	   	    	this.width = width;
	   	    else
				this.width = 500;
			return this;
	   	}
	   	
	   	
	   	/**
	   	 * 显示到如的数据源，把选择的记录导入列表
	   	 * @param
	   	 * @return  
	   	 */
	   	importDatasObj.prototype.showImportDatas=function(){
	   			var vReturnValue = showModalDialogYY(this.url,this.width,this.height,this.param,this.title,this.scoll);
	   	       // alert(vReturnValue);
	   	       if(vReturnValue){
	   	            if(this.relation)
		   	        	 vReturnValue = this.tranDatas(vReturnValue);
		   	        eval(this.gridname+".setColumnValueByEXForm(vReturnValue);");
		   	        //mygrid.setColumnValueByEXForm(vReturnValue);  
	   	        } 
	   	}
	   	
	   	/**
	   	 * 把传入的数据格式转换为列表方法需要的格式colname1^colvalue1###colname2^colvalue2
	   	 */
	   	//"pm^药 品###dw^中国医药###pg^20*3###cd^北 京"
	   	importDatasObj.prototype.tranDatas=function(data){
	   		  var aferTrandata ="";
	   		  try{
		   	      var datas = data.split("@@@");
		   		  for(var i=0;i<datas.length;i++){
		   		  	var field = datas[i].split("\^")[0];
		   		  	var value = datas[i].split("\^")[1];
		   		  	var tranfield = this.getTargetField(field);
		   		  	if(i==datas.length-1){
		   		  	    aferTrandata = aferTrandata+tranfield+"\^"+value;
		   		  	}else{
		   		  		aferTrandata = aferTrandata+tranfield+"\^"+value+"###";
		   		  	}
		   		  		
		   		  }
		   	   
	   		  }catch(e){
	   		      alert("数据转换出错");
	   		  }
	   		  
	   		  if(!aferTrandata){
	   		   	alert("数据转换失败");
	   		  }
	   		   return aferTrandata;
	   	
	   	}
	   	
	   	/*
	   	 * 通过传入的数据字段名称查找对应的列表字段名称
	   	 */
	   	importDatasObj.prototype.getTargetField=function(sourField){
	   	    var tranField ="";
	   		try{
	   		   tranField = this.relation[sourField];
	   			
	   		}catch(e){
	   			alert("查找目标字段出错");
	   		}
	   		if(!tranField){
	   			//alert("没有要查找的目标字段");
	   		}
	   		return tranField;
	   	}