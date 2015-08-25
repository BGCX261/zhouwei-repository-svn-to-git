/**
*  这个js文件中包含了单独的日期时间控件和时间选择段控件的脚本
*  将某种指定的日期时间串转化为Date对象等其它脚本.
*  @author niejt
*  @version 1.0 
*/
    /**
	* 这个函数的作用是将给定日期的年月日部分转化为js的Date类型
	* @param cdate 传入的字符串格式日期 类似 yyyy-mm-dd yyyy年mm月dd日的格式
	*/
    function convertToDate(cdate){
	     var rdate;  // 返回的date类型的日期
		if(((cdate.indexOf("-") != -1) && (cdate.indexOf(":") != -1)) || 
				((cdate.indexOf("年") != -1) && (cdate.indexOf("时") != -1)))//判断日期时间格式是否是长格式,即即有时间又有年月日
		{
				var str = cdate.split(" "); 
				if(str[0].indexOf("-")!=-1){   
					var time   = str[0].split("-");
					year = time[0];
					month = time[1]-1;
					day = time[2];
					rdate=new Date(year,month,day);
					return rdate;
	             }else if(str[0].indexOf("年")!=-1){
				     re=/[年月日]/g;
		             var str1=str[0].replace(re,' ');
		             time   = str1.split(" ");
					 year = time[0];
					 month = time[1]-1;
					 day = time[2];
					 rdate=new Date(year,month,day);
					 return rdate;
				 }
	   }else if(cdate.indexOf("-") != -1&& cdate.indexOf(":")==-1){    //日期是短日期格式,即yyyy-mm-dd，不包含时间部分
				 time = cdate.split("-");
				 year = time[0];
				 month = time[1]-1;
				 day = time[2];
				 rdate=new Date(year,month,day);
				 return rdate;
	  }else if(cdate.indexOf("年")!=-1 && cdate.indexOf("时")==-1){
	             re=/[年月日]/g;
				 str1=cdate.replace(re,' ');
				 time   = str1.split(" ");
				 year = time[0];
				 month = time[1]-1; 
				 day = time[2];
				 rdate=new Date(year,month,day);
				 return rdate;
	  }  
	}
	
   /**
   * 用户输入的日期格式转化为jscalendar所用的格式
   * @param 用户输入的日期格式 
   */
      
     function showFormat(dateFormat){
        var ifFormat;
        var  showsTime;
          if (dateFormat=="yyyy-mm-dd") {
			 ifFormat="%Y-%m-%d"; 
			 showTime=false;
		}
		if (dateFormat=="yyyy-mm-dd hh:mm:ss") {
			ifFormat ="%Y-%m-%d %H:%M:%S";
			showsTime=true;
		}
		if (dateFormat=="yyyy-mm-dd hh:mm") {
			ifFormat="%Y-%m-%d %H:%M";
			showsTime=true ;
		}
		if (dateFormat=="ＹＹＹＹ年ＭＭ月ＤＤ日") {
			ifFormat="%Y年%m月%d日 %H时%M分" ;
			 showTime=false;
		}
		if (dateFormat=="ＹＹＹＹ年ＭＭ月ＤＤ日 hh时mm分ss秒"){
			ifFormat="%Y年%m月%d日 %H时%M分%S秒";
			showsTime=true;
		}
		if (dateFormat=="ＹＹＹＹ年ＭＭ月ＤＤ日 hh时mm分") {
			  ifFormat ="%Y年%m月%d日 %H时%M分";
			  showsTime=true;
		}

		 return([ifFormat,showsTime]);
     }
	
//------------------------------------日期时间部分-------------------------------------------------------------------------
      /**
     * 调用日历的函数
     * @param Id 日期文本框的id 
     * @param dateFormat  日期时间格式
     */
     function showCalendar(Id,dateFormat){
		  s=document.getElementById(Id);
		  var cal = new Zapatec.Calendar(true, null, selected, closeHandler);
	      cal.time24 = true;
		  var xy=showFormat(dateFormat);
		  cal.setDateFormat(xy[0]);
		  cal.showsTime=xy[1];
		  cal.setRange(1970, 2050);
		  cal.helpButton = false;
		    cal.dateClicked = true;
		  //cal.dragging=true;
		  cal.create();
		  cal.showAtElement(s , "BR");        
		  cal.sel = s;                 // inform it what input field we use
	 } 
//----------------------------------------------------时间段部分-----------------------------------------     
     var startDate;  //开始时间
     var endDate;    //结束时间
     /**
     * 调用开始日历的函数
     * @param startId 开始文本框的id
     * @param endId   结束文本框的id,用做开始日期与结束日期比较
     * @param dateFormat  日期时间格式 
     */
     function showBeginCalendar(startId,endId,dateFormat){
		  s=document.getElementById(startId);
		  e=document.getElementById(endId);
		  endDate=convertToDate(e.value); //将结束日期转化为Date类型,用于比较
		  var cal = new Zapatec.Calendar(true, null, selected, closeHandler);
	      cal.time24 = true;
		  var xy=showFormat(dateFormat);
		  cal.setDateFormat(xy[0]);
		  cal.showsTime=xy[1];
		  cal.setRange(1970, 2050);
		  cal.helpButton = false;
		  cal.dateClicked = true;
		  //cal.dragging=true;
		  cal.setDisabledHandler(disallowDateAfter); //设置日期的回调屏蔽函数,屏蔽结束日期后面日期不可选
          cal.create();
		  cal.showAtElement(s , "BR");        
		  cal.sel = s;                 // inform it what input field we use
	 } 
	 
	  /**
     * 调用结束日历的函数
     * @param startId 开始文本框的id
     * @param endId   结束文本框的id,用做开始日期与结束日期比较
     * @param dateFormat  日期时间格式
     */
	  function showEndCalendar(startId,endId,dateFormat){
		  e=document.getElementById(endId);
		  s=document.getElementById(startId);
		  startDate=convertToDate(s.value); //将开始日期转化为Date类型
		  var cal = new Zapatec.Calendar(true, null, selected, closeHandler);
	      cal.time24 = true;
		  var xy=showFormat(dateFormat);
		  cal.setDateFormat(xy[0]);
		  
		  cal.showsTime=xy[1];
		  cal.setRange(1970, 2050);
		  cal.helpButton = false;
		  cal.sel = e;  
		  cal.dateClicked = true;
		  //cal.dragging=true;
		  cal.setDisabledHandler(disallowDateBefore); //设置日期的回调屏蔽函数,屏蔽开始日期前面的日期不可选
          cal.create();
		  cal.showAtElement(e , "BR");        // show the calendar  
		}
		
		/**
	     * 结束日期的回调函数，如果开始日期存在，开始日期前日期不可选。
	     * @param date  一个日期比较的参数
     	*/
		function disallowDateBefore(date){
		      /*
		        now=new Date();
		        hour=now.getHours();
		        minute=now.getMinutes();
		        second= now.getSeconds();
                millisecond= now.getMilliseconds();
		        
		        date.setHours(hour,minute,second,millisecond);
			    if ((startDate != null) && startDate > date){
				 return true; 
		        }
		        return false;
		      */
		      if (startDate != null) {
					var compareDays = compareDatesOnly(startDate, date);
					if  (compareDays < 0) {
						return (true);
					}
                    if  (compareDays == 0) {
						{return "edges";}
					}
					if ((endDate != null) && (date > startDate) && (date < endDate)) {
						return "between";
					} 
			} 
				  return false;
		 }
		 
		 /**
		  * 开始日期的回调函数，如果结束日期存在，结束日期后日期不可选。
		*/
         function disallowDateAfter(date) { 
              /*  
               now=new Date();
		        hour=now.getHours();
		        minute=now.getMinutes();
		        second= now.getSeconds()  ;
                millisecond= now.getMilliseconds();
		        
		        date.setHours(hour,minute,second,millisecond);
	           // date.setHours(0,0,0,0)
	           if ((endDate != null) && date > endDate){
				  return true;
				}
                return false;
              */
              
              if (endDate != null) {

					 
					var compareEnd = compareDatesOnly(date, endDate);
					if  (compareEnd < 0) {
						return (true);
					}

				 
					if  (compareEnd == 0) {
						{return "edges";}
					}

                   if (startDate != null){
						var compareStart = compareDatesOnly(date, startDate);
						if  (compareStart < 0) {
							return "between";
						} 
					} 
				}

			   return false;
	      }
        /**
        * 日期(年月日)的比较函数
        */
        function compareDatesOnly(date1, date2) {
				var year1 = date1.getYear();
				var year2 = date2.getYear();
				var month1 = date1.getMonth();
				var month2 = date2.getMonth();
				var day1 = date1.getDate();
				var day2 = date2.getDate();

				if (year1 > year2) {
					return -1;
				}
				if (year2 > year1) {
					return 1;
				}

				//years are equal
				if (month1 > month2) {
					return -1;
				}
				if (month2 > month1) {
					return 1;
				}

				//years and months are equal
				if (day1 > day2) {
					return -1;
				}
				if (day2 > day1) {
					return 1;
				}

				//days are equal
				return 0;


				/* Can't do this because of timezone issues
				var days1 = Math.floor(date1.getTime()/Date.DAY);
				var days2 = Math.floor(date2.getTime()/Date.DAY);
				return (days1 - days2);
				*/
			}
//--------------------------------------------------公共的回调函数----------------------------------------------
	    /**
	    * 更新文本框下的字段
	    */  
	    function selected(cal, date) {
		     cal.sel.value = date; // just update the date in the input field.
             if (cal.dateClicked )  //日期双击时候关闭日历
                cal.callCloseHandler();
	    } 
	    /**
	    * 关闭日期函数
	    */  
        function closeHandler(cal) {
            cal.hide();                        // hide the calendar
            cal.destroy();
            calendar = null;
        }
		   