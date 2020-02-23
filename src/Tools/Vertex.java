package Tools;

import org.joml.Vector3d;

public class Vertex {
    private Vector3 position;

    public Vertex(Vector3 pos){
        this.position = pos;
    }

    public Vector3 getPosition(){
        return position;
    }

    public void setPosition(Vector3 pos){
        this.position = pos;
    }
}
