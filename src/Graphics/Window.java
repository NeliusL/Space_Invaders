package Graphics;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

public class Window {
    public static final int DEFAULT_WIDTH = 1280;
    public static final int DEFAULT_HEIGHT = 720;
    public static final String TITLE = "Space Invaders, but BETTER";

    private static int width = DEFAULT_WIDTH;
    private static int height = DEFAULT_HEIGHT;
    private static long window;

    // Open and Init the window
    public static void open(){

        // Init library
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

        //GLFW.glfwSetWindowPos(window, videoMode.width()/2, videoMode.height()/2);
        GLFW.glfwMakeContextCurrent(window);
        GL.createCapabilities();    // Creates new GLCapabilities instance to allow the use of OpenGL
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GLFW.glfwShowWindow(window);

        GL11.glLoadIdentity();
        GL11.glOrtho(0, width, height, 0, 1, -1);

        // Maintains the window open but need to find a way to get an event and close the window upon this event
        while(!glfwWindowShouldClose(window))
            glfwPollEvents();

    }

    public static void close(){
        GLFW.glfwTerminate();
        // TODO
    }
}
