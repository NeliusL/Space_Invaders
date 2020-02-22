package Graphics;

import org.lwjgl.opencl.AMDOfflineDevices;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class Mesh {

    // Object VAO ID that is used to get its VAO
    // Contains the object's data in the form of VBO.
    // VAO contains the object vertices, vertices colors, texture etc...
    // These informations can be called by accessing the vao's components
    private static int vao;


    // The object's number of vertices
    private static int vertices;

    public Mesh(int vao, int vertex){
        this.vao = vao;
        this.vertices = vertex;
    }

    public static void Render(Mesh mesh,int mode ){
        mode = GL11.GL_TRIANGLES;       // for tests purposes

        GL30.glBindVertexArray(mesh.getVao());
        GL20.glEnableVertexAttribArray(0);
        GL11.glDrawElements(mode, mesh.getVertices(), GL11.GL_UNSIGNED_INT, 0);
        GL20.glDisableVertexAttribArray(0);
        GL30.glBindVertexArray(0);

    }

    // Getters
    public static int getVao()         { return vao;}
    public static int getVertices()    { return vertices;}
}
