package Graphics;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.TextureLoader;

import java.awt.event.MouseAdapter;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.ARBVertexArrayObject.*;

public class Window {
    public static final int DEFAULT_WIDTH = 1280;
    public static final int DEFAULT_HEIGHT = 720;
    public static final int DEFAULT_FRAME_RATE = 60;
    public static final String TITLE = "Space Invaders, but BETTER";

    private static int width = DEFAULT_WIDTH;
    private static int height = DEFAULT_HEIGHT;
    private static int fps = DEFAULT_FRAME_RATE;
    private static TextureLoader textureLoader;
    private static long window;


    // Classic getters
    public static int getWidth() { return width; }
    public static int getHeight() { return height; }
    public static long getId() { return window; }

    // Open and Init the window
    public static void open(){

        // Init GLFW
        if(!GLFW.glfwInit())
            throw new RuntimeException("Failed to initialize GLFW");

        // Create window and save its ID number in window
        window = GLFW.glfwCreateWindow(width, height, TITLE, 0, 0);

        if (window == 0)
            throw new RuntimeException("Failed to create the window");

        // Init hte window
        GLFWVidMode videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        if (videoMode == null)
            throw new RuntimeException("Failed to initialize the window");

        // Center the window
        glfwSetWindowPos(window, (videoMode.width() - width) / 2, (videoMode.height() - height) / 2);

        GLFW.glfwMakeContextCurrent(window);

        glfwSwapInterval(1);    // vsync
        GL.createCapabilities();        // Creates new GLCapabilities instance to allow the use of OpenGL
        GLFW.glfwSetInputMode(window,GLFW_CURSOR, GLFW_CURSOR_NORMAL);  // Hide cursor

        GL11.glEnable(GL11.GL_TEXTURE_2D);  // Texture rendering
        GL11.glDisable(GL11.GL_DEPTH_TEST); // Depth is not needed since it's 2D

        GL11.glMatrixMode(GL11.GL_PROJECTION);  // Load the camera matrix to draw the image
        GL11.glLoadIdentity();                  // No idea what it does but needed

        GL11.glOrtho(0, width, height, 0, -1, 1);

        textureLoader = new TextureLoader();

        GLFW.glfwMakeContextCurrent(window);

        // Show the window
        GLFW.glfwShowWindow(window);

        // Color used to fill the window when cleared
        GL11.glClearColor(0, 0, 0, 0);
    }

    // Close window
    public static void close(){
        glfwDestroyWindow(window);
        GLFW.glfwTerminate();
        // TODO (terminate the programme)

    }

    public static void update(){
        // Maintains the window open, closes when Escape is hit
        while(!glfwWindowShouldClose(window)){

            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
            glfwSwapBuffers(window);
            //checks for escape key press
            if(glfwGetKey(window, GLFW_KEY_ESCAPE) == GLFW_TRUE) {
                Window.close();
            }
            glfwPollEvents();
        }
    }

    // Getters
    public static boolean KeepWindowOpen(){ return !glfwWindowShouldClose(window); }
    public static long GetWindow(){ return window;}
}
