package Graphics;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.system.MemoryStack;
import org.newdawn.slick.opengl.TextureLoader;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryStack.stackPush;

import java.nio.IntBuffer;


public class Window {
    public static final int DEFAULT_WIDTH = 780;
    public static final int DEFAULT_HEIGHT = 420;
    public static final int DEFAULT_FRAME_RATE = 60;
    public static final String TITLE = "Space Invaders, but BETTER";

    private static int width = DEFAULT_WIDTH;
    private static int height = DEFAULT_HEIGHT;
    private static int fps = DEFAULT_FRAME_RATE;
    private static long window;


    // Open and Init the window
    public static void init(){

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

        //GLFW.glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {});

        try(MemoryStack stack = stackPush()){
            IntBuffer pWidth = stack.mallocInt(1);
            IntBuffer pHeight = stack.mallocInt(1);

            GLFW.glfwGetWindowSize(window, pWidth, pHeight);

            GLFWVidMode vidmode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());

            GLFW.glfwSetWindowPos(window,(vidmode.width() - pWidth.get(0)) / 2,(vidmode.height() - pHeight.get(0)) / 2);

            GLFW.glfwMakeContextCurrent(window);
            GLFW.glfwSwapInterval(1);
            GLFW.glfwShowWindow(window);
        }
/*

        GL.createCapabilities();        // Creates new GLCapabilities instance to allow the use of OpenGL
        GLFW.glfwSetInputMode(window,GLFW_CURSOR, GLFW_CURSOR_NORMAL);  // Hide cursor

        GL11.glDisable(GL11.GL_DEPTH_TEST); // Depth is not needed since it's 2D

        GL11.glMatrixMode(GL11.GL_PROJECTION);  // Load the camera matrix to draw the image

        GL11.glOrtho(0, width, height, 0, -1, 1);


        // Color used to fill the window when cleared
        GL11.glClearColor(0, 0, 0, 0);*/
    }

    // Close window
    public static void close(){
        glfwDestroyWindow(window);
        GLFW.glfwTerminate();
    }


    // Getters
    public static boolean KeepWindowOpen(){ return !glfwWindowShouldClose(window); }
    public static int getWidth() { return width; }
    public static int getHeight() { return height; }
    public static long getId() { return window; }

}
