package physicsengine;

public class Body {
	
	private Vector2 position = new Vector2(0,0);
	private Vector2 velocity = new Vector2(0,0);
	private Vector2 acceleration = new Vector2(0,0);
	public final Shape shape;
	
	public Body(Shape shape) {
		this.shape = shape;
	}
	
}
