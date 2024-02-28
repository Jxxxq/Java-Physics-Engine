package physicsengine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int BOARD_WIDTH = 1280;
    private int BOARD_HEIGHT = 980;
    private int padding = 120;
    
    private JButton addVelocityButton;
    private JTextField velocityXField, velocityYField;
    
    private JPanel drawingPanel; //the panel where balls are drawn

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
        World.getInstance().setGround(BOARD_HEIGHT - padding * 2);
        World.getInstance().setWalls(BOARD_WIDTH - padding * 2);
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
        addVelocityButton = new JButton("Add Velocity to Ball 1");
        addVelocityButton.setBounds(BOARD_WIDTH - 250, BOARD_HEIGHT - 100, 200, 30);
        
        velocityXField = new JTextField("X Velocity");
        velocityXField.setBounds(BOARD_WIDTH - 250, BOARD_HEIGHT - 140, 100, 30); 
        drawingPanel.add(velocityXField);
        
        velocityYField = new JTextField("Y Velocity");
        velocityYField.setBounds(BOARD_WIDTH - 140, BOARD_HEIGHT - 140, 100, 30); 
        drawingPanel.add(velocityYField);

        addVelocityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double xVelocity = Double.parseDouble(velocityXField.getText());
                    double yVelocity = Double.parseDouble(velocityYField.getText());
                    Ball ball1 = World.getInstance().getBalls().get(0);
                    ball1.body.velocity = new Vector2((float)xVelocity, (float)yVelocity);
                } catch (NumberFormatException ex) {
                    System.err.println("Invalid input for velocities");
                }
            }
        });
        drawingPanel.add(addVelocityButton);

        this.add(drawingPanel);
        this.setVisible(true);
    }

    private void drawBalls(Graphics g) {
        World manager = World.getInstance();
        for (Ball ball : manager.getBalls()) {
            Vector2 position = ball.body.getPosition();
            int radius = ball.getRadius();
            g.setColor(Color.RED);
            g.fillOval((int)position.getX() - radius, (int)position.getY() - radius, 2 * radius, 2 * radius);
        }
    }
    private void drawBarriers(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(0, 0, BOARD_WIDTH - padding * 2, BOARD_HEIGHT - padding * 2);

    }

}
