package Game;

import Graphics.*;

import Tools.Vector3;
import Tools.Vertex;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL20;





public class Main {

    // TEST STUFF
    static float[] vertices = {0f,0f,0f,
            0.75f, -0.75f, 0f,
            0f,0.75f,0f,
            -0.8f, -0.3f, 0f};
    static int[] indices = {0,1,2,3,4,5,6};

    static Mesh TestTriangle;

    public static void main(String[] args) {
       RunGame();
    }

    public static void RunGame(){
        Window.init();

        GameLoop();
        Window.close();
    }

    public static void GameLoop(){
        GL.createCapabilities();

        TestTriangle = MeshLoader.Gen2DMesh(vertices,indices);          // To put after GL.createCapabilities

        // END OF TEST STUFF
        while(Window.KeepWindowOpen()){
            Display_Update();
        }
    }

    public static void Update(){
        Game_Update();
        Display_Update();
    }

    public static void Game_Update(){

    }

    public static void Display_Update(){

        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);

        GL30.glBindVertexArray(TestTriangle.getVao());  // TEST

        GL20.glEnableVertexAttribArray(0);

        // =============== DRAWING PART
        GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, TestTriangle.getVertices()); // TEST

        GL20.glDisableVertexAttribArray(0);
        GL30.glBindVertexArray(0);              // Unload Vertex Array

        GLFW.glfwSwapBuffers(Window.getId());         // Load Next Frame
        GLFW.glfwPollEvents();

    }

}
