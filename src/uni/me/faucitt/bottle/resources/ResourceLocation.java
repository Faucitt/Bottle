package uni.me.faucitt.bottle.resources;

public class ResourceLocation {
	public ResourceLocation(String path) {
		this.path = path;
	}
	
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
