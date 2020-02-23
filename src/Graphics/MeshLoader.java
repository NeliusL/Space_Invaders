package Graphics;

import com.sun.source.tree.BreakTree;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.*;

import javax.lang.model.element.UnknownAnnotationValueException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

public class MeshLoader {

    // Contains the object's data in the form of VBO.
    // VAO contains the object vertices, vertices colors, texture etc...
    // These informations can be called by accessing the vao's components
    private static List<Integer> vaos = new ArrayList<Integer>();

    // Basically an array of data
    // Can contain for example the coordinates of all the vertices of the mesh
    private static List<Integer> vbos = new ArrayList<Integer>();



// Don't bother with it
//=============================================================================

    // Turn float/int arrays into buffers
    // This makes sure we only use the data we need
    private static FloatBuffer genFloatBuffer(float[] data) {
        FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
        buffer.put(data);   // Load data in the buffer
        buffer.flip();      // Was in writing mode, turns it into reading mode
        return buffer;
    }

    private static IntBuffer genIntBuffer(int[] data) {
        IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
        buffer.put(data);   // Load data in the buffer
        buffer.flip();      // Was in writing mode, turns it into reading mode
        return buffer;
    }


    // Create VBOs by saving the data in a VBO
    // type refers to what the VBO will be used for (vertices position/color, texture....)
    // dimension refers to whether it will be 2D or 3D data
    private static void SaveData(int type, int dimension, float[] data){
        int vbo = GL15.glGenBuffers();  // Creates a VBO by generating its ID
        vbos.add(vbo);

        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);        // Load the current VBO

        // Store the data after turning it into a buffer
        FloatBuffer buffer = genFloatBuffer(data);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
        // Let OpenGL know where this vbo's data will start (as if it was generating a pointer for OpenGL)
        GL20.glVertexAttribPointer(type, dimension, GL11.GL_FLOAT, false, 0, 0);

        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);         // Unload the current VBO
    }

    // Index used to know the order in which the vertices are drawn
    private static void bindIndex(int[] data){
        int vbo = GL15.glGenBuffers();  // Creates a VBO by generating its ID
        vbos.add(vbo);
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vbo);
        IntBuffer buffer = genIntBuffer(data);
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
    }

    // Create a VAO and store it in the list making it usable
    private static int genVAO(){
        int vao = GL30.glGenVertexArrays();
        vaos.add(vao);
        GL30.glBindVertexArray(vao);        // "Activate" the VAO by binding it
        return vao;
    }

//=============================================================================
// End of the don't bother with it


// Functions that you'll (probably) use

    // Generate a Mesh from the vertices
    public static Mesh GenMesh(float[] vertices, int[] indexes, int dimension){
        int vao = genVAO();
        SaveData(0, dimension, vertices);
        //SaveData(1,2,UVs);
        bindIndex(indexes);
        GL30.glBindVertexArray(0);      // Unload the VAO
        return new Mesh(vao, indexes.length);
    }

    // Generates a 2D mesh using the GenMesh function
    public static Mesh Gen2DMesh(float[] vertices, int[] indexes){
        return GenMesh(vertices,indexes, 2);
    }

    // Clear the vaos and vbos lists when terminating the game to clear memory
    public static void Destroy(){
        for (int vao:vaos){
            GL30.glDeleteVertexArrays(vao);
        }

        for (int vbo:vbos){
            GL30.glDeleteBuffers(vbo);
        }
    }
}
