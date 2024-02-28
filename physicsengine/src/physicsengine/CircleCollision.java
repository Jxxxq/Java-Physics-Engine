package physicsengine;

public class CircleCollision {

	public static void handleCollision(Body bodyA, Body bodyB, CInfo cinfo) {

		float distance = Vector2.getDistance(bodyA.position, bodyB.position);
		float radius1 = ((Ball) bodyA.shape).getRadius();
		float radius2 = ((Ball) bodyB.shape).getRadius();
		
		Vector2 dir = new Vector2(bodyB.position);
		dir.subtract(bodyA.position);
		dir.normalize();
		
		Vector2 collisionPoint = new Vector2(bodyA.position);
		Vector2 scaledDir = new Vector2(dir);
		scaledDir.scale(radius1/(radius1+radius2)*distance);
		collisionPoint.add(scaledDir);
		
		if(distance > (radius1+radius2)) { //no collision
			cinfo.Contacted = false;
			return;
		}
		//System.out.println("Collision between 2 cirlces @ " + collisionPoint.toString());
		cinfo.Contacted = true;
	}
	
}
