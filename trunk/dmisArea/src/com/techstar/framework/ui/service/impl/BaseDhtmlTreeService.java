package com.techstar.framework.ui.service.impl;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.techstar.framework.ui.entity.DhtmlxTreeNode;
import com.techstar.framework.ui.entity.DhtmlxTreeNodeDis;
import com.techstar.framework.ui.service.impl.DhtmlxTreeOperationImpl;
import com.techstar.framework.ui.utils.tree.*;
import com.techstar.framework.ui.service.IDhtmlxTreeService;
public abstract class BaseDhtmlTreeService implements IDhtmlxTreeService{
	
	private DhtmlxTreeOperationImpl op ; 
	
	
	
	public void  setOp(DhtmlxTreeOperationImpl op){
		this.op = op;
	}

	
	/**
	 * 根据父节点取得子节点的xml
	 * @param node
	 * @return
	 */
	public String getTreexmlByParentNode(DhtmlxTreeNode node,Map params){
		StringBuffer buff =  new StringBuffer();
		try{
			op.setParamap(params);
			Map nodemap = op.getNodeMapByPrentNode(node);
			buff.append("<?xml version='1.0' encoding='UTF-8'?>");
			buff.append("<tree id='"+node.getId()+"'>");
			if(nodemap.containsKey(Constants.NODIS_PRODUCE)){
				DhtmlxTreeNode paroduce = (DhtmlxTreeNode)nodemap.get(Constants.NODIS_PRODUCE);
				paroduce = doChange(paroduce);
				String createstr= "<item ";
				//判断虚节点是否有子节点
				if(paroduce.getChildFlag().equals("1")){
					createstr+= "child='1'  open='yes' ";
				}else{
					createstr+= "child='0' ";
				}
				
				createstr+= "id='"+paroduce.getId()+"' ";
				 if(paroduce.getIsChecked().equals("1"))
					 createstr+="checked='1' ";
					 
				createstr+= "text='"+paroduce.getText()+"' >";
				createstr+= "<userdata name='info'>"+paroduce.getTreeName()+";;;"+paroduce.getNodeDisName()+";;;"+paroduce.getUserData()+"</userdata>";
				buff.append(createstr);
				nodemap.remove(Constants.PARENT_NODE);
				nodemap.remove(Constants.NODIS_PRODUCE);
				String substr = tranNodeMapToXMLStr(nodemap);
				buff.append(substr);
				buff.append("</item>");
			}else{
				nodemap.remove(Constants.PARENT_NODE);
				String str = tranNodeMapToXMLStr(nodemap);
				buff.append(str);
			}
			
			buff.append("</tree>");
		}catch(Exception e){
			e.printStackTrace();
		}
		//System.out.println(buff.toString());
		return buff.toString();
	}
	
	
	/**
	 * 把节点集合转化成xml
	 * @param nodeMap
	 * @return
	 */
	protected String tranNodeMapToXMLStr(Map nodeMap){
		StringBuffer buff =  new StringBuffer();
		try
		{
			 Set keyset = nodeMap.keySet();
			 Iterator keyit = keyset.iterator();
			 while(keyit.hasNext())
			 {
				 DhtmlxTreeNodeDis dis = (DhtmlxTreeNodeDis)keyit.next();
				 List list =  (List)nodeMap.get(dis);
				 for(int i =0;i<list.size();i++)
				 {
					 DhtmlxTreeNode node = (DhtmlxTreeNode)list.get(i);
					 node = doChange(node);
					 String item = creatItem(node);
					 buff.append(item);
				 }
			 }
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//System.out.println(buff.toString());
		return buff.toString();
	}
	
	/**
	 * 把节点对象转化成xml的item
	 * @param node
	 * @return
	 */
	protected String creatItem(DhtmlxTreeNode node){
		 String str= "<item  ";
		 str+= "child='"+node.getChildFlag()+"' ";
		 str+= "id='"+node.getId()+"' ";
		 if(node.getIsChecked().equals("1"))
			 str+="checked='1' ";
		 if(node.getIsOpen().endsWith("1"))
		 	 str+="open='yes' ";
		 str+= "text='"+node.getText()+"' >";
		 str+= "<userdata name='info'>"+node.getTreeName()+";;;"+node.getNodeDisName()+";;;"+node.getUserData()+"</userdata>";
		 str+= "</item>";
		 return str;
	 }	
	
	
	
	/**
	 * 根据节点信息对节点作修改
	 * @param node
	 * @return
	 */
	public abstract DhtmlxTreeNode doChange(DhtmlxTreeNode node);
	 
   
}

