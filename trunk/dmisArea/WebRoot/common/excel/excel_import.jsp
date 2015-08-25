<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/script/public.js"> </script>
<html>
	<head>
		<html:base />
		<title>Excel导入</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />

	</head>
	<body>
	 <script type="text/javascript">
	 function ordioClick(strValue)
	 {
	 	document.all.clickValue.value=strValue;
	 
	 }
	function importInfo()
	{
		
		var xls=new ActiveXObject("Excel.Application");
		var newBooks=xls.Workbooks.Open(document.all.filename.value);
		var endrow=xls.ActiveSheet.UsedRange.Rows.Count;		
		var endcol=xls.ActiveSheet.UsedRange.Columns.Count;
		var retValue="1";
		//retValue=document.all.clickValue.value;
	
		//alert(retValue);
		if(retValue=='1')
		{
			for(rowid=1;rowid<=endrow;rowid++){
            //将当前行的数据导入到grid中

				for(colid=1;colid<=endcol;colid++) { 
					retValue+=xls.ActiveSheet.Cells(rowid,colid)+"##";
				}
				retValue+="^^";
			

			}

			if(retValue!="")
			{
				var valuelength=retValue.lastIndexOf("^^");
			
				retValue=retValue.substring(0,valuelength);
			
			}
		
		}
		else//到出xml
		{
			var propertyValue=new Array(endcol);
			
			 for(rowid=1;rowid<=endrow;rowid++){

            	
				for(colid=1;colid<=endcol;colid++) { 
				 	if(rowid==1)
				 	{
				 		propertyValue[colid]=xls.ActiveSheet.Cells(rowid,colid);
				 	}
				 	else
				 	{
				 		retValue+="<"+propertyValue[colid]+">"+xls.ActiveSheet.Cells(rowid,colid)+"</"+propertyValue[colid]+">";
				 	
				 	}
					
				}
				retValue+="";
			

			}
		
		}
		xls.Quit();
		xls=null;
		window.returnValue=retValue;
			window.close();
			//alert(retValue);
            
		}
		function returnCancel()
		{
			window.returnValue="";
			window.close();
		
		}
	
	//xml
</script>
<br>
<br>


			<table  cellspacing="0" cellpadding="0" border=0>
				<tr >
					<td align="center">
						<table  width="100%" height="100%" cellspacing="0">
							<tr>

								<td height="23" width="30%" colspan="3">
									<input type="file" name="filename">
								
								</td>

							</tr>
					<!-- 		<tr>
								<td id='fileType'>
								<center>
								<input type=hidden name='clickValue' value='1' >
									<input type="radio" name="returnType" value="1" onClick='ordioClick(event.srcElement.value);' checked>列表
									&nbsp;&nbsp;&nbsp;
									<input type="radio" name="returnType" value="0" onClick='ordioClick(event.srcElement.value);'>XML 
								</center>	
								</td>
							</tr> 
					 -->
							<tr>
								<td>
								<center>
										<input type="button" name="submit" value="导入"
										onclick="importInfo();">
								
								&nbsp;&nbsp;&nbsp;
										<input type="button" name="cancel" value="取消"
										onclick="returnCancel();">
								</center>
								</td>
							</tr>


						</table>
					</td>
				</tr>
			</table>
		


	</body>
</html>
