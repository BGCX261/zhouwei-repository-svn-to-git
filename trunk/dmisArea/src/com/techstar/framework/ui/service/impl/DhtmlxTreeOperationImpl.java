package com.techstar.framework.ui.service.impl;
import java.util.*;
import com.techstar.framework.dao.*;
import com.techstar.framework.ui.utils.tree.*;
import com.techstar.framework.ui.entity.DhtmlxTreeNode;
import com.techstar.framework.ui.entity.DhtmlxTreeNodeDis;

/**
 * 节点的通用操作
 * @author gaojing
 *
 */


public class DhtmlxTreeOperationImpl{

	private  IBaseJdbcDao baseJdbcDao  ;
	
	public void setBaseJdbcDao(IBaseJdbcDao dao){
		this.baseJdbcDao = dao;
	}
	
    private Map paramap;//根据业务产生的sql条件 key是sqlName value是对应的条件语句
	public void setParamap(Map paramap){
		this.paramap = paramap;
	}
	/**
	 * 通过父节点查找子节点
	 * @param parentnode 父节点对象
	 * @return map key:子节点描述对象 value:List  里边存放子节点对象
	 */
	
	public Map  getNodeMapByPrentNode(DhtmlxTreeNode parentnode){
		Map nodeMap = new HashMap();
		Map resutlMap = new HashMap();
		DhtmlxTreeNode produceNode = null;
		try
		{   DhtmlxTreeNodeDis dis = this.getDhtmlxTreeNodeDisByNode(parentnode);
			//第一次加载的时候如果为虚节点时把虚节点的描述对象直接转化为节点对象
			if ((dis.getTableName()==null||dis.getTableName().equals(""))&&!dis.getIdField().equals(parentnode.getId()))

			{   
				produceNode = new DhtmlxTreeNode();
				produceNode.setId(dis.getIdField());
				produceNode.setText(dis.getTextField());
				produceNode.setTreeName(dis.getTreeName());
				produceNode.setNodeDisName(dis.getNodeName());
				produceNode.setUserData(dis.getUserDataField());		
				//把虚节点转化为他相关的子节点的描述对象
				parentnode = produceNode;
				//produceNode.setNodeDisName(dis.getPchildNodis());
			
			}
			long start = System.currentTimeMillis();
			resutlMap = getChildrenResultByNode(parentnode);//查找子节点记录
			//当有虚节点是判断数据库是否有记录
			if(produceNode!=null&&resutlMap.size()==0){
				produceNode.setChildFlag("0");
			}else if(produceNode!=null&&resutlMap.size()>0){
				produceNode.setChildFlag("1");
			}
			long end = System.currentTimeMillis();
			System.out.println("getdatesult is :"+(end-start));
			nodeMap = this.tanResultMapToNodeMap(resutlMap);//把子节点记录转化成子节点
			System.out.println("get nodeMap is :"+(System.currentTimeMillis()-end));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		nodeMap.put(Constants.PARENT_NODE, parentnode);
		//把虚节点放入nodeMap
		if(produceNode!=null)
			nodeMap.put(Constants.NODIS_PRODUCE, produceNode);
		return nodeMap;
	}
	
	
	/**
	 * 同过节点对象 查找子节点的记录集
	 * @param parentnode 父节点
	 * @return  map key:节点描述对象 value :list 里边存放节点的数据库记录 一条记录对应一个map
	 */
	public  Map  getChildrenResultByNode(DhtmlxTreeNode parentnode){
		
		Map resultMap = new HashMap();
		try
		{  
			//获得节点描述对象
			DhtmlxTreeNodeDis dis = this.getDhtmlxTreeNodeDisByNode(parentnode);
			SqlHelp sqlhelp = new SqlHelp();
			//sqlmap  key :为子节点描述对象 value:拼好的sql
			Map  SqlMap  =  sqlhelp.getChildsSqlByDisAndNode(dis, parentnode,paramap);
			//map key:节点描述对象 value :list 里边存放节点的数据库记录 一条记录对应一个map
			resultMap = getNodesFromSqlMap(SqlMap);
		}
		catch(Exception e){e.printStackTrace();}
		return resultMap;
	}
   
	

	
	
	
	/**
	 * 通过 sqlMap 获得节点记录的map
	 * @param SqlMap key:节点描述对象 value:节点描述对象所拼出来的sql
	 * @return Map key:节点描述对象 value 为List:符合描述的节点数据
	 */
	
	private Map getNodesFromSqlMap(Map SqlMap){
		Map resultMap = new HashMap();
		try{
			if(SqlMap!=null&&!SqlMap.isEmpty())
			{
				Set keys = SqlMap.keySet();
				Iterator it  = keys.iterator();
				while(it.hasNext())
				{   
					//获得节点描述对象
					DhtmlxTreeNodeDis childdis = (DhtmlxTreeNodeDis)it.next();
					//取出对应的sql
					String sql = (String)SqlMap.get(childdis);
					//数据库查找 每条记录对应一个map
					System.out.println("sql="+sql);
					List resultlist = new ArrayList();
					if(sql!=null&&!sql.equals(""))
					    resultlist = (List)baseJdbcDao.queryForListBySql(sql);
					System.out.println("条数:"+resultlist.size());
					if(resultlist!=null&&resultlist.size()>0)
						resultMap.put(childdis, resultlist);
				}
			}
		}catch(Exception e){e.printStackTrace();}
		return resultMap;
	}
	
	
	
	
	/**
	 * 把resultMap转化成NodeMap
	 * @param resultMap key 节点描述对象 value :list 封装对应的数据库记录 每条记录对应一个map
	 * @return map key 节点描述对象 value:list 里边存放节点对象
	 */
	private Map tanResultMapToNodeMap(Map resultMap){
		Map nodeMap = new HashMap();
		Iterator keys = resultMap.keySet().iterator();
		while(keys.hasNext())
		{
			DhtmlxTreeNodeDis dis = (DhtmlxTreeNodeDis)keys.next();
			//把记录List 转化成node list
			List list = tranResultListToNodeList(dis,(List)resultMap.get(dis));
			nodeMap.put(dis, list);
		}
		return nodeMap;
	}
	
	
	
	/**
	 * 把数据结果按照描述对象转化成节点对象
	 * @param dis 节点描述对象
	 * @param resultlist    封装对应的数据库记录 每条记录对应一个map
	 * @return list 里边存放节点对象
	 */
	
	private  List tranResultListToNodeList(DhtmlxTreeNodeDis dis,List resultlist){
		List treeNodeList = new ArrayList();
		try
		{
			if(resultlist!=null&&resultlist.size()!=0)
			{
				for (int i =0;i<resultlist.size();i++)
				{
					Map recordmap = (Map) resultlist.get(i);
					//把map转化为节点对象
					DhtmlxTreeNode node = tranMapToTreeNode(dis,recordmap);
					treeNodeList.add(node);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return treeNodeList;
	}
	
	
	
	
	/**
	 * 通过节点描述对象,把数据库的记录导入节点对象
	 * @param dis   节点描述对象
	 * @param resultMap 为数据库的一条记录
	 * @return 节点对象
	 */
	
	private DhtmlxTreeNode  tranMapToTreeNode(DhtmlxTreeNodeDis dis,Map resultMap){
		DhtmlxTreeNode node = new DhtmlxTreeNode();
		node.setTreeName(dis.getTreeName());
		node.setNodeDisName(dis.getNodeName());
		node.setId(fieldToString(resultMap,dis.getIdField()));
		node.setText(tranText(resultMap,dis.getTextField()));
		node.setUserData(tranUserDate(resultMap,dis.getUserDataField()));
		node.setNodeDis(dis);
		String havechild = checkHaveChildren(node);
		node.setChildFlag(havechild);
		return node;
	}
	
	
	/**
	 * 取出userdate信息
	 * @param userdatefield   　字段名称例如：＂id,number|name＂
	 * @param resultMap 为数据库的一条记录
	 * @return userdate信息
	 */
	private  String tranUserDate(Map map ,String userdatefield){
		String tranuserdate="";
		try{
			if(userdatefield!=null&&!userdatefield.equals("")){
				String[] userdatefields = userdatefield.split("\\|");
				for(int i=0;i<userdatefields.length;i++){
					if(i!=userdatefields.length-1)
						tranuserdate+=(fieldToString(map,userdatefields[i])+"|");
					else
						tranuserdate+=fieldToString(map,userdatefields[i]);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return tranuserdate;
	}
	
	
	/**
	 * 取出text树的显示中文
	 * @param text   　 对应的字段名称例如：＂b|res_name^(ID:b-bres_name+名称：res_name)b-res_name＂ "^"后边的是显示的格式
	 * @param resultMap 为数据库的一条记录
	 * @return text树的显示中文
	 */
	private String tranText(Map resultMap ,String text){
		String trantext="";
		String format ="";
		try{
			String[] texts = text.split("\\^");//分割字段名称和显示格式
			if(texts.length==2){
				format=texts[1];
			}
			String[] fields  = texts[0].split("\\|");//分割字段名称
			for(int i=0;i<fields.length;i++){
				String val = fieldToString(resultMap,fields[i]);//取出字段对应的值
				String temp = "";
				if(!format.equals("")){
					boolean islast = isLastStr(format,fields[i]);//判断根式是不是以该字段结束
					String[] oth = format.split(fields[i]);//取出字段前后的内容
					//把字段名称替换为该字段的值
					for(int j=0;j<oth.length;j++){
						if(islast){
							temp += oth[j]+val;
						}else{
							if(j!=oth.length-1)
								temp += (oth[j]+val);
							else 
								temp += oth[j];
						}
					}
					if(!temp.equals(""))
						format = temp;
				}else{
					trantext+=val;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return (!format.equals(""))?format:trantext;
	}
	
	
	/**
	 * 判断字符串是否在目标字符串的结尾
	 * @param target   　 目标字符串
	 * @param lastStr    要判断的字符串
	 * @return　boolean
	 */
	private boolean isLastStr(String target ,String lastStr){
		
		int tarlength = target.length();
		int lastStrlength  = lastStr.length();
		if(target.indexOf(lastStr)!=-1){
			int ind = target.lastIndexOf(lastStr);
			if(ind+1+lastStrlength>=tarlength){
				return true;
			}else{
				return false;
			}
			
		}else{
			return false;
		}
	}
	/**
	 * 根据字段的类型从从map里取出数据转化为String
	 * @param resultMap
	 * @param field
	 * @return
	 */
	private String fieldToString(Map resultMap,String field){
		String value = "";
		String[] fieldAndtype = field.split(",");
		//System.out.println(fieldAndtype[0]);
		if(fieldAndtype.length>1&&fieldAndtype[1]!=null&&!fieldAndtype[1].equals(""))
		{
			if(fieldAndtype[1].toLowerCase().equals("string"))//类型为字符串
			
				value = (String)resultMap.get(fieldAndtype[0]);
			else//类型为其他
			{	
				if(resultMap.get(fieldAndtype[0])!=null){//判断是否有值
					value = resultMap.get(fieldAndtype[0]).toString();
				}else{
					value ="";
				}
			}
			
		}
		else//默认为字符串
		{
			value = (String)resultMap.get(fieldAndtype[0]);
		}
			
		return value;
		
	}
	
	
	/**
	 * 检查节点是否有子节点
	 * @param parentDis 父节点描述对象
	 * @return 0:无 1:有
	 */
	private String checkHaveChildren(DhtmlxTreeNode parentnode){
		   Map nodeMap= this.getChildrenResultByNode(parentnode);
		   if(nodeMap==null||nodeMap.size()==0||nodeMap.isEmpty())
			   return "0";
		   else
			   return "1";
	}
	
	
	
	
	/**
	 * 通过 树的名称和节点描述对象的名称 查找节点描述对象
	 * @param treename
	 * @param disNodeName
	 * @return
	 */
	private  DhtmlxTreeNodeDis getDhtmlxTreeNodeDis(String treename,String disNodeName){
		TreeXmlUtil util = new TreeXmlUtil();
		return util.getNodeDis(treename, disNodeName);
	}
	
	
	/**
	 * 通过节点对象 查找相应的节点 描述对象
	 * @param node
	 * @return
	 */
	
   private DhtmlxTreeNodeDis getDhtmlxTreeNodeDisByNode(DhtmlxTreeNode node){
	   TreeXmlUtil util = new TreeXmlUtil();
	   return util.getNodeDis(node.getTreeName(), node.getNodeDisName());
   }
	
	
	
}
