<%@ page language="java" pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>选择日期</title>
	</head>
	<body>
		<table>
			<tr>
				<td>
					<font face="Arial, Helvetica, sans-serif" color="#000033" style="font-size:10px" >从：</font>
					<input type="text" border="1" align="left" name="sdate" disabled="disabled" />
				</td>
				<td>
					<img src="date.gif" onclick="showCalendar(document.all.sdate)" />
				</td>
			</tr>
			<tr>
				<td>
				   <font face="Arial, Helvetica, sans-serif" color="#000033" style="font-size:10px" >到：</font>
				   <input type="text" border="1" align="left" name="edate" disabled="disabled" />
				</td>
				<td>
					<img src="date.gif" onclick="showCalendar(document.all.edate)" />
				</td>
			</tr>
		</table>
		&nbsp;&nbsp;
		<div align="center">
			<input type="button" name="confirm" onclick="closeWindowWithVal()" value="确定" />
			<input type="button" name="cancel" onclick="closeWindowNotVal()" value="取消" />
		</div>
		
	</body>
	<script type="text/javascript">
	   function closeWindowWithVal(){
	      var retVal = "";
	      var sdateVal=document.all.sdate.value;
	      var edateVal=document.all.edate.value;
	      //alert(sdateVal.length);
	      if (sdateVal.length == 0){
	          alert('请选择开始日期!');
	          return false;
	      } 
          if (edateVal.length == 0){
	          alert('请选择终止日期!');
	          return false;
	      }
	      retVal =  '从：'+sdateVal+' 到：'+edateVal;
	      window.parent.returnValue = retVal;
          window.parent.close();  
	      return;
	   }
	   function closeWindowNotVal(){
	       window.parent.returnValue = "Nullity";
           window.parent.close();  
           return;
	   }
	</script>
	<script type="text/javascript">     
	    var inputFieldObj;   
	    /**
	     * 日期控件的入口函数
	     */
	    function showCalendar(obj){	      
	        inputFieldObj = obj;
	        Calendar2.Show(obj,true);
	    }
	         
	    /**
		 *日期回调函数
		 * calendar 为回调函数传回的值
		 */
		function dateChanged(calendar) {
		  if(calendar.dateClicked){
		     //获取日期控件返回的值
			 var temp_vale = formatdd('yyyy-MM-dd',calendar.date);			
			 if (inputFieldObj.name == 'sdate'){
			    //起始日期
			    inputFieldObj.value = temp_vale;
			 } else {
			    //终止日期
			    inputFieldObj.value = temp_vale +' '+'23:59:59';
			 }
					 
		  }
		}
		   
		   
	    var formatdd = function(format,da) {	        
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
	   /**
	    * 
	    */
		function getpopupcalender(src)	{
		    
			popupcalender = src;
		}
		/**
		 *
		 */
		function Calendar2(){
			this.version = "0.0.06.0314";
		    
			this.show = function(refObj){
				this._init(refObj);
		        
				this._popup.show(0,refObj.offsetHeight,250,210,refObj);
			}
		    
			this.hide = function(){
				this._popup.hide();
			}
		    
			this._popup = null;        
			this._init  = function(refObj){
				if(this._popup == null) {
					this._popup = window.createPopup();
					this._popup.document.write(popupcalender.replace("{0}", refObj.id));
		            
					this._popup.document.write("<head><META http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head>");
		            
				}
			}
		}
	
		Calendar2._G_M  = null;
		Calendar2._C_M  = null;
		Calendar2.Show = function(refObj,showNew){
			if(typeof(refObj) == "string")
				refObj = document.getElementById(refObj);
		        
			if(showNew)	{
				Calendar2._C_M = new Calendar2();
		        
				Calendar2._C_M.show(refObj);
			} else {        
				if(Calendar2._G_M == null)
					Calendar2._G_M = new Calendar2();
		        
				Calendar2._C_M = Calendar2._G_M;
				Calendar2._C_M.show(refObj);
			}
		}
	
		Calendar2.Hide = function(){
			Calendar2._C_M.hide();		
		}				
   </script>
   <DOWNLOAD ID="dwn" STYLE="behavior:url(#default#download)" />
   <script>
	   dwn.startDownload('<%=request.getContextPath()%>/script/tag/grid/calendar/popupcalendarch0.htm', getpopupcalender);
   </script>
</html>
