package physicsengine;

public class Ball {

	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;
	private int radius = 20;
	
	public Ball(Vector2 position) {
		this.position = new Vector2(position);
		this.velocity = new Vector2(0,0);
		this.acceleration = new Vector2(0,9.8f);
	}
	
	public void addForce(Vector2 force) {
		acceleration.add(force);
	}
	
	public void update(float deltaTime) {
	    Vector2 acc = new Vector2(acceleration);
	    acc.scale(deltaTime);
	    velocity.add(acc);
	    
	    Vector2 vel = new Vector2(velocity);
	    vel.scale(deltaTime);
	    position.add(vel); 
	    
	}

	
	public Vector2 getPosition() {
		return new Vector2(position);
	}
	
	public int getRadius() {
		return radius;
	}
	
}
