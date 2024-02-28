package physicsengine;

public class CInfo {

	public Body bodyA;
	public Body bodyB;
	public boolean Contacted;
	
	public CInfo(Body bodyA, Body bodyB) {
		this.bodyA = bodyA;
		this.bodyB = bodyB;
	}
	
	public void solve() {
		CircleCollision.handleCollision(bodyA, bodyB, this);
	}
}
