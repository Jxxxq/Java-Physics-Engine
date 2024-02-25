package physicsengine;

public abstract class Shape {
	
	public Body body;

	public abstract void initialize();
	
	public abstract void calcMass();
	
	public abstract Type getType();
}
