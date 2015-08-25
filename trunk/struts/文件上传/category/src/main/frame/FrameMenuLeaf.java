package frame;

public class FrameMenuLeaf {

	private String id;
	private String name;
	private String image;
	private String url;
	
	public FrameMenuLeaf(String id,String name,String image,String url){
		this.id = id;
		this.name = name;
		this.image = image;
		this.url = url;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
