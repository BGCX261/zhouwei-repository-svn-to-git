
<%@ page language="java" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>svg test</title>
</head>
<SCRIPT LANGUAGE="javascript" >
function ColorClick()
{
    var svgdoc = document.test.getSVGDocument();

	// Now change the SVG element's fill-opacity.
	var svgobj = svgdoc.getElementById('中文');
	if (svgobj != null)
	{
		//svgobj.setAttribute("stroke","#000000");
		svgobj.setAttribute("stroke","red");
	}
	// Propagate the event to other handlers.
	return true;
 }
</SCRIPT>
<body>

<EMBED name=test pluginspage=http://www.adobe.com/svg/viewer/install/ 
src="/framework/workflow.do?method=getGpd&taskId=<%=request.getParameter("taskId")%>" 
width=400 height=300 type=image/svg+xml> 

<input name="dd" type="button" onClick="ColorClick()" value="dd">
</body>
</html>