package physicsengine;

public class Main {

	public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
			GUI g = new GUI(1200,700);
			g.setVisible(true);
        });
	}
	
}
