package uni.me.faucitt.bottle.resources;

import java.io.IOException;

public interface ResourceManager
{
    Resource loadResource(ResourceLocation var1) throws IOException;
}