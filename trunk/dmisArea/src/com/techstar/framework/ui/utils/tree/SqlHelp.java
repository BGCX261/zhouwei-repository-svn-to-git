package com.techstar.framework.ui.utils.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.techstar.framework.ui.entity.DhtmlxTreeNode;
import com.techstar.framework.ui.entity.DhtmlxTreeNodeDis;


/**
 * 通过节点描述对象和节点对象 来拼凑sql语句
 * @author gaojing
 *
 */

public class SqlHelp {
    
	
	
	
	/**
     * @param parentdis:父描述节点对象
     * @param params:sql所学要的参数
     * @return  每个子节点对应的sql
   
	public Map getChildsSqlByDisAndPra(DhtmlxTreeNodeDis parentdis,Object[] params) {
		Map map = null;
		List childDislist  = parentdis.getChildsNodeDis();
		map = getSqlByDisListAndPra(childDislist,params);
		return map;
	}
	
	
	
	
	
	public Map getSqlByDisListAndPra(List disList,Object[] params){
		Map map = new HashMap();
		for(int i=0;i<disList.size();i++)
		{
			DhtmlxTreeNodeDis childdis = (DhtmlxTreeNodeDis)disList.get(i);
			String hql = getSql(childdis,params);
			map.put(childdis, hql);
		}
		return map;
	}  */
	
	
	/**
     * @param dis:描述节点对象
     * @param params:sql所需要的参数
     * @return  得到本节点的sql
     */
	public   String getSql(DhtmlxTreeNodeDis dis,Object[] params,String condition){
		//System.out.println("sqlbody="+dis.getSql().getSqlBody());
		String sqlBody = dis.getSql().getSqlBody();
		if (params!=null&&params.length>0)
			 sqlBody   = createSql(sqlBody,params,condition);
		
		return sqlBody;
	}
	
	
	
	/**
	 * 根据父节点描述对象和父节点对象
	 * @param parentdis
	 * @param node
	 * @return
	 */
	public Map getChildsSqlByDisAndNode(DhtmlxTreeNodeDis parentdis,DhtmlxTreeNode parentNode,Map map){
		List childDislist  = parentdis.getChildsNodeDis();
		Map sqlMap = new HashMap();
		for(int i =0;i<childDislist.size();i++)
		{
			DhtmlxTreeNodeDis dis = (DhtmlxTreeNodeDis)childDislist.get(i);
			String sql = this.getSql(dis,parentNode,map);
			sqlMap.put(dis, sql);
		}
		return sqlMap;
	}
	

	
	/**
     * @param dis:描述节点对象
     * @param parentNode:父节点对象
     * @param Map :根据业务产生的sql条件
     * @return  得到本节点的sql
     */
	
	private String getSql(DhtmlxTreeNodeDis dis,DhtmlxTreeNode parentNode,Map map){
		String paramfrom = dis.getSqlByRefName(parentNode.getNodeDisName()).getSqlParamFrom();
		//System.out.println("paramfrom="+paramfrom);
		 String sqlBody = dis.getSqlByRefName(parentNode.getNodeDisName()).getSqlBody();
		 String addcondition="";
		 String[] parems = null;
		if(paramfrom!=null||!paramfrom.equals("")){
			parems = paramfrom.split(",");
			for(int i=0;i<parems.length;i++)
			{
				if(parems[i].equals(Constants.PARENTNODE_ID))
					parems[i] = parentNode.getId();
				else if(parems[i].equals(Constants.PARENTNODE_TEXT))
					parems[i] = parentNode.getText();
				else if(parems[i].indexOf(Constants.PARENTNODE_USERDATA)!=-1){
					String para = parems[i].substring(parems[i].lastIndexOf("[")+1,parems[i].lastIndexOf("]"));
					String[] userdates = parentNode.getUserData().split("\\|");
					parems[i] = userdates[Integer.parseInt(para)];
				}
					
			}
		}
		if(map!=null){
				if(map.containsKey(dis.getSqlByRefName(parentNode.getNodeDisName()).getSqlName()))
					addcondition = (String)map.get(dis.getSqlByRefName(parentNode.getNodeDisName()).getSqlName());
			}
		//if (parems!=null&&parems.length>0||!addcondition.equals(""))
				 sqlBody   = createSql(sqlBody,parems,addcondition);
		
		return sqlBody;
	}
	
	/**
     * @param sql: "select CATEGORY_ID,CATEGORY_NAME,ACTIVE_STATUS from product_category where PARENT_CATEGORY_ID = '?' "
     * @param params:sql所需要的参数
     * @return  拼成sql
     */
	private  String createSql(String sql ,Object[] params,String addCondition){
		//System.out.println(sql);
		StringBuffer sqlbuf = new StringBuffer();
		if(params!=null){
			String[] subsql = sql.split("\\?");
			for(int i =0;i<subsql.length;i++)
			{
				//System.out.println(i+"=subsql[i]="+subsql[i]);
				sqlbuf.append(subsql[i]);
				if(i<params.length)
					sqlbuf.append(params[i]);
			}
		}else{
			sqlbuf.append(sql);
		}
		sqlbuf.append(" "+addCondition);
		//System.out.println(sqlbuf.toString());
		return sqlbuf.toString();
	}
	
	
}
