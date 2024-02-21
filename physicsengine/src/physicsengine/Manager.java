package physicsengine;

import java.util.ArrayList;
import java.util.List;

public class Manager {

	private static Manager instance = null;
	private List<Ball> balls;
	
	public static synchronized Manager getInstance() {
		if(instance == null) {
			instance = new Manager();
		}
		return instance;
	}
	
	public Manager() {
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
}
