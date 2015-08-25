<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp" %>
<%@ page language="java" buffer="18kb"%>
<% 
	/*********************************************/
	//             通用查询列表模板                    //
	//         @author MaJian 2006-12-20         //
	/*********************************************/
%>
<html>
<head>
  <title>gridtest</title> 
    <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/style.css">
    <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/default.css">
	
</head>
<body>



<div id='mygrid'></div>

<div id='standGridPage1'></div> 
<!--<jhop:page currPage="1" pageSize="15" totalCount="30" urlStr="" ></jhop:page>--> 
</body>	
<%--处理消息--%>
<%
	/*
	if (message != null && !message.equals("") && !message.equals("null")){
%>
		<script language="javascript">
			dealMessage('<%=message%>');
		</script>
<% 
	 }
	 */
	 String parentid= request.getParameter("fcomputerno");
	 request.setAttribute("parentid",parentid);
%>

<%-- 创建弹出窗口，并传递参数 --%>
<jhop:grid 	id="mygrid"
      pageId="standGridPage1"
      busName="DdSwitchseqbillDto1"
      subName="128205695515787306"
      pageItems="50"
      listType="2"
      listKind="104"
      entityName="DdSeqbilldetail"
      isDisplaySet="0"
      isQuerySet="0"
      isPageSet="0"
      isOutputSet="0"
      isCheckBox="0" 
      
      listBox="fstationname#108^showStation,fgivetime#5^,fsummittime#5^,fgiver#2^src=ddperson,faccepter#2^src=person,fsummiter#2^src=person" 
      editType="fstep#ro,fstationname#ro"
      refColVal ="zddseqbilldetail1.fcomputerno^${parentid}"
      queryPath="/ddSwitchseqbill.do?method=SeqBillDetailGridQuery&parentid=${parentid}">
</jhop:grid>

	<script>

   var si = setInterval(setParentId,500) ;
   function setParentId(){
        if(mygrid){
            //alert('zddseqbilldetail1.fcomputerno^<%=parentid%>');
			mygrid.setRefColVal('zddseqbilldetail1.fcomputerno^<%=parentid%>');
			clearInterval(si);
		}
   }  
   
   //弹出对话框

		
			function showStation(){
			    var dd= new Date();
			    var  impo = new importDatasObj('/application/stdstation/showstdstation.jsp?dd='+dd,{'stationname':'fstationname'},'mygrid');  
				impo.height = 500;
                impo.width = 400;
                impo.showImportDatas();
           }
  
</script>


	<script>
		//存储行id
		var tem_rid;
		//存储列 index
		var tem_ind;
		//var dataXml = mygrid.serializeGrid();
        
		//存储临时值的value
		var temp_vale;
		//单元格最初的值;
		var  init_temp_value;
	 function editHandler(state,rid, ind){
	
       // alert(headCols);
		  //把当前单元格的rowid和index存在变量里tem_rid,tem_ind
			tem_rid = rid;
			tem_ind = ind;
			var  typ = this.getColHiType(ind);
			//如果不是日期类型的单元格隐藏日期控件
			if((typ!="timestamp"&&typ!="Date")){
				var caldiv = document.getElementById("dropDiv");
				if(caldiv){
					caldiv.style.display='none';
				}
			}
			var  listbox = this.getListBox(ind);
			if(listbox==0){	
					hideWindow();
			}
			//alert("listbox="+listbox);
			if(listbox=="5")//日期类型
			{       
					//取得单元格对象

					var tempcel = this.getRowById(rid).childNodes[ind];
					if(state==0)
					{	
					    //显示日期控件
						temp_vale=null;
						Calendar2.Show(tempcel,true,'','yyyy-mm-dd hh:mm','*');
					}
					if(state==2)
					{
					   //结束后把值保存
					   if(temp_vale!=null)
					   {
							var _cell = this.cells(tem_rid,tem_ind);
							_cell.setValue(temp_vale);
						}
					}
			}
			else if(listbox=="6"){
					var tempcel = this.getRowById(rid).childNodes[ind];
					var vv = this.getDateGroup(rid,ind);
					var groups = vv.split("@");
					var qu = getQote(groups[1]);
					if(state==0)
					{	
					    //显示日期控件
						temp_vale=null;
						Calendar2.Show(tempcel,true,groups[0],'yyyy-mm-dd hh:mm:ss',qu);
					}
					if(state==2)
					{
					   //结束后把值保存
					   if(temp_vale!=null)
					   {
							var _cell = this.cells(tem_rid,tem_ind);
							_cell.setValue(temp_vale);
						}
					}
			}
			else if(listbox=='1'||listbox=='2'||listbox=='3'||listbox=='4'||listbox=='101')//1:系统字典2:业务字典
			{
				    var  listboxsrc =this.getListBoxSrc(ind);
				   //取得单元格对象
					var tempcel = this.getRowById(rid).childNodes[ind];
					if(state==0)
					{   temp_vale=null;
					    if(listbox=='1'||listbox=='3')//1:系统字典
					    {   
					    	var content = listboxsrc.split("@@@");
					    	//alert("content="+content)
					    	var  typ = (content[0].split("="))[1];//取得type
					    	//alert(typ);
					    	var  parent = (content[1].split("="))[1];//取得parentId
					    	//alert("ffff");
					    	//(type, parentId, outText, attachName, hiddName, initValue,checkbox, func, clearObj)
							displaySysSelect( typ, parent, "", tempcel, "","sss",0,chagevalue);
						}else if(listbox=='2'||listbox=='4')//2:业务字典
						{
							displayBusSelect(tempcel, "", "", listboxsrc, 0, chagevalue);
						}
						//自己设置的下拉框
						else if(listbox=='101'){
						    var content = listboxsrc.split("@@@");
						    var pp = content[0].split("\@");
						    var news="";
						    var count=0;
						    for(var j=0;j<pp.length;j++){
						        if(count!=pp.length-1){
						    		news+=pp[j]+"#";
						    	}else{
						    		news+=pp[j];
						    	}
						    	count++;
						    }
							displaySysSelect( '', "", "", tempcel, "",news,0,chagevalue);
						}
					}
					if(state==2)
					{   
					   //结束后把值保存
					   if(temp_vale!=null&&temp_vale!=""&&temp_vale.length>0)
					   {    
					   	    //取得当前单元格对象
							var _cell = this.cells(tem_rid,tem_ind);
							//设定值
							_cell.setValue(temp_vale);
						}
					}
					//下拉框控件回调函数
					function chagevalue(text,key)
					{   //alert("ffffff");
						if(listbox=='1'||listbox=='2'||listbox=='101'){
							var _cell = eval("mygrid.cells(tem_rid,tem_ind)");
							temp_vale=text;
							_cell.setValue(text);
						}else if(listbox=='3'||listbox=='4'){
							temp_vale=key;
							var v = key+"\^"+text;
							var exe = "mygrid.setColumnValueByListBox(tem_rid,tem_ind,v)";
							eval(exe);
							//mygrid.setColumnValueByListBox(tem_rid,tem_ind,v)
						}
					}
		      }
		      //弹出对话框
		      else if(listbox=='108'){
		      	 var  listboxsrc =this.getListBoxSrc(ind);
		      	 if(state==0){
		      		var _show= eval(listboxsrc);
		      		_show();
		      	 }
		      }
				return true;
		}
	   	
	      var cal;
	  
		   /**
		  	*日期回调函数
		    * calendar 为回调函数传回的值
		    */
		  function dateChanged(calendar) {
			  if(calendar.dateClicked){
			     //修改要 要取得
			  	  //var dateformat = getDateFormat(tem_ind);
				 //temp_vale = calendar.date.format('yyyy-MM-dd');
				 temp_vale = formatdd('yyyy-MM-dd hh:mm',calendar.date);
				  //得到当前的单元格以后用grid的名称名称
				  var _cell = mygrid.cells(tem_rid,tem_ind);
				  //把值赋给单元格
				  _cell.setValue(temp_vale);
				  //改变行状态
				  //mygrid.changeRowStatusByControl(tem_rid,tem_ind);
				  //隐藏日期控件
			  }
		}
	   
	              
	 /**
	     把数字转化为对应的符号 
	     3:> 前面日期不可选 (不包括传入的日期) 
	     5<: 后面日期不可选（不包括传入的日期）

	     4:>= 前面日期不可选 (包括传入的日期)
	     6:<=  后面日期不可选（包括传入的日期）
	     10: <> 传入的日期不可选择
	     1:==传入的日期可选择其它的日期不可选

	 */      
    function  getQote(q){
       var quot="";
    	switch (parseInt(q)){
		case 1:
		   quot = "==";
		   break;
		case 3:
		   quot = ">";
		   break;
		case 4:
		   quot = ">=";
		   break;
		case 5:
		   quot = "<";
		   break;
		case 6:
		   quot = "<=";
		   break;
		   
		 case 10:
		   quot = "<>";
		   break;
		}
		return quot;
    }

       	    var formatdd = function(format,da)
		   {
		        
				var o = {
				"M+" : da.getMonth()+1, //month
				"d+" : da.getDate(),    //day
				"h+" : da.getHours(),   //hour
				"m+" : da.getMinutes(), //minute
				"s+" : da.getSeconds(), //second
				"q+" : Math.floor((da.getMonth()+3)/3),  //quarter
				"S" : da.getMilliseconds() //millisecond
				}
				if(/(y+)/.test(format)) 
				format=format.replace(RegExp.$1,(da.getFullYear()+"").substr(4 - RegExp.$1.length));
				
				for(var k in o)
					if(new RegExp("("+ k +")").test(format))
						format = format.replace(RegExp.$1,RegExp.$1.length==1 ? o[k] :("00"+ o[k]).substr((""+ o[k]).length));
					return format;
		   } 
	    
			
				var popupcalender;
				
				function getpopupcalender(src)
				{
					popupcalender = src;
				}
				
				function Calendar2()
				{
					this.version = "0.0.06.0314";
				    
					this.show = function(refObj)
					{
						this._init(refObj);
				        
						this._popup.show(0,refObj.offsetHeight,250,220,refObj);
					}
				    
					this.hide = function()
					{
						this._popup.hide();
					}
				    
					this._popup = null;        
					this._init  = function(refObj)
					{
						if(this._popup == null)
						{
							this._popup = window.createPopup();
						 
							this._popup.document.write(popupcalender.replace("{0}", refObj.id));
				            
							//this._popup.document.write("<head><META http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head>");
				            
						}
					}
				}

				Calendar2._G_M  = null;
				Calendar2._C_M  = null;
				var objId;    //绑定日期对象的id
				var dateFormat;   //日期时间格式
				var ptime;          //需要屏蔽的时间
				  /**
				  屏蔽的类型 
				     0:> 前面日期不可选 (不包括传入的日期) 
				     1<: 后面日期不可选（不包括传入的日期）


				     2:>= 前面日期不可选 (包括传入的日期)
				     3:<=  后面日期不可选（包括传入的日期）
				     4: <> 传入的日期不可选择
				     5:==传入的日期可选择其它的日期不可选


				  */
				var ptype;       
				Calendar2.Show = function(refObj,showNew,time,format,type)
				{
				 objId=refObj;
				 dateFormat=format;
				 ptime=time;
				 ptype=type;
					if(typeof(refObj) == "string"){
						refObj = document.getElementById(refObj);
				    } 
					if(showNew)
					{
						Calendar2._C_M = new Calendar2();
				        
						Calendar2._C_M.show(refObj);
					}
					else
					{        
						if(Calendar2._G_M == null)
							Calendar2._G_M = new Calendar2();
				        
						Calendar2._C_M = Calendar2._G_M;
						Calendar2._C_M.show(refObj);
					}
				}

				Calendar2.Hide = function()
				{
					Calendar2._C_M.hide();
					
				}
				
			
	  
</script>

	<DOWNLOAD ID="dwn" STYLE="behavior:url(#default#download)" />
	<script>
			dwn.startDownload('<%=request.getContextPath()%>/components/tag/grid/popupcalendarch0.htm', getpopupcalender);
			
		</script>

</html>
