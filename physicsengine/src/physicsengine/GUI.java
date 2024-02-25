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
        World.getInstance().setGround(BOARD_HEIGHT);
        World.getInstance().setWalls(BOARD_WIDTH);
        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawBalls(g); 
                drawBarriers(g);
            }
        };
        drawingPanel.setSize(BOARD_WIDTH, BOARD_HEIGHT);
        drawingPanel.setLayout(null);
        this.add(drawingPanel);
        this.setVisible(true);
    }

    private void drawBalls(Graphics g) {
        World manager = World.getInstance();
        for (Ball ball : manager.getBalls()) {
            Vector2 position = ball.getPosition();
            int radius = ball.getRadius();
            g.setColor(Color.RED);
            g.fillOval((int)position.getX() - radius, (int)position.getY() - radius, 2 * radius, 2 * radius);
        }
    }
    private void drawBarriers(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(0, 0, BOARD_WIDTH - 1, BOARD_HEIGHT - 1);

    }

}
