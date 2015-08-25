package frame;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.net.*;

public class FrameConfig {
	
	private volatile static LinkedHashMap<String,FrameMenu> map;
	
	private FrameConfig(){}
	
	public static LinkedHashMap<String,FrameMenu> getConfig(String path){
		if(map==null){
			synchronized(FrameConfig.class){
				if(map==null){
					map = new FrameConfig().read(path);
				}
			}
		}
		return map;
	}

	private LinkedHashMap<String,FrameMenu> read(String path){
		LinkedHashMap<String,FrameMenu> frameMap = new LinkedHashMap<String,FrameMenu>();
		if(path==null){
			path = "/modules/frame";
		}
		////
		URL url = this.getClass().getResource(path);
		try {
			File file = new File(url.toURI());
			String[] list = file.list();
			for(int i=0;i<list.length;i++){
				readSimple(path+"/"+list[i],frameMap);
			}
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		///System.out.println(path);	
		
		return frameMap;
	}
	
	private void readSimple(String path,LinkedHashMap<String,FrameMenu> frameMap){
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db;		
			db = dbf.newDocumentBuilder();		
			InputStream in = getClass().getResourceAsStream(path);
			Document doc = db.parse(in);
			NodeList rootList = doc.getElementsByTagName("menu");
			for(int i=0;i<rootList.getLength();i++){
				Node rootNode = rootList.item(i);
				Element rootElement = (Element)rootNode;
				String rootId = rootElement.getAttribute("id");
				String rootName = rootElement.getAttribute("name");
				String rootImage = rootElement.getAttribute("image");
				FrameMenu menu = new FrameMenu(rootId,rootName,rootImage,getMenuNodeMap(rootElement));
				///System.out.println(rootId+","+rootName+":"+rootElement.getChildNodes().getLength());
				frameMap.put(rootId, menu);
			}		
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static LinkedHashMap<String,FrameMenuNode> getMenuNodeMap(Element rootElement){
		LinkedHashMap<String,FrameMenuNode> nodeMap = new LinkedHashMap<String,FrameMenuNode>();
		NodeList nodeList = rootElement.getElementsByTagName("menuitem");
		for(int j=0;j<nodeList.getLength();j++){
			///Node node = nodeList.item(j);
			//System.out.println(node.getNodeType()+","+node.getNodeName());
			Element nodeElement = (Element)nodeList.item(j);
			String nodeId = nodeElement.getAttribute("id");
			String nodeName = nodeElement.getAttribute("name");
			String nodeImage = nodeElement.getAttribute("image");
			FrameMenuNode menuNode = new FrameMenuNode(nodeId,nodeName,nodeImage,getMenuLeafMap(nodeElement));
			nodeMap.put(nodeId, menuNode);
		}
		return nodeMap;
	}
	
	public static LinkedHashMap<String,FrameMenuLeaf> getMenuLeafMap(Element nodeElement){
		LinkedHashMap<String,FrameMenuLeaf> leafMap = new LinkedHashMap<String,FrameMenuLeaf>();
		NodeList leafList = nodeElement.getElementsByTagName("menuleaf");
		for(int l=0;l<leafList.getLength();l++){
			Element leafElement = (Element)leafList.item(l);
			String leafId = leafElement.getAttribute("id");
			String leafName = leafElement.getAttribute("name");
			String leafImage = leafElement.getAttribute("image");
			String leafUrl = leafElement.getAttribute("url");
			FrameMenuLeaf leaf = new FrameMenuLeaf(leafId,leafName,leafImage,leafUrl);
			leafMap.put(leafId, leaf);
		}
		return leafMap;
	}
	
	public static void main(String[] args){
		LinkedHashMap<String,FrameMenu> map = FrameConfig.getConfig("E:\\MyEclipse 6.6\\workspace\\webx_frame_demo\\src\\frame.xml");
		System.out.println(1+":"+map.size());
		FrameMenu menu1 = map.get("root_id1");
		System.out.println(menu1.getName());
		LinkedHashMap<String,FrameMenuNode> map2 = menu1.getNodeMap();
		System.out.println(2+":"+map2.size());
		FrameMenuNode node = map2.get("node12");
		System.out.println(node.getName());
		LinkedHashMap<String,FrameMenuLeaf> map3 = node.getLeafMap();
		System.out.println(3+":"+map3.size());
		FrameMenuLeaf leaf = map3.get("leaf121");
		System.out.println(leaf.getName());
	}
}
