package com.techstar.framework.ui.entity;
import java.util.*;

import com.techstar.framework.ui.utils.tree.TreeXmlUtil;




/**
 * 封状节点的描述的信息以及生成节点的规则
 * @author gaojing
 *
 */
public  class DhtmlxTreeNodeDis extends BaseNodeDis {
	
	
	//dhtmlxTree Id 对应实体的属性名称
	
	private String idField = "";
	
	//dhtmlxTree text 对应的实体的属性名称
	private String textField = "";
	
	//子描述节点对象所对应的父描述节点对象的名称
    private String parentNodeDis = "";
    
    //对应子描述节点对象
    private List childsNodeDis = null;
    
    //节点描述对应的表 当没有表的名称时表示的是虚节点
    private String tableName="";
    
    //描述获得业务实体的过滤条件
    private DhtmlTreeSqlObj sql = null;
    
    //存储的sqlMap key:refName
    private Map   sqlObjRef = new HashMap();
    //存储的sqlMap key:sqlName
    private Map   sqlObj = new HashMap();
    //描述业务实体里用户所关心的业务属性;
    private String userDataField ="";
    private String entityClass="";//对应的业务实体
    
    
    
    
    public void setIdField(String idField){
    	this.idField = idField;
    }
    public String getIdField(){
    	return this.idField;
    }
    
    public void setTextField(String textField){
    	this.textField = textField;
    }
    public String getTextField(){
    	return this.textField;
    }
    
    
    
    public void setTableName(String tableName){
    	this.tableName = tableName;
    }
    public String getTableName(){
    	return this.tableName;
    }
    
    public void setSql(DhtmlTreeSqlObj sql){
    	this.sqlObj.put(sql.getSqlName(), sql);
    	if(sql.getRefName()!=null&&!sql.getRefName().equals(""))
    			this.sqlObjRef.put(sql.getRefName(), sql);
    }
    public DhtmlTreeSqlObj getSql(){
    	return this.sql;
    }
    
    public DhtmlTreeSqlObj getSqlByName(String sqlname){
    	return (DhtmlTreeSqlObj)this.sqlObj.get(sqlname);
    }
    /**
     * 通过refName查找sqlObj
     * @param refName
     * @return
     */
    public DhtmlTreeSqlObj getSqlByRefName(String refName){
    	DhtmlTreeSqlObj obj = null;
    	
    	if(sqlObjRef.size()!=0){
    		obj =  (DhtmlTreeSqlObj)this.sqlObjRef.get(refName);
    	}else{
    		Iterator it = this.sqlObj.keySet().iterator();
    		while(it.hasNext()){
    			obj =  (DhtmlTreeSqlObj)this.sqlObj.get(it.next());
    		}
    		 
    	}
    	return obj;
    }
    
    public void setUserDataField(String userDataField){
    	this.userDataField = userDataField;
    }
    public String getUserDataField(){
    	return this.userDataField;
    }
    
    

    
    public void setChildsNodeDis(List childs){
    	this.childsNodeDis = childs;
    }
    public List getChildsNodeDis(){
    	if(childsNodeDis==null||childsNodeDis.size()==0)
    	{
    		TreeXmlUtil util = new TreeXmlUtil();
    		childsNodeDis = util.getChildrenNodeDis(this.treeName, this.nodeName);
    	}
    	return this.childsNodeDis;
    }
    
    
    


	public Map getSqlObj() {
		return sqlObj;
	}

	public void setSqlObj(Map sqlObj) {
		this.sqlObj = sqlObj;
	}

	public Map getSqlObjRef() {
		return sqlObjRef;
	}

	public void setSqlObjRef(Map sqlObjRef) {
		this.sqlObjRef = sqlObjRef;
	}

	
	


	public String getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(String entityclass) {
		this.entityClass = entityclass;
	}
	
	
}
