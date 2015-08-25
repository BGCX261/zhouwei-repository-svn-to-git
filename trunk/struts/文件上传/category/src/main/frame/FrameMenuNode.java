package frame;

import java.util.LinkedHashMap;

public class FrameMenuNode implements FrameElement{

	private String id;
	private String name;
	private String image;
	private LinkedHashMap<String,FrameMenuLeaf> leafMap;
	
	public FrameMenuNode(String id,String name,String image,LinkedHashMap<String,FrameMenuLeaf> leafMap){
		this.id = id;
		this.name = name;
		this.image = image;
		this.leafMap = leafMap;
	}
	
	public FrameMenuNode(String id,String name,String image){
		this.id = id;
		this.name = name;
		this.image = image;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public LinkedHashMap<String,FrameMenuLeaf> getLeafMap() {
		return leafMap;
	}

	public void setLeafMap(LinkedHashMap<String,FrameMenuLeaf> leafMap) {
		this.leafMap = leafMap;
	}
	
	
}
