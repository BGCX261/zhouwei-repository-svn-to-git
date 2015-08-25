package frame;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class FrameServer {
	
	private final static String path = "/modules/frame"; 
	//private final static String path = "/modules/frame"; 
	private LinkedHashMap<String,FrameMenu> map;
	
	public FrameServer(){	
		map = FrameConfig.getConfig(path);
	}
	
	public FrameMenu[] getFrameMenu(){
		//System.out.println("getFrameMenu");
		FrameMenu[] obj = new FrameMenu[map.size()];
		obj = map.values().toArray(obj);
		return obj;
	}
	
	public FrameMenuNode[] getFrameMenuNode(String menuId){
		//System.out.println("getFrameMenuNode:"+menuId);
		FrameMenu menu = map.get(menuId);
		//System.out.println("menu="+menu+"--"+menu.getNodeMap().size());
		FrameMenuNode[] nodes = new FrameMenuNode[menu.getNodeMap().size()];
		nodes = menu.getNodeMap().values().toArray(nodes);
		return nodes;
	}
	
	public FrameMenuLeaf[] getFrameMenuLeaf(String nodeId){
		LinkedHashMap<String,FrameMenuLeaf> leafMap = null;
		Iterator<FrameMenu> ite = map.values().iterator();
		while(ite.hasNext()){
			FrameMenu menu = ite.next();
			if(menu.getNodeMap().get(nodeId)!=null){
				leafMap = menu.getNodeMap().get(nodeId).getLeafMap();
				break;
			}
		}
		FrameMenuLeaf[] leafs = new FrameMenuLeaf[leafMap.size()];
		leafs = leafMap.values().toArray(leafs);
		return leafs;
	}
	
}
