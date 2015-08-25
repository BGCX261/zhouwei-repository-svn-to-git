package com.techstar.framework.ui.utils.tree;

import java.util.*;
import com.techstar.framework.ui.entity.DhtmlxTreeNode;



public class NodeXMLHelp {
	
	private List nodes;
	private String lineFlag ="";
	public List getNodes() {
		return nodes;
	}

	public void setNodes(List nodes) {
		this.nodes = nodes;
	}
	
	/**
	 * 该父节点下所有子节点的xml
	 * @param parentNode
	 * @return
	 */
	public String  getAllXmlByParentNode(DhtmlxTreeNode parentNode){
		String datasXml = "<?xml version='1.0' encoding='UTF-8'?>"+this.lineFlag;
		datasXml += "<tree id='"+parentNode.getId()+"'>"+this.lineFlag;
		datasXml += this.createSubXmlAll(parentNode)+this.lineFlag;
		datasXml +="</tree>";
		return datasXml;
	}
	
	
	/**
	 * 通过父节点叠代所有子节点
	 * @param parentNode
	 * @return 返回xml
	 */
	private String createSubXmlAll(DhtmlxTreeNode parentNode){
		//Document doc = DocumentBuilder.;
		String nodexml ="";
		try{
			for(int i=0;i<this.nodes.size();i++){
				DhtmlxTreeNode node =  (DhtmlxTreeNode)nodes.get(i);
				if(node.getParentId().equals(parentNode.getId())){
					String subxml=createSubXmlAll(node);
					nodexml+= tranNodeToXml(node,subxml);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return nodexml;
	}

	/**
	 * 该父节点下的一层子节点的xml
	 * @param parentNode
	 * @return
	 */
	
	public  String getSubXmlByParentNode(DhtmlxTreeNode parentNode){
		String nodexml ="";
		try{
			for(int i=0;i<this.nodes.size();i++){
				DhtmlxTreeNode node =  (DhtmlxTreeNode)nodes.get(i);
				node.setTreeName(parentNode.getTreeName());
				if(node.getParentId().equals(parentNode.getId())){
					nodexml+= tranNodeToXml(node,"",checkHasChildren(node));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		String datasXml = "<?xml version='1.0' encoding='UTF-8'?>"+this.lineFlag;
		datasXml += "<tree id='"+parentNode.getId()+"'>"+this.lineFlag;
		datasXml += nodexml+this.lineFlag;
		datasXml +="</tree>";
		return datasXml;
	}
	
	
	
	
	/**
	 * 判断节点是否有子节点 0 表示无 1表示有
	 * @param parentNode
	 * @return
	 */
	private String  checkHasChildren(DhtmlxTreeNode parentNode){
		String haschild = "0";
		try{
			for(int i=0;i<this.nodes.size();i++){
				DhtmlxTreeNode node =  (DhtmlxTreeNode)nodes.get(i);
				if(node.getParentId().equals(parentNode.getId())){
					return "1";
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return haschild;
	}
	
	
	/**
	 * 把节点对象转化为xml
	 * @param node
	 * @param subXml
	 * @return
	 */
	private String tranNodeToXml(DhtmlxTreeNode node,String subXml){
		 String str= "<item  ";
		 
		 str+= "id='"+node.getId()+"' ";
		 if(node.getIsChecked().equals("1")){
			 str+= "checked='1' ";
		 }
		 if(node.getIsOpen().equals("1")){
			 str+= "open='yes' ";
		 }
		 if(node.getChildFlag().equals("1")){
			 str+= "child='1' ";
		 }
		 str+= "text='"+node.getText()+"' >"+this.lineFlag;
		 str+= "<userdata name='info'>"+node.getTreeName()+";;;"+node.getNodeDisName()+";;;"+node.getUserData()+"</userdata>"+this.lineFlag;
		 str+=""+subXml+this.lineFlag;
		 str+= "</item>"+this.lineFlag;
		 return str;
	}
	
	
	/**
	 * 把节点对象转化为xml带判断是否有子节点
	 * @param node
	 * @param subXml
	 * @return
	 */
	private String tranNodeToXml(DhtmlxTreeNode node,String subXml,String hasChildren){
		 String str= "<item  ";
		 
		 str+= "id='"+node.getId()+"' ";
		 if(node.getIsChecked().equals("1")){
			 str+= "checked='1' ";
		 }
		 if(node.getIsOpen().equals("1")){
			 str+= "open='yes' ";
		 }
		 str+="child='"+hasChildren+"' ";
		 str+= "text='"+node.getText()+"' >"+this.lineFlag;
		 str+= "<userdata name='info'>"+node.getTreeName()+";;;"+node.getNodeDisName()+";;;"+node.getUserData()+"</userdata>"+this.lineFlag;
		 str+=""+subXml+this.lineFlag;
		 str+= "</item>"+this.lineFlag;
		 return str;
	}

	
	
   public  static void main(String[] arg){
	   ArrayList list =new ArrayList();
	   DhtmlxTreeNode node1 =  new DhtmlxTreeNode();
	   node1.setId("1");
	   node1.setText("t1");
	   node1.setIsChecked("1");
	   node1.setParentId("-1");
	   
	   DhtmlxTreeNode node2 =  new DhtmlxTreeNode();
	   node2.setId("2");
	   node2.setText("t2");
	   node2.setIsChecked("1");
	   node2.setParentId("1");
	   
	   DhtmlxTreeNode node3 =  new DhtmlxTreeNode();
	   
	   node3.setId("3");
	   node3.setText("t3");
	   node3.setIsChecked("1");
	   node3.setParentId("1");
	   
	   DhtmlxTreeNode node4 =  new DhtmlxTreeNode();
	   node4.setId("4");
	   node4.setText("t4");
	   node4.setIsChecked("1");
	   node4.setParentId("2");
	   
	   
	   
	   DhtmlxTreeNode node5 =  new DhtmlxTreeNode();
	   node5.setId("5");
	   node5.setText("t5");
	   node5.setIsChecked("1");
	   node5.setParentId("4");
	   
	   
	   
	   DhtmlxTreeNode nodep =  new DhtmlxTreeNode();
	   nodep.setId("-1");
	   
	   list.add(nodep);
	   list.add(node1);
	   list.add(node2);
	   list.add(node3);
	   list.add(node4);
	   list.add(node5);
	   
	 
	   NodeXMLHelp help = new NodeXMLHelp();
	   help.setNodes(list);
	   String xml = help.getAllXmlByParentNode(nodep);
	   
	   String xml2 =help.getSubXmlByParentNode(node2);
	   System.out.println(xml+"\n");
	   System.out.println(xml2+"\n");
	   
   }

}
