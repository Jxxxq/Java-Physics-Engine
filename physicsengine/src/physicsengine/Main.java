package physicsengine;

public class Main {

	public static void main(String[] args) {
		Manager.getInstance().addBall(new Ball(new Vector2(500,500)));
        java.awt.EventQueue.invokeLater(() -> {
			GUI g = new GUI(1200,700);
			g.setVisible(true);
			new Thread(() -> g.updateAndRepaint()).start();
        });
        
        
	}
	
	
	
	
}
