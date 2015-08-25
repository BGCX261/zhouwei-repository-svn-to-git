
package com.techstar.framework.ui.entity;

import java.io.Serializable;
import java.util.Map;


/**
 * 封装节点的信息
 * @author gaojing
 *
 */
public class DhtmlxTreeNode implements Serializable{
	private String id ="";//节点的Id
	private String text="";//节点显示的名称
	private String childFlag="";//是否有子节点 1:有 0:无
	private String userData="";//用户关心的信息
	private String nodeDisName="";//树节点在描述文件里对应的DisNode name
	private String treeName="";//树节点在描述文件里对应的treename
	private Map    childsqlparams;// 查询子节点的sql参数
	private DhtmlxTreeNodeDis nodeDis;//树节点在描述文件里对应的DisNode
	private String parentId ="";//父节点的id;
	private String isOpen="";//该节点是否打开　１：为打开　０：为不打开
	private String isChecked="";//该节点是否被选种1:为选种 其他为不被选种
	
	
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}
	
	
	
	public void setText(String text ){
		this.text = text;
	}
	public String getText(){
		return this.text;
	}
	
	
	
	public void setChildFlag(String childFlag){
		this.childFlag = childFlag;
	}
	public String getChildFlag(){
		return this.childFlag;
	}
	
	
	public void setNodeDis(DhtmlxTreeNodeDis NodeDis){
		this.nodeDis = NodeDis;
	}
	public DhtmlxTreeNodeDis getNodeDis(){
		return this.nodeDis;
	}
	
	
	
	public void setUserData(String userDate){
		this.userData = userDate;
	}
	public String getUserData(){
		return this.userData;
	}
	
	
	
	public void setNodeDisName(String nodeDisName){
		this.nodeDisName = nodeDisName;
	}
	public String getNodeDisName(){
		return this.nodeDisName;
	}
	
	
	
	
	public void setTreeName(String treeName){
	    	this.treeName = treeName;
	    }
	   public String getTreeName(){
		   return this.treeName;
	   }
	public Map getChildsqlparams() {
		return childsqlparams;
	}
	public void setChildsqlparams(Map childsqlparams) {
		this.childsqlparams = childsqlparams;
	}
	public String getIsChecked() {
		return isChecked;
	}
	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}
	public String getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
}
