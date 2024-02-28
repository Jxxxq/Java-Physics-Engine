package physicsengine;

public class Main {

	public static void main(String[] args) {
		World.getInstance().addBall(new Ball(new Vector2(500,500)));
		World.getInstance().addBall(new Ball(new Vector2(500,200)));
		java.awt.EventQueue.invokeLater(() -> {
		    GUI g = new GUI(1200,700);
		    g.setVisible(true);
		    Physics physics = new Physics(g); 
		    physics.startSimulation();
		});
		World.getInstance().getBalls().get(0).addForce(new Vector2(0,200f));
		World.getInstance().getBalls().get(1).addForce(new Vector2(0,200f));

        
	}
	
	
	
	
}
