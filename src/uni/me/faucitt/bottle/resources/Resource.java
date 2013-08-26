package uni.me.faucitt.bottle.resources;

import java.io.InputStream;

public interface Resource {
	InputStream getStream();

	boolean isBroken();

	String path();
}
