 /* 前端检验check.js
 ***************************************************************************************************************
 int          整数                     [int]
 float        小数                     [float]
 scale        数值范围                 [scale,>,8]          第二个参数为!=,=,>,<,>=,<=
 null         空字符串                 [null]
 notnull      非空字符串               [notnull]
 length       定长字符串               [length,<=,7]        第二个参数为!=,=,>,<,>=,<=
 date         日期                     [date,yyyy-mm-dd]    第二个参数为yyyy-mm-dd,yyyy/mm/dd,yyyymmdd,yyyy.mm.dd,*其中*为其中任一格式
 time         时间                     [time]               hh:mm:ss
 datetime     日期时间                 [datetime]           yyyy-mm-dd hh:mm:ss
 email        电子邮件                 [email]
 equaltext    等于其它文本框的内容     [equaltext,text1]    第二个参数为文本框ID
 compare      比较内容                 [compare,text1]      第二个参数为是否等于第二个参数
 																	     [compare,=,text1]    第二个参数为!=,=,>,<,>=,<= 
 mobilenumber 电话号码                 [mobilenumber]
 phonenumber  固定电话号码             [phonenumber]
 ascchar      ASC表内字符              [ascchar]
 ipaddress    IP地址格式               [ipaddress]
 selected     下拉别表是否选择         [selected]
                                       [selected,b]         第二个参数为是否等于第二个参数
                                       [selected,>,b] 		  第二个参数为!=,=,>,<,>=,<=
 ***************************************************************************************************************
 */
  function webx_ui_chkform(frmName){   
     this.frmName=frmName;
     this.paramList=[];
     this.msgtype=1;
     this._BindToEle=true;
     this._Submit=false;
     this._SubmitFun=null;
     this._Reset=false;
     this._ResetFun=null;
     
  }  
  
  webx_ui_chkform.prototype.add = function(eleName,errorstr,chrarray,profun,aftfun){
  	var checkelement=function(eleName,errorstr,checkstring,profun,aftfun) {
	  	var elevalue="";
	  	var i=0;
	    var j=0;
	    var checkstr=checkstring.toString();
	    var eleObj=document.getElementById(eleName);
	    if(typeof(profun)=="function")
  		{
  			try
				{
					profunobj=eval(profun);
				}
				catch(e)
    		{
	    		alert("Profunction error!");
    			return false;
    		}
				profunobj(eleObj);
  		}
			switch (document.getElementById(eleName).tagName.toLowerCase())
			{
				case "input":
					switch (document.getElementById(eleName).type.toLowerCase())
					{
						case "text":
							elevalue=document.getElementById(eleName).value;
							break;
						case "password":
							elevalue=document.getElementById(eleName).value;
							break;
					}
			};
			ErrorString="<br/>";
			while(true)
    	{
	    	ErrStr="";
	    	i=checkstr.indexOf("[",0);
    		if(i<0)
	    		break;
    		j=checkstr.indexOf("]",i)
    		if((j<0)&&(j-i<=1))
	    		break;
    		argarray=checkstr.slice(i+1,j).split(",");
    		checkreturn=false;
    		switch (argarray[0].toString().toLowerCase())
  	 		{
	  	 		case "int": //整数
	  	 		  ErrStr="输入值不为整数";
  	 				checkreturn=((elevalue.toString()=='')||(elevalue.match(/^-?\d+$/)!=null && elevalue.match(/^-?[0]\d+$/)==null))?true:false;
  	 				break;
					case "float": //小数
						ErrStr="输入值不为小数";
	          checkreturn=((elevalue.toString()=='')||(elevalue.match(/^(-?\d+)(\.\d+)$/)!=null && elevalue.match(/^(-?[0]\d+)(\.\d+)?$/)==null))?true:false;
  	 		 		break;
  	 			case "scale": //数值范围 d0003,>=,0.23
	  	 		 	ErrStr="输入值不在所在范围";
	          if(argarray.length<3) 
							break;
          	if(elevalue.toString()=='')
          	{
	          	checkreturn==true;
          		break;
          	}
          	if(((elevalue.match(/^-?\d+$/)!=null && elevalue.match(/^-?[0]\d+$/)==null)||(elevalue.match(/^(-?\d+)(\.\d+)$/)!=null && elevalue.match(/^(-?[0]\d+)(\.\d+)?$/)==null))==false)
	            break;
  	 		 		ev=parseFloat(elevalue.toString());
  	 		 		if(isNaN(ev)==true)
	  	 		 	  break;
  	 		 		cv=parseFloat(argarray[2].toString());   
  	 		 		if(isNaN(cv)==true)
	  	 		 	  break;
  	 		 		switch (argarray[1].toString())
  	 		 		{
	  	 		 		case "=":
  	 		 				if(ev==cv)
	  	 		 				checkreturn=true;
  	 		 				break;
  	 		 			case ">":
	  	 		 			if(ev>cv)
  	 		 					checkreturn=true;
  	 		 				break;
  	 		 			case "<":
	  	 		 			if(ev<cv)
  	 		 					checkreturn=true;
  	 		 				break;
  	 		 			case ">=":
	  	 		 			if(ev>=cv)
  	 		 					checkreturn=true;
  	 		 				break;
  	 		 			case "<=":
	  	 		 			if(ev<=cv)
  	 		 					checkreturn=true;
  	 		 				break;
  	 		 			case "!=":
	  	 		 			if(ev!=cv)
  	 		 					checkreturn=true;
  	 		 				break;
  	 		 			default:
	  	 		 		  alert("unexpected error(0002)");
  	 		 		  	break;
  	 		 		}
  	 		  	break;
					case "null": //空字符串
						ErrStr="输入值不为空字符串";
	          checkreturn=(elevalue.toString()=='')?true:false;
  	 		 		break;
					case "notnull": //非空字符串
					 	ErrStr="输入值不为非空字符串";
	          checkreturn=(!(elevalue.toString()==''))?true:false;
  	 		 		break;
					case "length": //定长字符串 c0003,>,8
						ErrStr="输入值不为指定长度";
	          if(argarray.length<3) 
							break;
						lenv=parseInt(argarray[2].toString());
  	 		 		if(isNaN(lenv)==true)
	  	 		 	  break;
						switch (argarray[1].toString())
  	 		 		{
	  	 		 		case "=":
  	 		 				if(elevalue.length==lenv)
	  	 		 				checkreturn=true;
  	 		 				break;
  	 		 			case "!=":
	  	 		 			if(elevalue.length!=lenv)
  	 		 					checkreturn=true;
  	 		 				break;
  	 		 			case ">":
	  	 		 		  if(elevalue.length>lenv)
  	 		 					checkreturn=true;
  	 		 				break;
  	 		 			case ">=":
	  	 		 		  if(elevalue.length>=lenv)
  	 		 					checkreturn=true;
  	 		 				break;
  	 		 			case "<":
	  	 		 		  if(elevalue.length<lenv)
  	 		 					checkreturn=true;
  	 		 				break;
  	 		 			case "<=":
	  	 		 		  if(elevalue.length<=lenv)
  	 		 					checkreturn=true;
  	 		 				break;
  	 		 			default:
	  	 		 		  alert("unexpected error(0003)");
  	 		 		  	break;	
  	 		 		}
  	 		 		break;
					case "date": //年月日格式 c0004,yyyy-mm-dd
						ErrStr="输入值不为日期格式";
	          if(elevalue.toString()=='')
						{
							checkreturn=true;
							break;
						}
						if(argarray.length<2) 
							break;
						switch (argarray[1].toString())
  	 		 		{
	  	 		 		case "yyyy-mm-dd":
  	 		 				if(elevalue.match(/^((((1[0-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[0-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[0-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[0-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29))$/)!=null)
	  	 		 				checkreturn=true;
  	 		 				break;
  	 		 			case "yyyy/mm/dd":
	  	 		 		  if(elevalue.match(/^((((1[0-9]|[2-9]\d)\d{2})\/(0?[13578]|1[02])\/(0?[1-9]|[12]\d|3[01]))|(((1[0-9]|[2-9]\d)\d{2})\/(0?[13456789]|1[012])\/(0?[1-9]|[12]\d|30))|(((1[0-9]|[2-9]\d)\d{2})\/0?2\/(0?[1-9]|1\d|2[0-8]))|(((1[0-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))\/0?2\/29))$/)!=null)
  	 		 					checkreturn=true;
  	 		 				break;
  	 		 			case "yyyymmdd":
	  	 		 		  if(elevalue.match(/^((((1[0-9]|[2-9]\d)\d{2})(0?[13578]|1[02])(0?[1-9]|[12]\d|3[01]))|(((1[0-9]|[2-9]\d)\d{2})(0?[13456789]|1[012])(0?[1-9]|[12]\d|30))|(((1[0-9]|[2-9]\d)\d{2})0?2(0?[1-9]|1\d|2[0-8]))|(((1[0-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))0?229))$/)!=null)
  	 		 					checkreturn=true;
  	 		 				break;
  	 		 			case "yyyy.mm.dd":
	  	 		 		  if(elevalue.match(/^((((1[0-9]|[2-9]\d)\d{2})\.(0?[13578]|1[02])\.(0?[1-9]|[12]\d|3[01]))|(((1[0-9]|[2-9]\d)\d{2})\.(0?[13456789]|1[012])\.(0?[1-9]|[12]\d|30))|(((1[0-9]|[2-9]\d)\d{2})\.0?2\.(0?[1-9]|1\d|2[0-8]))|(((1[0-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))\.0?2\.29))$/)!=null)
  	 		 					checkreturn=true;
  	 		 				break;
  	 		 			case "*":
	  	 		 		  if((elevalue.match(/^((((1[0-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[0-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[0-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[0-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29))$/)!=null)||
  	 		 		     	(elevalue.match(/^((((1[0-9]|[2-9]\d)\d{2})\/(0?[13578]|1[02])\/(0?[1-9]|[12]\d|3[01]))|(((1[0-9]|[2-9]\d)\d{2})\/(0?[13456789]|1[012])\/(0?[1-9]|[12]\d|30))|(((1[0-9]|[2-9]\d)\d{2})\/0?2\/(0?[1-9]|1\d|2[0-8]))|(((1[0-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))\/0?2\/29))$/)!=null)||
  	 		 		     	(elevalue.match(/^((((1[0-9]|[2-9]\d)\d{2})(0?[13578]|1[02])(0?[1-9]|[12]\d|3[01]))|(((1[0-9]|[2-9]\d)\d{2})(0?[13456789]|1[012])(0?[1-9]|[12]\d|30))|(((1[0-9]|[2-9]\d)\d{2})0?2(0?[1-9]|1\d|2[0-8]))|(((1[0-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))0?229))$/)!=null)||
  	 		 			   	(elevalue.match(/^((((1[0-9]|[2-9]\d)\d{2})\.(0?[13578]|1[02])\.(0?[1-9]|[12]\d|3[01]))|(((1[0-9]|[2-9]\d)\d{2})\.(0?[13456789]|1[012])\.(0?[1-9]|[12]\d|30))|(((1[0-9]|[2-9]\d)\d{2})\.0?2\.(0?[1-9]|1\d|2[0-8]))|(((1[0-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))\.0?2\.29))$/)!=null))
              		checkreturn=true;
  	 		 				break;
  	 		 			default:
	  	 		 		  alert("unexpected error(0004)");
  	 		 		  	break;	
  	 		 		}
          	break;
          case "time": //时间格式,hh:mm:ss
						ErrStr="输入值不为日期格式";
	          if(elevalue.match(/^([0-1]\d|2[0-3]):[0-5]\d:[0-5]\d$/)!=null)
  	 		 			checkreturn=true;
  	 		 		break;
  	 		 	case "datetime": //日期时间格式,yyyy-mm-dd hh:mm:ss
						ErrStr="输入值不为日期时间格式";
						if(elevalue.match(/^((((1[0-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[0-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[0-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[0-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29))(\s)(([0-1]\d|2[0-3]):[0-5]\d:[0-5]\d)$/)!=null)
	  	 		 		checkreturn=true;
  	 		 		break;
        	case "email": //邮件格式 whitezdm@163.com  
	        	ErrStr="输入值不为邮件格式";
	          checkreturn=(elevalue.toString()==''||elevalue.match(/\w{1,}[@][\w\-]{1,}([.]([\w\-]{1,})){1,3}$/)!=null)?true:false;
  	 				break;
  	 			case "equaltext": //等于其它单元格的文本  
	        	ErrStr="输入值不为其它单元格相等";
	          if(elevalue.toString()=='')
						{
							checkreturn=true;
							break;
						}
						if(argarray.length<2) 
							break;
						if(elevalue.toString()==document.getElementById(argarray[1].toString()).value)
						  checkreturn=true;
						break;
					case "compare": //比较输入文本  
	        	ErrStr="输入值不符合要求";
	        	if(argarray.length==2)
	        	{
	        		if(elevalue.toString()==argarray[1].toString())
	        			checkreturn=true;
	        		break;
	        	}	
	        	if(argarray.length>2)
	        	{
	        		cmpValue=argarray[2].toString();
	        		switch (argarray[1].toString())
  	 		 			{
	  	 		 			case "=":
  	 		 					if(elevalue.toString()==cmpValue)
	  	 		 					checkreturn=true;
  	 		 					break;
  	 		 				case "!=":
	  	 		 				if(elevalue.toString()!=cmpValue)
  	 		 						checkreturn=true;
  	 		 					break;
  	 		 				case ">":
	  	 		 		  	if(elevalue.toString()>cmpValue)
  	 		 						checkreturn=true;
  	 		 					break;
  	 		 				case ">=":
	  	 		 		  	if(elevalue.toString()>=cmpValue)
  	 		 						checkreturn=true;
  	 		 					break;
  	 		 				case "<":
	  	 		 		  	if(elevalue.toString()<cmpValue)
  	 		 						checkreturn=true;
  	 		 					break;
  	 		 				case "<=":
	  	 		 		  	if(elevalue.toString()<=cmpValue)
  	 		 						checkreturn=true;
  	 		 					break;
  	 		 				default:
	  	 		 		  	alert("unexpected error(0008)");
  	 		 		  		break;	
  	 		 			}
  	 		 			break;    		
	        	}
					case "mobilenumber": //等于手机号  
	        	ErrStr="输入值不为手机号格式";
	          if(elevalue.match(/^(13|15)\d{9}$/)!=null)
  	 		 			checkreturn=true;
  	 		 		break;
  	 		 	case "phonenumber": //等于固定电话 010-1234567  
	        	ErrStr="输入值不为电话格式";
	          if(elevalue.match(/^\d+-\d+$/)!=null)
  	 		 			checkreturn=true;
  	 		 		break;
  	 		 	case "ascchar": //等于asc表内字符 
	        	ErrStr="输入值不为电话格式";
	          if(elevalue.match(/^[\x00-\xff]+$/)!=null)
  	 		 			checkreturn=true;
  	 		 		break;
  	 		 	case "ipaddress": //等于IP地址格式
	        	ErrStr="输入值不为IP地址格式";
	          if(elevalue.match(/^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$/)!=null)
  	 		 			checkreturn=true;
  	 		 		break;
  	 		 	case "selected": //是否选择select,值是多少
	        	ErrStr="没有选择列表";
	        	if(eleObj.selectedIndex<0)
	        		break;
	        	if(argarray.length==1)
	        	{
	        		checkreturn=true;
	        		break;
	        	}	
	        	ErrStr="没有选择指定的选项";
	        	if(argarray.length==2)
	        	{
	        		if(eleObj.options[eleObj.selectedIndex].value==argarray[1].toString())
	        			checkreturn=true;
	        		break;
	        	}
	        	if(argarray.length>2)
	        	{
	        		selectedValue=eleObj.options[eleObj.selectedIndex].value;
	        		cmpValue=argarray[2].toString();
	        		switch (argarray[1].toString())
  	 		 			{
	  	 		 			case "=":
  	 		 					if(selectedValue==cmpValue)
	  	 		 					checkreturn=true;
  	 		 					break;
  	 		 				case "!=":
	  	 		 				if(selectedValue!=cmpValue)
  	 		 						checkreturn=true;
  	 		 					break;
  	 		 				case ">":
	  	 		 		  	if(selectedValue>cmpValue)
  	 		 						checkreturn=true;
  	 		 					break;
  	 		 				case ">=":
	  	 		 		  	if(selectedValue>=cmpValue)
  	 		 						checkreturn=true;
  	 		 					break;
  	 		 				case "<":
	  	 		 		  	if(selectedValue<cmpValue)
  	 		 						checkreturn=true;
  	 		 					break;
  	 		 				case "<=":
	  	 		 		  	if(elevalue.length<=cmpValue)
  	 		 						checkreturn=true;
  	 		 					break;
  	 		 				default:
	  	 		 		  	alert("unexpected error(0007)");
  	 		 		  		break;	
  	 		 			}
  	 		 			break;    		
	        	}
					default:
						var args=new function(){
							this.element=document.getElementById(eleName);
							this.list=new Array();
							this.listcount=0;
							this.errormsg="";
							for(var k=1;k<argarray.length;k++)
							{
							 	this.list[this.list.length]=argarray[k];
								this.listcount=this.list.length;
							}	
						};
						try
						{
							funobj=eval(argarray[0].toString());
						}
						catch(e)
    				{
	    				checkreturn=false;
    					alert("tag function error!");
    					break;
    				}
				  	checkreturn=funobj(args)?true:false;
          	ErrStr=args.errormsg;
	          break;
		  	}
		  	//if((checkreturn==false)&&(ErrStr!=""))
		  		//ErrorString+=ErrStr+"<br/>";
    		midStr=(checkreturn==true)?"true":"false";
    		preStr=aftStr="";
    		if(i>0)
    	   	preStr=checkstr.slice(0,i);
    		if(j<checkstr.length-1)
    	   	aftStr=checkstr.slice(j+1);
    		checkstr=preStr+midStr+aftStr;   
    	}
    	try {
	    	evalvalue=eval(checkstr);
    	}
    	catch(e)
    	{
	    	evalvalue=false;
    	}
    	checkstr="";
    	switch(msgtype){
    		case 1:
    			if(document.getElementById(eleName+"_msg_tmp_"))
	      		if(window.ActiveXObject)
  	    			document.getElementById(eleName+"_msg_tmp_").removeNode(true);
  	  			else
	  	    		document.getElementById(eleName+"_msg_tmp_").parentNode.removeChild(document.getElementById(eleName+"_msg_tmp_")); 
    			if(evalvalue==false)
  				{ 
	  				var oNewNode=document.createElement("div");
  					oNewNode.id=eleName+"_msg_tmp_";
  					oNewNode.className="msgerror";
  					if(document.getElementById(eleName).parentNode.lastChild == document.getElementById(eleName)) 
       				document.getElementById(eleName).parentNode.appendChild(oNewNode);
     				else 
       				document.getElementById(eleName).parentNode.insertBefore(oNewNode, document.getElementById(eleName).nextSibling);
  					oNewNode.innerHTML=errorstr+ErrorString;
  					document.getElementById(eleName).className="fail";
  				}
  				else
						document.getElementById(eleName).className="passed";
					break;
    		case 2:
    			if(evalvalue==false)
    			{
    		  	document.getElementById(eleName).className="fail";
    		  	alert(errorstr.replace(/\<br\/\>/g,"\n")+ErrorString.replace(/\<br\/\>/g,"\n"));
    		  }
  				else
						document.getElementById(eleName).className="passed";
    		  break;
    	}
    	if(typeof(aftfun)=="function")
  		{
  			try
				{
					aftfunobj=eval(aftfun);
				}
				catch(e)
    		{
	    		alert("Aftfunction error!");
    			return false;
    		}
				aftfunobj(eleObj);
  		}
    	return evalvalue;
  	}  
  	this.chkelement=checkelement; 
  	msgtype=this.msgtype; 
  	if(this.paramList.length==0)
  	  this.paramList.push([eleName,errorstr,chrarray,profun,aftfun,function(){checkelement(eleName,errorstr,chrarray,profun,aftfun)}]);
  	else
  		for(var i=0;i<this.paramList.length;i++)
  		{
  			if(this.paramList[i][0].toString().toLowerCase()==eleName.toLowerCase())
  			{
  				alert("error 0005");
  				return;
  			}
  			if(i==this.paramList.length-1)
  			{
  			  this.paramList.push([eleName,errorstr,chrarray,profun,aftfun,function(){checkelement(eleName,errorstr,chrarray,profun,aftfun)}]);
  			  break;
  			}
  		}
  	if(this._BindToEle==true)
  		this.bindelement(this.paramList.length-1);
  }
  
  webx_ui_chkform.prototype.bindelement=function(Listindex){
  	var eleName=this.paramList[Listindex][0];
  	switch (document.getElementById(eleName).tagName.toLowerCase())
  	{
  		case "input":
				switch (document.getElementById(eleName).type.toLowerCase())
  		 		{
  		 			case "text":
  		 			  if(window.ActiveXObject)
  		 			  	document.getElementById(eleName).attachEvent("onblur",this.paramList[Listindex][5]);
  		 				else
  		 					document.getElementById(eleName).addEventListener("blur",this.paramList[Listindex][5],false);
  		 				break;
  		 			case "password":
  		 				if(window.ActiveXObject)
  		 			  	document.getElementById(eleName).attachEvent("onblur",this.paramList[Listindex][5]);
  		 				else
  		 					document.getElementById(eleName).addEventListener("blur",this.paramList[Listindex][5],false);
  		 				break;
  		 		}
  		 		break;
  		case "select":
  		 	break;
  	}
  }
  
  webx_ui_chkform.prototype.unbindelement=function(Listindex){
  	var eleName=this.paramList[Listindex][0];
  	switch (document.getElementById(eleName).tagName.toLowerCase())
  	{
  		case "input":
				switch (document.getElementById(eleName).type.toLowerCase())
  		 		{
  		 			case "text":
  		 			  if(window.ActiveXObject)
  		 			  	document.getElementById(eleName).detachEvent("onblur",this.paramList[Listindex][5]);
  		 				else
  		 					document.getElementById(eleName).removeEventListener("blur",this.paramList[Listindex][5],false);
  		 				break;
  		 			case "password":
  		 				if(window.ActiveXObject)
  		 			  	document.getElementById(eleName).detachEvent("onblur",this.paramList[Listindex][5]);
  		 				else
  		 					document.getElementById(eleName).removeEventListener("blur",this.paramList[Listindex][5],false);
  		 				break;
  		 		}
  		 		break;
  		case "select":
  		 	break;
  	}  	
  }
  
  webx_ui_chkform.prototype.del=function(eleName){
  	var j=-1;
  	if(this.paramList.length==0)
  	  alert("error 0006");
  	else
  		for(var i=0;i<this.paramList.length;i++)
  		{
  			if(this.paramList[i][0].toString().toLowerCase()==eleName.toLowerCase())
  			{
  				j=i;
  			  break;
  			}
  			if(i==this.paramList.length-1)
  			{
  			  alert("error 0007");
  				return;
  			}
  		}
  	this.unbindelement(j);
  	this.paramList.splice(j,1);
  }
  
  webx_ui_chkform.prototype.delall=function(){
  	for(var i=0;i<this.paramList.length;i++)
			this.unbindelement(i); 	
  	this.paramList.splice(0,this.paramList.length);
  }
   
	webx_ui_chkform.prototype.addsubmit = function(){ 
  	var pList=this.paramList;
  	var checkelement=this.chkelement;
  	var getEvent=function(){     
			if(document.all)    
		  	return window.event;
			func=getEvent.caller;            
			while(func!=null){    
				var arg0=func.arguments[0];
					if(arg0){
						if((arg0.constructor==Event || arg0.constructor ==MouseEvent)
            	|| (typeof(arg0)=="object" && arg0.preventDefault && arg0.stopPropagation))   
							return arg0;
					}
      	func=func.caller;
			}
			return null;
		}
  	var checksubmit=function(paramList,msgtype) {
  		var returnValue=true;
  		for(var i=0;i<paramList.length;i++)
  		{
  			var eleName=paramList[i][0].toString();
  			var errorstr=paramList[i][1].toString();
  			var chrarray=paramList[i][2];
  			if(checkelement(eleName,errorstr,chrarray)==false)
  		  	returnValue=false;
  		  if((msgtype==2)&&(returnValue==false))
  		  	break;
  		}
  		if(returnValue==false)
  		{
  			var e=getEvent();
  	  	if(e && e.preventDefault) 
  	  		e.preventDefault();
  		}
  		return returnValue;
		}
		this._SubmitFun=function(){return checksubmit(pList,this.msgtype);};
  	if(window.ActiveXObject)
			document.getElementById(this.frmName).attachEvent("onsubmit",this._SubmitFun);
  	else
  		document.forms[this.frmName].addEventListener("submit",this._SubmitFun,false);
  	this._Submit=true;
  } 
  
  webx_ui_chkform.prototype.delsubmit = function(){ 
  	if(this._Submit==false)
  		return;
  	if(window.ActiveXObject)
			document.getElementById(this.frmName).detachEvent("onsubmit",this._SubmitFun);
  	else
  		document.forms[this.frmName].removeEventListener("submit",this._SubmitFun,false);
  	this._Submit=false;
  }
  
	webx_ui_chkform.prototype.addreset = function(){ 
  	var pList=this.paramList;
  	var checkelement=this.chkelement;
  	var getEvent=function(){     
			if(document.all)    
		  	return window.event;
			func=getEvent.caller;            
			while(func!=null){    
				var arg0=func.arguments[0];
					if(arg0){
						if((arg0.constructor==Event || arg0.constructor ==MouseEvent)
            	|| (typeof(arg0)=="object" && arg0.preventDefault && arg0.stopPropagation))   
							return arg0;
					}
      	func=func.caller;
			}
			return null;
		}
  	var checkreset=function(paramList) {
  		for(var i=0;i<paramList.length;i++)
  		{
  			eleName=paramList[i][0].toString();
  			if(document.getElementById(eleName+"_msg_tmp_"))
        	if(window.ActiveXObject)
  	       	document.getElementById(eleName+"_msg_tmp_").removeNode(true);
  	    	else
  	       document.getElementById(eleName+"_msg_tmp_").parentNode.removeChild(document.getElementById(eleName+"_msg_tmp_")); 
  			document.getElementById(eleName).className="checkcss1";
  		}
  		var e=getEvent();
  		if(e && e.preventDefault) 
				e.preventDefault();
  		return false;
  	} 
		this._ResetFun=function(){return checkreset(pList);};
  	if(window.ActiveXObject)
  		document.getElementById(this.frmName).attachEvent("onreset",this._ResetFun);
  	else
  		document.forms[this.frmName].addEventListener("reset",this._ResetFun,false);
  	this._Reset=true;
  } 
  
  webx_ui_chkform.prototype.delreset = function(){ 
  	if(this._Reset==false)
  		return;
  	if(window.ActiveXObject)
			document.getElementById(this.frmName).detachEvent("onreset",this._ResetFun);
  	else
  		document.forms[this.frmName].removeEventListener("reset",this._ResetFun,false);
  	this._Submit=false;
  }
  
  webx_ui_chkform.prototype.groupcheck=function(){
  	var ListArray=[];
  	for(i=0;i<arguments.length;i++)
  	{
  		for(j=0;j<this.paramList.length;j++)
  		{
  			if(arguments[i]==this.paramList[j][0])
  			{
  				if(ListArray.length==0)
  				  ListArray.push([arguments[i],j]);
  				else
  					for(k=0;k<ListArray.length;k++)
  					{
  						if(arguments[i]==ListArray[k][0])
  							break;
  						if(k==ListArray.length-1)
  						{
  							ListArray.push([arguments[i],j]);
  							break;
  						}
  					}
  				break;
  			}
  		}
  	}
  	var returnValue=true;
  	var checkelement=this.chkelement;
  	for(var i=0;i<ListArray.length;i++)
  	{
  		eleName=this.paramList[ListArray[i][1]][0].toString();
  		errorstr=this.paramList[ListArray[i][1]][1].toString();
  		chrarray=this.paramList[ListArray[i][1]][2];
  		if(checkelement(eleName,errorstr,chrarray)==false)
  		  returnValue=false;
  		if((msgtype==2)&&(returnValue==false))
  		  break;
  	}
  	return returnValue;	
  }  
  
  webx_ui_chkform.prototype.groupclear=function(){
  	var ListArray=[];
  	for(i=0;i<arguments.length;i++)
  	{
  		for(j=0;j<this.paramList.length;j++)
  		{
  			if(arguments[i]==this.paramList[j][0])
  			{
  				if(ListArray.length==0)
  				  ListArray.push([arguments[i],j]);
  				else
  					for(k=0;k<ListArray.length;k++)
  					{
  						if(arguments[i]==ListArray[k][0])
  							break;
  						if(k==ListArray.length-1)
  						{
  							ListArray.push([arguments[i],j]);
  							break;
  						}
  					}
  				break;
  			}
  		}
  	}
  	var returnValue=true;
  	var checkelement=this.chkelement;
  	for(var i=0;i<ListArray.length;i++)
  	{
  		eleName=this.paramList[ListArray[i][1]][0].toString();
  		if(document.getElementById(eleName+"_msg_tmp_"))
        if(window.ActiveXObject)
  	      document.getElementById(eleName+"_msg_tmp_").removeNode(true);
  	    else
  	      document.getElementById(eleName+"_msg_tmp_").parentNode.removeChild(document.getElementById(eleName+"_msg_tmp_")); 
  		document.getElementById(eleName).className="checkcss1";
  	}
  }
  
  webx_ui_chkform.prototype.groupcheckall=function(){
  	var returnValue=true;
  	var checkelement=this.chkelement;
  	for(var i=0;i<this.paramList.length;i++)
  	{
  		eleName=this.paramList[i][0].toString();
  		errorstr=this.paramList[i][1].toString();
  		chrarray=this.paramList[i][2];
  		if(checkelement(eleName,errorstr,chrarray)==false)
  		  returnValue=false;
  		if((msgtype==2)&&(returnValue==false))
  		  break;
  	}
  	return returnValue;	
  }
  
  webx_ui_chkform.prototype.groupclearall=function(){
  	var checkelement=this.chkelement;
  	for(var i=0;i<this.paramList.length;i++)
  	{
  		eleName=this.paramList[i][0].toString();
  		if(document.getElementById(eleName+"_msg_tmp_"))
        if(window.ActiveXObject)
  	      document.getElementById(eleName+"_msg_tmp_").removeNode(true);
  	    else
  	      document.getElementById(eleName+"_msg_tmp_").parentNode.removeChild(document.getElementById(eleName+"_msg_tmp_")); 
  		document.getElementById(eleName).className="checkcss1";
  	}
  }
  
  webx_ui_chkform.prototype.bindtoelement=function(tfvalue){
  	if((this._BindToEle==false)&&(tfvalue==true))
  		for(var i=0;i<this.paramList.length;i++)
				this.bindelement(i);
  	this._BindToEle=tfvalue;
  }
  
  webx_ui_chkform.prototype.seterror=function(eleName,errorstr){
  	var checkelement=this.chkelement;
		for(var i=0;i<this.paramList.length;i++)
  	{
  		if(this.paramList[i][0]==eleName)
  		{
  			chrarray=this.paramList[i][2].toString();
  			this.unbindelement(i);
  			this.paramList[i][1]=errorstr;
  			this.paramList[i][5]=function(){checkelement(eleName,errorstr,chrarray)};
  			pList=this.paramList;
  			if(this._BindToEle==true)
  				this.bindelement(i);
  			break;
  		}
  	}
  }
  
  webx_ui_chkform.prototype.setparam=function(eleName,chrarray){
  	var checkelement=this.chkelement;
		for(var i=0;i<this.paramList.length;i++)
  	{
  		if(this.paramList[i][0]==eleName)
  		{
  			errorstr=this.paramList[i][1].toString();
  			this.unbindelement(i);
  			this.paramList[i][2]=chrarray;
  			this.paramList[i][5]=function(){checkelement(eleName,errorstr,chrarray)};
  			if(this._BindToEle==true)
  				this.bindelement(i);
  			if(this._Reset==true)
  			{
  				this.delreset();
  				this.addreset();
  			}
  			break;
  		}
  	}
  }
  
  