package com.techstar.framework.ui.utils.tree;
import javax.servlet.http.HttpServletRequest;
import com.techstar.framework.ui.entity.DhtmlxTreeNode;
public class TreeActionHelp {

	
		public static DhtmlxTreeNode getTreeNodeByRequest(HttpServletRequest request){
			DhtmlxTreeNode node = new DhtmlxTreeNode();
			try{
				String id  = request.getParameter("id");
				String text = request.getParameter("text");
				String info  =  request.getParameter("info");
				System.out.println(id+" "+text+"fffffff"+info);
				//String tranproduce = new String(produce.getBytes("ISO-8859-1"),"GBK");
				
				if(info!=null&&!info.equals(""))//分割userdate
				{
					String[] infos =  info.split(";;;");
					for(int i=0;i<infos.length;i++)
					{
						if(infos[i]!=null&&!infos[i].equals(""))
						{
							switch (i)
							{
								case 0:
									node.setTreeName(infos[i]);
									break;
								case 1:
									node.setNodeDisName(infos[i]);
									break;
								case 2:
									node.setUserData(infos[i]);
									break;
							}
						}
					}
				}
				node.setId(id);
				node.setText(text);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			return node;
		}
}
