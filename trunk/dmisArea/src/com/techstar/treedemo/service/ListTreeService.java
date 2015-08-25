package com.techstar.treedemo.service;
import java.util.*;

import com.techstar.framework.ui.utils.tree.NodeXMLHelp;
import com.techstar.framework.ui.utils.tree.NodesListPool;
import com.techstar.framework.ui.entity.DhtmlxTreeNode;
public class ListTreeService {
	
	
	/**
	 * 一次性获取数据
	 * @param treeNode
	 * @return
	 */
	public String getTreeXml(DhtmlxTreeNode treeNode){
		
		List list = this.initDatas();
		NodeXMLHelp help = new NodeXMLHelp();
		help.setNodes(list);
		String xml = help.getAllXmlByParentNode(treeNode);
		return xml;
	}
	
	
	
   /**
    * 把数据加到内存中分步取数
    * @param treeNode
    * @return
    */
    
	public String getTreeXml2(DhtmlxTreeNode treeNode){
		List list;
		if(NodesListPool.isObjectInPool(treeNode.getTreeName())){
			list = (List)NodesListPool.getObject(treeNode.getTreeName());
			System.out.println("ffffffffffffffff");
		}else{
			list = this.initDatas();
			NodesListPool.setObject(treeNode.getTreeName(), list);
			System.out.println("dddddddddddddddd");
		}
		NodeXMLHelp help = new NodeXMLHelp();
		help.setNodes(list);
		String xml = help.getSubXmlByParentNode(treeNode);
		System.out.println(xml);
		return xml;
		
	}
	
	
	
	/**
	 * 把数据加到内存中但刷新根节点的时候要从新取得数据
	 * @param treeNode
	 * @return
	 */
	public String getTreeXml3(DhtmlxTreeNode treeNode){
		List list;
		if(NodesListPool.isObjectInPool(treeNode.getTreeName())){
			String pp = treeNode.getTreeName();
			Object[] o = (Object[])NodesListPool.getObject(treeNode.getTreeName());
			String id = (String)o[0];
			if(!id.equals(treeNode.getId())){
				list = (List)o[1];
				System.out.println("ffffffffffffffff");
			}else{
				list = this.initDatas();
				Object[] o1={treeNode.getId(),list};
				NodesListPool.setObject(treeNode.getTreeName(), o1);
				System.out.println("grrrrrrrrrrrrrrrrrrrr");
			}
			
		}else{
			list = this.initDatas();
			Object[] o={treeNode.getId(),list};
			NodesListPool.setObject(treeNode.getTreeName(), o);
			System.out.println("dddddddddddddddd");
		}
		
		
		NodeXMLHelp help = new NodeXMLHelp();
		help.setNodes(list);
		String xml = help.getSubXmlByParentNode(treeNode);
		System.out.println(xml);
		return xml;
	}
	
	
	private ArrayList initDatas(){
		 ArrayList list =new ArrayList();
		   DhtmlxTreeNode node1 =  new DhtmlxTreeNode();
		   node1.setId("1");
		   node1.setText("t1");
		   node1.setIsChecked("1");
		   node1.setParentId("zsy");
		  
		   
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
		   return list;
	}
	
	
}
