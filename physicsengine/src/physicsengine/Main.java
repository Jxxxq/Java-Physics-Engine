package physicsengine;

public class Main {

	public static void main(String[] args) {
		Ball ball1 = new Ball(150,350);
		Ball ball2 = new Ball(350,350);
		World.getInstance().addBall(ball1);
		World.getInstance().addBall(ball2);
		java.awt.EventQueue.invokeLater(() -> {
		    GUI g = new GUI(1300,900);
		    g.setVisible(true);
		    Physics physics = new Physics(g); 
		    physics.startSimulation();
		});
        
		ball1.addVel(new Vector2(280.19f, -20f)); 
		ball2.addVel(new Vector2(8.80f, -20f)); 
	}
	
	
	
	
}
