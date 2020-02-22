package Game;

import Graphics.Window;
import Graphics.MeshLoader;
import Graphics.Mesh;
import Graphics.Tools;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL20;





public class Main {

    static float[] vertices = {0f, 0f, 0,
                        1f, 1f, 0,
                        0.5f, 1f, 0};

    static int[] indexes = {0,1,2};
    private static Mesh MyTriangle;



    public static void main(String[] args) {

        // Just testing the window generation
        Window.open();

        MeshLoader meshLoader = new MeshLoader();
        MyTriangle = meshLoader.GenMesh(vertices, indexes, 3);

        Mesh.Render(MyTriangle, 0);

        while(Window.KeepWindowOpen())
        {
            Update();

        }
        Window.update();
        Window.close();

    }


    public static void Update(){

        //GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

        GL30.glBindVertexArray(MyTriangle.getVao());
        GL20.glEnableVertexAttribArray(0);
        GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, 3);
        GL20.glDisableVertexAttribArray(0);
        GL30.glBindVertexArray(0);

        GLFW.glfwSwapBuffers(Window.GetWindow());
        GLFW.glfwPollEvents();

    }
}
