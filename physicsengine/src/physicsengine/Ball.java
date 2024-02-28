package physicsengine;

public class Ball extends Shape{

	private int radius = 20;
	private boolean isGrounded = false;
	
	public Ball(Vector2 position) {
		body.position = new Vector2(position);
		body.velocity = new Vector2(200,0);
		body.acceleration = new Vector2(0,200f); //set 200 for gravity
	}
	
	public void addForce(Vector2 force) {
		body.acceleration.add(force);
	}
	
	public boolean isGrounded() {
		return isGrounded;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public void setGrounded(boolean b) {
		isGrounded = b;
	}

	@Override
	public void initialize() {
		
	}

	@Override
	public Type getType() {
		return Type.CIRCLE;
	}

	@Override
	public void calculateMass() {
		// TODO Auto-generated method stub
		
	}
}
