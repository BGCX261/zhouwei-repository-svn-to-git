 <%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		 
		 
	</head>
	<body onload="init()">
		
		
		<script language='javascript'> 
		 
		function init(){ //页面初始化
		   var paraM = window.dialogArguments;  //提取传递的参数
		   var aCity =  paraM.startArray;
		   var bCity=   paraM.endArray; 
		   startSelect=document.getElementById('start');
			for(var i=0; i<aCity.length; i++){
		    	var oOption = document.createElement("OPTION");
				oOption.text=aCity[i][0];
				oOption.value=aCity[i][1];
				startSelect.add(oOption);
			}
			 
			
			endSelect=document.getElementById('end');
			for(var i=0; i<bCity.length; i++){
		    	var oOption = document.createElement("OPTION");
				oOption.text=bCity[i][0];
				oOption.value=bCity[i][1];
				endSelect.add(oOption);
			}
		}
		/** 
		*获得传回的参数
		*/
		function getData(){
		   var rarray=new Array();
		   endSelect=document.getElementById('end');
		   if (endSelect.length>0) {
		      for (i=0; i< endSelect.length; i++){
				  rarray[i]=new Array();
				 // alert(endSelect.options[i].value);
				  rarray[i][0]=endSelect.options[i].text;
				  rarray[i][1]=endSelect.options[i].value;
				}  
		   }
		   window.returnValue=rarray;   //传回数组返回值
		   window.close();
		}
		function openOptionTransfer(objectId)	
		{														                                 		
			var elem = document.getElementById(objectId);
			var top  = elem.offsetTop+elem.offsetHeight;
		    var left = elem.offsetLeft;
		    var o    = objectId+'div';
		    var oElem    = document.getElementById(o);  
		    oElem.style.top   = top;
		    oElem.style.left  = left;
		    oElem.style.display ='block';
		                                                       
		 }
		/**
		*  两个列表框元素互相移动
		* @param titleDiv 层元素的id
		**/
 		function moveOption(titleDiv)
       {
            var elem = event.srcElement;	//获得触发事件的对象
			var startDiv  = titleDiv+'start';									                  	
	        var endDiv    = titleDiv+'end';	
	         							                 
	        var startElem = document.getElementById(startDiv);			
		    var endElem =   document.getElementById(endDiv);	
			if(elem.id=='mLeft')   //根据id判断用户单击的是那个按钮. 向左全部移动
			{						                                                           
				var length = endElem.length;                
			    for(var x=0;x<length;x++)                                                        		    
			    {                                                                                 				
			    	var optionText = endElem.options[x].text;                                    		    	
			    	var optionValue= endElem.options[x].value;                                   		   		
			    	startElem.options[startElem.length] = new Option(optionText,optionValue);    		  
			    }                                                                                		    
			    endElem.length = 0;        
			 }else if(elem.id=='oLeft'){ 
			    for(var x=0;x<endElem.length;x++){	
				    if(endElem.options[x].selected == true)						                 				
				    {	
				    	var optionText  = endElem.options[x].text;       
				    	var optionValue = endElem.options[x].value;
				    	startElem.options[startElem.length] = new Option(optionText,optionValue);
				    	endElem.options[x] = null;
				    	x--;                                                                      				
				    }			                                                                  			
			 	}			                                                                      		
			}else if(elem.id=='mRight'){
				var length = startElem.length;
				for(var x=0;x<length;x++){
					var optionText = startElem.options[x].text;
					var optionValue= startElem.options[x].value;
					endElem.options[endElem.length] = new Option(optionText,optionValue); 
			    }                                                                                		    	
			    startElem.length = 0;        
			}else if(elem.id=='oRight'){			                                                                         			
			    for(var x=0;x<startElem.length;x++){																	             				
			        if(startElem.options[x].selected == true){
			        	var optionText  = startElem.options[x].text;
			        	var optionValue = startElem.options[x].value;
			        	endElem.options[endElem.length] = new Option(optionText,optionValue);
			        	startElem.options[x] = null; ;
			        	x--;                                                                      				
			        }			                                                                  			
			     }			                                                                      					                                                                          		
			 }			                                                                         	
		}
		
		 
 	
    </script>

		<style>  
			body{	
				SCROLLBAR-FACE-COLOR: #dfdfdf;
				SCROLLBAR-HIGHLIGHT-COLOR: #f4f4f4;
			    SCROLLBAR-SHADOW-COLOR: #ffffff;
			    SCROLLBAR-ARROW-COLOR: #5b5b5b;
			    scrollbar-dark-shadow-color: #ffffff;
			    scrollbar-3d-light-color: #ffffff;
			    margin-left: 0px;
			    margin-top: 0px;
			    margin-right: 0px;
			    margin-bottom: 0px;
			    text-align:center;
		    }
		    table{
		    	WORD-BREAK:break-all;
		    	font-size: 12px;
		        font-family:Arial, Helvetica, sans-serif,宋体;
		    }
		    a:link{	
		        font-family:Arial, Helvetica, sans-serif;
		        color:#000000;
		        text-decoration:none;
		    }
		    a:visited{	
		        font-family:Arial, Helvetica, sans-serif;	
		        color:#000000;
		        text-decoration:none;
		    }
		    .pt{	
		        padding-top:1px;}
		    .hand{	cursor:hand;}
		    .label_top{	width:100%;}
		    .ooib{	
		    	width:960px;
		    	height:300px;
		    	border-width: 1px;
		    	border-style: none solid solid;
		    	border-color: #dadada;
		    }
		    .hr{	
		    	color:#ffffff;
		    }
		    .ooih td{
		    	border-width: 1px;	
		    	padding:10px 5px 3px 5px;
		    }
		    .ooihj{
		    	color: #000000;
		    	background-color: #ffffff;
		    	border-style: solid solid none;
		        border-color: #dadada;
		        text-decoration:none;
		        font-weight:bolder;
		        padding-left:10px;
		    }.ooihs{
		    	color: #006f6a;
		    	background-color: #f9ffff;
		    	border-style: solid;
		    	border-color: #dadada #dadada #dadada;
		    	cursor: hand;
		    	text-decoration:underline;
		    }																	 
		    .ooihx		
		    {  
		        border-style: none none solid;	
		        border-color: #dadada;											 
		    }																	 
		    #lable2															 
		    {																	 	
		    	width:100%;														 	h
		    	eight:30px;
		    	border-style:none;												 
		    }
	    </style>
	   
		<div id='optiondiv' class='showdiv'
			style='position:absolute; top:0px; left:0px; width:97px; height:100px; z-index:8888; background-color:#ffffff; display:block;'
			onMouseOut=''>
			<table border='1' align='center' cellpadding='0' cellspacing='0'
				bordercolor='#dadada' bgcolor='#FFFFFF' class='tableborder'>
				<tr align='center'>
					<td align='center'>
						<table width='100%' border='0' cellspacing='0' cellpadding='0'>
							<tr>
								<td width='20' bgcolor='#f3f3f3'>
									&nbsp;
								</td>
								<td height='30' bgcolor='#f3f3f3'>
									<b>请选择欲统计字段：</b>
								</td>
								<td width='30' bgcolor='#f3f3f3'></td>
							</tr>
						</table>
						<table width='100%' border='0' cellspacing='10' cellpadding='0'>
							<tr>
								<td>
									<table width='100%' border='1' align='center' cellpadding='0'
										cellspacing='0' bordercolor='#dadada' bgcolor='#FFFFFF'
										class='tableborder'>
										<tr>
											<td height='18' id='table3'>
												<table width='100%' border='0' cellpadding='0'
													cellspacing='3'>
													<tr>
														<td>
															<table width='100%' border='1' cellpadding='2'
																cellspacing='0' bordercolor='#dadada'
																class='tableborder'>
																<tr>
																	<td align='center'>
																		<table width='97%' border='0' align='center'
																			cellpadding='3' cellspacing='0'>
																			<tr>
																				<td bgcolor='#f7f7f7'>
																					<div align='center'>
																						待选字段
																					</div>
																				</td>
																				<td bgcolor='#f7f7f7'>
																					&nbsp;
																				</td>
																				<td bgcolor='#f7f7f7'>
																					<div align='center'>
																						已选字段
																					</div>
																				</td>
																			</tr>
																			<tr>
																			</tr>
																			<tr>
																				<td width='158'>
																					<select name='optionstart' id='start' size='16'
																						multiple
																						style='width:150; border:none; outline:none;'>
																						
																					</select>
																				</td>
																				<td width='18' align='center' bgcolor='#f7f7f7'>
																					<img class='hand' id='mLeft'
																						src='<%=request.getContextPath() %>/themes/themes1/images/main/select_left.gif'
																						onClick=moveOption('option');>
																					<br>
																					<img class='hand' id='oLeft'
																						src='<%=request.getContextPath() %>/themes/themes1/images/main/select2_left.gif'
																						onClick=moveOption('option');>
																					<br>
																					<img class='hand' id='oRight'
																						src='<%=request.getContextPath() %>/themes/themes1/images/main/select2_right.gif'
																						onClick=moveOption('option');>
																					<br>
																					<img class='hand' id='mRight'
																						src='<%=request.getContextPath() %>/themes/themes1/images/main/select_right.gif'
																						onClick=moveOption('option');>
																				</td>
																				<td width='159'>
																					<select name='optionend' id='end' size='16'
																						multiple style='width:150;'>
																					</select>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
									<table width='100%' cellpadding='0'>
										<tr>
											<td>
												&nbsp;
											</td>
										</tr>
										<tr>
											<td align='right'>
												<span style='text-align:right' class='hand'>
													<img class='hand' onClick='getData();' src='<%=request.getContextPath() %>/themes/themes1/images/main/ok.gif'>
												</span>&nbsp;
												<img class='hand' onClick='window.close()' src='<%=request.getContextPath() %>/themes/themes1/images/main/reset.gif'>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											</td>
										</tr>
									</table>
								<td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		
		 
       
       


	</body>
</html>
 