<%
/**
 * initialize date css,javascript
 */
%>
<link href="<%=request.getContextPath()%>/themes/themes1/catalina/doc/zpcal.css"    rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/themes/themes1/catalina/doc/template.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/themes/themes1/catalina/themes/system.css" rel="stylesheet" type="text/css"  />

<!-- import the calendar script -->
<script type="text/javascript" src="<%=request.getContextPath()%>/script/calendar/utils.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/script/calendar/calendar.js"></script>

<!-- import the language module -->
<script type="text/javascript" src="<%=request.getContextPath()%>/script/calendar/calendar-zh.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/script/calendar/calendar-setup.js"></script>