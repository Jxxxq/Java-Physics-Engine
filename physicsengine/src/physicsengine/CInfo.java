package physicsengine;

public class CInfo {

	public Body bodyA;
	public Body bodyB;
	
	public CInfo(Body bodyA, Body bodyB) {
		this.bodyA = bodyA;
		this.bodyB = bodyB;
	}
	
	public void solve() {
		bodyA.shape.getType();
	}
}
