//ȡһ��Χ���漴����
var random_integer = function(min, max){
      return Math.floor(Math.random() * (max - min + 1)) + min;
};

/**
 * ���Ҹ�ʽ�� #,##0.00
 */
function formatMoney(num,floatCount){

	num = String(num.toFixed(floatCount));
	var nums = num.split(".");
	var re=/(\d+)(\d{3})/;
	while(re.test(nums[0])){
		nums[0]=nums[0].replace(re,"$1,$2");
	}
	return nums[0]+"."+nums[1];
}
/*
*	���� ����
*/
var aa= unescape("%d7")
alert(aa);

/**
*��֤����Ԫ��double����
*/
function checkNumber(formName){
	var myForm = document.getElementById(formName);
	var re = /^(-?\d+)(\.\d+)?$/;
	var inputs = myForm.elements;
	var len = inputs.length; 
	for(var i=0;i<len;i++){ 
		if(inputs[i].ifNo){
			if(!re.test(inputs[i].value)){
				alert('��������ȷ���ָ�ʽ!');
				inputs[i].select();
				return false;
			}
		}
	}	
	return true;
}
/**
*ɾ��table��һ�У�tr��
*obj td ����
*/
function delRow(obj){
	var trobj =obj.parentElement.parentElement;   
   	trobj.parentElement.removeChild(trobj); 
}

/**
*<textarea onchange="return checkLength(this,5)" ></textarea>
*��֤textarea text ����
*/
function checkLength(obj,length)
{
 	if (obj.value.length>0)
	{
		var length1=obj.value.length;
		if (length1>length)
		{
			alert("¼����Ϣ���ȳ������ƣ�����ֽڳ���Ϊ"+length);
			return false;
		}
	}
	return true;
}
/**
*�� a_1  b_2    c_3  ת���� ��a_1,b_2,c_3
*/
function buildSql(){
	var tx = document.getElementById('a');
	tx.value=tx.value.replace(/(^\s+)|(\s+$)/g,"");
	var re = /(\w+)(\s+)(\w+)/;
	while(re.test(tx.value)){
		tx.value=tx.value.replace(re,"$1,$3");
	}
}
function managerOption(v,t){
	var oOption = document.createElement("OPTION");
	oOption.value=v;
	oOption.text=t;
	document.all.userId.add(oOption);
}
function clearOption(){
	selLength = document.all.userId.length;
	for (var i=0; i<selLength; i++){
		document.all.userId.options.remove(0);
	}
	// document.all.userId.options.length = 0;
	//document.all.userId.length = 0;
}

function saveFile(T,content)
{//����
  var filename=document.all(T).value;
  var win=window.open('','','top=10000,left=10000');
  win.document.write(document.all(content).innerText);
  win.document.execCommand('SaveAs','',filename)
  win.close();
}

/**
 * ȥ���ַ�����β�ո�
 */
String.prototype.trim = function()
{
   return this.replace(/(^\s+)|\s+$/g,"");
}
/**
 * ���㸸ҳ����ϼ�
 */
function showMoenySum()
{
	var parent = self.opener;
    var b = new Array();
    var tbRows = parent.document.all.lossListTable.rows;
    var rowNum = tbRows.length;
    var k = 0;
    for(var i=1;i<rowNum;i++){
        var flag = true;
        var arrNum = b.length;
        for(var j=0;j<arrNum;j++){
            if(b[j][0]==tbRows[i].cells[0].innerText){
                flag = false;
                b[j][2] = parseFloat(b[j][2]) + parseFloat(tbRows[i].cells[2].innerText.replace(/,/g,""));
                b[j][4] = parseFloat(b[j][4]) + parseFloat(tbRows[i].cells[4].innerText.replace(/,/g,""));
                b[j][5] = parseFloat(b[j][5]) + parseFloat(tbRows[i].cells[8].innerText.replace(/,/g,""));
                b[j][3] = b[j][3]>tbRows[i].cells[3].innerText?tbRows[i].cells[3].innerText:b[j][3];
            }
        }
        if(flag){
        	var a = new Array();
            a[0] = tbRows[i].cells[0].innerText;
            a[1] = tbRows[i].cells[1].innerText;
            a[2] = tbRows[i].cells[2].innerText.replace(/,/g,"");
            a[3] = tbRows[i].cells[3].innerText;
            a[4] = tbRows[i].cells[4].innerText.replace(/,/g,"");
            a[5] = tbRows[i].cells[8].innerText.replace(/,/g,"");
            b[k++] = a;
        }
    }

    for(var i=0;i<b.length;i++){
    	
    	 var rowNum = document.all.showMoenySumTb.rows.length;
         var newRow = document.all.showMoenySumTb.insertRow(rowNum);
	     newRow.onmouseover = function onMover(){this.bgColor='#EAEAEA';};
         newRow.onmouseout = function onMout(){this.bgColor='#ffffff';};
		 
		 for(var j=0;j<b[i].length;j++){
		 	 var alignStr = 'center';
		 	 b[i][j]=(b[i][j]+'').replace(/(^\s*)|(\s*$)/g,"");
		 	 if(/^(-?\d+)(\.\d+)?$/.test(b[i][j])){
		 	 	alignStr = 'right';
		 	 	b[i][j] = outputMoney2(b[i][j]);
		 	 }
		 	 var newTd = newRow.insertCell();
		 	 newTd.innerHTML = '<font color="#000066">'+ b[i][j] + '</font>';
			 newTd.align = alignStr;
			 newTd.height = "22";
		 }
    }  
}
/**
 * ajax
 * <body onLoad="createAJAXHttpRequest();" >
 */
var ajaxHttpRequest = false;
function createAJAXHttpRequest(){
	if(window.ActiveXObject){
		ajaxHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	}else if(window.XMLHttpRequest){
		try{
			alert("window.XMLHttpRequest");
			ajaxHttpRequest = new XMLHttpRequest();
		}
		catch(fail){
			try{
				ajaxHttpRequest = new ActiveXObject("MSXML2.XMLHTTP");
			}
			catch(failed){
				ajaxHttpRequest = false;
			}
		}
	}
}
function sendDataToServerForQuota(){

	if(!ajaxHttpRequest){
		alert("��ʱ�޷�������������");
		return false;
	}else{
		
		var timeStamp = "?timeStamp="+new Date().getTime();
		var paramStr = "&method=queryBuyerQuota";
		
		var rowNum = document.all.lossListTable.rows.length;

		for(var i=1;i<rowNum;i++){
			  var theRow = document.all.lossListTable.rows[i];
			  if(theRow.cells[0].firstChild.checked&&!theRow.cells[0].firstChild.disabled){
			      paramStr += "&serialNo="+theRow.cells[0].firstChild.value;
			  }
		}
					   
		var url = '/domesticLossRecord.do';
		ajaxHttpRequest.open("POST",url,true);
		ajaxHttpRequest.onreadystatechange = function(){
					handleCallBackForQuota();
		};
		//'POST' method must	alert(timeStamp + paramStr);
		ajaxHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded;");
		ajaxHttpRequest.send(timeStamp + paramStr);
		
	}
}
function handleCallBackForQuota(){
	if ( ajaxHttpRequest.readyState == 4 ) {
		if (ajaxHttpRequest.status == 200) {
			
			form1.refreshFlag.value = '1';
			/*
				String responseTextStr = "the data<String> sent to page";
				response.setContentType("text/html;charset=gbk");
			 	PrintWriter out = response.getWriter();
				out.print(responseTextStr);
				out.flush();
				out.close();
			*/
            var result = ajaxHttpRequest.responseText;
			var con = result.split("+");
			var rowNum = document.all.QuotaInfoTable.rows.length;
			
			for(var i=1;i<rowNum;){
			     var tbRow = document.all('QuotaInfoTable').rows[i];
				 document.all('QuotaInfoTable').deleteRow(tbRow.rowIndex);
				 rowNum = document.all.QuotaInfoTable.rows.length;
			}
			
			for(var i=0;i<con.length&&result.length>0;i++){
                 var newRow = document.all.QuotaInfoTable.insertRow(rowNum);
			     var val = con[i].split("|");
                 newRow.onmouseover = function onMover(){this.bgColor='#EAEAEA';};
                 newRow.onmouseout = function onMout(){this.bgColor='#ffffff';};
					
				 var newTd1 = newRow.insertCell();
				 newTd1.innerHTML = 
                 '<input name="quotaPayTerm" type="text" value="'+val[0]+'" size="5" class="submit" readonly/>��' ;
				 newTd1.align = 'center';

				 var newTd2 = newRow.insertCell();
				 val[1] = outputMoney2(val[1]);
				 newTd2.innerHTML = 
                 '<input name="quotaSum" type="text"  value="'+val[1]+'" size="15"  class="submit" readonly >' ;
				 newTd2.align = 'center';

				 var newTd3 = newRow.insertCell();
				 newTd3.innerHTML = 
                 '<input name="quotaEffectDate" type="text" value="'+val[2]+'" size="10" class="submit"  readonly>' ;
				 newTd3.align = 'center';

				 var newTd4 = newRow.insertCell();
				 newTd4.innerHTML = 
                 '<input name="quotaLapseDate" type="text" value="'+val[3]+'" size="10" class="submit"  readonly>' ;
				 newTd4.align = 'center';

				 var newTd5 = newRow.insertCell();
				 newTd5.innerHTML = 
                 '<input name="quotaPayRate" type="text" value="'+val[4]+'" size="5" class="submit"  readonly>'+
                 '<input name="quotaMoneyId" type="hidden" value="'+val[5]+'">'+
                  '<input name="quotaDollarRate" type="hidden" value="'+val[6]+'">'+
                  '<input name="quotaCnyRate" type="hidden" value="'+val[7]+'">'+
                  '<input name="buyerQuotaNo" type="hidden" value="'+val[8]+'">';
				 newTd5.align = 'center';
			}
			hideTooltip('dHTMLToolTip');
			document.form1.cmdQuery.disabled = false;
			document.form1.cmdSave.disabled=false;
			document.form1.cmdButton.disabled=false;
			document.form1.reFreshCmd.disabled = false;
			viewFlag = true;

		}else{//(ajaxHttpRequest.status == 500)

			hideTooltip('dHTMLToolTip');
			alert("��ʱ�޷�������������");
			document.form1.cmdQuery.disabled = false;
			document.form1.cmdSave.disabled=false;
			document.form1.cmdButton.disabled=false;
			document.form1.reFreshCmd.disabled = false;
			viewFlag = true;

		}
	}else{

		document.form1.cmdQuery.disabled = true;
		document.form1.cmdSave.disabled=true;
		document.form1.cmdButton.disabled=true;
		document.form1.reFreshCmd.disabled = true;
		if(viewFlag)
			showTooltip('dHTMLToolTip',event,'<font color=#000066>&nbsp;���ڲ�ѯ�У����Ժ�......&nbsp;</font>', '#B8BDDE','#000000','#000000');
		viewFlag = false;

	}
}
/*
<BODY>
<OL ID = "oList">
<LI>List Item 1</LI>
<LI>List Item 2</LI>
<LI>List Item 3</LI>
</OL>
<INPUT TYPE = "button" VALUE = "Add Item" onclick="fnAdd()">
</BODY>
object.insertAdjacentElement(toWhere,newItem);
toWhere: beforeBegin,afterBegin,beforeEnd,afterEnd
*/
function fnAdd()
{
   var oNewItem = document.createElement("LI");    
   oList.children(0).insertAdjacentElement("beforeBegin",oNewItem);
   oNewItem.innerText = "List Item 0";
}
/*
-------------------
javascript:R=0; x1=.1; y1=.05; x2=.25; y2=.24; x3=1.6; y3=.24; x4=300; y4=200; x5=300; y5=200; DI=document.images; DIL=DI.length; function A(){for(i=0; i-DIL; i++){DIS=DI[ i ].style; DIS.position='absolute'; DIS.left=Math.sin(R*x1+i*x2+x3)*x4+x5; DIS.top=Math.cos(R*y1+i*y2+y3)*y4+y5}R++}setInterval('A()',5); void(0); 
-------------------
R=0; x1=.1; y1=.05; x2=.25; y2=.24; x3=1.6; y3=.24; x4=300; y4=200; x5=300; y5=200; 
DI=document.images; 
DIL=DI.length; 
function A(){
	for(i=0; i-DIL; i++){
		DIS=DI[ i ].style;
		DIS.position='absolute';
		DIS.left=Math.sin(R*x1+i*x2+x3)*x4+x5; 
		DIS.top=Math.cos(R*y1+i*y2+y3)*y4+y5;
	}
	R++
}
setInterval('A()',5); 
void(0);
*/
Date.prototype.isLeapYear �ж�����
Date.prototype.Format ���ڸ�ʽ��
Date.prototype.DateAdd ���ڼ���
Date.prototype.DateDiff �Ƚ����ڲ�
Date.prototype.toString ����ת�ַ���
Date.prototype.toArray ���ڷָ�Ϊ����
Date.prototype.DatePart ȡ���ڵĲ�����Ϣ
Date.prototype.MaxDayOfDate ȡ���������µ��������
Date.prototype.WeekNumOfYear �ж�����������ĵڼ���
StringToDate �ַ���ת������
IsValidDate ��֤������Ч��
CheckDateTime ��������ʱ����
daysBetween ����������


//����������������������������������
// �ж�����
//����������������������������������
Date.prototype.isLeapYear = function()
{
return (0==this.getYear()%4&&((this.getYear()%100!=0)||(this.getYear()%400==0)));
}

//����������������������������������
// ���ڸ�ʽ��
// ��ʽ YYYY/yyyy/YY/yy ��ʾ���
// MM/M �·�
// W/w ����
// dd/DD/d/D ����
// hh/HH/h/H ʱ��
// mm/m ����
// ss/SS/s/S ��
//����������������������������������
Date.prototype.Format = function(formatStr)
{
var str = formatStr;
var Week = ['��','һ','��','��','��','��','��'];

str=str.replace(/yyyy|YYYY/,this.getFullYear());
str=str.replace(/yy|YY/,(this.getYear() % 100)>9?(this.getYear() % 100).toString():'0�� + (this.getYear() % 100));

str=str.replace(/MM/,this.getMonth()>9?this.getMonth().toString():'0�� + this.getMonth());
str=str.replace(/M/g,this.getMonth());

str=str.replace(/w|W/g,Week[this.getDay()]);

str=str.replace(/dd|DD/,this.getDate()>9?this.getDate().toString():'0�� + this.getDate());
str=str.replace(/d|D/g,this.getDate());

str=str.replace(/hh|HH/,this.getHours()>9?this.getHours().toString():'0�� + this.getHours());
str=str.replace(/h|H/g,this.getHours());
str=str.replace(/mm/,this.getMinutes()>9?this.getMinutes().toString():'0�� + this.getMinutes());
str=str.replace(/m/g,this.getMinutes());

str=str.replace(/ss|SS/,this.getSeconds()>9?this.getSeconds().toString():'0�� + this.getSeconds());
str=str.replace(/s|S/g,this.getSeconds());

return str;
}

//+����������������������������������
//| ������ʱ��������� ���ڸ�ʽΪ YYYY-MM-dd
//+����������������������������������
function daysBetween(DateOne,DateTwo)
{
var OneMonth = DateOne.substring(5,DateOne.lastIndexOf ('-'));
var OneDay = DateOne.substring(DateOne.length,DateOne.lastIndexOf ('-')+1);
var OneYear = DateOne.substring(0,DateOne.indexOf ('-'));

var TwoMonth = DateTwo.substring(5,DateTwo.lastIndexOf ('-'));
var TwoDay = DateTwo.substring(DateTwo.length,DateTwo.lastIndexOf ('-')+1);
var TwoYear = DateTwo.substring(0,DateTwo.indexOf ('-'));

var cha=((Date.parse(OneMonth+'/'+OneDay+'/'+OneYear)- Date.parse(TwoMonth+'/'+TwoDay+'/'+TwoYear))/86400000);
return Math.abs(cha);
}


//+����������������������������������
//| ���ڼ���
//+����������������������������������
Date.prototype.DateAdd = function(strInterval, Number) {
var dtTmp = this;
switch (strInterval) {
case 's' :return new Date(Date.parse(dtTmp) + (1000 * Number));
case ��n' :return new Date(Date.parse(dtTmp) + (60000 * Number));
case ��h' :return new Date(Date.parse(dtTmp) + (3600000 * Number));
case ��d' :return new Date(Date.parse(dtTmp) + (86400000 * Number));
case ��w' :return new Date(Date.parse(dtTmp) + ((86400000 * 7) * Number));
case ��q' :return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number*3, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
case ��m' :return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
case ��y' :return new Date((dtTmp.getFullYear() + Number), dtTmp.getMonth(), dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
}
}

//+����������������������������������
//| �Ƚ����ڲ� dtEnd ��ʽΪ�����ͻ��� ��Ч���ڸ�ʽ�ַ���
//+����������������������������������
Date.prototype.DateDiff = function(strInterval, dtEnd) {
var dtStart = this;
if (typeof dtEnd == 'string' )//������ַ���ת��Ϊ������
{
dtEnd = StringToDate(dtEnd);
}
switch (strInterval) {
case 's' :return parseInt((dtEnd - dtStart) / 1000);
case ��n' :return parseInt((dtEnd - dtStart) / 60000);
case ��h' :return parseInt((dtEnd - dtStart) / 3600000);
case ��d' :return parseInt((dtEnd - dtStart) / 86400000);
case ��w' :return parseInt((dtEnd - dtStart) / (86400000 * 7));
case ��m' :return (dtEnd.getMonth()+1)+((dtEnd.getFullYear()-dtStart.getFullYear())*12) - (dtStart.getMonth()+1);
case ��y' :return dtEnd.getFullYear() - dtStart.getFullYear();
}
}

 //+����������������������������������
 //| ��������ַ�����������ϵͳ��toString����
 //+����������������������������������
 Date.prototype.toString = function(showWeek)
 {
 var myDate= this;
 var str = myDate.toLocaleDateString();
 if (showWeek)
 {
 var Week = ['��','һ','��','��','��','��','��'];
 str += �� ����' + Week[myDate.getDay()];
 }
 return str;
 }

 //+����������������������������������
 //| ���ںϷ�����֤
 //| ��ʽΪ��YYYY-MM-DD��YYYY/MM/DD
 //+����������������������������������
 function IsValidDate(DateStr)
 {
 var sDate=DateStr.replace(/(^\s+|\s+$)/g,��); //ȥ���߿ո�;
 if(sDate==��) return true;
 //�����ʽ����YYYY-(/)MM-(/)DD��YYYY-(/)M-(/)DD��YYYY-(/)M-(/)D��YYYY-(/)MM-(/)D���滻Ϊ��
 //���ݿ��У��Ϸ����ڿ�����:YYYY-MM/DD(2003-3/21),���ݿ���Զ�ת��ΪYYYY-MM-DD��ʽ
 var s = sDate.replace(/[\d]{ 4,4 }[\-/]{ 1 }[\d]{ 1,2 }[\-/]{ 1 }[\d]{ 1,2 }/g,��);
 if (s==��) //˵����ʽ����YYYY-MM-DD��YYYY-M-DD��YYYY-M-D��YYYY-MM-D
 {
 var t=new Date(sDate.replace(/\-/g,'/'));
 var ar = sDate.split(/[-/:]/);
 if(ar[0] != t.getYear() || ar[1] != t.getMonth()+1 || ar[2] != t.getDate())
 {
 //alert('��������ڸ�ʽ����ʽΪ��YYYY-MM-DD��YYYY/MM/DD��ע�����ꡣ');
 return false;
 }
 }
 else
 {
 //alert('��������ڸ�ʽ����ʽΪ��YYYY-MM-DD��YYYY/MM/DD��ע�����ꡣ');
 return false;
 }
 return true;
 }

 //+����������������������������������
 //| ����ʱ����
 //| ��ʽΪ��YYYY-MM-DD HH:MM:SS
 //+����������������������������������
 function CheckDateTime(str)
 {
 var reg = /^(\d+)-(\d{ 1,2 })-(\d{ 1,2 }) (\d{ 1,2 }):(\d{ 1,2 }):(\d{ 1,2 })$/;
 var r = str.match(reg);
 if(r==null)return false;
 r[2]=r[2]-1;
 var d= new Date(r[1],r[2],r[3],r[4],r[5],r[6]);
 if(d.getFullYear()!=r[1])return false;
 if(d.getMonth()!=r[2])return false;
 if(d.getDate()!=r[3])return false;
 if(d.getHours()!=r[4])return false;
 if(d.getMinutes()!=r[5])return false;
 if(d.getSeconds()!=r[6])return false;
 return true;
 }

 //+����������������������������������
 //| �����ڷָ������
 //+����������������������������������
 Date.prototype.toArray = function()
 {
 var myDate = this;
 var myArray = Array();
 myArray[0] = myDate.getFullYear();
 myArray[1] = myDate.getMonth();
 myArray[2] = myDate.getDate();
 myArray[3] = myDate.getHours();
 myArray[4] = myDate.getMinutes();
 myArray[5] = myDate.getSeconds();
 return myArray;
 }

 //+����������������������������������
 //| ȡ������������Ϣ
 //| ���� interval ��ʾ��������
 //| y �� m�� d�� w���� ww�� hʱ n�� s��
 //+����������������������������������
 Date.prototype.DatePart = function(interval)
 {
 var myDate = this;
 var partStr=��;
 var Week = ['��','һ','��','��','��','��','��'];
 switch (interval)
 {
 case ��y' :partStr = myDate.getFullYear();break;
 case ��m' :partStr = myDate.getMonth()+1;break;
 case ��d' :partStr = myDate.getDate();break;
 case ��w' :partStr = Week[myDate.getDay()];break;
 case ��ww' :partStr = myDate.WeekNumOfYear();break;
 case ��h' :partStr = myDate.getHours();break;
 case ��n' :partStr = myDate.getMinutes();break;
 case 's' :partStr = myDate.getSeconds();break;
 }
 return partStr;
 }

 //+����������������������������������
 //| ȡ�õ�ǰ���������µ��������
 //+����������������������������������
 Date.prototype.MaxDayOfDate = function()
 {
 var myDate = this;
 var ary = myDate.toArray();
 var date1 = (new Date(ary[0],ary[1]+1,1));
 var date2 = date1.dateAdd(1,'m',1);
 var result = dateDiff(date1.Format('yyyy-MM-dd'),date2.Format('yyyy-MM-dd'));
 return result;
 }

 //+����������������������������������
 //| ȡ�õ�ǰ������������һ���еĵڼ���
 //+����������������������������������
 Date.prototype.WeekNumOfYear = function()
 {
 var myDate = this;
 var ary = myDate.toArray();
 var year = ary[0];
 var month = ary[1]+1;
 var day = ary[2];
 document.write('< script language=VBScript\> \n');
 document.write('myDate = DateValue(��+month+'-'+day+'-'+year+��) \n');
 document.write('result = DatePart('ww', myDate) \n');
 document.write(' \n');
 return result;
 }

 //+����������������������������������
 //| �ַ���ת����������
 //| ��ʽ MM/dd/YYYY MM-dd-YYYY YYYY/MM/dd YYYY-MM-dd
 //+����������������������������������
 function StringToDate(DateStr)
 {

 var converted = Date.parse(DateStr);
 var myDate = new Date(converted);
 if (isNaN(myDate))
 {
 //var delimCahar = DateStr.indexOf('/')!=-1?'/':'-';
 var arys= DateStr.split('-');
 myDate = new Date(arys[0],�Carys[1],arys[2]);
 }
 return myDate;
 }
 
 /**
 *����radio ��ȡ��ѡ��
 */
  	var bnVal = '';	
	function test(bn){
		
		if(bn.flag == 1 && bn.value == bnVal ){
			bn.checked = false;
			bn.flag = 0;
		}else{
			bn.flag = 1;
			bnVal = bn.value;
		}
	}
 //��֤�Ƿ�Ϊ�գ�Ϊ����(double����)���Ƿ񳬳�
 function checkData(){
	var re = /^(-?\d+)(\.\d+)?$/;
	var inputs = document.forms[0].elements;
	for(var i=0;i<inputs.length;i++){
		if(inputs[i].need){
			if(inputs[i].value.replace(/(^\s+)|\s+$/g,"") == ''){
				alert(inputs[i].disName+'����Ϊ�� !');
				inputs[i].focus();
				return false;
			}
		}
		if(inputs[i].isNumber){
			if(!re.test(inputs[i].value)){
				alert('��������ȷ���ָ�ʽ!');
				inputs[i].select();
				return false;
			}
		}
		if(inputs[i].range){
			
			var ranges = inputs[i].range.split(',');
			if(ranges.length!=1){
				var tempVals = inputs[i].value.split('.');
				if(tempVals[0].length > (ranges[0]-ranges[1]) || (tempVals[1] && tempVals[1].length > ranges[1])){
					alert('¼�����ֳ�����Χ!');
					inputs[i].select();
					return false;
				}
			}else{
				if(inputs[i].value.length > ranges[0]){
					alert("¼����Ϣ������Χ!");
					inputs[i].select();
					return false;
				}
			}
		}
	}
	return true;
 }