package physicsengine;

public class Main {

	public static void main(String[] args) {
		World.getInstance().addBall(new Ball(new Vector2(500,500)));
		java.awt.EventQueue.invokeLater(() -> {
		    GUI g = new GUI(1200,700);
		    g.setVisible(true);
		    Physics physics = new Physics(g); // Pass the GUI instance to Physics
		    physics.startSimulation(); // This starts the physics update loop
		});

        
        
	}
	
	
	
	
}
