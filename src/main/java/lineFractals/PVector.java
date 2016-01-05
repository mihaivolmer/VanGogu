package lineFractals;


public class PVector {
    /** The x component of the vector. */
    public float x;

    /** The y component of the vector. */
    public float y;

    /** Array so that this can be temporarily used in an array context */
    protected float[] array;


    /**
     * Constructor for an empty vector: x, y, and z are set to 0.
     */
    public PVector() {
    }

    /**
     * Constructor for a 2D vector: z coordinate is set to 0.
     *
     * @param  x the x coordinate.
     * @param  y the y coordinate.
     */
    public PVector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Set x, y, and z coordinates.
     *
     * @param x the x coordinate.
     * @param y the y coordinate.
     */
    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Set x, y, and z coordinates from a Vector3D object.
     *
     * @param v the PVector object to be copied
     */
    public void set(PVector v) {
        x = v.x;
        y = v.y;
    }

    /**
     * Get a copy of this vector.
     */
    public PVector get() {
        return new PVector(x, y);
    }

    /**
     * Add a vector to this vector
     * @param v the vector to be added
     */
    public void add(PVector v) {
        x += v.x;
        y += v.y;
    }


    public void add(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void sub(float x, float y) {
        this.x -= x;
        this.y -= y;
    }


    static public PVector sub(PVector v1, PVector v2, PVector target) {
        if (target == null) {
            target = new PVector(v1.x - v2.x, v1.y - v2.y);
        } else {
            target.set(v1.x - v2.x, v1.y - v2.y);
        }
        return target;
    }

    /**
     * Subtract one vector from another
     * @param v1 a vector
     * @param v2 another vector
     * @return a new vector that is v1 - v2
     */
    static public PVector sub(PVector v1, PVector v2) {
        return sub(v1, v2, null);
    }

    /**
     * Multiply this vector by a scalar
     * @param n the value to multiply by
     */
    public void mult(float n) {
        x *= n;
        y *= n;
    }

    /**
     * Divide this vector by a scalar
     * @param n the value to divide by
     */
    public void div(float n) {
        x /= n;
        y /= n;
    }

    public void rotate(float theta) {
        float xTemp = x;
        // Might need to check for rounding errors like with angleBetween function?
        x = (float) (x*Math.cos(theta) - y*Math.sin(theta));
        y = (float) (xTemp*Math.sin(theta) + y*Math.cos(theta));
    }

}
