package physicsengine;

public class Ball {

	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;
	private int radius = 20;
	private boolean isGrounded = false;
	
	public Ball(Vector2 position) {
		this.position = new Vector2(position);
		this.velocity = new Vector2(200,0);
		this.acceleration = new Vector2(0,98f);
	}
	
	public void addForce(Vector2 force) {
		acceleration.add(force);
	}
	
	public boolean isGrounded() {
		return isGrounded;
	}
	
	public Vector2 getAcceleration() {
		return new Vector2(acceleration);
	}

	public Vector2 getVelocity() {
		return new Vector2(velocity);
	}
	
	
	public Vector2 getPosition() {
		return new Vector2(position);
	}
	
	public int getRadius() {
		return radius;
	}
	
	public void setVelocity(Vector2 vel) {
		velocity = vel;
	}
	
	public void setAcceleration(Vector2 acc) {
		acceleration = acc;
	}
	
	public void setPosition(Vector2 pos) {
		position = pos;
	}
	
	public void setGrounded(boolean b) {
		isGrounded = b;
	}
}
