<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true"/>
<html>
<head>
	<%@ include file="/commons/head.jsp"%>
	<title>${key.title}</title>
	<script type="text/javascript">
    	function addOperate(){
    	    ECTableUtil.submit("${ctx}/categoryAction.do?method=doAdd","ec");
    	}
    	function deleteOperate(){
    		ECTableUtil.operateECForm("categoryAction.do?method=doDeleteByIds",null,null ,null ,"true","ec");
    	}
	</script>
</head>
<body style=na'megin:20px;" >

<bean:define id="rownumberKey" type="java.lang.String"><bean:message key="rownumber"/></bean:define> 
<bean:define id="modifyKey" type="java.lang.String"><bean:message key="modify"/></bean:define> 
<bean:define id="nameKey" type="java.lang.String"><bean:message key="name"/></bean:define> 
<bean:define id="descnKey" type="java.lang.String"><bean:message key="descn" /></bean:define> 
  
 
<div id="content">
<%@ include file="/commons/messages.jsp"%>
<ec:table items="CategoryVos" var="Item"
   	view="ssview"   title="${key.formTitle}"
	action="${ctx}/categoryAction.do?method=list"
   	csvFileName="${key.formTitle}.csv"
   	xlsFileName="${key.formTitle}.xls"
   	pdfFileName="${key.formTitle}.pdf"
>
	<ec:row recordKey="${ Item.catid}" rowId="rowid_${GLOBALROWCOUNT}" >
		<ec:column alias="id" cell="checkbox" headerCell="checkbox" property="catid" value="${ Item.catid}" width="50" tagAttributes="align='center'"/>
		<ec:column property="<%=rownumberKey%>" value="${GLOBALROWCOUNT}" title="${key.No}" width="60" tagAttributes="align='center'" resizeColWidth="false"  />
		<ec:column property="<%=modifyKey %>"  title="${ Item.catid}" width="60" errMSG="${ Item.catid}" checkEXP="[notnull]">
			<a href=${ctx}/categoryAction.do?method=doEdit&id=${ Item.catid}>modify</a>
		</ec:column>
		<ec:column property="<%=nameKey%>" value="${ Item.name}" title="${ Item.name}" width="60" errMSG="${ Item.name}" checkEXP="[notnull]"/>
		<ec:column property="<%=descnKey %>" value="${ Item.descn}" title="${ Item.descn}" width="60" errMSG="${ Item.descn}" checkEXP="[notnull]"/>
	</ec:row>
</ec:table>
</div>
<div>
<input type="button" name="add" class="button" value="<bean:message key="add" />" onClick="addOperate()" />
<input type="button" name="delete" class="button" value="<bean:message key="delete" />" onClick="deleteOperate()" />
</div>
<!-- 编辑和过滤所使用的 通用的文本框模板 -->
<textarea id="ecs_t_date" rows="" cols="" style="display:none">
	<input type="text" class="inputtext" value=""
	 style="width:100px;" name="" /><input class="calendarImgButton"
	 onclick="ECTableUtil.showCalendar(this)" type="button"  id="date_button" />
</textarea>

<!-- 编辑和过滤所使用的 通用的文本框模板 -->
<textarea id="ecs_t_input" rows="" cols="" style="display:none">
	<input type="text"  class="inputtext" value="" onblur="ECTableUtil.updateEditCell(this)"
	 style="width:100%;" name="" />
</textarea>

<!-- 编辑性别所用模板 -->
<textarea id="ecs_t_gender" rows="" cols="" style="display:none" >
	<select onblur="ECTableUtil.updateEditCell(this)"
	style="width:100%;" name="GENDER" >
<ec:options items="GENDER_MAP" />
	</select>
</textarea>

<!-- 编辑角色所用模板 -->
<textarea id="ecs_t_role" rows="" cols="" style="display:none" >
	<select onblur="ECTableUtil.updateEditCell(this)"
	style="width:100%;" name="USERROLE" >
<ec:options items="USERROLE_MAP" />
	</select>
</textarea>

<!-- 新建记录所用模板 -->
<textarea id="add_template" rows="" cols="" style="display:none">
&#160;
<tpsp />
&#160;
<tpsp />
<tpsp />
<input type="text" id="" name="categoryName" class="inputtext" value="" />
<tpsp />
<input type="text" id="" name="categoryDes" class="inputtext" value="" />
&#160;
<tpsp />
<tpsp />
&#160;
</textarea>
</body>
</html>
