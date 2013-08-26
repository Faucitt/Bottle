package uni.me.faucitt.bottle.texture;

import java.io.IOException;

import uni.me.faucitt.bottle.resources.ResourceManager;

public interface TextureObject
{
    void loadTexture(ResourceManager var1) throws IOException;

    int textureID();
}
