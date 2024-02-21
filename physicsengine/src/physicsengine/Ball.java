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
	
	public void update(float deltaTime) {
		if(velocity.getX() <= 0.000000001f && velocity.getX() >= -0.000000001f && velocity.getY()<= 0.3 && !isGrounded) {
			isGrounded = true;
			velocity = Vector2.ZERO();
		}
	    if(position.getX() > World.getInstance().getWalls() - radius || position.getX() < radius) {
	        velocity.setX(-velocity.getX() * 0.5f);
	        if (position.getX() > World.getInstance().getWalls() - radius) {
	            position.setX(World.getInstance().getWalls() - radius);
	        } else {
	            position.setX(radius);
	        }
	    }
	    if(position.getY() > World.getInstance().getGround() - radius || position.getY() < radius) {
	        velocity.setY(-velocity.getY() * 0.5f);
	        velocity.setX(velocity.getX() * 0.8f); //like it skids a little bit when it hits the ground
	        if (position.getY() > World.getInstance().getGround() - radius) {
	            position.setY(World.getInstance().getGround() - radius);
	        } else {
	            position.setY(radius);
	        }
	    }

	    Vector2 acc = new Vector2(acceleration);
	    acc.scale(deltaTime);
	    velocity.add(acc);

	    Vector2 vel = new Vector2(velocity);
	    vel.scale(deltaTime);
	    position.add(vel);
	    System.out.println("Vel: <" + velocity.getX() + ", " + velocity.getY() + ">");
	    System.out.println("Acc: <" + acceleration.getX() + ", " + acceleration.getY() + ">");

	}



	
	
	public Vector2 getPosition() {
		return new Vector2(position);
	}
	
	public int getRadius() {
		return radius;
	}
	
}
