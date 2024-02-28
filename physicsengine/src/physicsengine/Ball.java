package physicsengine;

public class Ball extends Shape{

	private int radius = 20;
	private boolean isGrounded = false;
	
	public Ball(Vector2 position) {
		body.position = new Vector2(position);
		body.velocity = new Vector2(0,0);
		body.acceleration = new Vector2(0,400f); //set 400 for gravity
	}
	
	public Ball(int posX, int posY) {
		body.position = new Vector2(posX,posY);
		body.velocity = new Vector2(0,0);
		body.acceleration = new Vector2(0,200f); //set 400 for gravity
	}
	
	public void addVel(Vector2 amount) {
		body.velocity.add(amount);
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
