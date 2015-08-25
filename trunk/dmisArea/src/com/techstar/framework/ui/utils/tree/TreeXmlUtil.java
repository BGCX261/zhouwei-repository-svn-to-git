package com.techstar.framework.ui.utils.tree;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import com.techstar.framework.utils.AppHelper;
import com.techstar.framework.ui.entity.DhtmlxTreeNodeDis;
import com.techstar.framework.ui.entity.DhtmlTreeSqlObj;
import com.techstar.framework.utils.ConfigurationHelper;




public class TreeXmlUtil {
	
	public static Map treeobjsmap = null;
	
	
	/**
	 * 根据 树的名称,节点的名称 取得节点描述对象
	 * @param treeName  树的名称
	 * @param nodeName  节点的名称
	 * @return 
	 */
	public   DhtmlxTreeNodeDis getNodeDis(String treeName ,String nodeName){
		if(treeobjsmap==null)
			loadXmlToMap();
		//System.out.println("treeddddis"+treeName+ "  "+nodeName);
		Object[] treeNodeobject = (Object[])((Map)treeobjsmap.get(treeName)).get(nodeName);
		return (DhtmlxTreeNodeDis)treeNodeobject[0];
	}
	
		
	/**
	 * 根据 树的名称,节点的名称 取得节点描述对象的子节点描述对象
	 * @param treeName
	 * @param nodeName
	 * @return
	 */
	public  List getChildrenNodeDis(String treeName ,String nodeName){
		if(treeobjsmap==null)
			loadXmlToMap();
		Object[] treeNodeobject = (Object[])((Map)treeobjsmap.get(treeName)).get(nodeName);
		return (List)treeNodeobject[1];
	}
	
	
	
	
	/**
	 * 树描述的xml文件封状到map 里 
	 *
	 */
	private   void loadXmlToMap(){
		treeobjsmap =  new HashMap();
		File[] filespath = getTreeDisXml();
		try{
			for(int h=0;h<filespath.length;h++){
				Document  doc = getFileDoc(filespath[h].getPath());
				Element root = doc.getRootElement();
				List treeidss = root.getChildren("treeobj-dis");
				
				
				//循环取得每棵树	
				for(int i=0;i<treeidss.size();i++)
				{
					Element treedis = (Element)treeidss.get(i);
					Map treeobj_dismap = new HashMap();
					List nodediss = treedis.getChildren("node-dis");
					//System.out.println(nodediss.size());
					
					
					//循环取得节点描述对象
					for(int j=0;j<nodediss.size();j++)
					{
						Element nodedis = (Element)nodediss.get(j);
						DhtmlxTreeNodeDis treeNodeDis = new DhtmlxTreeNodeDis();
						treeNodeDis.setTreeName(treedis.getAttributeValue("treename"));
						treeNodeDis.setDataSource(treedis.getAttributeValue("datasSrc"));
						//System.out.println("nademane="+nodedis.getAttributeValue("nodeName"));
						treeNodeDis = tranElementToNodeDis(treeNodeDis,nodedis);
						
						
						
						//循环取得子描述树节点对象
						List  childlist = new ArrayList();
						for(int k=0;k<nodediss.size();k++)
						{
							Element childnodedel = (Element)nodediss.get(k);
							String parentdisname = childnodedel.getChildText("parentNodeDis");
							
							if(parentdisname!=null&&!parentdisname.equals(""))
							{   
								String[] parrents = parentdisname.split(",");
								System.out.println(parrents.length);
								for(int d =0;d<parrents.length;d++)
								{
										System.out.println(nodedis.getAttributeValue("nodeName"));
										if(parrents[d].equals(nodedis.getAttributeValue("nodeName")))
										{
											DhtmlxTreeNodeDis childnodedis = new DhtmlxTreeNodeDis();
											childnodedis.setTreeName(treedis.getAttributeValue("treename"));
											childnodedis.setDataSource(treedis.getAttributeValue("datasSrc"));
											childnodedis = tranElementToNodeDis(childnodedis,childnodedel);
											childlist.add(childnodedis);
										}
								}
							}
						}
						//把节点描述对象和他的子节点描述对象list封装在一个Objecc[]里	
						Object[] disnoobj = new Object[]{treeNodeDis,childlist};
						//把objec[]封装在一个map里这个map 代表一个树的描述	
						treeobj_dismap.put(treeNodeDis.getNodeName(), disnoobj);
					}
					
					
					treeobjsmap.put(treedis.getAttributeValue("treename"), treeobj_dismap);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("loadXmlToMap 出现错误");
			e.printStackTrace();
		}
	}
	

	
	
	
	
	
	/**
	 * 把从xml里获得的element的信息放到树节点的描述对象里
	 * @param DhtmlxTreeNodeDis treeNodeDis: 树节点的描述对象
	 * @param Element nodedis:xml 里的节点
	 * @return  DhtmlxTreeNodeDis : 返回树节点的描述对象
	 */

	private  DhtmlxTreeNodeDis  tranElementToNodeDis(DhtmlxTreeNodeDis treeNodeDis,Element nodedis){
		treeNodeDis.setNodeName(nodedis.getAttributeValue("nodeName"));
		treeNodeDis.setIdField(nodedis.getChildText("idField"));
		treeNodeDis.setTextField(nodedis.getChildText("textField"));
		
		
		//String pchildnodis = nodedis.getChildText("pchildNodis");
		//if(pchildnodis!=null&&!pchildnodis.equals(""))
			//treeNodeDis.setPchildNodis(pchildnodis);
		
		
		
		String tableName = nodedis.getChildText("tableName");
		if(tableName!=null&&!tableName.equals(""))
			treeNodeDis.setTableName(tableName);
		
		String userDataField = nodedis.getChildText("userDataField");
		if(userDataField!=null&&!userDataField.equals(""))
			treeNodeDis.setUserDataField(userDataField);
		
		
	   //实体的名称
       String entityClass = nodedis.getChildText("entityClass");
       if(entityClass!=null&&!entityClass.equals(""))
			treeNodeDis.setEntityClass(entityClass);
       
		//获得sqlObj element
		List sqlobj = nodedis.getChildren("sqlObj");
		if(sqlobj!=null&&sqlobj.size()!=0){
			//System.out.println("wwwwwwwwww");
			for(int i=0;i<sqlobj.size();i++){
				//treeNodeDis.setSql(tranElementToSqlObj((Element)sqlobj.get(0)));
				treeNodeDis.setSql(tranElementToSqlObj((Element)sqlobj.get(i)));
			}
		
		}
		
		
		
		//String parentName = nodedis.getChildText("parentNodeDis");
		
		//if(parentName!=null&&!parentName.equals(""))
			//treeNodeDis.setParentNodeDis(parentName);
		
	
		return treeNodeDis;
	}
	
	
	
	
	/**
	 * 把Element 转化成SqlObj
	 * @param sqlobj : xml的sqlObj的节点
	 * @return SqlObj的对象
	 */
	private  DhtmlTreeSqlObj tranElementToSqlObj(Element sqlobj){
		DhtmlTreeSqlObj  sql = new DhtmlTreeSqlObj();
		//System.out.println("ssssbody="+(String)sqlobj.getChildText("sqlBody"));
		sql.setSqlName((String)sqlobj.getAttributeValue("sqlName"));
		sql.setRefName((String)sqlobj.getAttributeValue("refName"));
		sql.setSqlBody((String)sqlobj.getChildText("sqlBody"));
		sql.setSqlPramaFrom((String)sqlobj.getChildText("sqlParamFrom"));
		return sql;
		
	}
	
	/**
	 * 通用用于String转化成jdomdocument对象
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public  Document getConfDoc(String content) throws Exception {
		Document doc = null;
		System.out.println("系统得到content是"+content);
		try 
		{
			content = content.trim();
			SAXBuilder builder = new SAXBuilder(false);
			doc = builder.build(new StringReader(content));
		} 
		catch (Exception e) 
		{
			System.out.println("FilterParse Exception: from getConfDoc;");
			e.printStackTrace();
		}
		return doc;
	}
    
	
	
	
	/**
	 * 通用用于String转化成jdomdocument对象
	 * @param content
	 * @return
	 * @throws Exception
	 */
	private   Document getFileDoc(String filepath) throws Exception {
		Document doc = null;
		System.out.println("filepath"+filepath);
		try 
		{
			SAXBuilder builder = new SAXBuilder(false);
			doc = builder.build(new FileReader(filepath));
		} 
		catch (Exception e) 
		{
			System.out.println("FilterParse Exception: from getFileDoc;");
			e.printStackTrace();
		}
		return doc;
	}
	
	
	/**
	 * 得到treedis.xml 路径
	 * @param args
	 */
	private   File[]  getTreeDisXml(){
		//String webapppath = AppHelper.getWebAppPath();
		//System.out.println(webapppath+Constants.TREEDIS_PATH);
		return ConfigurationHelper.getTreeDisFile();
		//return webapppath+Constants.TREEDIS_PATH;
	}
	
	
	
	public static void main(String[] args){
		try{
		TreeXmlUtil util = new TreeXmlUtil();
		//util.loadXmlToMap();
		//Map map = (Map)treeobjsmap.get("tree2");
		DhtmlxTreeNodeDis dis = (DhtmlxTreeNodeDis)util.getNodeDis("entitytree1", "t1");
		//System.out.println(dis.getPchildNodis()+dis.getTextField());
		//System.out.println(dis.getParentNodeDis());
		List childdis = dis.getChildsNodeDis();
		System.out.println("gggggggg"+childdis.size());
		Iterator it = childdis.iterator();
		while(it.hasNext())
		{
			DhtmlxTreeNodeDis chi = (DhtmlxTreeNodeDis)it.next();
			//if(chi.getSqlByName("t2")!=null){
			//System.out.println(chi.getSqlByRefName("proresource").getSqlBody()+" "+chi.getSqlByName("resourcesql2").getRefName());
			//}
			//System.out.println(chi.getSqlByRefName("proresource").getSqlBody()+" "+chi.getSqlByName("resourcesql").getRefName());
			System.out.println(chi.getDataSource()+" "+chi.getEntityClass());
			//System.out.println(chi.getSql().getSqlBody());
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
