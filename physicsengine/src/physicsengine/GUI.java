package physicsengine;

import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GUI extends JFrame {
    
    private int BOARD_WIDTH = 1280;
    private int BOARD_HEIGHT = 880;

    private JLabel label;
    
    public GUI(int width, int height) {
        this.BOARD_HEIGHT = height;
        this.BOARD_WIDTH = width;
        initGUI();
    }
    
    public GUI() {
        initGUI();
    }
    
    private void initGUI() {
        this.setTitle("Java Physics Engine");
        this.setSize(BOARD_WIDTH, BOARD_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        
        label = new JLabel("Budget Physics Engine", SwingConstants.CENTER);
        centerLabel(BOARD_WIDTH, BOARD_HEIGHT);
        this.add(label);
        
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                centerLabel(getWidth(), getHeight());
            }
        });
    }
    
    private void centerLabel(int frameWidth, int frameHeight) {
        int labelWidth = frameWidth / 2; 
        int labelHeight = 100; 
        int labelX = (frameWidth - labelWidth) / 2; 
        int labelY = (frameHeight - labelHeight) / 2;
        
        label.setBounds(labelX, labelY, labelWidth, labelHeight);
        
        float newSize = frameWidth / 50f;
        label.setFont(new Font("Arial", Font.PLAIN, Math.max(10, (int)newSize)));
    }
}
