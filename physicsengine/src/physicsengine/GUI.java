package physicsengine;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame {
    
    private int BOARD_WIDTH = 1280;
    private int BOARD_HEIGHT = 880;

    private JPanel drawingPanel; // A panel where balls are drawn

    public GUI(int width, int height) {
        this.BOARD_WIDTH = width;
        this.BOARD_HEIGHT = height;
        initGUI();
    }
    
    public GUI() {
        initGUI();
    }
    
    private void initGUI() {
        this.setTitle("Java Physics Engine");
        this.setSize(BOARD_WIDTH, BOARD_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        // Initialize the drawing panel
        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawBalls(g); // Draw all balls on this panel
            }
        };
        drawingPanel.setSize(BOARD_WIDTH, BOARD_HEIGHT);
        drawingPanel.setLayout(null);
        this.add(drawingPanel);
        this.setVisible(true);
    }

    private void drawBalls(Graphics g) {
        Manager manager = Manager.getInstance();
        for (Ball ball : manager.getBalls()) {
            Vector2 position = ball.getPosition();
            int radius = ball.getRadius();
            g.setColor(Color.RED);
            g.fillOval((int)position.getX() - radius, (int)position.getY() - radius, 2 * radius, 2 * radius);
        }
    }

    public void updateAndRepaint() {
        long lastUpdate = System.nanoTime();
        while (true) {
            long now = System.nanoTime();
            float deltaTime = (now - lastUpdate) / 1000000000.0f; // Convert to seconds
            lastUpdate = now;

            System.out.println(deltaTime);
            Manager manager = Manager.getInstance();
            for (Ball ball : manager.getBalls()) {
                ball.addForce(new Vector2(0,deltaTime)); // Scale gravity by deltaTime
                ball.update(deltaTime);
            }
            
            drawingPanel.repaint(); 

//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
