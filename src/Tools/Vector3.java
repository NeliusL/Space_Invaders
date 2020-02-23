package Tools;

public class Vector3 {
    public float x;
    public float y;
    public float z;

    public Vector3(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vector3 zero = new Vector3(0, 0, 0);
    public static Vector3 one = new Vector3(1, 1, 1);
    public static Vector3 forward = new Vector3(0, 0, 1);
    public static Vector3 backward = new Vector3(0, 0, -1);
    public static Vector3 right = new Vector3(1, 0, 0);
    public static Vector3 left = new Vector3(-1,0, 0);
    public static Vector3 up = new Vector3(0, 1, 0);
    public static Vector3 down = new Vector3(0,-1, 0);

    @Override
    public String toString() { return "("+ x +", "+ y +", "+ z +")"; }
    public static void display(Vector3 v) { System.out.println(v.toString()); }
    public void display() { System.out.println(this.toString()); }

    // Basic Operations ------------------------------------------------------------------------------------------------

    /**@param a Vector3
     * @param b Vector3
     * @return The sum of a and b*/
    public static Vector3 add(Vector3 a, Vector3 b) {
        return new Vector3(
                a.x + b.x,
                a.y + b.y,
                a.z + b.z);
    }
    /** @see Vector3#add(Vector3, Vector3) */
    public Vector3 add(Vector3 b) { return add(this, b); }
    /** Returns a - b */
    public static Vector3 subtract(Vector3 a, Vector3 b) { return add(a, negate(b)); }
    /** @see Vector3#subtract(Vector3, Vector3) */
    public Vector3 subtract(Vector3 b) { return add(this, negate(b)); }

    /**@param a Vector3
     * @param k float
     * @return a *k*/
    public static Vector3 multiply(Vector3 a, float k) {
        return new Vector3(
                a.x * k,
                a.y * k,
                a.z * k);
    }
    /** @see Vector3#multiply(Vector3, float) */
    public Vector3 multiply(float k) { return multiply(this, k); }
    /** Returns a *1/k */
    public static Vector3 divide(Vector3 a, float k) { return multiply(a, 1/k); }
    /** @see Vector3#divide(Vector3, float) */
    public Vector3 divide(float k) { return multiply(this, 1/k); }
    /** Returns -a */
    public static Vector3 negate(Vector3 a) { return multiply(a, -1); }
    /** @see Vector3#negate(Vector3) */
    public Vector3 negate() { return multiply(this, -1); }

    /**@param a Vector3
     * @return The length of a squared (Less calculations than returning the length, useful for comparison) */
    public static float sqrLength(Vector3 a) {
        return a.x * a.x + a.y * a.y + a.z * a.z;
    }
    /** @see Vector3#sqrLength(Vector3) */
    public float sqrLength() { return sqrLength(this); }
    /** Returns the length of the vector */
    public static float length(Vector3 a) { return (float) Math.sqrt(sqrLength(a)); }
    /** @see Vector3#length(Vector3) */
    public float length() { return (float) Math.sqrt(sqrLength(this)); }

    //Normalization
    /**@param a The vector
     * @return Returns a Vector3 with the same direction but with length 1 */
    public static Vector3 normalize(Vector3 a) {
        float length = a.length();
        if(length == 0)
            throw new ArithmeticException("Can't normalize a 0 vector");
        return a.divide(length);
    }
    /**@see Vector3#normalize(Vector3)*/
    public Vector3 normalize() { return normalize(this); }

    //Dot product
    public static float dot(Vector3 a, Vector3 b) {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }
    public float dot(Vector3 b) { return dot(this, b); }

    //Cross product
    public static Vector3 cross(Vector3 a, Vector3 b) {
        return new Vector3(
                a.y * b.z - a.z * b.y,
                a.z * b.x - a.x * b.z,
                a.x * b.y - a.y * b.x);
    }
    public Vector3 cross(Vector3 b) { return cross(this, b); }

}
