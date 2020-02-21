package Graphics;

import org.lwjgl.BufferUtils;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.awt.*;
import java.nio.IntBuffer;



import static org.lwjgl.stb.STBImage.stbi_load;


public class Tools {

    IntBuffer w = BufferUtils.createIntBuffer(1);
    IntBuffer h = BufferUtils.createIntBuffer(1);
    IntBuffer comp = BufferUtils.createIntBuffer(1);

    // Loads texture from file path
    // format : format of the image (.png, .jpg...)
    public static Texture loadTexture(String path, String format){

        try {
            return TextureLoader.getTexture(format, new FileInputStream(new File(path)));
        }
        catch(IOException e){
            System.out.println("Exception thrown: " + e);
        }
        return null;
    }

}