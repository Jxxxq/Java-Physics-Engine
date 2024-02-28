package physicsengine;

public class Vector2 {

	private float x, y;
	
	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;	
	}
	
	public Vector2(Vector2 vec) {
		this.x = vec.getX();
		this.y = vec.getY();
	}
	
	public float getMagnitude() {
		return (float) Math.sqrt(x*x+y*y);
	}
	
	public void normalize() {
		scale(1/getMagnitude());
	}
	
	public void scale(float scalar) {
		this.x *= scalar;
		this.y *= scalar;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void add(Vector2 v2) {
		this.x += v2.getX();
		this.y += v2.getY();
	}
	
	public void subtract(Vector2 v2) {
		this.x -= v2.getX();
		this.y -= v2.getY();
	}
	
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	
	public static Vector2 ZERO() {
		return new Vector2(0,0);
	}
	
	public static Vector2 UP() {
		return new Vector2(0,1);
	}
	
	public static Vector2 RIGHT() {
		return new Vector2(1,0);
	}
	
	public static Vector2 DOWN() {
		return new Vector2(0,-1);
	}
	
	public static Vector2 LEFT() {
		return new Vector2(-1,0);
	}
	
	public static float dotProduct(Vector2 v1, Vector2 v2) {
		return (v1.getX() * v2.getX() + v1.getY() * v2.getY());
	}
	
	public static float getDistance(Vector2 v1, Vector2 v2) {
		float diffX = v1.getX()-v2.getX();
		float diffY = v1.getY()-v2.getY();
		return (float) Math.sqrt(diffX * diffX + diffY * diffY);
	}
	
	public static float angleBetween(Vector2 v1, Vector2 v2) {
	    float dot = dotProduct(v1, v2);
	    float magMult = v1.getMagnitude() * v2.getMagnitude();
	    return (float) Math.acos(dot / magMult);
	}
	
	public String toString() {
		return "<" + x + ", " + y + ">";
	}

	
}
