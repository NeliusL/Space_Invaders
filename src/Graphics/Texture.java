package Graphics;

import java.io.File;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;

public class Texture {

    // This will contain all of the textures we'll be using
    // This means we will refer to our textures with names and IDs
    private static HashMap<String, Integer> idMap = new HashMap<String, Integer>();

    public static int LoadTexture(String path){
        try(MemoryStack stack = MemoryStack.stackPush()){
        }
        //TODO
        return 0;
    }

}
