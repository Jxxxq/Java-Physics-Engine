package physicsengine;

import java.util.ArrayList;
import java.util.List;

public class World {

	private static World instance = null;
	public ArrayList<CInfo> collisions = new ArrayList<>();
	private List<Ball> balls;
	private float ground;
	private float walls;
	
	public static synchronized World getInstance() {
		if(instance == null) {
			instance = new World();
		}
		return instance;
	}
	
	public World() {
		balls = new ArrayList<>();
	}
	
	public void addBall(Ball ball) {
		balls.add(ball);
	}
	
	public void removeBall(Ball ball) {
		balls.remove(ball);
	}
	
	public List<Ball> getBalls(){
		return balls;
	}
	
	public void setGround(float pos) {
		ground = pos;
	}
	
	public void setWalls(float pos) {
		walls = pos;
	}
	
	public float getGround() {
		return ground;
	}
	
	public float getWalls() {
		return walls;
	}
}
