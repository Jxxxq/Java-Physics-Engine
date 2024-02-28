package physicsengine;

public class Body {
	
	protected Vector2 position = new Vector2(0,0);
	protected Vector2 velocity = new Vector2(0,0);
	protected Vector2 acceleration = new Vector2(0,0);
	public final Shape shape;
	
	public Body(Shape shape) {
		this.shape = shape;
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
	public void setVelocity(Vector2 vel) {
		velocity = vel;
	}
	
	public void setAcceleration(Vector2 acc) {
		acceleration = acc;
	}
	
	public void setPosition(Vector2 pos) {
		position = pos;
	}
}
