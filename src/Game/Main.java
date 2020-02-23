package Game;

import Graphics.*;

import Tools.Vector3;
import Tools.Vertex;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL20;





public class Main {


    private static Mesh MyTriangle;



    public static void main(String[] args) {
        /*float[] vertices = {-0.5f,-0.5f,0f,
                0.5f, -0.5f, 0f,
                0f,0.5f,0f};
        int[] indices = {0,1,2};
        */

        Vector3 a = new Vector3(0, 0, 0);
        Vector3 b = new Vector3(0, 1, 0);
        Vector3 c = new Vector3(1, 0, 0);
        Vector3 d = new Vector3(1, 1, 0);

        Vertex av = new Vertex(a);
        Vertex bv = new Vertex(b);
        Vertex cv = new Vertex(c);
        Vertex dv = new Vertex(d);

        Vertex[] Square = new Vertex[] {av, bv, cv, dv};
        int[] SquareIndices = new int[] {0, 1, 2, 3};


        // Just testing the window generation
        Window.open();
        Model sq = new Model(Square, SquareIndices);

        while(Window.KeepWindowOpen())
        {
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);
            sq.render();

            GLFW.glfwSwapBuffers(Window.GetWindow());
            GLFW.glfwPollEvents();

        }
        Window.close();

    }
/*

    public static void Update(){

        //GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

        GL30.glBindVertexArray(MyTriangle.getVao());
        GL20.glEnableVertexAttribArray(0);
        GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, 3);
        GL20.glDisableVertexAttribArray(0);
        GL30.glBindVertexArray(0);

        GLFW.glfwSwapBuffers(Window.GetWindow());
        GLFW.glfwPollEvents();

    }*/
}
