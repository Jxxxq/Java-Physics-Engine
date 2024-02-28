package physicsengine;

public abstract class Shape {
	
	public Body body;

	public Shape() {
		body = new Body(this);
	}
	public abstract void initialize();
		
	public abstract Type getType();
	
	public abstract void calculateMass();
	
}
