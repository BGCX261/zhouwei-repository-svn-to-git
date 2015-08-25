package frame;

import java.util.LinkedHashMap;

public class FrameMenu implements FrameElement{

	private String id;
	private String name;
	private String image;
	private LinkedHashMap<String,FrameMenuNode> nodeMap;
	
	public FrameMenu(String id,String name,String image){
		this.id = id;
		this.name = name;
		this.image = image;
		nodeMap = new LinkedHashMap<String,FrameMenuNode>();
	}
	
	public FrameMenu(String id,String name,String image,LinkedHashMap<String,FrameMenuNode> nodeMap){
		this.id = id;
		this.name = name;
		this.image = image;
		this.nodeMap = nodeMap;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public LinkedHashMap<String,FrameMenuNode> getNodeMap() {
		return nodeMap;
	}

	public void setNodeMap(LinkedHashMap<String,FrameMenuNode> nodeMap) {
		this.nodeMap = nodeMap;
	}
	
	
}
