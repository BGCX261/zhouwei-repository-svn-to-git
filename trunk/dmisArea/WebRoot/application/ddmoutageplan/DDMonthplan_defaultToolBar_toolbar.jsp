<%@ page contentType="text/html; charset=utf-8" language="java"%>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/prototype.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/application/ddmoutageplan/DDMonthplan.js"> </script>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/public.js"></script>



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

	function newPlanFromNot(itemId,itemValue){
        //从未完成计划生成新计划

        var num=Math.random();
		var url="/ddMoutageplan.do?method=showModalDialog&key=newPlanFromNot&num="+num;
		
		var QQ = new Object();
		
		var vReturnValue=showModalDialogYY(url,600,600,QQ,"",1);

		if(vReturnValue){
		  var pars        = "fmonthplanno="+vReturnValue;
          var url="<%=request.getContextPath()%>/ddMoutageplan.do?method=newPlanFromNot";
		  var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: showResponse});
		     function showResponse(originalRequest){
		                dealAlertMessage(originalRequest.responseText);
	                    //alert(originalRequest.responseText);
						var td1    = parent.downFrame.document.all.ID1;
						selectTab(td1, '', 'true','false');
						parent.downFrame.iframe1.createGrid('','0','','','','','','');
	         }
        }
	}

    function deleteData(temId,itemValue){
    
        var gridId 		= parent.downFrame.iframe1.mygrid;
		var rows 		= gridId.getSelectedRows();
		if(!rows){
		    dealAlertMessage("请选择需要删除的月计划");
		    //alert("请选择需要删除的月计划");
		    return false;
		}
		var primaryId = "";
		var version   = ""; 
		var fexcutestatus    = "";
		if(rows != null && rows != "undefined" && rows != ""){
			for (row = 0;row<rows.length;row++){ 
				//获取指定行的主键列的列值


				var colValue = gridId.getValByRC(rows[row],'fmonthplanno');
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
				var statusVersion = gridId.getValByRC(rows[row],'fexcutestatus');
				if(statusVersion!="草稿"){
				  dealAlertMessage("您选择的第"+(rows[row])+"条月计划不是草稿状态,请检查!!!");
                  //alert("您选择的第"+(rows[row])+"条月计划不是草稿状态,请检查!!!");
                  return;
                }
				if (statusVersion == "" || statusVersion == null) { continue;}
				if (fexcutestatus == ""){ 
					fexcutestatus = statusVersion;
				} else {
					fexcutestatus += '^'+statusVersion;
				}
			}
		}
		if (primaryId == ""){  
		    dealAlertMessage("没有找到主键值!");	      
			//alert("没有找到主键值!"); 	      
			return false; 	   
		} 
		if (version == ""){  
		    dealAlertMessage("没有找到版本值!");	      
			//alert("没有找到版本值!"); 	      
			return false; 	   
		} 
		//alert("#######:"+primaryId+":#######:"+version+":#######:"+fexcutestatus);
		var sign = confirm(" 您确认将删除选中数据?");
		if(sign){
			var statusArra = fexcutestatus.split("^");
			for(var i=0; i<statusArra.length; i++){
				if(statusArra[i] != "草稿"){
				    dealAlertMessage("只有状态为草稿的可以删除!!!");
					//alert("只有状态为草稿的可以删除!!!");
					return false;
				}
			}
			if(version != null && version != "" && primaryId != null && primaryId != ""){
				var pars        = "fmonthplanno="+primaryId;
					pars	   += "&version="+version;
				var url="<%=request.getContextPath()%>/ddMoutageplan.do?method=delete";
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
	
	function eomUpdataState(temId,itemValue){//填写未完成原因

	
	    var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
	    if(!rows){
	        dealAlertMessage("请选择需要填写未完成原因的月计划");
		    //alert("请选择需要填写未完成原因的月计划");
		    return false;
		}
	    if(rows.length>1){
	       dealAlertMessage("您仅且只能选择一条月计划!!!");
	       //alert("您仅且只能选择一条月计划!!!");
		   return false;    
	    }
		var primaryStr = parent.downFrame.iframe1.mygrid.getSelectedRowsData(3);
		var primaryId   = "";
		var fexcutestatus		= "";
		if(primaryStr.indexOf("@@@") != -1){
			var dataArra 	= primaryStr.split("@@@");
			for(var x=0; x<dataArra.length; x++){
				if(dataArra[x].indexOf("^") != -1){
					var name = dataArra[x].split("^")[0];
					var value = dataArra[x].split("^")[1];
					if(name == "fmonthplanno"){
						primaryId = value;
					}
					if(name == "fexcutestatus"){
						fexcutestatus = value;
					}
				}
			}
		}
		if(fexcutestatus == "已批准"||fexcutestatus == "未完成"){
		
		  var url="/application/systemdic/showsystemdic.jsp?typeId=60";
	      var QQ = new Object();
		  var  vReturnValue=showModalDialogYY(url,600,600,QQ,"取消原因",1);
		  if(vReturnValue){
		  
          //只填写原因 不包含原因id的方式

		  //var url="<%=request.getContextPath()%>/application/ddmoutageplan/eomUpdataState.jsp";
		  //var vReturnValue=showModalDialogYY(url,600,200,"","填写未完成原因",1);
          //var para ="fmonthplanno="+primaryId+"&funfinishreason="+vReturnValue;
          
          
          var  reason= vReturnValue.split("\^")[0];
		  var  rcode = vReturnValue.split("\^")[1];
          var para ="fmonthplanno="+primaryId+"&reason="+reason+"&rcode="+rcode;
		  var url="<%=request.getContextPath()%>/ddMoutageplan.do?method=eomUpdataState";
		  var sign = confirm(" 您确认添加未完成原因? ");
		  if(sign){
		      var myAjax = new Ajax.Request(url,{method: 'post', parameters: para,  onComplete: showResponse});
		      function showResponse(originalRequest){
	                   dealAlertMessage(originalRequest.responseText);
	                   var td1    = parent.downFrame.document.all.ID1;
	                   selectTab(td1, '', 'true','false');
                       parent.downFrame.iframe1.createGrid('','0','','','','','','');
	          }       
	      }
	     }    
	    }else{
	          dealAlertMessage("只有状态为已批准或者未完成的才可以填写未完成原因!!!");
	          //alert("只有状态为已批准或者未完成的才可以填写未完成原因!!!");
	    }
	}

    function pigeonhole(temId,itemValue){//归档
		/***************

          判断是否为可以归档



		*/
		
		var gridId 		= parent.downFrame.iframe1.mygrid;
		var rows 		= gridId.getSelectedRows();
		if(!rows){
		    dealAlertMessage("请选择需要归档的月计划");
		    //alert("请选择需要归档的月计划");
		    return false;
		}
		var primaryId = "";
		var version   = ""; 
		var fexcutestatus    = "";
		if(rows != null && rows != "undefined" && rows != ""){
			for (row = 0;row<rows.length;row++){ 
				//获取指定行的主键列的列值


				var colValue = gridId.getValByRC(rows[row],'fmonthplanno');
				if (colValue == "" || colValue == null) { continue;}
				if (primaryId == ""){ 
					primaryId = colValue;
				} else {
					primaryId += '^'+colValue;
				}

				var statusVersion = gridId.getValByRC(rows[row],'fexcutestatus');
				if(statusVersion!="已执行"){
                  dealAlertMessage("您选择的第"+(rows[row])+"条月计划不是已执行状态,请检查!!!");
                  //alert("您选择的第"+(rows[row])+"条月计划不是已执行状态,请检查!!!");
                  return;
                }
                if (statusVersion == "" || statusVersion == null) { continue;}
				if (fexcutestatus == ""){ 
					fexcutestatus = statusVersion;
				} else {
					fexcutestatus += '^'+statusVersion;
				}
			}
		}
		if (primaryId == ""){  	      
			dealAlertMessage("没有找到主键值!");
			//alert("没有找到主键值!"); 	      
			return false; 	   
		} 
		//alert("#######:"+primaryId+":#######:"+version+":#######:"+fexcutestatus);
		var sign = confirm(" 您确认将归档选中数据?");
		if(sign){
			var statusArra = fexcutestatus.split("^");
			for(var i=0; i<statusArra.length; i++){
				if(statusArra[i] != "已执行"){
					dealAlertMessage("只有状态为已执行的才可以归档!!!");
					//alert("只有状态为已执行的才可以归档!!!");
					return false;
				}
			}
			if(primaryId != null && primaryId != ""){
				var pars        = "fmonthplanno="+primaryId;
				var url="<%=request.getContextPath()%>/ddMoutageplan.do?method=pigeonhole";
				var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
				function callBackGrid(originalRequest){
					if(originalRequest){
						dealAlertMessage(originalRequest.responseText);
						//alert(originalRequest.responseText);
						var td1    = parent.downFrame.document.all.ID1;
						selectTab(td1, '', 'true','false');
						parent.downFrame.iframe1.createGrid('','0','','','','','','');
					}
				}
			}
		}	
	}

    function uniteByObject(temId,itemValue){//根据目标合并
    
    
      var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
      if(!rows){
		    dealAlertMessage("请选择需要合并的月计划");
		    //alert("请选择需要合并的月计划");
		    return false;
	  }
      if(rows.length<2){
	       dealAlertMessage("您只选择了一条月计划 注意:合并至少须要选择2条月计划");
	       //alert("您只选择了一条月计划 注意:合并至少须要选择2条月计划");
		   return false;    
	  }
      var colName="";
      var Merge="";
      for (var row = 0;row<rows.length;row++){
         colName = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fexcutestatus');
         Merge=parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'ismerge');
         if(Merge=="Y"){
                 dealAlertMessage("您选择的第"+(rows[row])+"条月计划是已合并记录,请检查!!!");
                 //alert("您选择的第"+(rows[row])+"条月计划是已合并记录,请检查!!!");
                 return;
         }
         if(colName=="审核中");
         else{
               dealAlertMessage("您选择的第"+(rows[row])+"条月计划不在审核状态中,请检查!!!");
               //alert("您选择的第"+(rows[row])+"条月计划不在审核状态中,请检查!!!");
               return;
          }
      }
      
        var  datas = parent.downFrame.iframe1.mygrid.getSelectedRowsData(1);
        var data =  datas.split("###");
        var ids  = "";
        for(var j=0;j<data.length;j++){
          ids = ids+(data[j].split("\^"))[1]+"\^";
        }
        //
        var num=Math.random();
        var url="/ddMoutageplan.do?method=unite&unite_key="+ids+"&num="+num;
        
        var QQ = new Object();
        
		var vReturnValue=showModalDialogYY(url,600,600,QQ,"计划合并",1);

		if(vReturnValue){
		  //alert("yes :"+vReturnValue);
		  var para ="para="+vReturnValue;
          var url="<%=request.getContextPath()%>/ddMoutageplan.do?method=doUniteByObject";
		  var myAjax = new Ajax.Request(url,{method: 'post', parameters: para,  onComplete: showResponse});
		     function showResponse(originalRequest){
		        dealAlertMessage(originalRequest.responseText);
	            //alert(originalRequest.responseText);
                var td1    = parent.downFrame.document.all.ID1;
				selectTab(td1, '', 'true','false');
				parent.downFrame.iframe1.createGrid('','0','','','','','','');
	         }
        }else{
          //alert("error");
        }
	}
	
	
	
    function uniteByContent(temId,itemValue){//根据内容合并
    
      var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
      if(!rows){
		    dealAlertMessage("请选择需要合并的月计划");
		    //alert("请选择需要合并的月计划");
		    return false;
	  }
      if(rows.length<2){
	       dealAlertMessage("您只选择了一条月计划 注意:合并至少须要选择2条月计划");
	       //alert("您只选择了一条月计划 注意:合并至少须要选择2条月计划");
		   return false;    
	  }
      var colName="";
      var Merge="";
      var count=0;//已合并的个数
      for (var row = 0;row<rows.length;row++){
         colName = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fexcutestatus');
         Merge=parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'ismerge');
         
         if(colName=="审核中"||colName=="已批准");
         else {
                   dealAlertMessage("您选择的第"+(rows[row])+"条月计划不在审核、已批准状态中,请检查!!!");
                   //alert("您选择的第"+(rows[row])+"条月计划不在审核状态中,请检查!!!");
                   return;
         }
         if(Merge=="Y"){
                 count++; 
                 if(count==1){
                    if(colName!="已批准"){
                         dealAlertMessage("您选择的第"+(rows[row])+"条月计划不在已批准状态中,请检查!!!");
                         return false;
                    }         
                 }
         }
      }
      if(count==0){
              dealAlertMessage("您必须选择一条已合并状态下的月计划,请检查!!!");
              //alert("您必须选择一条已合并状态下的月计划,请检查!!!");
              return;
       } 
       if(count!=1){
              dealAlertMessage("您只能选择一条已合并状态下的月计划,请检查!!!");
              //alert("您只能选择一条已合并状态下的月计划,请检查!!!");
              return;
       }
        //
        var  datas = parent.downFrame.iframe1.mygrid.getSelectedRowsData(1);
		//alert(datas);
		if(!datas)return false;
        var data =  datas.split("###");
        var ids  = "";
        for(var j=0;j<data.length;j++){
          ids = ids+(data[j].split("\^"))[1]+"\^";
        }
        //
        var num=Math.random();
        var url="/ddMoutageplan.do?method=unite&unite_key="+ids+"&num="+num;
        
        var QQ = new Object();
        
		var vReturnValue=showModalDialogYY(url,600,600,QQ,"计划合并",1);

		if(vReturnValue){
		  var para ="para="+vReturnValue;
          var url="<%=request.getContextPath()%>/ddMoutageplan.do?method=doUniteByContent";
		  var myAjax = new Ajax.Request(url,{method: 'post', parameters: para,  onComplete: showResponse});
		     function showResponse(originalRequest){
		        dealAlertMessage(originalRequest.responseText);
	            //alert(originalRequest.responseText);
                var td1    = parent.downFrame.document.all.ID1;
				selectTab(td1, '', 'true','false');
				parent.downFrame.iframe1.createGrid('','0','','','','','','');
	         }

        }else{
          //alert("error");
        }
	}
	
	
    function dayPlan(temId,itemValue){//日计划


        //
        var num=Math.random();
        var url="/ddMoutageplan.do?method=showModalDialog&key=dayPlan"+"&num="+num;
        var QQ = new Object();
		var vReturnValue=showModalDialogYY(url,600,600,QQ,"",1);

		if(vReturnValue){
		  var pars        = "fmonthplanno="+vReturnValue;
          var url="<%=request.getContextPath()%>/ddMoutageplan.do?method=doDayPlan";
		  var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: showResponse});
		     function showResponse(originalRequest){
		                dealAlertMessage(originalRequest.responseText);
	                    //alert(originalRequest.responseText);
						var td1    = parent.downFrame.document.all.ID1;
						selectTab(td1, '', 'true','false');
						parent.downFrame.iframe1.createGrid('','0','','','','','','');
	         }
        }
	}
	
	function wPlan(temId,itemValue){//旬计划


        //
        var num=Math.random();
        var url="/ddMoutageplan.do?method=showModalDialog&key=wPlan"+"&num="+num;
        var QQ = new Object();
		var vReturnValue=showModalDialogYY(url,600,600,QQ,"",1);

		if(vReturnValue){
		  var pars        = "fmonthplanno="+vReturnValue;
          var url="<%=request.getContextPath()%>/ddMoutageplan.do?method=doWPlan";
		  var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: showResponse});
		     function showResponse(originalRequest){
		                dealAlertMessage(originalRequest.responseText);
	                    //alert(originalRequest.responseText);
						var td1    = parent.downFrame.document.all.ID1;
						selectTab(td1, '', 'true','false');
						parent.downFrame.iframe1.createGrid('','0','','','','','','');
	         }
        }
	}
	
	/**
     * 上一条操作

     */
	
	 function preRow(){

       operToolbarRow("iframe1","ddMoutageplan","previous");

    }

     /**
     * 下一条操作

     */

    function nextRow(){

       operToolbarRow("iframe1","ddMoutageplan","next");

    }
    
    function workTransition(itemId,itemValue){//工作流


       var mygrid = parent.downFrame.iframe4.mygrid;
       
       var rows 		= mygrid.getSelectedRows();
	   if(!rows){
		    dealAlertMessage("请先选择相应的记录！");
		    return false;
	   }
	   	
		   var id = mygrid.getValueByName("id");  
		   		   
		   if(id==undefined)return false;
	       
           var status = mygrid.getValueByName("status"); 

           var taskId = mygrid.getValueByName("taskId_");

           var taskInstanceId = mygrid.getValueByName("taskInstanceId_");

           var url = '/application/ddmoutageplan/wfpopup.jsp?id='+id+'&status='+status+'&taskInstanceId='+taskInstanceId+'&taskId='+taskId;

           var param = new Object();

           vReturnValue = showModalDialogYY(url,"700","350",param,"工作流","auto");
       
           if(vReturnValue){
                  var url="<%=request.getContextPath()%>/ddMoutageplan.do?method=workflowHandle";
	              var myAjax = new Ajax.Request(url,{method: 'post', parameters: vReturnValue.type,  onComplete: showResponse});
	              function showResponse(originalRequest){
                        if(vReturnValue.title=="simple"){
                           var td4    = parent.downFrame.document.all.ID4;
						   selectTab(td4, '', 'true','false');
						   parent.downFrame.iframe4.createGrid('','0','','','','','','');
                        }
	                    
	              }
           }       
    }
    function wf_history(itemId,itemValue){

           var mygrid = parent.downFrame.iframe4.mygrid;

           //判断列表对象是否存在

           if (mygrid == "undefined"){          

               return false;

           }  

           

           var id = mygrid.getValueByName("id");  
           
           var bstatus = mygrid.getValueByName("bstatus");
           
		   if(bstatus=="草稿"||bstatus==null||bstatus==''){
		      dealAlertMessage("注意：业务状态为草稿状态的都没有工作流处理历史！");
		      return false;
		   }    

           if(id==''||id==null){

                     alert("请先选择相应的记录！");

                     return false;

           }else{

                    var taskInstanceId = mygrid.getValueByName("taskInstanceId_");

                    var url = 'application/todolist/handlehistory.jsp?taskInstanceId='+taskInstanceId+'&busId='+id;

                    window.open(url);

                    //showNotModalDialogYY(url,"600","500");

           }        
       }

    

	



</script>
